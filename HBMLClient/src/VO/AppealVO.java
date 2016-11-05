package VO;

import java.io.Serializable;
import java.util.Date;

import VO.OrderVO;
import VO.WebMarketerAccountVO;;

public class AppealVO implements Serializable{
	Date time;
	WebMarketerAccountVO webMarketerAccount;
	String explanation;
	String state;
	OrderVO order;
	
	public AppealVO(String explaination)
	{
		this.explanation = explaination;
	}
	public AppealVO(Date t,WebMarketerAccountVO wMA,String e,
			String s,OrderVO o){
		time=t;
		webMarketerAccount=wMA;
		explanation=e;
		state=s;
		order=o;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public WebMarketerAccountVO getWebMarketerAccount() {
		return webMarketerAccount;
	}

	public void setWebMarketerAccount(WebMarketerAccountVO webMarketerAccount) {
		this.webMarketerAccount = webMarketerAccount;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}

}
