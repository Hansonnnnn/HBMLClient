package mock_object;

import businesslogic.hotelInfobl.hotelhelper.Hotel;

public class MockObject_Hotel extends Hotel{
		public String name;
		
		public MockObject_Hotel(String name)
		{
			this.name = name;
		}
		
		public String getHotelName()
		{
			return name;
		}
		
}
