package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import People.Student;
import gradeManagement.grade;
import schoolRegister.checkInfo;


public class gradeAll_UI extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, re;
	UI_Main ui;
	JLabel sID, sName, sGpa;

	public gradeAll_UI(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeAll_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// �л� ���� �޾ƿ���
		grade gr = new grade();
		checkInfo ci = new checkInfo();
		Student st = ui.getStudent();
		if(st.getsID() == null) {
			return;
		}
		
		String stuGrade = gr.getGradeAll(st.getsID());
			
		String stuStr = ci.checkInfo(st.getsID());
		if (stuStr == null) return;
		String[] splitString = stuStr.split(" ");

		sID = new JLabel(st.getsID());
		sID.setBounds(480, 270, 450, 55);
		sID.setForeground(Color.WHITE);

		sName = new JLabel(splitString[0]);
		sName.setBounds(480, 197, 450, 55);
		sName.setForeground(Color.WHITE);

		sGpa = new JLabel(stuGrade);
		sGpa.setBounds(480, 343, 450, 55);
		sGpa.setForeground(Color.WHITE);

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
		re = new JButton("���ư���");
		re.setBackground(new Color(114, 137, 218));
		re.setForeground(Color.WHITE);
		re.setBounds(307, 647, 350, 60);
		re.setBorderPainted(false);
		re.setFocusPainted(false);

		add(sID);
		add(sName);
		add(sGpa);
		add(re);
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(lblNewLabel);
		curriculum_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		course_bt.addActionListener(new MyActionListener());
		re.addActionListener(new MyActionListener());
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
			case "���ư���":
				ui.update_UI("gradeManagement");
				break;
			}
		}
	}
}