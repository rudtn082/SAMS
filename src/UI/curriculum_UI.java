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
		// 레이아웃 설정
		setLayout(null);

		JLabel lblNewLabel = new JLabel("교과 관리");
		lblNewLabel.setIcon(new ImageIcon("Resource/curriculum.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// 메뉴 바  버튼 들 //

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

		// 교과 관리 버튼 들 //

		// 교과목(조회) 버튼 추가
		subCheck_bt = new JButton("교과목");
		subCheck_bt.setBackground(new Color(114, 137, 218));
		subCheck_bt.setForeground(Color.WHITE);
		subCheck_bt.setBounds(50, 280, 355, 60);
		subCheck_bt.setBorderPainted(false);
		subCheck_bt.setFocusPainted(false);	
		
		// 강의 시간표 버튼 추가
		scheduleCheck_bt = new JButton("강의 시간표");
		scheduleCheck_bt.setBackground(new Color(114, 137, 218));
		scheduleCheck_bt.setForeground(Color.WHITE);
		scheduleCheck_bt.setBounds(520, 280, 355, 60);
		scheduleCheck_bt.setBorderPainted(false);
		scheduleCheck_bt.setFocusPainted(false);	
		
		// 교육 과정 버튼 추가
		courseCheck_bt = new JButton("교육과정");
		courseCheck_bt.setBackground(new Color(114, 137, 218));
		courseCheck_bt.setForeground(Color.WHITE);
		courseCheck_bt.setBounds(50, 530, 355, 60);
		courseCheck_bt.setBorderPainted(false);
		courseCheck_bt.setFocusPainted(false);	
		
		// 대체 과정 버튼 추가
		altCourse_bt = new JButton("대체과목");
		altCourse_bt.setBackground(new Color(114, 137, 218));
		altCourse_bt.setForeground(Color.WHITE);
		altCourse_bt.setBounds(520, 530, 355, 60);
		altCourse_bt.setBorderPainted(false);
		altCourse_bt.setFocusPainted(false);	
		
		// 메뉴바
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		// 교과 관리
		add(subCheck_bt);
		add(scheduleCheck_bt);
		add(courseCheck_bt);
		add(altCourse_bt);
		
		// 메뉴 바
		add(lblNewLabel);
		curriculum_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		course_bt.addActionListener(new MyActionListener());
		// 교과 관리
		subCheck_bt.addActionListener(new MyActionListener());
		scheduleCheck_bt.addActionListener(new MyActionListener());
		courseCheck_bt.addActionListener(new MyActionListener());
		altCourse_bt.addActionListener(new MyActionListener());
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
				System.out.println("성적관리 버튼");
				break;
			case "교과관리":
				ui.update_UI("curriculum_UI");
				break;
			case "수강관리":
				ui.update_UI("courseManagement_UI");
				break;
			// 교과 관리 버튼
			case "교과목":	
				ui.update_UI("Subject_UI");
				break;
			case "강의 시간표":
				ui.update_UI("schedule_UI");
				break;
			case "교육과정":
				ui.update_UI("courseCheck_UI");
				break;
			case "대체과목":
				ui.update_UI("altCourse");
				break;
			}
		}
	}
}
