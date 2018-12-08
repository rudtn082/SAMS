package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scholarshipManagement.scholarshipDAO;

public class checkScholarship_UI extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, ok, cancel;
	UI_Main ui;
	JLabel aID;
	JTextField stufield;
	scholarshipDAO sc = new scholarshipDAO();

	public checkScholarship_UI(UI_Main ui) {
		this.ui = ui;

		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeAdmin_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// 로그인 계정 라벨
		aID = new JLabel("admin");
		aID.setBounds(807, 133, 100, 20);
		aID.setForeground(Color.WHITE);

		// 교과목1 필드
		stufield = new JTextField(10);
		stufield.setBounds(630, 235, 100, 20);
		stufield.setOpaque(false);
		stufield.setForeground(Color.WHITE);
		// subject1field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stufield.setCaretColor(Color.white);

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

		// 저장버튼 추가
		ok = new JButton("저장");
		ok.setBackground(new Color(114, 137, 218));
		ok.setForeground(Color.WHITE);
		ok.setBounds(105, 647, 350, 60);
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);

		// 취소버튼 추가
		cancel = new JButton("취소");
		cancel.setBackground(new Color(114, 137, 218));
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(510, 647, 350, 60);
		cancel.setBorderPainted(false);
		cancel.setFocusPainted(false);

		add(stufield);
		add(aID);
		add(register_bt);
		add(grade_bt);
		add(scholarship_bt);
		add(cancel);
		add(ok);
		add(lblNewLabel);
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		scholarship_bt.addActionListener(new MyActionListener());
		ok.addActionListener(new MyActionListener());
		cancel.addActionListener(new MyActionListener());
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
				System.out.println("scholarship");
				break;
			case "저장":
				// 학번1 예외처리
				if (stufield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stufield.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stufield.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						} else {
							if (sc.checkStuMatch(stufield.getText()) == true) {
								JOptionPane.showMessageDialog(null, "해당 학생은 장학생으로 입력 가능합니다.", "확인 여부", JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
					}
				}
				
				JOptionPane.showMessageDialog(null, "해당 학생은 장학생으로 입력 가능합니다.", "확인 여부", JOptionPane.WARNING_MESSAGE);

			case "취소":
				ui.update_UI("scholarship");
				break;
			}
		}

	}

	public boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean isStringEqualToTemp(String s) {
		switch (s) {
		case "건축공학과":
			return true;
		case "컴퓨터공학과":
			return true;
		case "영어영문학과":
			return true;
		case "철학과":
			return true;
		case "환경공학과":
			return true;
		case "토목공학과":
			return true;
		case "국어국문학과":
			return true;
		case "기계공학과":
			return true;
		case "심리학과":
			return true;
		case "무역학과":
			return true;
		default:
			return false;
		}
	}
}
