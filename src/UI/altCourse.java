package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import People.Student;
import schoolRegister.checkInfo;

public class altCourse extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, re;
	UI_Main ui;
	JLabel la = new JLabel("No Mouse Event");
	Object seletedMajor = "������а�";

	public altCourse(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/curriculum.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		////////////////////////////////////////////////////////////////////////// ��ǥ������

		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		la.setBounds(0, 0, 200, 30);
		la.setForeground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////

		// ��ü���� �̹��� ��������========================================
		JLabel altCourseImage = new JLabel("");
		altCourseImage.setIcon(new ImageIcon("Resource/altCourse/korean.JPG"));
		altCourseImage.setBounds(205, 190, 580, 440);
		altCourseImage.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
		// ���� ���� �̹��� ��������========================================
		
		// �޺� �ڽ� ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 102, 110, 70);
		panel.setOpaque(false);
		panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.blue));
		
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
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/korean.JPG"));
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/english.JPG"));
				}
				else if(seletedMajor.equals("ö�а�")) {
					System.out.println("ö�а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/fe.JPG"));
				}
				else if(seletedMajor.equals("�ɸ��а�")) {
					System.out.println("�ɸ��а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/mind.JPG"));
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/trade.JPG"));
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/buliding.JPG"));
				}
				else if(seletedMajor.equals("ȯ����а�")) {
					System.out.println("ȯ����а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/green.JPG"));
				}
				else if(seletedMajor.equals("�����к�")) {
					System.out.println("�����к�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/mechanical.JPG"));
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/ground.JPG"));
				}
				else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
					System.out.println("��ǻ�Ͱ��а�");
					altCourseImage.setIcon(new ImageIcon("Resource/altCourse/computer.JPG"));
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
		add(la);
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
				System.out.println("�������� ��ư");
				break;
			case "��������":
				ui.update_UI("curriculum_UI");
				break;
			case "��������":
				System.out.println("�������� ��ư");
				break;
			case "���ư���":
				ui.update_UI("curriculum_UI");
				break;
			}
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
