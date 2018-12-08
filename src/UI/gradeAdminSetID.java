package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import UI.Main_Menu_admin.MyActionListener;
import gradeManagement.registerGrade;
import gradeManagement.grade;

public class gradeAdminSetID extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, ok, cancel;
	UI_Main ui;
	JTextField sIDfield;

	public gradeAdminSetID(UI_Main ui) {
		this.ui = ui;
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeAdminSetID.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// 학번 필드 추가
		sIDfield = new JTextField(10);
		sIDfield.setBounds(400, 343, 150, 30);
		sIDfield.setOpaque(false);
		sIDfield.setForeground(Color.WHITE);
		sIDfield.setCaretColor(Color.white);

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
		ok = new JButton("확인");
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

		add(sIDfield);
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
				ui.update_UI("scholarship");
				break;
			case "확인":
				grade stu = new grade();
				String stuStr = stu.checkSID(sIDfield.getText());
				// 학번 예외처리
				if (!sIDfield.getText().isEmpty()) {// 학번을 적었으면
					if (isStringDouble(sIDfield.getText()) == false) { // 숫자로 잘 입력 안했으면!!!
						JOptionPane.showMessageDialog(null, "학번은 숫자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (!(stuStr == null)) { // 숫자로 잘 입력 했고 아이디가 있으면
						if (isStringEqualToTemp(stu.checkSubject(sIDfield.getText(), 1))) { // 숫자로 잘입력했고 아이디가 있고 점수도 있으면
							JOptionPane.showMessageDialog(null, "학생의 정보가 이미 있습니다.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "학생 성적란을 생성합니다.", "입력 결과", JOptionPane.INFORMATION_MESSAGE);
					}
				}

				// 학번 설정
				ui.setStudentAdmin(sIDfield.getText());
				ui.update_UI("gradeAdmin_UI");
				break;
			case "취소":
				ui.update_UI("Main_Menu_admin");
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
		case "A+":
			return true;
		case "A0":
			return true;
		case "B+":
			return true;
		case "B0":
			return true;
		case "C+":
			return true;
		case "C0":
			return true;
		case "D":
			return true;
		case "F":
			return true;
		case "N/A":
			return true;
		default:
			return false;
		}
	}
}
