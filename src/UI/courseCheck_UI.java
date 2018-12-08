package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import curriculum.courseCheckDAO;

public class courseCheck_UI extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, re;
	UI_Main ui;
	Object seletedYear = "2018";
	Object seletedMajor = "������а�";
	courseCheckDAO courseCheck = new courseCheckDAO();

	public courseCheck_UI(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/courseCheck_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);
		
		// ���� ����(courseCheck) DAO ����, ������ ��������
		ImageIcon[][] courseList = courseCheck.courseCheckDAO();
		
		// ���� ���� �̹��� ��������========================================
		JLabel courseImage = new JLabel("");
		courseImage.setIcon(courseList[0][0]);
		courseImage.setBounds(205, 190, 580, 440);
		// ���� ���� �̹��� ��������========================================
		
		// �޺� �ڽ� ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 102, 110, 70);
		panel.setOpaque(false);
		
		// �޺� �ڽ� �� ���� ���� �޴� ����
		String[] major = {"������а�","������а�","ö�а�","�ɸ��а�","�����а�","������а�","ȯ����а�","�����к�","�����а�","��ǻ�Ͱ��а�"};
		String[] courseYear = {"2018","2017","2016"};
		
		// ���� ���� �޺� �ڽ� ���� �� �߰�
		JComboBox majorCombo = new JComboBox();
		majorCombo.setModel(new DefaultComboBoxModel(major));	
		panel.add(majorCombo);
		
		// �⵵ ���� �ĺ� �ڽ� ���� �� �߰�
		JComboBox courseYearCombo = new JComboBox();
		courseYearCombo.setModel(new DefaultComboBoxModel(courseYear));

		
		// �޺� �ڽ� �⵵ �� ��������
		courseYearCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				// TODO Auto-generated method stub
				seletedYear = ev.getItem();
				
				// TODO Auto-generated method stub
				if(seletedYear.equals("2018")) {
					
					if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[0][0]);						
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[0][1]);
					}
					else if(seletedMajor.equals("ö�а�")) {
						courseImage.setIcon(courseList[0][2]);
					}
					else if(seletedMajor.equals("�ɸ��а�")) {
						courseImage.setIcon(courseList[0][3]);
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(courseList[0][4]);
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[0][5]);
					}
					else if(seletedMajor.equals("ȯ����а�")) {
						courseImage.setIcon(courseList[0][6]);
					}
					else if(seletedMajor.equals("�����к�")) {
						courseImage.setIcon(courseList[0][7]);
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(courseList[0][8]);
					}
					else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
						courseImage.setIcon(courseList[0][9]);
					}
				}
				else if(seletedYear.equals("2017")) {
					if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[1][0]);
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[1][1]);
					}
					else if(seletedMajor.equals("ö�а�")) {
						courseImage.setIcon(courseList[1][2]);
					}
					else if(seletedMajor.equals("�ɸ��а�")) {
						courseImage.setIcon(courseList[1][3]);
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(courseList[1][4]);
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[1][5]);
					}
					else if(seletedMajor.equals("ȯ����а�")) {
						courseImage.setIcon(courseList[1][6]);
					}
					else if(seletedMajor.equals("�����к�")) {
						courseImage.setIcon(courseList[1][7]);
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(courseList[1][8]);
					}
					else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
						courseImage.setIcon(courseList[1][9]);
					}
				}
				else if(seletedYear.equals("2016")) {
					if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[2][0]);
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[2][1]);
					}
					else if(seletedMajor.equals("ö�а�")) {
						courseImage.setIcon(courseList[2][2]);
					}
					else if(seletedMajor.equals("�ɸ��а�")) {
						courseImage.setIcon(courseList[2][3]);
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(courseList[2][4]);
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(courseList[2][5]);
					}
					else if(seletedMajor.equals("ȯ����а�")) {
						courseImage.setIcon(courseList[2][6]);
					}
					else if(seletedMajor.equals("�����к�")) {
						courseImage.setIcon(courseList[2][7]);
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(courseList[2][8]);
					}
					else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
						courseImage.setIcon(courseList[2][9]);
					}
				}
			}
		});
		
		// �޺� �ڽ� ���� �� ��������
		majorCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				seletedMajor = ev.getItem();

				// TODO Auto-generated method stub
				if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					if (seletedYear.equals("2018")) {
						System.out.println("������а�/2018");
						courseImage.setIcon(courseList[0][0]);
					}
					else if(seletedYear.equals("2017")) {
						System.out.println("������а�/2017");
						courseImage.setIcon(courseList[1][0]);
					}
					else if(seletedYear.equals("2016")) {
						System.out.println("������а�/2016");
						courseImage.setIcon(courseList[2][0]);
					}
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][1]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][1]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][1]);
					}
				}
				else if(seletedMajor.equals("ö�а�")) {
					System.out.println("ö�а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][2]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][2]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][2]);
					}
				}
				else if(seletedMajor.equals("�ɸ��а�")) {
					System.out.println("�ɸ��а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][3]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][3]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][3]);
					}
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][4]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][4]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][4]);
					}
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][5]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][5]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][5]);
					}
				}
				else if(seletedMajor.equals("ȯ����а�")) {
					System.out.println("ȯ����а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][6]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][6]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][6]);
					}
				}
				else if(seletedMajor.equals("�����к�")) {
					System.out.println("�����к�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][7]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][7]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][7]);
					}
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][8]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][8]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][8]);
					}
				}
				else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
					System.out.println("��ǻ�Ͱ��а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(courseList[0][9]);
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(courseList[1][9]);
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(courseList[2][9]);
					}
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
		panel.add(courseYearCombo);
		add(courseImage);
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
