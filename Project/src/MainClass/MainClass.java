package MainClass;

import DBInterface.DBInterface;
import Frame.LoginFrame;
import Frame.MonthChooseFrame;
import Frame.ProductListFrame;
import Frame.PurchaseFrame;
import OptionPane.OptionPane;

public class MainClass {
	public static void main(String[] args) throws Exception {
		DBInterface.init();
//		new LoginFrame();
//		new ProductListFrame("rlsmd1", "장지용");
//		new PurchaseFrame("rlsmd1", 1);
		new MonthChooseFrame();
	}
}
