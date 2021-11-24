package Frame;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductManagementFrame extends JFrame {
	private String[] header = {"상품 번호", "상품 카테고리", "상품명", "상품 가격", "상품 재고", "상품 설명"};
	private DefaultTableModel model = new DefaultTableModel(header, 0);
	private JTable table = new JTable(model);
	private JScrollPane scroll = new JScrollPane(table);
	
	private JComboBox<String> combo = new JComboBox<String>();
	
	public ProductManagementFrame() {
		setTitle("상품관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		formDesign();
		eventHandler();
		setSize(500, 500);
		setVisible(true);
	}
	
	public void formDesign() {}
	
	public void eventHandler() {}
	
	public void refresh() {
		
	}
}