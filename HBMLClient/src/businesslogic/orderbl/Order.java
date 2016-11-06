package businesslogic.orderbl;

public class Order {
		OrderPO orderpo;
		
		/**
		 * 创建Order对象时传入OrderPO
		 * @param orderpo
		 */
		public Order(OrderPO orderpo)
		{
			this.orderpo = orderpo;
		}
		
		/**
		 * 要用到PromotionPO进行包装
		 * @return
		 */
		public int getPrice()
		{	
			PromotionService promotionServiceImpl = PromotionServiceImpl.getInstance();
			return 
		}
}
