package presentation.view.hotelinfoui;

import javax.swing.JPanel;

import vo.HotelVO;

public class HotelManagerOfHotelView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	HotelInfoViewControlerService controler;

	public HotelManagerOfHotelView(HotelInfoViewControlerService controler) {
		this.controler = controler;
	}

	public void modifyHotel() {
		controler.modifyHotel(new HotelVO());
	}
}