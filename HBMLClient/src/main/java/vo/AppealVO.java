package vo;

import java.io.Serializable;
import java.util.Date;

import vo.UnexecutedOrderVO;
import vo.WebMarketerAccountVO;;

public class AppealVO implements Serializable{
	Date time;
	WebMarketerAccountVO webMarketerAccount;
	String explanation;
	String state;
	UnexecutedOrderVO order;
	
	public AppealVO()
	{
		
	}
	public AppealVO(String explaination)
	{
		this.explanation = explaination;
	}
	public AppealVO(Date t,WebMarketerAccountVO wMA,String e,
			String s,UnexecutedOrderVO o){
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

	public UnexecutedOrderVO getOrder() {
		return order;
	}

	public void setOrder(UnexecutedOrderVO order) {
		this.order = order;
	}

}