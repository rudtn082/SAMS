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
	Object seletedMajor = "국어국문학과";
	courseCheckDAO courseCheck = new courseCheckDAO();

	public courseCheck_UI(UI_Main ui) {
		this.ui = ui;
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/courseCheck_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);
		
		// 교과 과정(courseCheck) DAO 접근, 데이터 가져오기
		ImageIcon[][] courseList = courseCheck.courseCheckDAO();
		
		// 교과 과정 이미지 가져오기========================================
		JLabel courseImage = new JLabel("");
		courseImage.setIcon(courseList[0][0]);
		courseImage.setBounds(205, 190, 580, 440);
		// 교과 과정 이미지 가져오기========================================
		
		// 콤보 박스 ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 102, 110, 70);
		panel.setOpaque(false);
		
		// 콤보 박스 내 선택 가능 메뉴 선언
		String[] major = {"국어국문학과","영어영문학과","철학과","심리학과","무역학과","건축공학과","환경공학과","기계공학부","토목공학과","컴퓨터공학과"};
		String[] courseYear = {"2018","2017","2016"};
		
		// 전공 선택 콤보 박스 생성 및 추가
		JComboBox majorCombo = new JComboBox();
		majorCombo.setModel(new DefaultComboBoxModel(major));	
		panel.add(majorCombo);
		
		// 년도 선택 컴보 박스 생성 및 추가
		JComboBox courseYearCombo = new JComboBox();
		courseYearCombo.setModel(new DefaultComboBoxModel(courseYear));

		
		// 콤보 박스 년도 값 가져오기
		courseYearCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				// TODO Auto-generated method stub
				seletedYear = ev.getItem();
				
				// TODO Auto-generated method stub
				if(seletedYear.equals("2018")) {
					
					if(seletedMajor.equals("국어국문학과")) {
						courseImage.setIcon(courseList[0][0]);						
					}
					else if(seletedMajor.equals("영어영문학과")) {
						courseImage.setIcon(courseList[0][1]);
					}
					else if(seletedMajor.equals("철학과")) {
						courseImage.setIcon(courseList[0][2]);
					}
					else if(seletedMajor.equals("심리학과")) {
						courseImage.setIcon(courseList[0][3]);
					}
					else if(seletedMajor.equals("무역학과")) {
						courseImage.setIcon(courseList[0][4]);
					}
					else if(seletedMajor.equals("건축공학과")) {
						courseImage.setIcon(courseList[0][5]);
					}
					else if(seletedMajor.equals("환경공학과")) {
						courseImage.setIcon(courseList[0][6]);
					}
					else if(seletedMajor.equals("기계공학부")) {
						courseImage.setIcon(courseList[0][7]);
					}
					else if(seletedMajor.equals("토목공학과")) {
						courseImage.setIcon(courseList[0][8]);
					}
					else if(seletedMajor.equals("컴퓨터공학과")) {
						courseImage.setIcon(courseList[0][9]);
					}
				}
				else if(seletedYear.equals("2017")) {
					if(seletedMajor.equals("국어국문학과")) {
						courseImage.setIcon(courseList[1][0]);
					}
					else if(seletedMajor.equals("영어영문학과")) {
						courseImage.setIcon(courseList[1][1]);
					}
					else if(seletedMajor.equals("철학과")) {
						courseImage.setIcon(courseList[1][2]);
					}
					else if(seletedMajor.equals("심리학과")) {
						courseImage.setIcon(courseList[1][3]);
					}
					else if(seletedMajor.equals("무역학과")) {
						courseImage.setIcon(courseList[1][4]);
					}
					else if(seletedMajor.equals("건축공학과")) {
						courseImage.setIcon(courseList[1][5]);
					}
					else if(seletedMajor.equals("환경공학과")) {
						courseImage.setIcon(courseList[1][6]);
					}
					else if(seletedMajor.equals("기계공학부")) {
						courseImage.setIcon(courseList[1][7]);
					}
					else if(seletedMajor.equals("토목공학과")) {
						courseImage.setIcon(courseList[1][8]);
					}
					else if(seletedMajor.equals("컴퓨터공학과")) {
						courseImage.setIcon(courseList[1][9]);
					}
				}
				else if(seletedYear.equals("2016")) {
					if(seletedMajor.equals("국어국문학과")) {
						courseImage.setIcon(courseList[2][0]);
					}
					else if(seletedMajor.equals("영어영문학과")) {
						courseImage.setIcon(courseList[2][1]);
					}
					else if(seletedMajor.equals("철학과")) {
						courseImage.setIcon(courseList[2][2]);
					}
					else if(seletedMajor.equals("심리학과")) {
						courseImage.setIcon(courseList[2][3]);
					}
					else if(seletedMajor.equals("무역학과")) {
						courseImage.setIcon(courseList[2][4]);
					}
					else if(seletedMajor.equals("건축공학과")) {
						courseImage.setIcon(courseList[2][5]);
					}
					else if(seletedMajor.equals("환경공학과")) {
						courseImage.setIcon(courseList[2][6]);
					}
					else if(seletedMajor.equals("기계공학부")) {
						courseImage.setIcon(courseList[2][7]);
					}
					else if(seletedMajor.equals("토목공학과")) {
						courseImage.setIcon(courseList[2][8]);
					}
					else if(seletedMajor.equals("컴퓨터공학과")) {
						courseImage.setIcon(courseList[2][9]);
					}
				}
			}
		});
		
		// 콤보 박스 전공 값 가져오기
		majorCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				seletedMajor = ev.getItem();

				// TODO Auto-generated method stub
				if(seletedMajor.equals("국어국문학과")) {
					System.out.println("국어국문학과");
					if (seletedYear.equals("2018")) {
						System.out.println("국어국문학과/2018");
						courseImage.setIcon(courseList[0][0]);
					}
					else if(seletedYear.equals("2017")) {
						System.out.println("국어국문학과/2017");
						courseImage.setIcon(courseList[1][0]);
					}
					else if(seletedYear.equals("2016")) {
						System.out.println("국어국문학과/2016");
						courseImage.setIcon(courseList[2][0]);
					}
				}
				else if(seletedMajor.equals("영어영문학과")) {
					System.out.println("영어영문학과");
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
				else if(seletedMajor.equals("철학과")) {
					System.out.println("철학과");
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
				else if(seletedMajor.equals("심리학과")) {
					System.out.println("심리학과");
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
				else if(seletedMajor.equals("무역학과")) {
					System.out.println("무역학과");
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
				else if(seletedMajor.equals("건축공학과")) {
					System.out.println("건축공학과");
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
				else if(seletedMajor.equals("환경공학과")) {
					System.out.println("환경공학과");
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
				else if(seletedMajor.equals("기계공학부")) {
					System.out.println("기계공학부");
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
				else if(seletedMajor.equals("토목공학과")) {
					System.out.println("토목공학과");
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
				else if(seletedMajor.equals("컴퓨터공학과")) {
					System.out.println("컴퓨터공학과");
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
		// 콤보 박스 ====================================================
		
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

		// 돌아가기 버튼 추가
		re = new JButton("돌아가기");
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
			case "돌아가기":
				ui.update_UI("curriculum_UI");
				break;
			}
		}
	}
}
