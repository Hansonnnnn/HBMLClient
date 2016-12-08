package businesslogic.hotelInfobl.helper;

import java.rmi.RemoteException;
import java.util.LinkedHashMap;
import java.util.Map;

import businesslogic.utility.TransferImpl;
import businesslogicservice.TransferService;
import businesslogicservice.hotelinfoblservice.HotelRegionHelper;
import dao.hotel.HotelDao;
import po.RegionPO;
import rmi.ClientRunner;
import vo.RegionVO;

public class RegionHelper implements HotelRegionHelper{

	Map<Integer, RegionVO> regions;
	HotelDao hotelDao;
	TransferService regionTransferService;
	
	public RegionHelper() {
		hotelDao = ClientRunner.remoteHelper.getHotelDao();
		regionTransferService = new TransferImpl();
	}
	
	@Override
	public Map<Integer, RegionVO> getRegions() {
		try {
			regions = new LinkedHashMap<>();
			Map<Integer, RegionPO> map = hotelDao.getRegions();
			for (int key : map.keySet()) {
				
				regions.put(key, regionTransferService.poToVo(map.get(key)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return regions;
	}
	
	
}
