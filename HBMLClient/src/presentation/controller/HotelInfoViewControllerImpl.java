package presentation.controller;

import java.util.Map;

import businesslogicservice.TransferService;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.hotelinfoblservice.HotelManagerService;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import presentation.view.hotelinfoui.HotelInfoViewControlerService;
import vo.HotelVO;

public class HotelInfoViewControllerImpl implements HotelInfoViewControlerService {

	TransferService hotelTransferImpl;
	HotelManagerService hotelStaffImpl;
	HotelCustomerService hotelUserImpl;	
	HotelWebManagerService hotelWebManagerImpl;
	
	public HotelInfoViewControllerImpl(HotelManagerService hotelStaffImp) {

		this.hotelStaffImpl = hotelStaffImp;
	}
	
	public HotelInfoViewControllerImpl(HotelCustomerService hotelUserImp) {

		this.hotelUserImpl = hotelUserImp;
	}
	
	public HotelInfoViewControllerImpl(HotelWebManagerService hotelWebManagerImpl) {
	
		this.hotelWebManagerImpl = hotelWebManagerImpl;
	}
	
	@Override
	public Map<String,HotelVO> showHotelList(String hotel_region) {

		return null;
	}

	@Override
	public HotelVO showHotelInfo(String hotel_ID) {

		return null;
	}

	@Override
	public boolean addHotel(HotelVO vo) {

		return false;
	}

	@Override
	public boolean modifyHotel(HotelVO vo) {

		return false;
	}

	@Override
	public boolean deleteHotel(String hotel_ID) {

		return false;
	}

}