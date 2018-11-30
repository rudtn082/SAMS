package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import People.Student;
import schoolRegister.changeRegister;
import schoolRegister.checkInfo;

public class changeRegister_UI extends JPanel {
	Student st;
	JButton curriculum_bt, register_bt, grade_bt, course_bt, ok, cancel;
	UI_Main ui;
	JLabel la = new JLabel("No Mouse Event");
	JLabel Lname, Laddress, Lgender, Cname, Caddress, Cgender;
	JTextField namefield, addressfield, genderfield;
	
	public changeRegister_UI(UI_Main ui) {
		this.ui = ui;
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/changeRegister.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		////////////////////////////////////////////////////////////////////////// 좌표볼려구

		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		la.setBounds(0, 0, 200, 30);
		la.setForeground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////

		// 학생 정보 받아오기
		checkInfo ci = new checkInfo();
		st = ui.getStudent();
		if (st.getsID() == null) {
			return;
		}
		String stuStr = ci.checkInfo(st.getsID());
		String[] splitString = stuStr.split(" ");

		// 변경 전 내용 출력
		Lname = new JLabel(splitString[0]);
		Lname.setBounds(171, 185, 200, 30);
		Lname.setForeground(Color.GRAY);

		Laddress = new JLabel(splitString[2]);
		Laddress.setBounds(171, 353, 200, 30);
		Laddress.setForeground(Color.GRAY);
	
		Lgender = new JLabel(splitString[3]);
		Lgender.setBounds(220, 525, 200, 30);
		Lgender.setForeground(Color.GRAY);
		// 변경 전 내용 출력
		
		// 이름 필드
		namefield = new JTextField(10);
		namefield.setBounds(105, 232, 400, 60);
		namefield.setOpaque(false);
		namefield.setForeground(Color.WHITE);
		namefield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		namefield.setCaretColor(Color.white);

		// 주소 필드
		addressfield = new JTextField(10);
		addressfield.setBounds(105, 399, 400, 60);
		addressfield.setOpaque(false);
		addressfield.setForeground(Color.WHITE);
		addressfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		addressfield.setCaretColor(Color.white);

		// 성별 필드
		genderfield = new JTextField(10);
		genderfield.setBounds(105, 568, 400, 60);
		genderfield.setOpaque(false);
		genderfield.setForeground(Color.WHITE);
		genderfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		genderfield.setCaretColor(Color.white);
		
		// 교과관리 버튼 추가
		curriculum_bt = new JButton("교과관리");
		curriculum_bt.setContentAreaFilled(false);
		curriculum_bt.setFocusPainted(false);
		curriculum_bt.setForeground(Color.WHITE);
		curriculum_bt.setBounds(20, 23, 200, 55);

		// 학적관리 버튼 추가
		register_bt = new JButton("학적관리");
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(270, 23, 200, 55);

		// 성적관리 버튼 추가
		grade_bt = new JButton("성적관리");
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(520, 23, 200, 55);

		// 수강관리 버튼 추가
		course_bt = new JButton("수강관리");
		course_bt.setContentAreaFilled(false);
		course_bt.setFocusPainted(false);
		course_bt.setForeground(Color.WHITE);
		course_bt.setBounds(770, 23, 200, 55);

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

		add(Lname);
		add(Laddress);
		add(Lgender);
		add(namefield);
		add(addressfield);
		add(genderfield);
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(la);
		add(cancel);
		add(ok);
		add(lblNewLabel);
		curriculum_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		course_bt.addActionListener(new MyActionListener());
		ok.addActionListener(new MyActionListener());
		cancel.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "학적관리":
				ui.update_UI("schoolRegister");
				break;
			case "성적관리":
				System.out.println("성적관리 버튼");
				break;
			case "교과관리":
				ui.update_UI("curriculum_UI");
				break;
			case "수강관리":
				ui.update_UI("courseManagement_UI");
				break;
			case "저장":
				// 이름 예외처리
				if (namefield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(namefield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "이름은 글자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				
				// 주소 예외처리
				if (addressfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "주소를 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(addressfield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "주소는 글자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				
				// 성별 예외처리
				if (genderfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "성별을 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(genderfield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "성별은 글자로 입력해주세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (genderfield.getText().equals("남") || genderfield.getText().equals("여")) {
						} else {
							JOptionPane.showMessageDialog(null, "성별은 남/여로 입력해주세요.", "입력 오류",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				// 학적 변경
				changeRegister creg = new changeRegister();
				String message = creg.changeInfo(Integer.parseInt(st.getsID()), namefield.getText(), addressfield.getText(),
						genderfield.getText());
				JOptionPane.showMessageDialog(null, message, "입력 결과", JOptionPane.INFORMATION_MESSAGE);
				break;

			case "취소":
				ui.update_UI("schoolRegister");
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

	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			la.setText("MouseClicked(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("MouseMoved(" + e.getX() + "," + e.getY() + ")");
		}

	}

}
