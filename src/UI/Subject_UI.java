package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
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

import People.Student;
import curriculum.curriculumDAO;

public class Subject_UI extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt;
	UI_Main ui;
	JLabel la = new JLabel("No Mouse Event");
	Object seletedMajor = "������а�";
	curriculumDAO subcheckdao = new curriculumDAO();

	public Subject_UI(UI_Main ui) {
		this.ui = ui;
		
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("������");
		lblNewLabel.setIcon(new ImageIcon("Resource/subCheck.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		////////////////////////////////////////////////////////////////////////// ��ǥ������

		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		la.setBounds(0, 0, 200, 30);
		la.setForeground(Color.WHITE);
		
		// subCheckDAO(������) ����, ������ ������
		String[][] subList = subcheckdao.subCheckDAO();
		
		
		// ������ ���
		int height = 230;
		JLabel[] subListLabel = new JLabel[10];
		for(int i=0; i<10; i++) {
			subListLabel[i] = new JLabel("");
			subListLabel[i].setFont(new Font("Serif", Font.BOLD, 20));
			subListLabel[i].setOpaque(false);
			subListLabel[i].setForeground(Color.white);
			subListLabel[i].setSize(280 , 35);
			subListLabel[i].setText(subList[0][i]);
			subListLabel[i].setLocation(400, height + (36*i));
			subListLabel[i].setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
		}

		// �޺� �ڽ� ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 130, 110, 70);
		panel.setOpaque(false);
		panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.blue));
		
		// �޺� �ڽ� �� ���� ���� �޴� ����
		String[] major = {"������а�","������а�","ö�а�","�ɸ��а�","�����а�","������а�","ȯ����а�","�����к�","�����а�","��ǻ�Ͱ��а�"};
		
		// ���� ���� �޺� �ڽ� ���� �� �߰�
		JComboBox majorCombo = new JComboBox();
		majorCombo.setModel(new DefaultComboBoxModel(major));
		panel.add(majorCombo);
		
		// �޺� �ڽ� ������ 
		majorCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ev) {
				// TODO Auto-generated method stub
				seletedMajor = ev.getItem();
				
				// TODO Auto-generated method stub
				if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[0][i]);
					}
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[1][i]);
					}
				}
				else if(seletedMajor.equals("ö�а�")) {
					System.out.println("ö�а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[2][i]);
					}
				}
				else if(seletedMajor.equals("�ɸ��а�")) {
					System.out.println("�ɸ��а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[3][i]);
					}
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[4][i]);
					}
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[5][i]);
					}
				}
				else if(seletedMajor.equals("ȯ����а�")) {
					System.out.println("ȯ����а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[6][i]);
					}
				}
				else if(seletedMajor.equals("�����к�")) {
					System.out.println("�����к�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[7][i]);
					}
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[8][i]);
					}
				}
				else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
					System.out.println("��ǻ�Ͱ��а�");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[9][i]);
					}
				}
			}
		});		
				
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
		
		// �޴���
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(la);
		
		// �޴� ��
		add(panel);
		panel.add(majorCombo);
		for(int i=0; i<10; i++) {
			add(subListLabel[i]);
		}
		add(lblNewLabel);
		curriculum_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		course_bt.addActionListener(new MyActionListener());
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
				ui.update_UI("gradeManagement");
				break;
			case "��������":
				ui.update_UI("curriculum_UI");
				break;
			case "��������":
				ui.update_UI("courseManagement_UI");
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
