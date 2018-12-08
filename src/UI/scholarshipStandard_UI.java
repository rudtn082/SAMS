package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scholarshipManagement.scholarshipDAO;

public class scholarshipStandard_UI extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, re;
	UI_Main ui;
	scholarshipDAO sc = new scholarshipDAO();

	public scholarshipStandard_UI(UI_Main ui) {
		this.ui = ui;

		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/scholarshipStatus_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// scholarshipManegementDAO 접근, 데이터 가져옴
		ImageIcon timeTable = sc.checkScholarshipStandard();

		// 시간표 이미지 출력========================================
		JLabel timeTableLabel = new JLabel("");
		timeTableLabel.setIcon(timeTable);
		timeTableLabel.setBounds(205, 190, 580, 440);

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

		add(re);
		add(scholarship_bt);
		add(register_bt);
		add(grade_bt);
		add(timeTableLabel);
		add(lblNewLabel);

		scholarship_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		re.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
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
