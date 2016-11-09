package driver;

import businesslogic.hotelInfobl.HotelManagerImpl;
import businesslogic.hotelInfobl.HotelTransferImpl;

import java.rmi.RemoteException;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.hotelInfobl.HotelWebManagerImpl;
import businesslogicservice.hotelinfoblservice.HotelManagerService;
import businesslogicservice.hotelinfoblservice.HotelTransferService;
import businesslogicservice.hotelinfoblservice.HotelCustomerService;
import businesslogicservice.hotelinfoblservice.HotelWebManagerService;
import rmi.ClientRunner;

/**
 * 驱动的总测试入口
 * @author wangfan
 *
 */
public class Client {
	public static void main(String[] args)
	{
		ClientRunner cr = new ClientRunner();
		
		HotelTransferService hotelTransferImpl = new HotelTransferImpl();
		HotelManagerService hotelStaffImpl = null;
		HotelCustomerService hotelUserImpl = null;
		try {
			hotelUserImpl = new HotelCustomerImpl();
			hotelStaffImpl = new HotelManagerImpl(0001);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		HotelWebManagerService hotelWebManagerImpl = new HotelWebManagerImpl();
		HotelInfoBLService_Driver hotelInfoBLService_Driver = new HotelInfoBLService_Driver();
		hotelInfoBLService_Driver.drive(hotelTransferImpl,hotelStaffImpl, hotelUserImpl,hotelWebManagerImpl);
		
	
	}
}