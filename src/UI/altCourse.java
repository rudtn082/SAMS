package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import curriculum.altCourseDAO;

public class altCourse extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, re;
	UI_Main ui;
	Object seletedMajor = "������а�";
	altCourseDAO altcoursedao = new altCourseDAO();

	public altCourse(UI_Main ui) {
		this.ui = ui;
		
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/altCourse.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);
		
		// altCourseDAO(��ü����) ����, ������ ������
		ImageIcon[] altcourseList = altcoursedao.altCourseDAO();
		
		// ��ü���� �̹��� ���========================================
		JLabel altCourseImage = new JLabel("");
		altCourseImage.setIcon(altcourseList[0]);
		altCourseImage.setBounds(205, 190, 580, 440);
		// ���� ���� �̹��� ��������========================================
		
		// �޺� �ڽ� ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 102, 110, 70);
		panel.setOpaque(false);
		
		// �޺� �ڽ� �� ���� ���� �޴� ���� (����)
		String[] major = {"������а�","������а�","ö�а�","�ɸ��а�","�����а�","������а�","ȯ����а�","�����к�","�����а�","��ǻ�Ͱ��а�"};
		
		// ���� ���� �޺� �ڽ� ���� �� �߰�
		JComboBox majorCombo = new JComboBox();
		majorCombo.setModel(new DefaultComboBoxModel(major));	
//		panel.add(majorCombo);
		
		// �޺� �ڽ� ���� �� ��������
		majorCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				seletedMajor = ev.getItem();

				// TODO Auto-generated method stub
				if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					altCourseImage.setIcon(altcourseList[0]);
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					altCourseImage.setIcon(altcourseList[1]);
				}
				else if(seletedMajor.equals("ö�а�")) {
					System.out.println("ö�а�");
					altCourseImage.setIcon(altcourseList[2]);
				}
				else if(seletedMajor.equals("�ɸ��а�")) {
					System.out.println("�ɸ��а�");
					altCourseImage.setIcon(altcourseList[3]);
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					altCourseImage.setIcon(altcourseList[4]);
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					altCourseImage.setIcon(altcourseList[5]);
				}
				else if(seletedMajor.equals("ȯ����а�")) {
					System.out.println("ȯ����а�");
					altCourseImage.setIcon(altcourseList[6]);
				}
				else if(seletedMajor.equals("�����к�")) {
					System.out.println("�����к�");
					altCourseImage.setIcon(altcourseList[7]);
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					altCourseImage.setIcon(altcourseList[8]);
				}
				else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
					System.out.println("��ǻ�Ͱ��а�");
					altCourseImage.setIcon(altcourseList[9]);
				}
			}
		});
		// �޺� �ڽ� ====================================================
		
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

		// ���ư��� ��ư �߰�
		re = new JButton("���ư���");
		re.setBackground(new Color(114, 137, 218));
		re.setForeground(Color.WHITE);
		re.setBounds(307, 647, 350, 60);
		re.setBorderPainted(false);
		re.setFocusPainted(false);
		
		add(re);
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(panel);
		panel.add(majorCombo);
		add(altCourseImage);
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
				ui.update_UI("curriculum_UI");
				break;
			}
		}
	}
}
