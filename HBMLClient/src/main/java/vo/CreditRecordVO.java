package vo;

import model.CreditRecordReasonType;

import java.io.Serializable;
import java.util.Date;

public class CreditRecordVO implements Serializable{


	private static final long serialVersionUID = 2436059735173648306L;
	int creditRecordID;
	Date time;
	int userID;
	CreditRecordReasonType reasonType;
	Long amount;
	int orderID;

	/**
	 *
	 * @param creditRecordID		信用记录ID
	 * @param time
	 * @param userID
	 * @param reasonType			原因类型:０代表成功执行订单而增加信用值；１代表撤销订单而减少信用值；２代表异常订单申诉成功而增加信用值；３代表充值而增加信用值
	 * @param amount				增量，有正有负
	 * @param orderID				与订单相关的信用记录需要订单ID
	 */
	public CreditRecordVO(int creditRecordID, Date time, int userID, CreditRecordReasonType reasonType, Long amount, int orderID) {
		this.creditRecordID = creditRecordID;
		this.time = time;
		this.userID = userID;
		this.reasonType = reasonType;
		this.amount = amount;
		this.orderID = orderID;
	}

	public CreditRecordVO(Date time,CreditRecordReasonType reasonType,long amount,int orderID){
		this.time = time;
		this.reasonType = reasonType;
		this.amount = amount;
		this.orderID = orderID;
	}

	public CreditRecordVO(Date time, CreditRecordReasonType reasonType, long amount){
		this.time=time;
		this.reasonType=reasonType;
		this.amount=amount;
	}

	public int getCreditRecordID() {
		return creditRecordID;
	}

	public Date getTime() {
		return time;
	}

	public int getUserID() {
		return userID;
	}

	public CreditRecordReasonType getReasonType() {
		return reasonType;
	}

	public Long getAmount() {
		return amount;
	}

	public int getOrderID() {
		return orderID;
	}
}
