package VO;

import java.io.Serializable;

import VO.CreditRecordVO;

public class CreditVO implements Serializable{
	long value;
	CreditRecordVO creditRecord;
	
	
	public CreditVO(int v,CreditRecordVO cR){
		value=v;
		creditRecord=cR;
	}


	public long getValue() {
		return value;
	}


	public void setValue(long value) {
		this.value = value;
	}


	public CreditRecordVO getCreditRecord() {
		return creditRecord;
	}


	public void setCreditRecord(CreditRecordVO creditRecord) {
		this.creditRecord = creditRecord;
	}
}
