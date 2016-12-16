package vo;

import model.MemberType;
import model.UserType;

import java.awt.*;

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
    Image portrait;
    long creditValue;
    MemberType memberType;
    String memberInfo;
    int rank;
    String workid;
    int hotelid;

    /**
     * 此constructor仅供测试用
     * @param userID
     */
    public UserVO(int userID){

        this.userID=userID;

    }

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
            , String contact, Image portrait, long creditValue
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

    //constructors for customer

    /**
     *
     * @param id                客户ID
     * @param pwd
     * @param name
     * @param contact
     * @param image
     * @param creditValue
     * @param memberType
     * @param memberInfo
     * @param rank
     */
    public UserVO(int id, String pwd, String name, String contact,
                  Image image, long creditValue, MemberType memberType, String memberInfo, int rank){

        this.userID=id;
        this.userType= UserType.Customer;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;
        this.creditValue=creditValue;
        this.memberInfo=memberInfo;
        this.memberType=memberType;
        this.rank=rank;

    }

    /**
     * 这是注册用户时可以使用的constructor
     * @param userType
     * @param accountName
     * @param password
     */
    public UserVO(UserType userType,String accountName, String password){

        this.userType=userType;
        this.accountName=accountName;
        this.password=password;

    }

    /**
     * 这是不带用户ID的客户constructor
     * @param pwd
     * @param name
     * @param contact
     * @param image
     * @param creditValue
     * @param memberType
     * @param memberInfo
     * @param rank
     */
    public UserVO(String pwd, String name, String contact,
                  Image image, long creditValue, MemberType memberType, String memberInfo, int rank){

        this.userType= UserType.Customer;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;
        this.creditValue=creditValue;
        this.memberInfo=memberInfo;
        this.memberType=memberType;
        this.rank=rank;

    }

    //constructors for Staff
    public UserVO(int id, String pwd, String name, String contact, Image image, String workid, int hotelid){

        this.userID=id;
        this.userType= UserType.Staff;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;
        this.workid=workid;
        this.hotelid=hotelid;

    }

    /**
     * 这是酒店工作人员注册所需constructor
     * @param accountName
     * @param password
     * @param name
     * @param hotelID
     * @param contact
     */
    public UserVO(String accountName,String password,String name,int hotelID,String contact){
        this.userType=UserType.Staff;
        this.accountName=accountName;
        this.password=password;
        this.name=name;
        this.hotelid=hotelID;
        this.contact=contact;
    }

    /**
     * 这是不带用户ID的酒店工作人员constructor
     * @param pwd
     * @param name
     * @param contact
     * @param image
     * @param workid
     * @param hotelid
     */

    public UserVO(String pwd, String name, String contact, Image image, String workid, int hotelid){

        this.userType= UserType.Staff;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;
        this.workid=workid;
        this.hotelid=hotelid;

    }

    //这个不需要传image了
    public UserVO(String pwd, String name, String contact, String workid, int hotelid){

        this.userType= UserType.Staff;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.workid=workid;
        this.hotelid=hotelid;

    }

    //constructors for WebMarketer and WebManager
    public UserVO(int id, UserType userType, String pwd, String name, String contact, Image image){

        this.userID=id;
        this.userType=userType;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;

    }

    /**
     * 这是不带用户ID的网站营销人员和网站工作人员constructor
     * @param userType
     * @param pwd
     * @param name
     * @param contact
     * @param image
     */
    public UserVO(UserType userType, String pwd, String name, String contact, Image image){

        this.userType=userType;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;

    }

    //这个不需要传image了
    public UserVO(UserType userType, String pwd, String name, String contact){

        this.userType=userType;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;

    }


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

    public Image getPortrait() {
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
}
