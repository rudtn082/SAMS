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

public class setScholarship_UI extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, ok, cancel;
	UI_Main ui;
	JLabel aID;
	JTextField majfield, stu1field, stu2field, stu3field, stu4field, stu5field, stu6field;
	scholarshipDAO sc = new scholarshipDAO();

	public setScholarship_UI(UI_Main ui) {
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

		// 학과명 필드
		majfield = new JTextField(10);
		majfield.setBounds(630, 235, 100, 20);
		majfield.setOpaque(false);
		majfield.setForeground(Color.WHITE);
		// subject1field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		majfield.setCaretColor(Color.white);

		// 교과목2 필드
		stu1field = new JTextField(10);
		stu1field.setBounds(630, 273, 100, 20);
		stu1field.setOpaque(false);
		stu1field.setForeground(Color.WHITE);
		// subject2field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu1field.setCaretColor(Color.white);

		// 교과목3 필드
		stu2field = new JTextField(10);
		stu2field.setBounds(630, 311, 100, 20);
		stu2field.setOpaque(false);
		stu2field.setForeground(Color.WHITE);
		// subject3field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu2field.setCaretColor(Color.white);

		// 교과목4 필드
		stu3field = new JTextField(10);
		stu3field.setBounds(630, 349, 100, 20);
		stu3field.setOpaque(false);
		stu3field.setForeground(Color.WHITE);
		// subject4field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu3field.setCaretColor(Color.white);

		// 교과목5 필드
		stu4field = new JTextField(10);
		stu4field.setBounds(630, 387, 100, 20);
		stu4field.setOpaque(false);
		stu4field.setForeground(Color.WHITE);
		// subject5field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu4field.setCaretColor(Color.white);

		// 교과목6 필드
		stu5field = new JTextField(10);
		stu5field.setBounds(630, 425, 100, 20);
		stu5field.setOpaque(false);
		stu5field.setForeground(Color.WHITE);
		// subject6field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu5field.setCaretColor(Color.white);

		// 교과목7 필드
		stu6field = new JTextField(10);
		stu6field.setBounds(630, 463, 100, 20);
		stu6field.setOpaque(false);
		stu6field.setForeground(Color.WHITE);
		// subject7field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu6field.setCaretColor(Color.white);

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

		add(majfield);
		add(stu1field);
		add(stu2field);
		add(stu3field);
		add(stu4field);
		add(stu5field);
		add(stu6field);
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

				// 학과명 예외처리
				if (!majfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학과명을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(majfield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "학과명은 문자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(majfield.getText()) == true) {
						} else {
							JOptionPane.showMessageDialog(null, "학과명을 정확히 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 학번1 예외처리
				if (stu1field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu1field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu1field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 학번2 예외처리
				if (stu2field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu2field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu2field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 학번3 예외처리
				if (stu3field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu3field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu3field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 학번4 예외처리
				if (stu4field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu4field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu4field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 학번5 예외처리
				if (stu5field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu5field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu5field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 학번6 예외처리
				if (stu6field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu6field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu6field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 장학생 현황 생성
				String message = sc.setScholarshipStu(majfield.getText(), stu1field.getText(), stu2field.getText(),
						stu3field.getText(), stu4field.getText(), stu5field.getText(), stu6field.getText());
				JOptionPane.showMessageDialog(null, message, "입력 결과", JOptionPane.INFORMATION_MESSAGE);
				break;

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
