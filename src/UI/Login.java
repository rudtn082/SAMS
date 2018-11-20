package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import People.*;

public class Login extends JPanel{
	JTextField loginTextField;
	JPasswordField passwordField;
	BufferedImage img = null;
	JButton bt;
	JLabel Id, passwd;
	UI_Main ui;

	public Login(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(""); 
	    lblNewLabel.setIcon(new ImageIcon("Resource/login.png")); 
	    lblNewLabel.setBounds(0, 0, 1024, 768);
	

		// ���̵� �ʵ�
		loginTextField = new JTextField(10);	
		loginTextField.setBounds(435, 260, 400, 60);
		loginTextField.setOpaque(false);		
		loginTextField.setForeground(Color.WHITE);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		loginTextField.setCaretColor(Color.white);
		
		// �н����� �ʵ�
		passwordField = new JPasswordField(10);
		passwordField.setBounds(435, 415, 400, 60);
		passwordField.setOpaque(false);		
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		passwordField.setCaretColor(Color.white);
		
		// �α��ι�ư �߰�
		bt = new JButton("�α���");
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
			// admin�Է����� ��
			if(loginTextField.getText().equals(admin.getID())) {
				if(String.valueOf(passwordField.getPassword()).equals(admin.getPW())) {
					ui.update_UI("Main_Menu_admin");
				}
			}
			// �л��� �Է����� ��
			else {
				
			}
		}
	}
}
