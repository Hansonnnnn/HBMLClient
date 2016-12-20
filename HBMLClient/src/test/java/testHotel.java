import businesslogic.hotelInfobl.HotelStaffImpl;
import businesslogicservice.hotelinfoblservice.HotelStaffService;
import rmi.ClientRunner;

public class testHotel {

	public static void main(String[] args) {
		ClientRunner clientRunner = new ClientRunner();
		
		HotelStaffService hotelStaffService = new HotelStaffImpl();
		
		System.out.println(hotelStaffService.getHotelInfo(119).getEnvironment().size());
		
	}
}
