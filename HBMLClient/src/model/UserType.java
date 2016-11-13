package model;

/**
 * Created by alex on 16-11-13.
 */
public enum UserType {
    Customer,
    Staff,
    WebMarketer,
    WebManager,
    NoSuchUser;
    public UserType getUserType(String id){
        //wrong format
        if(id.length()!=10) return UserType.NoSuchUser;
        if(id.charAt(0)=='0'){
            //web manager以00开头
            if(id.charAt(1)=='0') return UserType.WebManager;
            //web marketer以01开头
            if(id.charAt(1)=='1') return UserType.WebMarketer;
            //staff以02开头
            if(id.charAt(1)=='2') return UserType.Staff;
        }
        //customer:其余情况
        return UserType.Customer;
    }
}
