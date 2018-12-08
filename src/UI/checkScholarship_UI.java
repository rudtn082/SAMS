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

		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeAdmin_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// �α��� ���� ��
		aID = new JLabel("admin");
		aID.setBounds(807, 133, 100, 20);
		aID.setForeground(Color.WHITE);

		// ������1 �ʵ�
		stufield = new JTextField(10);
		stufield.setBounds(630, 235, 100, 20);
		stufield.setOpaque(false);
		stufield.setForeground(Color.WHITE);
		// subject1field.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		stufield.setCaretColor(Color.white);

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
				// �й�1 ����ó��
				if (stufield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(stufield.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (stufield.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						} else {
							if (sc.checkStuMatch(stufield.getText()) == true) {
								JOptionPane.showMessageDialog(null, "�ش� �л��� ���л����� �Է� �����մϴ�.", "Ȯ�� ����", JOptionPane.WARNING_MESSAGE);
								break;
							}
						}
					}
				}
				
				JOptionPane.showMessageDialog(null, "�ش� �л��� ���л����� �Է� �����մϴ�.", "Ȯ�� ����", JOptionPane.WARNING_MESSAGE);

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
