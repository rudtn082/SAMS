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
import javax.swing.JPanel;

public class schoolRegister extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, srcheck_bt, srchange_bt;
	UI_Main ui;

	public schoolRegister(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/schoolRegister.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

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


		// ������ȸ ��ư �߰�
		srcheck_bt = new JButton("���� ��ȸ");
		srcheck_bt.setBackground(new Color(114, 137, 218));
		srcheck_bt.setForeground(Color.WHITE);
		srcheck_bt.setBounds(105, 380, 350, 60);
		srcheck_bt.setBorderPainted(false);
		srcheck_bt.setFocusPainted(false);	
		
		// ���� ���� ��ư �߰�
		srchange_bt = new JButton("���� ����");
		srchange_bt.setBackground(new Color(114, 137, 218));
		srchange_bt.setForeground(Color.WHITE);
		srchange_bt.setBounds(510, 380, 350, 60);
		srchange_bt.setBorderPainted(false);
		srchange_bt.setFocusPainted(false);	
		
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(srchange_bt);
		add(srcheck_bt);
		add(lblNewLabel);
		curriculum_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		course_bt.addActionListener(new MyActionListener());
		srcheck_bt.addActionListener(new MyActionListener());
		srchange_bt.addActionListener(new MyActionListener());
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
			case "���� ��ȸ":
				ui.update_UI("checkInfo_UI");
				break;
			case "���� ����":
				ui.update_UI("changeRegister_UI");
				break;
			}
		}
	}
}
