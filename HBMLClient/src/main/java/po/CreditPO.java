package po;

import java.io.Serializable;

public class CreditPO implements Serializable{
	int value;
	CreditRecordPO creditRecord;
	
	public CreditPO(int v)
	{
		this.value = v;
	}
	public CreditPO(int v,CreditRecordPO cR)
	{
		value=v;
		creditRecord=cR;
	}


	public int getValue()
	{
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public CreditRecordPO getCreditRecord() {
		return creditRecord;
	}


	public void setCreditRecord(CreditRecordPO creditRecord) {
		this.creditRecord = creditRecord;
	}

	
	
}
