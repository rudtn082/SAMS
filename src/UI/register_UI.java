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

import schoolRegister.register;

public class register_UI extends JPanel {
	JTextField name, id, address, gender, status, dob;
	JButton register_bt, grade_bt, scholarship_bt;
	UI_Main ui;
	JButton ok, cancel;

	public register_UI(UI_Main ui) {
		this.ui = ui;
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/register.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// 학적관리 버튼 추가
		register_bt = new JButton("학적관리");
		register_bt.setBorderPainted(false);
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(44, 23, 200, 55);

		// 성적관리 버튼 추가
		grade_bt = new JButton("성적관리");
		grade_bt.setBorderPainted(false);
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(300, 23, 200, 55);

		// 장학관리 버튼 추가
		scholarship_bt = new JButton("장학관리");
		scholarship_bt.setBorderPainted(false);
		scholarship_bt.setContentAreaFilled(false);
		scholarship_bt.setFocusPainted(false);
		scholarship_bt.setForeground(Color.WHITE);
		scholarship_bt.setBounds(556, 23, 200, 55);

		// 이름 필드
		name = new JTextField(10);
		name.setBounds(333, 195, 450, 55);
		name.setOpaque(false);
		name.setForeground(Color.WHITE);
		name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		name.setCaretColor(Color.white);

		// 학번 필드
		id = new JTextField(10);
		id.setBounds(333, 268, 450, 55);
		id.setOpaque(false);
		id.setForeground(Color.WHITE);
		id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		id.setCaretColor(Color.white);

		// 주소 필드
		address = new JTextField(10);
		address.setBounds(333, 341, 450, 55);
		address.setOpaque(false);
		address.setForeground(Color.WHITE);
		address.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		address.setCaretColor(Color.white);

		// 성별 필드
		gender = new JTextField(10);
		gender.setBounds(333, 414, 450, 55);
		gender.setOpaque(false);
		gender.setForeground(Color.WHITE);
		gender.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		gender.setCaretColor(Color.white);

		// 제적상황 필드
		status = new JTextField(10);
		status.setBounds(333, 487, 450, 55);
		status.setOpaque(false);
		status.setForeground(Color.WHITE);
		status.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		status.setCaretColor(Color.white);

		// 생년월일 필드
		dob = new JTextField(10);
		dob.setBounds(333, 560, 450, 55);
		dob.setOpaque(false);
		dob.setForeground(Color.WHITE);
		dob.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		dob.setCaretColor(Color.white);

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

		add(name);
		add(id);
		add(address);
		add(gender);
		add(status);
		add(dob);
		add(cancel);
		add(ok);
		add(register_bt);
		add(grade_bt);
		add(scholarship_bt);
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
			case "저장":
				// 이름 예외처리
				if (name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(name.getText()) == true) {
						JOptionPane.showMessageDialog(null, "이름은 글자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}

				// 학번 예외처리
				if (id.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "학번을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(id.getText()) == false) {
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (id.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "학번은 8자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 주소 예외처리
				if (address.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "주소를 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(address.getText()) == true) {
						JOptionPane.showMessageDialog(null, "주소는 글자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}

				// 성별 예외처리
				if (gender.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "성별을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(gender.getText()) == true) {
						JOptionPane.showMessageDialog(null, "성별은 글자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (gender.getText().equals("남") || gender.getText().equals("여")) {
						} else {
							JOptionPane.showMessageDialog(null, "성별은 남/여로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 제적상황 예외처리
				Boolean YorN = null;
				if (status.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "제적상황을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (status.getText().equals("Y") || status.getText().equals("y")) {
						YorN = true;
					} else if (status.getText().equals("N") || status.getText().equals("n")) {
						YorN = false;
					} else {
						JOptionPane.showMessageDialog(null, "제적상황은 Y 또는 N으로 입력해주세요.", "입력 오류",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				// 생년월일 예외처리
				if (dob.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "생년월일을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(dob.getText()) == false) {
						JOptionPane.showMessageDialog(null, "생년월일은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (dob.getText().length() != 6) {
							JOptionPane.showMessageDialog(null, "생년월일은 6자리로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// 학적생성
				register reg = new register();
				String message = reg.setSID(name.getText(), Integer.parseInt(id.getText()), address.getText(),
						gender.getText(), YorN, Integer.parseInt(dob.getText()));
				JOptionPane.showMessageDialog(null, message, "입력 결과", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "취소":
				ui.update_UI("Main_Menu_admin");
				break;
			case "학적관리":
				ui.update_UI("register");
				break;
			case "성적관리":
				ui.update_UI("gradeAdminSedtID");
				break;
			case "장학관리":
				System.out.println("장학관리 버튼");
				break;
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
	}
}
