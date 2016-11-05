package dataservice.datafactoryservice;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hotelinfodataservice.HotelInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roominfodataservice.RoomInfoDataService;
import dataservice.userdataservice.UserDataService;

public interface DatabaseFactory {
	public OrderDataService getOrderDataService();
	public CreditDataService getCreditDataService();
	public UserDataService getUserDataService();
	public PromotionDataService getPromotionDataService();
	public HotelInfoDataService getHotelInfoDataService();
	public RoomInfoDataService getRoomInfoDataService();
}
