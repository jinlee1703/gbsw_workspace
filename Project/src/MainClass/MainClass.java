package MainClass;

import DBInterface.DBInterface;
import Dialog.MonthChooseDialog;
import Frame.AttendanceFrame;
import Frame.CouponFrame;
import Frame.LoginFrame;
import Frame.ProductListFrame;
import Frame.ProductManagementFrame;
import Frame.ProductUpdateFrame;
import Frame.PurchaseFrame;
import Frame.PurchaseListFrame;
import OptionPane.OptionPane;

public class MainClass {
	public static void main(String[] args) throws Exception {
		DBInterface.init();
		new LoginFrame();
//		new ProductListFrame("rlsmd1", "장지용");
//		new PurchaseFrame("rlsmd1", 1);
//		new MonthChooseFrame();
//		new PurchaseListFrame("rlsmd1");
//		new AttendanceFrame("rlsmd1");
//		new ProductManagementFrame();
//		new ProductUpdateFrame(1);
//		new CouponFrame(1, 5);
	}
}
