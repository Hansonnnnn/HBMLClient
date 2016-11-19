package presentation.view.hotelinfoui;

import java.util.HashMap;
import java.util.Map;

import vo.HotelVO;

public class HotelInfoViewControlerService_Stub implements HotelInfoViewControlerService{
	String users_type;
	String users_ID;
	HotelVO hotelVO;
	Map<String,HotelVO> hotelList = new HashMap<>();
	HotelVO hotelVOs[] = null;
	
	public HotelInfoViewControlerService_Stub(String type, String ID) {
		// TODO Auto-generated constructor stub
		users_type = type;
		users_ID = ID;
	}
	
	
	//controller具体实现中，会根据type的不同，实现不同类中的getHotelList方法（多态）；
	@Override
	public Map<String,HotelVO> showHotelList(String hotel_region) {
		// TODO Auto-generated method stub
		if (hotel_region.equals("0001")) {
			hotelList.put(hotel_region, new HotelVO());
		
			System.out.println("getHotelList success!");
			return hotelList;
		}
		return null;
	}

	@Override
	public HotelVO showHotelInfo(String hotel_ID) {
		// TODO Auto-generated method stub
		if (hotel_ID.equals("0001")) {
			System.out.println("getHotelInfo success!");
			return new HotelVO();
		}
		return null;
	}

	@Override
	public boolean addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		System.out.println("addHotel success!");
		return true;
	}

	@Override
	public boolean modifyHotel(HotelVO vo) {
		System.out.println("modifyHotel success!");
		return true;
	}

	@Override
	public boolean deleteHotel(String hotel_ID) {
		// TODO Auto-generated method stub
		System.out.println("deleteHotel success!");
		return true;
	}

}