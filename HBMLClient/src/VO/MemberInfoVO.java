package VO;

import java.io.Serializable;

public class MemberInfoVO implements Serializable{
	String memberType;
	String memberInfo;
	int rank;
	
	public MemberInfoVO(String mt,String mi,int r){
		memberType=mt;
		memberInfo=mi;
		rank=r;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(String memberInfo) {
		this.memberInfo = memberInfo;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
