package driver;

import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import dao.OrderDao;
import rmi.ClientRunner;
import vo.HotelVO;
/**
 * 驱动的总测试入口
 * @author wangfan
 *
 */
public class Client {
	public static void main(String[] args)
	{
		ClientRunner cr = new ClientRunner();
		
		HotelCustomerService hotelCustomerService = new HotelCustomerImpl();
		Map<Integer, HotelVO> map = hotelCustomerService.getHotelList(null, null, null);
	
		for (HotelVO hotelVO : map.values()) {
			System.out.println(map);
		}
	
		Image
	}
}