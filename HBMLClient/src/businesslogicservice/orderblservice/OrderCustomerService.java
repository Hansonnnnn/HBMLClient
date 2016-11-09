package businesslogicservice.orderblservice;

/**
 * 该类为所有orderbl模块中Customer需要提供的服务
 * @author xiezhenyu
 *
 */
public interface OrderCustomerService {
		public boolean makeOrder();
		public boolean isUpToStandard();//判断是否符合生成订单的条件
		public boolean editOrder();
		public boolean cancelOrder();
		public void evaluateOrder();
		public void appealForAbnormalOrder();
		public void saveAppeal();
}
