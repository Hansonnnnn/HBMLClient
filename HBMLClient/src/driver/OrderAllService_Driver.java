package driver;

import businesslogic.orderbl.Order;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.orderblservice.OrderCustomerService;
import businesslogicservice.orderblservice.OrderStaffService;
import businesslogicservice.orderblservice.OrderWebMarketerService;
import vo.AppealVO;

public class OrderAllService_Driver 
{
		public void drive(OrderBLService orderBLService, 
									OrderCustomerService customerService, 
									OrderStaffService staffService,
									OrderWebMarketerService webMarketerService)
		{
			orderBLService.showOrderList("0001");
			orderBLService.showOrderInfo("20161110");
			Order order = new Order();
			orderBLService.updateOrderPO(order);
			
			customerService.appealForAbnormalOrder();
			customerService.cancelOrder();
			customerService.editOrder();
			customerService.evaluateOrder();
			customerService.makeOrder();
			customerService.saveAppeal();
			
			staffService.executeOrder();
			
			AppealVO appeal = new AppealVO();
			webMarketerService.checkAppealReason(appeal);
		}
}
