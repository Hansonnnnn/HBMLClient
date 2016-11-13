package mock_object;

import businesslogic.creditbl.Credit;

public class MockObject_Credit extends Credit{
		public int value = 0;
		
		public MockObject_Credit(int value)
		{
			super(value);
		}
		
		public int showCredit()
		{
			return value;
		}
}
