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
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeAdminSetID.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// �й� �ʵ� �߰�
		sIDfield = new JTextField(10);
		sIDfield.setBounds(400, 343, 150, 30);
		sIDfield.setOpaque(false);
		sIDfield.setForeground(Color.WHITE);
		sIDfield.setCaretColor(Color.white);

		// �������� ��ư �߰�
		register_bt = new JButton("��������");
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(44, 23, 200, 55);

		// �������� ��ư �߰�
		grade_bt = new JButton("��������");
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(300, 23, 200, 55);

		// ���а��� ��ư �߰�
		scholarship_bt = new JButton("���а���");
		scholarship_bt.setContentAreaFilled(false);
		scholarship_bt.setFocusPainted(false);
		scholarship_bt.setForeground(Color.WHITE);
		scholarship_bt.setBounds(556, 23, 200, 55);

		// �����ư �߰�
		ok = new JButton("Ȯ��");
		ok.setBackground(new Color(114, 137, 218));
		ok.setForeground(Color.WHITE);
		ok.setBounds(105, 647, 350, 60);
		ok.setBorderPainted(false);
		ok.setFocusPainted(false);

		// ��ҹ�ư �߰�
		cancel = new JButton("���");
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
			case "��������":
				ui.update_UI("register");
				break;
			case "��������":
				ui.update_UI("gradeAdminSetID");
				break;
			case "���а���":
				ui.update_UI("scholarship");
				break;
			case "Ȯ��":
				grade stu = new grade();
				String stuStr = stu.checkSID(sIDfield.getText());
				// �й� ����ó��
				if (!sIDfield.getText().isEmpty()) {// �й��� ��������
					if (isStringDouble(sIDfield.getText()) == false) { // ���ڷ� �� �Է� ��������!!!
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else if (!(stuStr == null)) { // ���ڷ� �� �Է� �߰� ���̵� ������
						if (isStringEqualToTemp(stu.checkSubject(sIDfield.getText(), 1))) { // ���ڷ� ���Է��߰� ���̵� �ְ� ������ ������
							JOptionPane.showMessageDialog(null, "�л��� ������ �̹� �ֽ��ϴ�.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "�л� �������� �����մϴ�.", "�Է� ���", JOptionPane.INFORMATION_MESSAGE);
					}
				}

				// �й� ����
				ui.setStudentAdmin(sIDfield.getText());
				ui.update_UI("gradeAdmin_UI");
				break;
			case "���":
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
