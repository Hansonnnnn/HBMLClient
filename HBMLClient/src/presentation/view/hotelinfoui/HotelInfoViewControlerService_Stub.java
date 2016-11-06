package presentation.view.hotelinfoui;

import java.util.ArrayList;

import vo.HotelVO;

public class HotelInfoViewControlerService_Stub implements HotelInfoViewControlerService{
	String users_type;
	String users_ID;
	HotelVO hotelVO;
	ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
	HotelVO hotelVOs[] = null;
	
	public HotelInfoViewControlerService_Stub(String type, String ID) {
		// TODO Auto-generated constructor stub
		users_type = type;
		users_ID = ID;
	}
	
	
	//controller具体实现中，会根据type的不同，实现不同类中的getHotelList方法（多态）；
	@Override
	public HotelVO[] showHotelList(String hotel_region) {
		// TODO Auto-generated method stub
		if (hotel_region.equals("0001")) {
			hotelList.add(new HotelVO());
			hotelList.add(new HotelVO());
			hotelVOs = new HotelVO[hotelList.size()];
			hotelVOs =	hotelList.toArray(hotelVOs);
			System.out.println("getHotelList success!");
			return hotelVOs;
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