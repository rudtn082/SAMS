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

import People.*;
import SAMS.Main;

public class Login extends JPanel{
	ArrayList<String> array = new ArrayList<String>(); // 파일 읽은 값을 저장하는 arraylist
	JTextField loginTextField;
	JPasswordField passwordField;
	BufferedImage img = null;
	JButton bt;
	JLabel Id, passwd;
	UI_Main ui;

	public Login(UI_Main ui) {
		this.ui = ui;
		// 레이아웃 설정
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(""); 
	    lblNewLabel.setIcon(new ImageIcon("Resource/login.png")); 
	    lblNewLabel.setBounds(0, 0, 1024, 768);
	

		// 아이디 필드
		loginTextField = new JTextField(10);	
		loginTextField.setBounds(435, 260, 400, 60);
		loginTextField.setOpaque(false);		
		loginTextField.setForeground(Color.WHITE);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		loginTextField.setCaretColor(Color.white);
		
		// 패스워드 필드
		passwordField = new JPasswordField(10);
		passwordField.setBounds(435, 415, 400, 60);
		passwordField.setOpaque(false);		
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordField.setCaretColor(Color.white);
		
		// 로그인버튼 추가
		bt = new JButton("로그인");
		bt.setBackground(new Color(114, 137, 218));
		bt.setForeground(Color.WHITE);
		bt.setBounds(435, 500, 400, 60);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);	
		
		add(loginTextField);
		add(passwordField);
		add(bt);
		add(lblNewLabel);
		bt.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Admin admin = new Admin();
			Student stu = new Student();
			// admin입력했을 때
			if(loginTextField.getText().equals(admin.getID())) {
				if(String.valueOf(passwordField.getPassword()).equals(admin.getPW())) {
					ui.update_UI("Main_Menu_admin");
				}
			}
			// 학생이 입력했을 때
			else {
				register_read(); // 파일을 먼저 읽어온다.
				if (array.isEmpty() == false)  {
					for (int i = 0; i < array.size(); i++) {
						String[] splitString = array.get(i).split(" ");
						// 동일한 학번이 있으면
						if (loginTextField.getText().equals(splitString[1])) {
							for (int j = 0; j < array.size(); j++) {
								String[] splitString2 = array.get(j).split(" ");
								if(passwordField.getText().equals(splitString2[5])) {
									// 학생 클래스 생성 및 UI변경
									ui.setStudent(loginTextField.getText(), splitString2[0]);
									ui.update_UI("Main_Menu_Student");
									return;
								}
							}
						}
					}
					JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				} else { // array가 null이면 파일이 없는 것(학생 데이터가 없음)
					JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	

	// 파일 읽어오기 함수(학생정보)
	public void register_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/register.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				array.add(line);
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
