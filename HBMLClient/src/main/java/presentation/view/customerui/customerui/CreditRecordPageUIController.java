package presentation.view.customerui.customerui;

import businesslogic.creditbl.CreditCustomerImpl;
import businesslogicservice.creditblservice.CreditCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vo.CreditRecordVO;
import vo.UserVO;

public class CreditRecordPageUIController 
{
		@FXML private TableView<CreditRecordVO> list;
		@FXML private Button backButton;
		@FXML private Label nameLabel;
		@FXML private ImageView headImageView;
		@FXML private TableColumn<CreditRecordVO, Boolean> orderColumn;
		@FXML private TableColumn<CreditRecordVO, Boolean> timeColumn;
		@FXML private TableColumn<CreditRecordVO, Boolean> creditColumn;
		@FXML private TableColumn<CreditRecordVO, Boolean> reasonTypeColumn;
		@FXML private Label creditLabel;
		
		private Stage stage;
		private Scene preScene;
		private UserVO userVO;
		private CreditCustomerService customerService;
		private ObservableList< CreditRecordVO> creditRecordVOData;
		
		public void init(Stage stage, Scene preScene, UserVO userVO)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.userVO = userVO;
			customerService = new CreditCustomerImpl();
			nameLabel.setText(userVO.getName());
			try {
				creditLabel.setText(customerService.getCreditValue(userVO.getUserID())+"");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			initTable();
		}
		
		private void initTable()
		{
			orderColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
			timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
			creditColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
			reasonTypeColumn.setCellValueFactory(new PropertyValueFactory<>("reasonType"));
			
			creditRecordVOData = FXCollections.observableArrayList();
			if(customerService.getCreditRecordList(userVO.getUserID())!=null)
			{
				for (CreditRecordVO creditRecordVO : customerService.getCreditRecordList(userVO.getUserID()).values()) 
				{
					creditRecordVOData.add(creditRecordVO);
				}
			}
			list.setItems(creditRecordVOData);
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
}
