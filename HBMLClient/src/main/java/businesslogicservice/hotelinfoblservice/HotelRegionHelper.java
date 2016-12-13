package businesslogicservice.hotelinfoblservice;

import java.util.Map;

import vo.RegionVO;

/**
 * @author 凡
 *
 */
public interface HotelRegionHelper {

	
	/**
	 * @return Integer是Region编号  
	 * @see  编号是有意义的   具体什么意义看越明定义的文件说明
	 */
	public Map<Integer, RegionVO> getRegions();
}
