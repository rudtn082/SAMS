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
	Object seletedMajor = "국어국문학과";
	altCourseDAO altcoursedao = new altCourseDAO();

	public altCourse(UI_Main ui) {
		this.ui = ui;
		
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/altCourse.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);
		
		// altCourseDAO(대체과목) 접근, 데이터 가져옴
		ImageIcon[] altcourseList = altcoursedao.altCourseDAO();
		
		// 대체과목 이미지 출력========================================
		JLabel altCourseImage = new JLabel("");
		altCourseImage.setIcon(altcourseList[0]);
		altCourseImage.setBounds(205, 190, 580, 440);
		// 교과 과정 이미지 가져오기========================================
		
		// 콤보 박스 ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 102, 110, 70);
		panel.setOpaque(false);
		
		// 콤보 박스 내 선택 가능 메뉴 선언 (전공)
		String[] major = {"국어국문학과","영어영문학과","철학과","심리학과","무역학과","건축공학과","환경공학과","기계공학부","토목공학과","컴퓨터공학과"};
		
		// 전공 선택 콤보 박스 생성 및 추가
		JComboBox majorCombo = new JComboBox();
		majorCombo.setModel(new DefaultComboBoxModel(major));	
//		panel.add(majorCombo);
		
		// 콤보 박스 전공 값 가져오기
		majorCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				seletedMajor = ev.getItem();

				// TODO Auto-generated method stub
				if(seletedMajor.equals("국어국문학과")) {
					System.out.println("국어국문학과");
					altCourseImage.setIcon(altcourseList[0]);
				}
				else if(seletedMajor.equals("영어영문학과")) {
					System.out.println("영어영문학과");
					altCourseImage.setIcon(altcourseList[1]);
				}
				else if(seletedMajor.equals("철학과")) {
					System.out.println("철학과");
					altCourseImage.setIcon(altcourseList[2]);
				}
				else if(seletedMajor.equals("심리학과")) {
					System.out.println("심리학과");
					altCourseImage.setIcon(altcourseList[3]);
				}
				else if(seletedMajor.equals("무역학과")) {
					System.out.println("무역학과");
					altCourseImage.setIcon(altcourseList[4]);
				}
				else if(seletedMajor.equals("건축공학과")) {
					System.out.println("건축공학과");
					altCourseImage.setIcon(altcourseList[5]);
				}
				else if(seletedMajor.equals("환경공학과")) {
					System.out.println("환경공학과");
					altCourseImage.setIcon(altcourseList[6]);
				}
				else if(seletedMajor.equals("기계공학부")) {
					System.out.println("기계공학부");
					altCourseImage.setIcon(altcourseList[7]);
				}
				else if(seletedMajor.equals("토목공학과")) {
					System.out.println("토목공학과");
					altCourseImage.setIcon(altcourseList[8]);
				}
				else if(seletedMajor.equals("컴퓨터공학과")) {
					System.out.println("컴퓨터공학과");
					altCourseImage.setIcon(altcourseList[9]);
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
