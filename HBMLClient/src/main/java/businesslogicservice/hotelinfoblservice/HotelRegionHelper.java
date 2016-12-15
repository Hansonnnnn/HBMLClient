package businesslogicservice.hotelinfoblservice;

import java.util.List;
import java.util.Map;

import po.RegionPO;
import vo.RegionVO;

/**
 * @author 凡
 *
 */
public interface HotelRegionHelper {

	
	/**
	 * @return 所有的省的名字
	 */
	public List<String> getProvinces();
	
	/**
	 * @param province  传入省的名字
	 * @return	该省所有市的名字
	 */
	public List<String> getCities(String province);
	
	/**
	 * @param city   传入市的名字
	 * @return    该市所有商圈的VO
	 */
	public Map<Integer, RegionVO> getRegions(String city);
}
