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
	Object seletedMajor = "국어국문학과";
	curriculumDAO subcheckdao = new curriculumDAO();

	public Subject_UI(UI_Main ui) {
		this.ui = ui;
		
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("교과목");
		lblNewLabel.setIcon(new ImageIcon("Resource/subCheck.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		////////////////////////////////////////////////////////////////////////// 좌표볼려구

		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		la.setBounds(0, 0, 200, 30);
		la.setForeground(Color.WHITE);
		
		// subCheckDAO(교과목) 접근, 데이터 가져옴
		String[][] subList = subcheckdao.subCheckDAO();
		
		
		// 교과목 출력
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

		// 콤보 박스 ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 130, 110, 70);
		panel.setOpaque(false);
		panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.blue));
		
		// 콤보 박스 내 선택 가능 메뉴 선언
		String[] major = {"국어국문학과","영어영문학과","철학과","심리학과","무역학과","건축공학과","환경공학과","기계공학부","토목공학과","컴퓨터공학과"};
		
		// 전공 선택 콤보 박스 생성 및 추가
		JComboBox majorCombo = new JComboBox();
		majorCombo.setModel(new DefaultComboBoxModel(major));
		panel.add(majorCombo);
		
		// 콤보 박스 리스너 
		majorCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ev) {
				// TODO Auto-generated method stub
				seletedMajor = ev.getItem();
				
				// TODO Auto-generated method stub
				if(seletedMajor.equals("국어국문학과")) {
					System.out.println("국어국문학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[0][i]);
					}
				}
				else if(seletedMajor.equals("영어영문학과")) {
					System.out.println("영어영문학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[1][i]);
					}
				}
				else if(seletedMajor.equals("철학과")) {
					System.out.println("철학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[2][i]);
					}
				}
				else if(seletedMajor.equals("심리학과")) {
					System.out.println("심리학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[3][i]);
					}
				}
				else if(seletedMajor.equals("무역학과")) {
					System.out.println("무역학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[4][i]);
					}
				}
				else if(seletedMajor.equals("건축공학과")) {
					System.out.println("건축공학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[5][i]);
					}
				}
				else if(seletedMajor.equals("환경공학과")) {
					System.out.println("환경공학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[6][i]);
					}
				}
				else if(seletedMajor.equals("기계공학부")) {
					System.out.println("기계공학부");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[7][i]);
					}
				}
				else if(seletedMajor.equals("토목공학과")) {
					System.out.println("토목공학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[8][i]);
					}
				}
				else if(seletedMajor.equals("컴퓨터공학과")) {
					System.out.println("컴퓨터공학과");
					for(int i=0; i<10; i++) {
						subListLabel[i].setText(subList[9][i]);
					}
				}
			}
		});		
				
		// 교과관리 버튼 추가
		curriculum_bt = new JButton("교과관리");
		curriculum_bt.setContentAreaFilled(false);
		curriculum_bt.setFocusPainted(false);
		curriculum_bt.setForeground(Color.WHITE);
		curriculum_bt.setBounds(20, 23, 200, 55);

		// 학적관리 버튼 추가
		register_bt = new JButton("학적관리");
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(270, 23, 200, 55);

		// 성적관리 버튼 추가
		grade_bt = new JButton("성적관리");
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(520, 23, 200, 55);

		// 수강관리 버튼 추가
		course_bt = new JButton("수강관리");
		course_bt.setContentAreaFilled(false);
		course_bt.setFocusPainted(false);
		course_bt.setForeground(Color.WHITE);
		course_bt.setBounds(770, 23, 200, 55);
		
		// 메뉴바
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(la);
		
		// 메뉴 바
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
			// 메뉴 바
			case "학적관리":
				ui.update_UI("schoolRegister");
				break;
			case "성적관리":
				ui.update_UI("gradeManagement");
				break;
			case "교과관리":
				ui.update_UI("curriculum_UI");
				break;
			case "수강관리":
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
