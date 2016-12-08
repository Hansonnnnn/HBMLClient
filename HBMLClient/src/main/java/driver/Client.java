package driver;

import businesslogic.hotelInfobl.HotelStaffImpl;

import java.rmi.RemoteException;

import businesslogic.hotelInfobl.HotelCustomerImpl;
import businesslogic.hotelInfobl.HotelWebManagerImpl;
import businesslogic.utility.TransferImpl;
import businesslogicservice.hotelinfoblservice.HotelStaffService;
import businesslogicservice.TransferService;
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
		
		TransferService hotelTransferImpl = new TransferImpl();
		HotelStaffService hotelStaffImpl = null;
		HotelCustomerService hotelUserImpl = null;
		try {
			hotelUserImpl = new HotelCustomerImpl();
			hotelStaffImpl = new HotelStaffImpl(0001);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		HotelWebManagerService hotelWebManagerImpl = new HotelWebManagerImpl();
		HotelInfoBLService_Driver hotelInfoBLService_Driver = new HotelInfoBLService_Driver();
		hotelInfoBLService_Driver.drive(hotelStaffImpl, hotelUserImpl,hotelWebManagerImpl);
		
	
	}
}