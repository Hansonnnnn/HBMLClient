package businesslogic.orderbl;

import java.util.Date;

import po.CreditRecordPO;
import po.HotelPO;
import po.OrderPO;
import po.PersonalInfoPO;

public class Order {
		OrderPO orderpo;
		PersonalInfoPO personalInfo;
		String id;
		Date createDate;
		Date cancelDate;
		HotelPO hotelInfo;
		CreditRecordPO creditRecord;
		String state;
		Date checkDate;
		Date checkoutDate;
		int number;
		boolean hasChild;
		String contactInfo;
		String creditExplanation;
		Date executeDeadline;
		int price;
		
		/**
		 * 创建Order对象时传入OrderPO
		 * @param orderpo
		 */
		public Order(OrderPO orderpo)
		{
			this.orderpo = orderpo;
			PersonalInfoPO personalInfo = orderpo.getPersonalInfo();
			String id;
			Date createDate;
			Date cancelDate;
			HotelPO hotelInfo;
			CreditRecordPO creditRecord;
			String state;
			Date checkDate;
			Date checkoutDate;
			int number;
			boolean hasChild;
			String contactInfo;
			String creditExplanation;
			Date executeDeadline;
			int price;
		}
		
		/**
		 * 要用到PromotionPO进行包装
		 * @return
		 */
		public int getPrice()
		{	
//			PromotionService promotionServiceImpl = PromotionServiceImpl.getInstance();
			return 0;
		}
}
