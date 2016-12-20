import businesslogic.hotelInfobl.HotelWebManagerImpl;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import rmi.ClientRunner;

/**
 * Created by LENOVO on 2016/12/20.
 */
public class hotelFiletest {
    public static void main(String args[]){
        ClientRunner clientRunner = new ClientRunner();
        HotelWebManagerService hotelWebManagerService = new HotelWebManagerImpl();
        System.out.println(hotelWebManagerService.getHotelInfo(119).getEnvironment().size());
    }

}
