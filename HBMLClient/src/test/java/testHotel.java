import businesslogic.hotelInfobl.HotelStaffImpl;
import businesslogicservice.hotelinfoblservice.HotelStaffService;
import rmi.ClientRunner;

public class testHotel {

	public static void main(String[] args) {
		/*ClientRunner clientRunner = new ClientRunner();
		
		HotelStaffService hotelStaffService = new HotelStaffImpl();
	*/	
	//	System.out.println(hotelStaffService.getHotelInfo(1).getEnvironment().size());
		
	//	System.out.println("HBMLClient\\HBMLClient"+ "Final_HBMSServer2\\HBMSServer");
        System.out.println("HBMLClient/HBMLClient".replaceAll("HBMLClient/HBMLClient", "Final_HBMSServer2/HBMSServer"));
	}
}
