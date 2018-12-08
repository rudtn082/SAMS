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
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/register.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// �������� ��ư �߰�
		register_bt = new JButton("��������");
		register_bt.setBorderPainted(false);
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(44, 23, 200, 55);

		// �������� ��ư �߰�
		grade_bt = new JButton("��������");
		grade_bt.setBorderPainted(false);
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(300, 23, 200, 55);

		// ���а��� ��ư �߰�
		scholarship_bt = new JButton("���а���");
		scholarship_bt.setBorderPainted(false);
		scholarship_bt.setContentAreaFilled(false);
		scholarship_bt.setFocusPainted(false);
		scholarship_bt.setForeground(Color.WHITE);
		scholarship_bt.setBounds(556, 23, 200, 55);

		// �̸� �ʵ�
		name = new JTextField(10);
		name.setBounds(333, 195, 450, 55);
		name.setOpaque(false);
		name.setForeground(Color.WHITE);
		name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		name.setCaretColor(Color.white);

		// �й� �ʵ�
		id = new JTextField(10);
		id.setBounds(333, 268, 450, 55);
		id.setOpaque(false);
		id.setForeground(Color.WHITE);
		id.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		id.setCaretColor(Color.white);

		// �ּ� �ʵ�
		address = new JTextField(10);
		address.setBounds(333, 341, 450, 55);
		address.setOpaque(false);
		address.setForeground(Color.WHITE);
		address.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		address.setCaretColor(Color.white);

		// ���� �ʵ�
		gender = new JTextField(10);
		gender.setBounds(333, 414, 450, 55);
		gender.setOpaque(false);
		gender.setForeground(Color.WHITE);
		gender.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		gender.setCaretColor(Color.white);

		// ������Ȳ �ʵ�
		status = new JTextField(10);
		status.setBounds(333, 487, 450, 55);
		status.setOpaque(false);
		status.setForeground(Color.WHITE);
		status.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		status.setCaretColor(Color.white);

		// ������� �ʵ�
		dob = new JTextField(10);
		dob.setBounds(333, 560, 450, 55);
		dob.setOpaque(false);
		dob.setForeground(Color.WHITE);
		dob.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		dob.setCaretColor(Color.white);

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
			case "����":
				// �̸� ����ó��
				if (name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(name.getText()) == true) {
						JOptionPane.showMessageDialog(null, "�̸��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}

				// �й� ����ó��
				if (id.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�й��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(id.getText()) == false) {
						JOptionPane.showMessageDialog(null, "�й��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (id.getText().length() != 8) {
							JOptionPane.showMessageDialog(null, "�й��� 8�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// �ּ� ����ó��
				if (address.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�ּҸ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(address.getText()) == true) {
						JOptionPane.showMessageDialog(null, "�ּҴ� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}

				// ���� ����ó��
				if (gender.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(gender.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (gender.getText().equals("��") || gender.getText().equals("��")) {
						} else {
							JOptionPane.showMessageDialog(null, "������ ��/���� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// ������Ȳ ����ó��
				Boolean YorN = null;
				if (status.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������Ȳ�� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (status.getText().equals("Y") || status.getText().equals("y")) {
						YorN = true;
					} else if (status.getText().equals("N") || status.getText().equals("n")) {
						YorN = false;
					} else {
						JOptionPane.showMessageDialog(null, "������Ȳ�� Y �Ǵ� N���� �Է����ּ���.", "�Է� ����",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				// ������� ����ó��
				if (dob.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "��������� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(dob.getText()) == false) {
						JOptionPane.showMessageDialog(null, "��������� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (dob.getText().length() != 6) {
							JOptionPane.showMessageDialog(null, "��������� 6�ڸ��� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}

				// ��������
				register reg = new register();
				String message = reg.setSID(name.getText(), Integer.parseInt(id.getText()), address.getText(),
						gender.getText(), YorN, Integer.parseInt(dob.getText()));
				JOptionPane.showMessageDialog(null, message, "�Է� ���", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "���":
				ui.update_UI("Main_Menu_admin");
				break;
			case "��������":
				ui.update_UI("register");
				break;
			case "��������":
				ui.update_UI("gradeAdminSedtID");
				break;
			case "���а���":
				System.out.println("���а��� ��ư");
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
