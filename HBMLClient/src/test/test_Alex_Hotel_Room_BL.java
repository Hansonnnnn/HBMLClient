import businesslogic.roomInfobl.RoomInfoCustomerServiceImpl;
import businesslogicservice.roominfoblservice.RoomInfoCustomerService;
import rmi.ClientRunner;
import vo.RoomInfoVO;

import java.util.Date;
import java.util.Map;

/**
 * Created by alex on 12/19/16.
 */
public class test_Alex_Hotel_Room_BL {
    public static void main(String args[]){
        ClientRunner clientRunner=new ClientRunner();
        int hotelID=120;
        Map<String, RoomInfoVO> map;
        RoomInfoCustomerService roomInfoCustomerService=new RoomInfoCustomerServiceImpl();
        map=roomInfoCustomerService.getRoomList(hotelID,new Date());
        for(String key:map.keySet()){
            System.out.println(map.get(key));
        }

    }
}
