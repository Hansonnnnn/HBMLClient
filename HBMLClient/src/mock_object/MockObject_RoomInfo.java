package mock_object;

import businesslogic.roomInfobl.roomhelper.RoomInfo;

public class MockObject_RoomInfo extends RoomInfo
{
		String roomtype;
		public MockObject_RoomInfo(String roomtype)
		{
			this.roomtype = roomtype;
		}
		
		public String showRoomType()
		{
			return roomtype;
		}
}
