package presentation.view.customerui.customerui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import vo.HotelVO;

public class CommentedHotelListPageController 
{
		@FXML private TableView list;
		@FXML private TableColumn nameColumn;
		@FXML private TableColumn starColumn;
		@FXML private TableColumn scoreColumn;
		@FXML private TableColumn priceColumn;
		@FXML private TableColumn buttonColumn;
		
		private Stage stage;
		private Scene commentFirstPageScene;
		
		private ObservableList<HotelVO> hotelData;
		
		public void init(Stage stage, Scene commentFirstPageScene)
		{
			this.stage = stage;
			this.commentFirstPageScene = commentFirstPageScene;
			initTable();
		}
		
		private void initTable()
		{
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			starColumn.setCellValueFactory(new PropertyValueFactory<>("star"));
			scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
			priceColumn.setCellValueFactory(new PropertyValueFactory<>("lowestPrice"));
			buttonColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() {
				@Override
				public TableCell call(TableColumn param)
				{
					return new CommentButtonCell(stage);
				}
			});
		}
		
		public class CommentButtonCell extends TableCell<HotelVO, Boolean>
		{
			private Button commentButton = new Button("追加评价");
			
			public CommentButtonCell(Stage stage)
			{
				commentButton.setOnAction((ActionEvent e)->{
					stage.setScene(new CommentSubmitPage(new Group(), stage, commentFirstPageScene));
				});
			}
		}
}
