package vo;

import java.io.Serializable;

import vo.CreditRecordVO;

public class CreditVO implements Serializable{
	int value;
	CreditRecordVO creditRecord;
	
	
	public CreditVO(int v,CreditRecordVO cR){
		value=v;
		creditRecord=cR;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public CreditRecordVO getCreditRecord() {
		return creditRecord;
	}


	public void setCreditRecord(CreditRecordVO creditRecord) {
		this.creditRecord = creditRecord;
	}
}
