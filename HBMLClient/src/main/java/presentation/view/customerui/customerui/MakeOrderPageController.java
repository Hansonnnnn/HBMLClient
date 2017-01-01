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
import javafx.scene.control.ComboBox;
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
		@FXML private ComboBox<Integer> numberBox;
		@FXML private ComboBox<String> hasChildBox;
		
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
		private PromotionCustomerService customerService2;
		private OrderVO orderVO;
		private String choiceResult;
		private int sendInfo = 0;
		
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
			initWholePage();
		}
		
		@FXML
		private void back()
		{
			stage.setScene(preScene);
		}
		
		//初始化该界面的标签项、选择有无儿童的选择逻辑框、选择入住人数的选择逻辑框
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
			System.out.println(orderVO.getHotelID()+"  "+orderVO.getPrice()+"  "+orderVO.getUserID());
			//通过订单来获得可以使用的最优优惠策略的促销方式
			if(customerService2.getSelectedPromotion(orderVO)!=null)
			{
				System.out.println("***************");
				if(customerService2.getSelectedPromotion(orderVO).getPromotionVO().getContent()==null
				||customerService2.getSelectedPromotion(orderVO).getPromotionVO().getContent().equals(""))
				{
					promotionLabel.setText("--");
				}else
				{
					promotionLabel.setText(customerService2.getSelectedPromotion(orderVO).getPromotionVO().getContent());
				}
				
				newPriceLabel.setText(customerService2.getSelectedPromotion(orderVO).getPrice()+"");
			}
//					OrderVO orderVO = new OrderVO(0, userVO.getUserID(), hotelVO.getId(), hotelVO.getName(), roomInfoVO.getRoomInfoID(), OrderStateMessage.Unexecuted,
//							null, null, checkinTime, null, null, number, sendInfo, roomInfoVO.getDefaultPrice());
//					customerService.addOrder(orderVO);
			numberBox.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
						number = numberList.get(newValue.intValue());
				}
			});
			
			choiceResult = "否";
			hasChildBox.valueProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue ov, String oldValue, String newValue)
				{
					choiceResult = newValue;
				}
			});
			if(hasChild.equals("是"))
			{
				sendInfo = 1;
			}
		}
		
		//生成订单的事件响应
		@FXML
		private void makeOrder()
		{
			if(userVO.getCreditValue()>=0)
			{
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
