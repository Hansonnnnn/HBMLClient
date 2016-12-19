package vo;

public class RankVO {
	int rank;
	int discount;
	int value;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "RankVO [rank=" + rank + ", discount=" + discount + ", value=" + value + "]";
	}
	public RankVO(int rank, int discount, int value) {
		super();
		this.rank = rank;
		this.discount = discount;
		this.value = value;
	}
}
