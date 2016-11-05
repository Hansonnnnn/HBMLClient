package presentation.controller;

import VO.HotelVO;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.hotelinfoblservice.HotelManagerService;
import businesslogicservice.hotelinfoblservice.HotelTransferService;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import presentation.view.hotelinfoui.HotelInfoViewControlerService;

public class HotelInfoViewControllerImpl implements HotelInfoViewControlerService {

	HotelTransferService hotelTransferImpl;
	HotelManagerService hotelStaffImpl;
	HotelCustomerService hotelUserImpl;	
	HotelWebManagerService hotelWebManagerImpl;
	
	public HotelInfoViewControllerImpl(HotelManagerService hotelStaffImp,HotelTransferService hotelTransferImpll) {
		this.hotelTransferImpl = hotelTransferImpll;
		this.hotelStaffImpl = hotelStaffImp;
	}
	
	public HotelInfoViewControllerImpl(HotelCustomerService hotelUserImp,HotelTransferService hotelTransferImpll) {
		this.hotelTransferImpl = hotelTransferImpll;
		this.hotelUserImpl = hotelUserImp;
	}
	
	public HotelInfoViewControllerImpl(HotelWebManagerService hotelWebManagerImpl,HotelTransferService hotelTransferImpl) {
		this.hotelTransferImpl = hotelTransferImpl;
		this.hotelWebManagerImpl = hotelWebManagerImpl;
	}
	
	@Override
	public HotelVO[] showHotelList(String hotel_region) {

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