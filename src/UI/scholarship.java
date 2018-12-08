package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class scholarship extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, scholarshipStatus_bt, scholarshipStandard_bt,
			setScholarship_bt, ok, cancel;
	UI_Main ui;

	public scholarship(UI_Main ui) {
		this.ui = ui;
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/scholarship.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

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

		// 현재 장학생 보기 버튼 추가
		scholarshipStatus_bt = new JButton("장학생보기");
		scholarshipStatus_bt.setBackground(new Color(114, 137, 218));
		scholarshipStatus_bt.setForeground(Color.WHITE);
		scholarshipStatus_bt.setBounds(50, 280, 350, 60);
		scholarshipStatus_bt.setBorderPainted(false);
		scholarshipStatus_bt.setFocusPainted(false);

		// 장학 기준 보기 버튼 추가
		scholarshipStandard_bt = new JButton("장학기준");
		scholarshipStandard_bt.setBackground(new Color(114, 137, 218));
		scholarshipStandard_bt.setForeground(Color.WHITE);
		scholarshipStandard_bt.setBounds(520, 280, 350, 60);
		scholarshipStandard_bt.setBorderPainted(false);
		scholarshipStandard_bt.setFocusPainted(false);
		
		// 장학생 지정하기 버튼 추가
		setScholarship_bt = new JButton("장학생지정");
		setScholarship_bt.setBackground(new Color(114, 137, 218));
		setScholarship_bt.setForeground(Color.WHITE);
		setScholarship_bt.setBounds(520, 530, 350, 60);
		setScholarship_bt.setBorderPainted(false);
		setScholarship_bt.setFocusPainted(false);

		add(register_bt);
		add(grade_bt);
		add(scholarship_bt);
		add(scholarshipStatus_bt);
		add(scholarshipStandard_bt);
		add(setScholarship_bt);
		add(lblNewLabel);
		scholarship_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		scholarshipStatus_bt.addActionListener(new MyActionListener());
		scholarshipStandard_bt.addActionListener(new MyActionListener());
		setScholarship_bt.addActionListener(new MyActionListener());
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
			case "장학생보기":
				ui.update_UI("scholarshipStatus_UI");
				break;
			case "장학기준":
				ui.update_UI("scholarshipStandard_UI");
				break;
			case "장학생지정":
				ui.update_UI("setScholarship_UI");
				break;
			}
		}
	}
}
