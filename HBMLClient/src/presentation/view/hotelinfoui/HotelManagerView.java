package presentation.view.hotelinfoui;

import javax.swing.JPanel;

import VO.HotelVO;

public class HotelManagerView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	HotelInfoViewControlerService controler;

	public HotelManagerView(HotelInfoViewControlerService controler) {
		this.controler = controler;
	}

	public void modifyHotel() {
		controler.modifyHotel(new HotelVO());
	}
}