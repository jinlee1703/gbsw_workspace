package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DBInterface.DBInterface;

public class CouponFrame extends JFrame {
	private int u_no;
	private String u_name;
	private int v;
	private ImagePanel p = new ImagePanel();
	private JLabel title = new JLabel("10% 할인 쿠폰");
	private JLabel subTitle = new JLabel("쿠폰이 발급되었습니다.");
	private JLabel name = new JLabel("고객명 :  ");
	private JLabel issueDate = new JLabel("발급날짜 :  ");
	private JLabel deadlineDate = new JLabel("사용기한 :  ");
	Calendar date = Calendar.getInstance();
	int year = date.get(Calendar.YEAR);					// 연도	
	int month = date.get(Calendar.MONTH) + 1;			// 월
	int day = date.get(Calendar.DATE);

	public CouponFrame(int u_no, int v) {
		this.u_no = u_no;
		this.v = v;
		findName();
		setTitle("쿠폰");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		formDesign();
		setSize(600, 300);
		setVisible(true);
	}

	public void formDesign() {
		add(p);

		p.add(title);
		title.setFont(new Font("HY헤드라인M", Font.BOLD, 45));
		if (v >= 5) {
			title.setText("10%, 30% 할인 쿠폰");
			title.setBounds(70, 20, 500, 100);
		} else if (v >= 3) {
			title.setBounds(120, 20, 500, 100);
		}

		p.add(subTitle);
		subTitle.setFont(new Font("굴림", Font.BOLD, 25));
		subTitle.setForeground(Color.RED);
		subTitle.setBounds(170, 90, 300, 50);

		p.add(name);
		name.setText(name.getText() + u_name);
		name.setBounds(80, 150, 200, 50);

		p.add(issueDate);
		issueDate.setText(issueDate.getText() + new SimpleDateFormat("yyyy-MM-dd").format(date.getTime()));
		issueDate.setBounds(350, 150, 200, 50);
		
		p.add(deadlineDate);
		date.set(year, month, day);
		deadlineDate.setText(deadlineDate.getText() + new SimpleDateFormat("yyyy-MM-dd").format(date.getTime()));
		deadlineDate.setBounds(350, 180, 200, 50);
	}

	public void findName() {
		try {
			ResultSet rs = DBInterface.stmt.executeQuery("select * from user where u_no='" + u_no + "'");

			if (rs.next()) {
				u_name = rs.getString(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ImagePanel extends JPanel {
	public ImagePanel() {
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = new ImageIcon("datafile/이미지/쿠폰.jpg").getImage();
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
