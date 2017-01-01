package presentation.view.customerui.customerui;

import businesslogic.orderbl.OrderCustomerServiceImpl;
import businesslogicservice.orderblservice.OrderCustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import vo.OrderVO;

public class HistoryOrderPageController 
{
		@FXML private TableView<OrderVO> list;
		@FXML private TableColumn<OrderVO, Boolean> idColumn;
		@FXML private TableColumn<OrderVO, Boolean> timeColumn;
		@FXML private TableColumn<OrderVO, Boolean> orderStateColumn;
		@FXML private TableColumn<OrderVO, Boolean> priceColumn;
		
		private int hotelID;
		private int userID;
		private OrderCustomerService customerService;
		
		public void init(int hotelID, int userID)
		{
			this.hotelID = hotelID;
			this.userID = userID;
			customerService = new OrderCustomerServiceImpl();
			initTable();
		}
		
		
		//初始化表格内容，并调用BL层的方法来获得数据
		private void initTable()
		{
			ObservableList<OrderVO> orderData = FXCollections.observableArrayList();
			idColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
			timeColumn.setCellValueFactory(new PropertyValueFactory<>("generateTime"));
			orderStateColumn.setCellValueFactory(new PropertyValueFactory<>("orderState"));
			priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
			
			if(customerService.getUnexecutedOrderListOfSpecificHotel(userID, hotelID)!=null)
			{
				for (OrderVO orderVO : customerService.getUnexecutedOrderListOfSpecificHotel(userID, hotelID).values()) 
				{
					orderData.add(orderVO);
				}
			}
			if(customerService.getExecutedOrderListOfSpecificHotel(userID, hotelID)!=null)
			{
				for (OrderVO orderVO : customerService.getExecutedOrderListOfSpecificHotel(userID, hotelID).values()) 
				{
					orderData.add(orderVO);
				}
			}
			if(customerService.getAbnormalOrderListOfSpecificHotel(userID, hotelID)!=null)
			{
				for (OrderVO orderVO : customerService.getAbnormalOrderListOfSpecificHotel(userID, hotelID).values()) 
				{
					orderData.add(orderVO);
				}
			}
			if(customerService.getCancelledOrderListOfSpecificHotel(userID, hotelID)!=null)
			{
				for (OrderVO orderVO : customerService.getCancelledOrderListOfSpecificHotel(userID, hotelID).values()) 
				{
					orderData.add(orderVO);
				}
			}
			
			list.setItems(orderData);
		}
}
