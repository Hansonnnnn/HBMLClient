package presentation.view.customerui.customerui;


import businesslogic.promotionbl.PromotionCustomerImpl;
import businesslogicservice.promotionblservice.PromotionCustomerService;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import model.PromotionFilter;
import vo.PromotionVO;

public class PromotionPageUIController 
{
	    @FXML private TableView<PromotionVO> promotionList;
	    @FXML private TableColumn<PromotionVO, Boolean> nameColumn;
	    @FXML private TableColumn<PromotionVO, Boolean> startTimeColumn;
	    @FXML private TableColumn<PromotionVO, Boolean> endTimeColumn;
	    @FXML private TableColumn<PromotionVO, Boolean> conditionsColumn;
	    @FXML private TableColumn<PromotionVO, Boolean> contentColumn;
	    @FXML private Button hotelPromotionButton;
	    @FXML private Button webPromotionButton;
	    @FXML private Label sliderLabel;
	    
	    private PromotionCustomerService customerService;
	    private PromotionFilter filter;
	    private ObservableList<PromotionVO> promotionData;
	    
		public void initTable(String type)
		{
				nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startDateString"));
				endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endDateString"));
				conditionsColumn.setCellValueFactory(new PropertyValueFactory<>("requirement"));
				contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
				customerService = new PromotionCustomerImpl();
				promotionData = FXCollections.observableArrayList();
				filter = new PromotionFilter();
				if(type.equals("酒店促销优惠"))
				{
					try {
						if(customerService.getHotelPromotionList(filter)!=null)
						{
							for (PromotionVO promotionVO : customerService.getHotelPromotionList(filter).values())
							{
								promotionData.add(promotionVO);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else
				{
					try {
						if(customerService.getWebPromotionList(filter)!=null)
						{
							for (PromotionVO promotionVO : customerService.getWebPromotionList(filter).values())
							{
								promotionData.add(promotionVO);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				promotionList.setItems(promotionData);
		}
		
		@FXML
		private void hotelPromotion()
		{
			moveOrderButtonBottomBorder(sliderLabel, 0);
			initTable(hotelPromotionButton.getText());
		}
		
		@FXML
		private void webPromotion()
		{
			moveOrderButtonBottomBorder(sliderLabel, 140);
			initTable(webPromotionButton.getText());
		}
		
		  /**
	     * 设置按钮下边界滑动效果
	     */
	    private void moveOrderButtonBottomBorder(Label label,double x){
	        Timeline timeline=new Timeline();
	        timeline.setAutoReverse(false);
	        KeyValue newX=new KeyValue(label.layoutXProperty(),x);
	        KeyFrame kf=new KeyFrame(Duration.millis(300),newX);
	        timeline.getKeyFrames().add(kf);
	        timeline.play();
	    }
}
