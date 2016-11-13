package presentation.controller;

import businesslogicservice.userblservice.*;
import message.ResultMessage;
import presentation.view.userinfoui.UserInfoViewControllerService;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-10.
 */
public class UserInfoViewControllerImpl implements UserInfoViewControllerService{
    UserCustomerService customerServiceImpl;
    UserStaffService userStaffServiceImpl;
    UserWebMarketerService userWebMarketerServiceImpl;
    UserWebManagerService userWebManagerServiceImpl;
    UserTransferService userTransferServiceImpl;
    public UserInfoViewControllerImpl(UserCustomerService userCustomerService, UserTransferService userTransferService){
        this.customerServiceImpl=userCustomerService;
        this.userTransferServiceImpl=userTransferService;
    }

    public UserInfoViewControllerImpl(UserStaffService userStaffService,UserTransferService userTransferService){
        this.userStaffServiceImpl=userStaffService;
        this.userTransferServiceImpl=userTransferService;
    }

    public UserInfoViewControllerImpl(UserWebMarketerService userWebMarketerService,UserTransferService userTransferService){
        this.userWebMarketerServiceImpl=userWebMarketerService;
        this.userTransferServiceImpl=userTransferService;
    }

    public UserInfoViewControllerImpl(UserWebManagerService userWebManagerService,UserTransferService userTransferService){
        this.userWebManagerServiceImpl=userWebManagerService;
        this.userTransferServiceImpl=userTransferService;
    }

    @Override
    public ResultMessage addUserInfo(Object vo) {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage deleteUserInfo(Object vo) {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage modifyUserInfo(Object vo) {
        return ResultMessage.failure;
    }

    @Override
    public Object findUserInfo(String id) {
        return null;
    }

    @Override
    public Object showUserInfo() {
        return null;
    }

    @Override
    public ArrayList<Object> showUserInfoList() {
        return null;
    }

    @Override
    public ResultMessage login(String id, String pwd) {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage logout() {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage signup(CustomerVO vo) {
        return ResultMessage.failure;
    }
}
