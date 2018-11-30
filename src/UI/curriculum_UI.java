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

public class curriculum_UI extends JPanel  {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, subCheck_bt, scheduleCheck_bt, courseCheck_bt, altCourse_bt;
	UI_Main ui;

	public curriculum_UI(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("���� ����");
		lblNewLabel.setIcon(new ImageIcon("Resource/curriculum.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// �޴� ��  ��ư �� //

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

		// ���� ���� ��ư �� //

		// ������(��ȸ) ��ư �߰�
		subCheck_bt = new JButton("������");
		subCheck_bt.setBackground(new Color(114, 137, 218));
		subCheck_bt.setForeground(Color.WHITE);
		subCheck_bt.setBounds(50, 280, 355, 60);
		subCheck_bt.setBorderPainted(false);
		subCheck_bt.setFocusPainted(false);	
		
		// ���� �ð�ǥ ��ư �߰�
		scheduleCheck_bt = new JButton("���� �ð�ǥ");
		scheduleCheck_bt.setBackground(new Color(114, 137, 218));
		scheduleCheck_bt.setForeground(Color.WHITE);
		scheduleCheck_bt.setBounds(520, 280, 355, 60);
		scheduleCheck_bt.setBorderPainted(false);
		scheduleCheck_bt.setFocusPainted(false);	
		
		// ���� ���� ��ư �߰�
		courseCheck_bt = new JButton("��������");
		courseCheck_bt.setBackground(new Color(114, 137, 218));
		courseCheck_bt.setForeground(Color.WHITE);
		courseCheck_bt.setBounds(50, 530, 355, 60);
		courseCheck_bt.setBorderPainted(false);
		courseCheck_bt.setFocusPainted(false);	
		
		// ��ü ���� ��ư �߰�
		altCourse_bt = new JButton("��ü����");
		altCourse_bt.setBackground(new Color(114, 137, 218));
		altCourse_bt.setForeground(Color.WHITE);
		altCourse_bt.setBounds(520, 530, 355, 60);
		altCourse_bt.setBorderPainted(false);
		altCourse_bt.setFocusPainted(false);	
		
		// �޴���
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		// ���� ����
		add(subCheck_bt);
		add(scheduleCheck_bt);
		add(courseCheck_bt);
		add(altCourse_bt);
		
		// �޴� ��
		add(lblNewLabel);
		curriculum_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		course_bt.addActionListener(new MyActionListener());
		// ���� ����
		subCheck_bt.addActionListener(new MyActionListener());
		scheduleCheck_bt.addActionListener(new MyActionListener());
		courseCheck_bt.addActionListener(new MyActionListener());
		altCourse_bt.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			// �޴� ��
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
			// ���� ���� ��ư
			case "������":	
				ui.update_UI("Subject_UI");
				break;
			case "���� �ð�ǥ":
				ui.update_UI("schedule_UI");
				break;
			case "��������":
				ui.update_UI("courseCheck_UI");
				break;
			case "��ü����":
				ui.update_UI("altCourse");
				break;
			}
		}
	}
}
