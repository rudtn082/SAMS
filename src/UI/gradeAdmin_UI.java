package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import People.Student;
import UI.Main_Menu_admin.MyActionListener;
import courseManagement.courseManagementDAO;
import curriculum.subCheckDAO;
import People.Admin;
import gradeManagement.grade;
import gradeManagement.registerGrade;

public class gradeAdmin_UI extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, ok, cancel;
	UI_Main ui;
	JLabel aID;
	JLabel[] sub = new JLabel[10]; // �����
	JTextField subject1field, subject2field, subject3field, subject4field, subject5field, subject6field, subject7field,
			subject8field, subject9field, subject10field, gpafield;
	int majorNum;
	subCheckDAO subcheckdao = new subCheckDAO();
	String[] grade = null;
	String sID;
	courseManagementDAO coursemanagementdao = new courseManagementDAO();

	// ���� �����ο� �ҷ�����
	public String[] readCourseStudentNumber(int lineNumber) {
		String line = "";
		String[] splited;
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/curStuNum.txt");
			BufferedReader r = new BufferedReader(new FileReader(file));
			for (int i = 0; i < lineNumber + 1; i++) {
				line = r.readLine();
			}
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		splited = line.split(" ");

		return splited;
	}

	public gradeAdmin_UI(UI_Main ui) {
		this.ui = ui;
		Student st = ui.getStudent();
		sID = st.getsID();
		if (sID == null)
			return;
		majorNum = Integer.parseInt(sID);
		int subsID = Integer.parseInt(sID.substring(4, 5));
		String[][] subList = subcheckdao.subCheckDAO();

		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeAdmin_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		for (int i = 0; i < 10; i++) {
			sub[i] = new JLabel(subList[subsID][i]);
			sub[i].setForeground(Color.WHITE);
			sub[i].setBounds(235, (235 + (38 * i)), 100, 20);
			add(sub[i]);
		}

		// ������1 �ʵ�
		subject1field = new JTextField(10);
		subject1field.setBounds(630, 235, 100, 20);
		subject1field.setOpaque(false);
		subject1field.setForeground(Color.WHITE);
		// subject1field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject1field.setCaretColor(Color.white);

		// ������2 �ʵ�
		subject2field = new JTextField(10);
		subject2field.setBounds(630, 273, 100, 20);
		subject2field.setOpaque(false);
		subject2field.setForeground(Color.WHITE);
		// subject2field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject2field.setCaretColor(Color.white);

		// ������3 �ʵ�
		subject3field = new JTextField(10);
		subject3field.setBounds(630, 311, 100, 20);
		subject3field.setOpaque(false);
		subject3field.setForeground(Color.WHITE);
		// subject3field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject3field.setCaretColor(Color.white);

		// ������4 �ʵ�
		subject4field = new JTextField(10);
		subject4field.setBounds(630, 349, 100, 20);
		subject4field.setOpaque(false);
		subject4field.setForeground(Color.WHITE);
		// subject4field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject4field.setCaretColor(Color.white);

		// ������5 �ʵ�
		subject5field = new JTextField(10);
		subject5field.setBounds(630, 387, 100, 20);
		subject5field.setOpaque(false);
		subject5field.setForeground(Color.WHITE);
		// subject5field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject5field.setCaretColor(Color.white);

		// ������6 �ʵ�
		subject6field = new JTextField(10);
		subject6field.setBounds(630, 425, 100, 20);
		subject6field.setOpaque(false);
		subject6field.setForeground(Color.WHITE);
		// subject6field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject6field.setCaretColor(Color.white);

		// ������7 �ʵ�
		subject7field = new JTextField(10);
		subject7field.setBounds(630, 463, 100, 20);
		subject7field.setOpaque(false);
		subject7field.setForeground(Color.WHITE);
		// subject7field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject7field.setCaretColor(Color.white);

		// ������8 �ʵ�
		subject8field = new JTextField(10);
		subject8field.setBounds(630, 501, 100, 20);
		subject8field.setOpaque(false);
		subject8field.setForeground(Color.WHITE);
		// subject8field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject8field.setCaretColor(Color.white);

		// ������9 �ʵ�
		subject9field = new JTextField(10);
		subject9field.setBounds(630, 539, 100, 20);
		subject9field.setOpaque(false);
		subject9field.setForeground(Color.WHITE);
		// subject9field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject9field.setCaretColor(Color.white);

		// ������10 �ʵ�
		subject10field = new JTextField(10);
		subject10field.setBounds(630, 577, 100, 20);
		subject10field.setOpaque(false);
		subject10field.setForeground(Color.WHITE);
		// subject10field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		subject10field.setCaretColor(Color.white);

		// GPA �ʵ�
		gpafield = new JTextField(10);
		gpafield.setBounds(630, 615, 100, 20);
		gpafield.setOpaque(false);
		gpafield.setForeground(Color.WHITE);
		// gpafield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		gpafield.setCaretColor(Color.white);

		// �α��� ���� ��
		aID = new JLabel("admin");
		aID.setBounds(807, 133, 100, 20);
		aID.setForeground(Color.WHITE);

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
		ok = new JButton("����");
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

		add(subject1field);
		add(subject2field);
		add(subject3field);
		add(subject4field);
		add(subject5field);
		add(subject6field);
		add(subject7field);
		add(subject8field);
		add(subject9field);
		add(subject10field);
		add(gpafield);
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
			case "��������":
				ui.update_UI("register");
				break;
			case "��������":
				ui.update_UI("gradeAdminSetID");
				break;
			case "���а���":
				ui.update_UI("scholarship");
				break;
			case "����":
				// �й�6 ����ó��
				/*
				 * if (stu6field.getText().isEmpty()) { JOptionPane.showMessageDialog(null,
				 * "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE); break; } else { if
				 * (isStringDouble(stu6field.getText()) == false) {
				 * JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����",
				 * JOptionPane.WARNING_MESSAGE); break; } else { if
				 * (stu6field.getText().length() != 8) { JOptionPane.showMessageDialog(null,
				 * "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE); break; } } }
				 */

				// GPA ����ó��
				if (gpafield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "GPA�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(gpafield.getText()) == false) {
						JOptionPane.showMessageDialog(null, "GPA�� ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (gpafield.getText().length() != 4) {
							JOptionPane.showMessageDialog(null, "GPA�� 3�ڸ��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject1field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject1field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject1field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// ���� ����ó��
				if (subject2field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject2field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject2field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// ���� ����ó��
				if (subject3field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject3field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject3field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject4field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject4field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject4field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject5field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject5field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject5field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject6field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject6field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject6field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject7field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject7field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject7field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject8field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject8field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject8field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject9field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject9field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject9field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				
				// ���� ����ó��
				if (subject10field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(subject10field.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(subject10field.getText()) == false) {
							JOptionPane.showMessageDialog(null, "������ ��Ȯ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// ��������

				registerGrade reg = new registerGrade();
				String message = reg.setSGrade(Integer.parseInt(sID), Double.parseDouble(gpafield.getText()),
						subject1field.getText(), subject2field.getText(), subject3field.getText(),
						subject4field.getText(), subject5field.getText(), subject6field.getText(),
						subject7field.getText(), subject8field.getText(), subject9field.getText(),
						subject10field.getText());
				JOptionPane.showMessageDialog(null, message, "�Է� ���", JOptionPane.INFORMATION_MESSAGE);
				ui.update_UI("gradeAdminSetID");
				break;

			case "���":
				ui.update_UI("gradeAdminSetID");
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
