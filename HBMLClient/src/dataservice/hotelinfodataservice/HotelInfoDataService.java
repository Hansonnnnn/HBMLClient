package dataservice.hotelinfodataservice;

import PO.HotelPO;

public interface HotelInfoDataService {
	public HotelPO[] getHotelList(String hotel_region);	
	public HotelPO getHotelInfo(String hotel_ID);
	public HotelPO[] getHotelList();
	public boolean addHotel(HotelPO po);
	public boolean modifyHotel(HotelPO po);
	public boolean deleteHotel(String hotel_ID);
	
}
