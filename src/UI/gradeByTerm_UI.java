package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import People.Student;
import curriculum.curriculumDAO;
import courseManagement.courseManagementDAO;

import gradeManagement.grade;

public class gradeByTerm_UI extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, re;
	UI_Main ui;
	JLabel[] sub = new JLabel[10]; // �����
	JLabel[] termGrade = new JLabel[10]; // ���� ����
	
	curriculumDAO subcheckdao = new curriculumDAO();
	String[] grade = null;
	courseManagementDAO coursemanagementdao = new courseManagementDAO();
	int majorNum;

	// ���� �����ο� �ҷ�����
	public String[] readCourseStudentNumber(int lineNumber) {
		String line = "";
		String[] splited;
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/curStuNum.txt");
			BufferedReader r = new BufferedReader(new FileReader(file));
			for (int i = 0; i < lineNumber+1; i++) {
			   line = r.readLine();
			}
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		splited = line.split(" ");
		
		return splited;
	}
	
	// ��ü ���� �ο�(curStuNum.txt) ������Ʈ
	public void updaeCourseStudentNumber(int courseNum) {
		String[] line = new String[10];
		String[] splited = new String[10];
		String toWrite = "";
		String majorCourseNum = "";
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/curStuNum.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < 10; i++) {
				line[i] = br.readLine();
			}
			splited = line[majorNum].split(" ");
			br.close();
			splited[courseNum] = Integer.toString((Integer.parseInt(splited[courseNum])+1));
			
			for(int i=0; i<splited.length; i++) {
				majorCourseNum += splited[i] + " ";
			}
			line[majorNum] = majorCourseNum;
			for(int i=0; i<10; i++) {
				if(i<9) {
					toWrite += line[i] + "\r\n";
				}
				else {
					toWrite += line[i];
				}
				
			}
			FileWriter fw = new FileWriter(file, false);
			fw.write(toWrite);
			fw.flush();
			fw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public gradeByTerm_UI(UI_Main ui) {
		this.ui = ui;
		Student st = ui.getStudent();
		grade gr = new grade();
		String ID = st.getsID();
		
		if(ID == null) return;
		majorNum = Integer.parseInt(ID.substring(4,5));
		String[][] subList = subcheckdao.subCheckDAO();
		grade = gr.getGradeByTerm(st.getsID());
		
		// ���̾ƿ� ����
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeByTerm_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);
		
		for(int i=0; i<10; i++) {
			sub[i] = new JLabel(subList[majorNum][i]);
			sub[i].setForeground(Color.WHITE);
			sub[i].setBounds(235,(235+(36*i)),100,20);
			
			if(grade == null) return;
			String personLabel = grade[i+2];
			termGrade[i] = new JLabel(personLabel);
			termGrade[i].setBounds(670, (235+(36*i)), 100, 20);
			termGrade[i].setForeground(Color.WHITE);
			
		}
		
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
		

		// ���ư��� �߰�
		re = new JButton("���ư���");
		re.setBackground(new Color(114, 137, 218));
		re.setForeground(Color.WHITE);
		re.setBounds(307, 647, 350, 60);
		re.setBorderPainted(false);
		re.setFocusPainted(false);
		

		for(int i=0; i<10; i++) {
			add(sub[i]);
			add(termGrade[i]);
		}
		
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(re);
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
			System.out.println("e.getModifiers : " + e.getModifiers());
			switch(e.getActionCommand()) {
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
