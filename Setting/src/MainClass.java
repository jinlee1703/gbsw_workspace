import javax.swing.JOptionPane;

public class MainClass {
	public static void main(String[] args) {
		try {
			DBInterface.init();
			TableSetting.createDB();
			TableSetting.createGrants();
			TableSetting.createTables();
			TableSetting.createData();
			System.out.println("Setting Success!!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "셋팅 실패", "경고", JOptionPane.ERROR_MESSAGE);
		}
	}
}
