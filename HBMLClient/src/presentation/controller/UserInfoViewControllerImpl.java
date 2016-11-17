package presentation.controller;

import businesslogicservice.TransferService;
import businesslogicservice.userblservice.*;
import message.ResultMessage;
import presentation.view.userinfoui.UserInfoViewControllerService;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Created by alex on 16-11-10.
 */
public class UserInfoViewControllerImpl implements UserInfoViewControllerService{
    UserCustomerService customerServiceImpl;
    UserStaffService userStaffServiceImpl;
    UserWebMarketerService userWebMarketerServiceImpl;
    UserWebManagerService userWebManagerServiceImpl;
    TransferService userTransferServiceImpl;
    public UserInfoViewControllerImpl(UserCustomerService userCustomerService, TransferService userTransferService){
        this.customerServiceImpl=userCustomerService;
        this.userTransferServiceImpl=userTransferService;
    }

    public UserInfoViewControllerImpl(UserStaffService userStaffService,TransferService userTransferService){
        this.userStaffServiceImpl=userStaffService;
        this.userTransferServiceImpl=userTransferService;
    }

    public UserInfoViewControllerImpl(UserWebMarketerService userWebMarketerService,TransferService userTransferService){
        this.userWebMarketerServiceImpl=userWebMarketerService;
        this.userTransferServiceImpl=userTransferService;
    }

    public UserInfoViewControllerImpl(UserWebManagerService userWebManagerService,TransferService userTransferService){
        this.userWebManagerServiceImpl=userWebManagerService;
        this.userTransferServiceImpl=userTransferService;
    }

    @Override
    public ResultMessage addUserInfo(UserVO vo) {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage deleteUserInfo(String id) {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage modifyUserInfo(UserVO vo) {
        return ResultMessage.failure;
    }

    @Override
    public UserVO findUserInfo(String id) {
        return null;
    }

    @Override
    public UserVO showUserInfo() {
        return null;
    }

    @Override
    public ArrayList<UserVO> showUserInfoList() {
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
    public ResultMessage signup(UserVO vo) {
        return ResultMessage.failure;
    }
}
