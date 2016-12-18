package vo;

import model.MemberType;
import model.UserType;

import java.awt.*;
import java.io.File;

/**
 * Created by alex on 16-11-17.
 */
public class UserVO {


    int userID;
    UserType userType;
    String accountName;
    String password;
    String name;
    String contact;
    File portrait;
    long creditValue;
    MemberType memberType;
    String memberInfo;
    int rank;
    String workid;
    int hotelid;

    /**
     * 这是完整的constructor,参数用作参考
     * @param userID        用户ID
     * @param userType      用户类型，参见model.UserType
     * @param accountName   账号：用于登陆和系统唯一定位的
     * @param password
     * @param name          名字：真正的名字
     * @param contact
     * @param portrait      头像Image文件
     * @param creditValue   当前信用值
     * @param memberType    会员类型，参见model.MemberType
     * @param memberInfo    如果是非会员，此项为null,如果是个人，此项为生日(String),如果是企业，此项为公司名
     * @param rank          会员等级
     * @param workid        工号，可以自己定义，传空字符串也行
     * @param hotelid
     */
    public UserVO(int userID, UserType userType, String accountName, String password, String name
            , String contact, File portrait, long creditValue
            , MemberType memberType, String memberInfo, int rank
            , String workid, int hotelid) {

        this.userID = userID;
        this.userType=userType;
        this.accountName = accountName;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.portrait = portrait;
        this.creditValue = creditValue;
        this.memberType = memberType;
        this.memberInfo = memberInfo;
        this.rank = rank;
        this.workid = workid;
        this.hotelid = hotelid;
    }


    /**
     * 这是注册用户时可以使用的constructor
     * @param userType
     * @param accountName
     * @param password
     */
    public UserVO(UserType userType,String accountName, String password){
       this(0, userType,accountName,password,"User",null,null,0, MemberType.Tourist,null,1,null,0);
    }
    /**
     * 这是完整的constructor,参数用作参考
     *  userID        用户ID
     * userType      用户类型，参见model.UserType
     *  accountName   账号：用于登陆和系统唯一定位的
     *  password
     *  name          名字：真正的名字
     *  contact
     *  portrait      头像Image文件
     *  creditValue   当前信用值
     *  memberType    会员类型，参见model.MemberType
     *  memberInfo    如果是非会员，此项为null,如果是个人，此项为生日(String),如果是企业，此项为公司名
     *  rank          会员等级
     * workid        工号，可以自己定义，传空字符串也行
     *  hotelid
     */


    //getters
    public int getUserID() {
        return userID;
    }

    public UserType getUserType(){
        return userType;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public File getPortrait() {
        return portrait;
    }

    public long getCreditValue() {
        return creditValue;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public String getMemberInfo() {
        return memberInfo;
    }

    public int getRank() {
        return rank;
    }

    public String getWorkid() {
        return workid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setCreditValue(long creditValue) {
        this.creditValue = creditValue;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPortrait(File portrait) {
        this.portrait = portrait;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }
}
