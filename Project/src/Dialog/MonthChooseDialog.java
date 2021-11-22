package Dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import OptionPane.OptionPane;

public class MonthChooseDialog extends JDialog {
	private boolean[] monthSelection = new boolean[12]; 
	private JPanel monthPanel = new JPanel(new GridLayout(3, 4, 10, 10));
	private MonthCircle[] month = new MonthCircle[12];
	private JButton btn = new JButton("확인");
	
	public MonthChooseDialog(JFrame frame, String title) {
		super(frame, title, true);
		dialogDesign();
		dialogEvent();
		setSize(300, 300);
	}
	
	public void dialogDesign() {
		add(monthPanel, BorderLayout.CENTER);
		monthPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		for (int i = 0; i < 12; i++) {
			month[i] = new MonthCircle(i + 1);
			monthPanel.add(month[i]);
		}
		JPanel pp = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pp.add(btn);
		
		add(pp, BorderLayout.SOUTH);
	}
	
	public void dialogEvent() {
		for (int i = 0; i < 12; i++) {
			month[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int j = 0; j < month.length; j++) {
						if (e.getSource() == month[j]) {
							if (monthSelection[j]) {
								monthSelection[j] = false;
							} else {
								monthSelection[j] = true;
							}
							month[j].monthChoose(monthSelection[j]);
						}
					}					
				}
			});
		}
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getPropositionCnt() == 0) {
					OptionPane.showErrorMessage("구매 월을 선택하세요.");
				} else {
					dispose();
				}
			}
		});
	}
	
	public class MonthCircle extends JPanel {
		private int month;
		private JLabel monthLabel = new JLabel();
		
		public MonthCircle(int month) {
			this.month = month;
			setLayout(new BorderLayout());
			monthLabel = new JLabel(month + "월", JLabel.CENTER);
			
			add(monthLabel);
		}
		
		@Override
		public void paintComponent(Graphics g) {
//			super.paint(g);
			g.setColor(Color.YELLOW);
			g.fillOval(0, 0, getWidth(), getHeight());
			g.setColor(Color.BLACK);
			g.drawOval(0, 0, getWidth(), getHeight());
		}
		
		public void monthChoose(boolean tf) {
			if (tf) {
				monthLabel.setForeground(Color.RED);
			} else {
				monthLabel.setForeground(Color.BLACK);
			}
		}
	}
	
	public boolean[] getProposition() {
		return monthSelection;
	}
	
	public int getPropositionCnt() {
		int cnt = 0;
		
		for (int i = 0; i < monthSelection.length; i++) {
			if (monthSelection[i])
				cnt++;
		}
		
		return cnt;
	}
	
//	public void setAllTrue() {
//		for (int i = 0; i < monthSelection.length; i++) {
//			monthSelection[i] = true;
//		}
//	}
}
