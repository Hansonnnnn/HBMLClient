package presentation.view.hotelinfoui;

import vo.HotelVO;

public class HotelInfoView {
	
	private HotelManagerOfHotelView staff;
	private CustomerOfHotelView user;
	private WebManagerOfHotelView webManager;
	
	HotelInfoViewControlerService controler;

	public HotelInfoView(HotelInfoViewControlerService controler) {
		this.controler = controler;
	}
	
	public static void main(String[] args){
		
		HotelInfoViewControlerService hotelInfoViewControlerService = new HotelInfoViewControlerService_Stub(null, "0001");
		
		hotelInfoViewControlerService.addHotel(new HotelVO());
		hotelInfoViewControlerService.deleteHotel("0001");
		hotelInfoViewControlerService.modifyHotel(new HotelVO());
		hotelInfoViewControlerService.showHotelList("0001");
		hotelInfoViewControlerService.showHotelInfo("0001");
		
	}
}