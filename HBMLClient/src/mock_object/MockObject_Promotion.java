package mock_object;

import businesslogic.promotionbl.Promotion;

public class MockObject_Promotion extends Promotion{
		public String promotionInfo;
		
		public MockObject_Promotion(String promotion)
		{
			super(promotion);
		}
		
		public String showPromotion()
		{
			return promotionInfo;
		}
}
