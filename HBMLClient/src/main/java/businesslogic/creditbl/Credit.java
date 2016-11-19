package businesslogic.creditbl;

import po.CreditRecordPO;

public class Credit {
		public int value;
		public CreditRecordPO record;
		
		public Credit(int value)
		{
			
		}
		public Credit(int value, CreditRecordPO record)
		{
			this.value = value;
			this.record = record;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
		
		
}
