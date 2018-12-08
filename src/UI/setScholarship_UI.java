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

		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeAdmin_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// �α��� ���� ��
		aID = new JLabel("admin");
		aID.setBounds(807, 133, 100, 20);
		aID.setForeground(Color.WHITE);

		// �а��� �ʵ�
		majfield = new JTextField(10);
		majfield.setBounds(630, 235, 100, 20);
		majfield.setOpaque(false);
		majfield.setForeground(Color.WHITE);
		// subject1field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		majfield.setCaretColor(Color.white);

		// ������2 �ʵ�
		stu1field = new JTextField(10);
		stu1field.setBounds(630, 273, 100, 20);
		stu1field.setOpaque(false);
		stu1field.setForeground(Color.WHITE);
		// subject2field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu1field.setCaretColor(Color.white);

		// ������3 �ʵ�
		stu2field = new JTextField(10);
		stu2field.setBounds(630, 311, 100, 20);
		stu2field.setOpaque(false);
		stu2field.setForeground(Color.WHITE);
		// subject3field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu2field.setCaretColor(Color.white);

		// ������4 �ʵ�
		stu3field = new JTextField(10);
		stu3field.setBounds(630, 349, 100, 20);
		stu3field.setOpaque(false);
		stu3field.setForeground(Color.WHITE);
		// subject4field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu3field.setCaretColor(Color.white);

		// ������5 �ʵ�
		stu4field = new JTextField(10);
		stu4field.setBounds(630, 387, 100, 20);
		stu4field.setOpaque(false);
		stu4field.setForeground(Color.WHITE);
		// subject5field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu4field.setCaretColor(Color.white);

		// ������6 �ʵ�
		stu5field = new JTextField(10);
		stu5field.setBounds(630, 425, 100, 20);
		stu5field.setOpaque(false);
		stu5field.setForeground(Color.WHITE);
		// subject6field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu5field.setCaretColor(Color.white);

		// ������7 �ʵ�
		stu6field = new JTextField(10);
		stu6field.setBounds(630, 463, 100, 20);
		stu6field.setOpaque(false);
		stu6field.setForeground(Color.WHITE);
		// subject7field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stu6field.setCaretColor(Color.white);

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
			case "��������":
				ui.update_UI("register");
				break;
			case "��������":
				ui.update_UI("gradeAdminSetID");
				break;
			case "���а���":
				System.out.println("scholarship");
				break;
			case "����":

				// �а��� ����ó��
				if (!majfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�а����� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(majfield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "�а����� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (isStringEqualToTemp(majfield.getText()) == true) {
						} else {
							JOptionPane.showMessageDialog(null, "�а����� ��Ȯ�� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// �й�1 ����ó��
				if (stu1field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu1field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu1field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// �й�2 ����ó��
				if (stu2field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu2field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu2field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// �й�3 ����ó��
				if (stu3field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu3field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu3field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// �й�4 ����ó��
				if (stu4field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu4field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu4field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// �й�5 ����ó��
				if (stu5field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu5field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu5field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// �й�6 ����ó��
				if (stu6field.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stu6field.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stu6field.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// ���л� ��Ȳ ����
				String message = sc.setScholarshipStu(majfield.getText(), stu1field.getText(), stu2field.getText(),
						stu3field.getText(), stu4field.getText(), stu5field.getText(), stu6field.getText());
				JOptionPane.showMessageDialog(null, message, "�Է� ���", JOptionPane.INFORMATION_MESSAGE);
				break;

			case "���":
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
		case "������а�":
			return true;
		case "��ǻ�Ͱ��а�":
			return true;
		case "������а�":
			return true;
		case "ö�а�":
			return true;
		case "ȯ����а�":
			return true;
		case "�����а�":
			return true;
		case "������а�":
			return true;
		case "�����а�":
			return true;
		case "�ɸ��а�":
			return true;
		case "�����а�":
			return true;
		default:
			return false;
		}
	}
}
