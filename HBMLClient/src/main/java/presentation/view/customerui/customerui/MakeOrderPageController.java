package presentation.view.customerui.customerui;

import java.util.Date;


import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogic.promotionbl.PromotionCustomerImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.promotionblservice.PromotionCustomerService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import message.OrderStateMessage;
import model.DateHelper;
import presentation.view.application.MyDialog;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomInfoVO;
import vo.UserVO;

public class MakeOrderPageController 
{
		@FXML private Label hotelNameLabel; 
		@FXML private Label hotelAddressLabel;
		@FXML private Label roomTypeLabel;
		@FXML private Label priceLabel;
		@FXML private Label checkoutTimeLabel;
		@FXML private Label executeDDLLabel;
		@FXML private Label promotionLabel;
		@FXML private Label newPriceLabel;
		@FXML private Button makeOrderButton;
		@FXML private ChoiceBox<Integer> numberBox;
		@FXML private ChoiceBox<String> hasChildBox;
		
		private Stage stage;
		private Scene preScene;
		private HotelVO hotelVO;
		private RoomInfoVO roomInfoVO;
		private UserVO userVO;
		private Date checkinTime;
		private OrderCustomerService customerService;
		private ObservableList<Integer> numberList;
		private ObservableList<String> hasChildList;
		private int number;
		private String hasChild;
		private PromotionCustomerService customerService2;
		private OrderVO orderVO;
		
		public void init(Stage stage, Scene preScene, HotelVO hotelVO, RoomInfoVO roomInfoVO,UserVO userVO, Date checkinTime)
		{
			this.stage = stage;
			this.preScene = preScene;
			this.hotelVO = hotelVO;
			this.roomInfoVO = roomInfoVO;
			this.userVO = userVO;
			this.checkinTime = checkinTime;
			customerService = new OrderCustomerServiceImpl();
			customerService2 = new PromotionCustomerImpl();
			number = 0;
			hasChild = "";
			initWholePage();
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
		private void initWholePage()
		{
			hotelNameLabel.setText(hotelVO.getName());
			hotelAddressLabel.setText(hotelVO.getAddress());
			roomTypeLabel.setText(roomInfoVO.getRoomType());
			priceLabel.setText(roomInfoVO.getDefaultPrice()+"");
			executeDDLLabel.setText(DateHelper.dateToString(new Date(checkinTime.getTime()+18*60*60*1000)));
			Integer[] numbers = new Integer[]{1,2,3,4,5};
			numberList = FXCollections.observableArrayList();
			numberList.addAll(numbers);
			numberBox.setItems(numberList);
			String[] hasChild = new String[]{"是","否"};
			hasChildList = FXCollections.observableArrayList();
			hasChildList.addAll(hasChild);
			hasChildBox.setItems(hasChildList);
			orderVO = new OrderVO(0, userVO.getUserID(), hotelVO.getId(), hotelVO.getName(), roomInfoVO.getRoomInfoID(), OrderStateMessage.Unexecuted, 
					new Date(), null, new Date(checkinTime.getTime()+18*60*60*1000),null, null, 2, 0, roomInfoVO.getDefaultPrice());
			if(customerService2.getSelectedPromotion(orderVO)!=null)
			{
				promotionLabel.setText(customerService2.getSelectedPromotion(orderVO).getPromotionVO().getContent());
				newPriceLabel.setText(customerService2.getSelectedPromotion(orderVO).getPrice()+"");
			}
//					OrderVO orderVO = new OrderVO(0, userVO.getUserID(), hotelVO.getId(), hotelVO.getName(), roomInfoVO.getRoomInfoID(), OrderStateMessage.Unexecuted,
//							null, null, checkinTime, null, null, number, sendInfo, roomInfoVO.getDefaultPrice());
//					customerService.addOrder(orderVO);
		}
		
		@FXML
		private void makeOrder()
		{
			if(userVO.getCreditValue()>=0)
			{
				numberBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						if (newValue.intValue()>=0) {
							number = numberList.get(newValue.intValue());
						}
					}
					
				});
				
				hasChildBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						if (newValue.intValue()>=0) {
							hasChild = hasChildList.get(newValue.intValue());
						}
					}
				});
				int sendInfo = 0;
				if(hasChild.equals("是"))
				{
					sendInfo = 1;
				}
				System.out.println(sendInfo);
				orderVO = new OrderVO(0, userVO.getUserID(), hotelVO.getId(), hotelVO.getName(), roomInfoVO.getRoomInfoID(), OrderStateMessage.Unexecuted,
						null, null, checkinTime, null, null, number, sendInfo, roomInfoVO.getDefaultPrice());
				customerService.addOrder(orderVO);
				new MyDialog(stage, "生成订单成功，请到订单列表查看该订单", 2);
				stage.setScene(preScene);
			}else
			{
				new MyDialog(stage, "您的信用额度不足，请充值。", 1);
			}
			
		}
}
