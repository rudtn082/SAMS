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

public class gradeManagement extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, gbtcheck_bt, gacheck_bt;
	UI_Main ui;

	public gradeManagement(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeManagement.png"));
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


		// �б⺰ ���� ��ư �߰�
		gbtcheck_bt = new JButton("�б⺰ ����");
		gbtcheck_bt.setBackground(new Color(114, 137, 218));
		gbtcheck_bt.setForeground(Color.WHITE);
		gbtcheck_bt.setBounds(105, 380, 350, 60);
		gbtcheck_bt.setBorderPainted(false);
		gbtcheck_bt.setFocusPainted(false);	
		
		// ��ü ���� ��ư �߰�
		gacheck_bt = new JButton("��ü ����");
		gacheck_bt.setBackground(new Color(114, 137, 218));
		gacheck_bt.setForeground(Color.WHITE);
		gacheck_bt.setBounds(510, 380, 350, 60);
		gacheck_bt.setBorderPainted(false);
		gacheck_bt.setFocusPainted(false);	
		
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(gacheck_bt);
		add(gbtcheck_bt);
		add(lblNewLabel);
		curriculum_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		course_bt.addActionListener(new MyActionListener());
		gbtcheck_bt.addActionListener(new MyActionListener());
		gacheck_bt.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "��������":
				ui.update_UI("schoolRegister");
				break;
			case "��������":
				ui.update_UI("gradeManagement");
				break;
			case "��������":
				ui.update_UI("curriculum_UI");
				break;
			case "��������":
				ui.update_UI("courseManagement_UI");
				break;
			case "�б⺰ ����":
				ui.update_UI("gradeByTerm_UI");
				break;
			case "��ü ����":
				ui.update_UI("gradeAll_UI");
				break;
			}
		}
	}
}
