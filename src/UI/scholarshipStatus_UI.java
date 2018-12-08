package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scholarshipManagement.scholarshipDAO;

public class scholarshipStatus_UI extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, re;
	UI_Main ui;

	JLabel[] scholarStu = new JLabel[10]; // 장학생
	String[] majors = null;
	String[] maj = { "000", "001", "002", "003", "004", "005", "006", "007", "008", "009" };

	scholarshipDAO sc = new scholarshipDAO();

	public scholarshipStatus_UI(UI_Main ui) {
		this.ui = ui;

		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/scholarshipStatus.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		for (int i = 0; i < 10; i++) {
			String[] tmp = sc.getStatusByMaj(maj[i]);
			String personLabel = "";
			for (int j = 1; j < tmp.length; j++) {
				personLabel = personLabel + tmp[j] + "  ";
			}
			scholarStu[i] = new JLabel(personLabel);
			scholarStu[i].setBounds(450, (235 + (36 * i)), 400, 20);
			scholarStu[i].setForeground(Color.WHITE);
		}

		// 학적관리 버튼 추가
		register_bt = new JButton("학적관리");
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(44, 23, 200, 55);

		// 성적관리 버튼 추가
		grade_bt = new JButton("성적관리");
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(300, 23, 200, 55);

		// 장학관리 버튼 추가
		scholarship_bt = new JButton("장학관리");
		scholarship_bt.setContentAreaFilled(false);
		scholarship_bt.setFocusPainted(false);
		scholarship_bt.setForeground(Color.WHITE);
		scholarship_bt.setBounds(556, 23, 200, 55);

		// 돌아가기 추가
		re = new JButton("돌아가기");
		re.setBackground(new Color(114, 137, 218));
		re.setForeground(Color.WHITE);
		re.setBounds(307, 647, 350, 60);
		re.setBorderPainted(false);
		re.setFocusPainted(false);

		for (int i = 0; i < 10; i++) {
			add(scholarStu[i]);
		}

		add(register_bt);
		add(grade_bt);
		add(scholarship_bt);
		add(re);
		add(lblNewLabel);
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		scholarship_bt.addActionListener(new MyActionListener());
		re.addActionListener(new MyActionListener());

	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("e.getModifiers : " + e.getModifiers());
			switch (e.getActionCommand()) {
			case "학적관리":
				ui.update_UI("register");
				break;
			case "성적관리":
				ui.update_UI("gradeAdminSetID");
				break;
			case "장학관리":
				ui.update_UI("scholarship");
				break;
			case "돌아가기":
				ui.update_UI("scholarship");
				break;
			}
		}
	}
}
