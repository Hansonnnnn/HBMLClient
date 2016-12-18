package businesslogicservice.hotelinfoblservice;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.hotelInfobl.helper.RegionHelper;
import rmi.ClientRunner;
import vo.RegionVO;

public class HotelRegionHelperTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClientRunner clientRunner = new ClientRunner();
	}

	@Test
	public void testGetProvinces() {
		HotelRegionHelper hotelRegionHelper = new RegionHelper();
		List<String> list = hotelRegionHelper.getProvinces();
		assertNotNull(list);
	}

	@Test
	public void testGetCities() {
		HotelRegionHelper hotelRegionHelper = new RegionHelper();
		List<String> list = hotelRegionHelper.getCities("江苏");
		assertNotNull(list);
	}

	@Test
	public void testGetRegions() {
		HotelRegionHelper hotelRegionHelper = new RegionHelper();
		Map<Integer, RegionVO> map  = hotelRegionHelper.getRegions("南京");
		assertNotNull(map);
	}
	

}
