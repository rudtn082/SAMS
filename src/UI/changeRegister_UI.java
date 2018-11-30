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
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/changeRegister.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		////////////////////////////////////////////////////////////////////////// ��ǥ������

		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		la.setBounds(0, 0, 200, 30);
		la.setForeground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////

		// �л� ���� �޾ƿ���
		checkInfo ci = new checkInfo();
		st = ui.getStudent();
		if (st.getsID() == null) {
			return;
		}
		String stuStr = ci.checkInfo(st.getsID());
		String[] splitString = stuStr.split(" ");

		// ���� �� ���� ���
		Lname = new JLabel(splitString[0]);
		Lname.setBounds(171, 185, 200, 30);
		Lname.setForeground(Color.GRAY);

		Laddress = new JLabel(splitString[2]);
		Laddress.setBounds(171, 353, 200, 30);
		Laddress.setForeground(Color.GRAY);
	
		Lgender = new JLabel(splitString[3]);
		Lgender.setBounds(220, 525, 200, 30);
		Lgender.setForeground(Color.GRAY);
		// ���� �� ���� ���
		
		// �̸� �ʵ�
		namefield = new JTextField(10);
		namefield.setBounds(105, 232, 400, 60);
		namefield.setOpaque(false);
		namefield.setForeground(Color.WHITE);
		namefield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		namefield.setCaretColor(Color.white);

		// �ּ� �ʵ�
		addressfield = new JTextField(10);
		addressfield.setBounds(105, 399, 400, 60);
		addressfield.setOpaque(false);
		addressfield.setForeground(Color.WHITE);
		addressfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		addressfield.setCaretColor(Color.white);

		// ���� �ʵ�
		genderfield = new JTextField(10);
		genderfield.setBounds(105, 568, 400, 60);
		genderfield.setOpaque(false);
		genderfield.setForeground(Color.WHITE);
		genderfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		genderfield.setCaretColor(Color.white);
		
		// �������� ��ư �߰�
		curriculum_bt = new JButton("��������");
		curriculum_bt.setContentAreaFilled(false);
		curriculum_bt.setFocusPainted(false);
		curriculum_bt.setForeground(Color.WHITE);
		curriculum_bt.setBounds(20, 23, 200, 55);

		// �������� ��ư �߰�
		register_bt = new JButton("��������");
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(270, 23, 200, 55);

		// �������� ��ư �߰�
		grade_bt = new JButton("��������");
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(520, 23, 200, 55);

		// �������� ��ư �߰�
		course_bt = new JButton("��������");
		course_bt.setContentAreaFilled(false);
		course_bt.setFocusPainted(false);
		course_bt.setForeground(Color.WHITE);
		course_bt.setBounds(770, 23, 200, 55);

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
			case "��������":
				ui.update_UI("schoolRegister");
				break;
			case "��������":
				System.out.println("�������� ��ư");
				break;
			case "��������":
				ui.update_UI("curriculum_UI");
				break;
			case "��������":
				ui.update_UI("courseManagement_UI");
				break;
			case "����":
				// �̸� ����ó��
				if (namefield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(namefield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "�̸��� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				
				// �ּ� ����ó��
				if (addressfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�ּҸ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(addressfield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "�ּҴ� ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				
				// ���� ����ó��
				if (genderfield.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					break;
				} else {
					if (isStringDouble(genderfield.getText()) == true) {
						JOptionPane.showMessageDialog(null, "������ ���ڷ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
						break;
					} else {
						if (genderfield.getText().equals("��") || genderfield.getText().equals("��")) {
						} else {
							JOptionPane.showMessageDialog(null, "������ ��/���� �Է����ּ���.", "�Է� ����",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
				// ���� ����
				changeRegister creg = new changeRegister();
				String message = creg.changeInfo(Integer.parseInt(st.getsID()), namefield.getText(), addressfield.getText(),
						genderfield.getText());
				JOptionPane.showMessageDialog(null, message, "�Է� ���", JOptionPane.INFORMATION_MESSAGE);
				break;

			case "���":
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
