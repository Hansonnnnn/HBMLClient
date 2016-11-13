package vo;
import java.io.Serializable;
/**
 * Created by alex on 16-11-13.
 */
public class UserVO implements Serializable{
    //shared
    String id;
    String password;
    PersonalInfoVO personalInfo;
    //for customers
    CreditVO creditInfo;
    MemberInfoVO memberInfo;
    //for staffs
    String workid;
    String hotelid;
    //for web marketers and web managers: shared ones are enough
    //constructors for allVO
    public UserVO(String id){
        this.id=id;
    }

    //constructors for customerVO
    public UserVO(String id,String pwd,PersonalInfoVO personalInfo,CreditVO creditInfo
            ,MemberInfoVO memberInfo){
        this.id=id;
        this.password=pwd;
        this.personalInfo=personalInfo;
        this.creditInfo=creditInfo;
        this.memberInfo=memberInfo;
    }

    //constructors for StaffVO
    public UserVO(String id,String pwd,PersonalInfoVO personalInfo,CreditVO creditInfo
            ,MemberInfoVO memberInfo,String workid,String hotelid){
        this.id=id;
        this.password=pwd;
        this.personalInfo=personalInfo;
        this.creditInfo=creditInfo;
        this.memberInfo=memberInfo;
        this.workid=workid;
        this.hotelid=hotelid;
    }

    //constructors for WebMarketerVO and WebManagerVO
    public UserVO(String id,String pwd,PersonalInfoVO personalInfo){
        this.id=id;
        this.password=pwd;
        this.personalInfo=personalInfo;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public PersonalInfoVO getPersonalInfo() {
        return personalInfo;
    }

    public CreditVO getCreditInfo() {
        return creditInfo;
    }

    public MemberInfoVO getMemberInfo(){
        return memberInfo;
    }

    public String getWorkid() {
        return workid;
    }

    public String getHotelid() {
        return hotelid;
    }
}

