package vo;

import java.awt.Image;
import java.io.Serializable;

public class CommentInfoVO implements Serializable{
	int score;
	String comment;
	Image picture;
	
	public CommentInfoVO(int s,String c,Image p){
		score=s;
		comment=c;
		picture=p;
	}

	public int getScore() {
		return score;
	}

	public String getComment() {
		return comment;
	}

	public Image getPicture() {
		return picture;
	}
}
