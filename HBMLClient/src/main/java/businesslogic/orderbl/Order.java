package businesslogic.orderbl;

import java.util.Date;

import po.CreditRecordPO;
import po.HotelPO;
import po.OrderPO;
import po.PersonalInfoPO;
import vo.UnexecutedOrderVO;

public class Order {
		private OrderPO orderpo;
		private PersonalInfoPO personalInfo;
		private String user_id;
		private String id;
		private Date createDate;
		private Date cancelDate;
		private HotelPO hotelInfo;
		private CreditRecordPO creditRecord;
		private String state;
		private Date checkDate;
		private Date checkoutDate;
		int number;
		boolean hasChild;
		String contactInfo;
		String creditExplanation;
		Date executeDeadline;
		double price;
		
		/**
		 * 创建Order对象时传入OrderPO
		 * @param orderpo
		 */
		public Order(OrderPO orderpo)
		{
			this.orderpo = orderpo;
//			personalInfo = orderpo.getPersonalInfo();
			id = orderpo.getId();
			createDate = orderpo.getCreateDate();
			cancelDate = orderpo.getCancelDate();
			hotelInfo = orderpo.getHotelInfo();
			creditRecord = orderpo.getCreditRecord();
			state = orderpo.getState();
			checkDate = orderpo.getCheckDate();
			checkoutDate = orderpo.getCheckoutDate();
			number = orderpo.getNumber();
			hasChild = false;
			contactInfo = orderpo.getContactInfo();
			creditExplanation = orderpo.getCreditExplanation();
			executeDeadline = orderpo.getExecuteDeadline();
			price = orderpo.getPrice();
		}
		
		public Order()
		{
			
		}
		
		public Order(UnexecutedOrderVO ordervo)
		{
			
		}
		
		public OrderPO getOrderpo() {
			return orderpo;
		}

		public void setOrderpo(OrderPO orderpo) {
			this.orderpo = orderpo;
		}

		public PersonalInfoPO getPersonalInfo() {
			return personalInfo;
		}

		public void setPersonalInfo(PersonalInfoPO personalInfo) {
			this.personalInfo = personalInfo;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public Date getCancelDate() {
			return cancelDate;
		}

		public void setCancelDate(Date cancelDate) {
			this.cancelDate = cancelDate;
		}

		public HotelPO getHotelInfo() {
			return hotelInfo;
		}

		public void setHotelInfo(HotelPO hotelInfo) {
			this.hotelInfo = hotelInfo;
		}

		public CreditRecordPO getCreditRecord() {
			return creditRecord;
		}

		public void setCreditRecord(CreditRecordPO creditRecord) {
			this.creditRecord = creditRecord;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Date getCheckDate() {
			return checkDate;
		}

		public void setCheckDate(Date checkDate) {
			this.checkDate = checkDate;
		}

		public Date getCheckoutDate() {
			return checkoutDate;
		}

		public void setCheckoutDate(Date checkoutDate) {
			this.checkoutDate = checkoutDate;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public boolean isHasChild() {
			return hasChild;
		}

		public void setHasChild(boolean hasChild) {
			this.hasChild = hasChild;
		}

		public String getContactInfo() {
			return contactInfo;
		}

		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}

		public String getCreditExplanation() {
			return creditExplanation;
		}

		public void setCreditExplanation(String creditExplanation) {
			this.creditExplanation = creditExplanation;
		}

		public Date getExecuteDeadline() {
			return executeDeadline;
		}

		public void setExecuteDeadline(Date executeDeadline) {
			this.executeDeadline = executeDeadline;
		}

		public void setPrice(int price) {
			this.price = price;
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
