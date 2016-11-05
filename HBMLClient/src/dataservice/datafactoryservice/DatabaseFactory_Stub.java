package dataservice.datafactoryservice;

import dataservice.creditdataservice.CreditDataService;
import dataservice.creditdataservice.CreditDatabaseServiceMySqlImpl_Stub;
import dataservice.hotelinfodataservice.HotelInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderDatabaseServiceMySqlImpl_Stub;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roominfodataservice.RoomInfoDataService;
import dataservice.userdataservice.UserDataService;

public class DatabaseFactory_Stub implements DatabaseFactory{
	//获得操作OrderData的权限（即对应的Service）
	public OrderDataService getOrderDataService()
	{
		OrderDataService orderData = new OrderDatabaseServiceMySqlImpl_Stub();
		return orderData;
	}
	public CreditDataService getCreditDataService()
	{
		CreditDataService creditData = new CreditDatabaseServiceMySqlImpl_Stub();
		return creditData;
	}
	@Override
	public UserDataService getUserDataService() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PromotionDataService getPromotionDataService() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HotelInfoDataService getHotelInfoDataService() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RoomInfoDataService getRoomInfoDataService() {
		// TODO Auto-generated method stub
		return null;
	}
}
