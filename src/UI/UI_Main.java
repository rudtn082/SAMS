package UI;

import javax.swing.JFrame;

import People.Student;

public class UI_Main extends JFrame {
	Student st = new Student();
	Login Login = new Login(this);
	final static int width = 1024;
	final static int height = 800;

	public UI_Main() {
		setTitle("학사관리 시스템");
		// 닫기 버튼 시 종료
		add(Login);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(width, height);
		setVisible(true);
	}

	public void update_UI(String panelName) {
		schoolRegister schoolRegister = new schoolRegister(this);
		register_UI register_UI = new register_UI(this);
		checkInfo_UI checkInfo_UI = new checkInfo_UI(this);
		Main_Menu_Student Main_Menu_Student = new Main_Menu_Student(this);
		Main_Menu_admin Main_Menu_admin = new Main_Menu_admin(this);
		curriculum_UI curriculum_UI = new curriculum_UI(this);
		courseCheck_UI courseCheck_UI = new courseCheck_UI(this); 
		altCourse altCourse = new altCourse(this);
		Subject_UI Subject_UI = new Subject_UI(this);
		courseManagement_UI courseManagement_UI = new courseManagement_UI(this);
		schedule_UI schedule_UI = new schedule_UI(this);
		changeRegister_UI changeRegister_UI = new changeRegister_UI(this);
		gradeManagement gradeManagement = new gradeManagement(this);
		gradeByTerm_UI gradeByTerm_UI = new gradeByTerm_UI(this);
		gradeAll_UI gradeAll_UI = new gradeAll_UI(this);
		gradeAdmin_UI gradeAdmin_UI = new gradeAdmin_UI(this);
		gradeAdminSetID gradeAdminSetID = new gradeAdminSetID(this);
		scholarship scholarship = new scholarship(this);
		scholarshipStatus_UI scholarshipStatus_UI = new scholarshipStatus_UI(this);
		scholarshipStandard_UI scholarshipStandard_UI = new scholarshipStandard_UI(this);
		setScholarship_UI setScholarship_UI = new setScholarship_UI(this);
		
		switch(panelName) {
		case "Login":
			getContentPane().removeAll();
			getContentPane().add(Login);
			revalidate();
			repaint();
			break;
		case "Main_Menu_admin":
			getContentPane().removeAll();
			getContentPane().add(Main_Menu_admin);
			revalidate();
			repaint();
			break;
		case "register":
			getContentPane().removeAll();
			getContentPane().add(register_UI);
			revalidate();
			repaint();
			break;
		case "Main_Menu_Student":
			getContentPane().removeAll();
			getContentPane().add(Main_Menu_Student);
			revalidate();
			repaint();
			break;
		case "schoolRegister":
			getContentPane().removeAll();
			getContentPane().add(schoolRegister);
			revalidate();
			repaint();
			break;
		case "checkInfo_UI":
			getContentPane().removeAll();
			getContentPane().add(checkInfo_UI);
			revalidate();
			repaint();
			break;
		case "curriculum_UI":
			getContentPane().removeAll();
			getContentPane().add(curriculum_UI);
			revalidate();
			repaint();
			break;
		case "courseCheck_UI":
			getContentPane().removeAll();
			getContentPane().add(courseCheck_UI);
			revalidate();
			repaint();
			break;
		case "altCourse":
			getContentPane().removeAll();
			getContentPane().add(altCourse);
			revalidate();
			repaint();
			break;
		case "Subject_UI":
			getContentPane().removeAll();
			getContentPane().add(Subject_UI);
			revalidate();
			repaint();
			break;
		case "courseManagement_UI":
			getContentPane().removeAll();
			getContentPane().add(courseManagement_UI);
			revalidate();
			repaint();
			break;
		case "schedule_UI":
			getContentPane().removeAll();
			getContentPane().add(schedule_UI);
			revalidate();
			repaint();
			break;
		case "changeRegister_UI":
			getContentPane().removeAll();
			getContentPane().add(changeRegister_UI);
			revalidate();
			repaint();
			break;
		case "gradeManagement":
			getContentPane().removeAll();
			getContentPane().add(gradeManagement);
			revalidate();
			repaint();
			break;
		case "gradeByTerm_UI":
			getContentPane().removeAll();
			getContentPane().add(gradeByTerm_UI);
			revalidate();
			repaint();
			break;
		case "gradeAll_UI":
			getContentPane().removeAll();
			getContentPane().add(gradeAll_UI);
			revalidate();
			repaint();
			break;
		case "gradeAdmin_UI":
			getContentPane().removeAll();
			getContentPane().add(gradeAdmin_UI);
			revalidate();
			repaint();
			break;
		case "gradeAdminSetID":
			getContentPane().removeAll();
			getContentPane().add(gradeAdminSetID);
			revalidate();
			repaint();
			break;
		case "scholarship":
			getContentPane().removeAll();
			getContentPane().add(scholarship);
			revalidate();
			repaint();
			break;
		case "scholarshipStatus_UI":
			getContentPane().removeAll();
			getContentPane().add(scholarshipStatus_UI);
			revalidate();
			repaint();
			break;
		case "scholarshipStandard_UI":
			getContentPane().removeAll();
			getContentPane().add(scholarshipStandard_UI);
			revalidate();
			repaint();
			break;
		case "setScholarship_UI":
			getContentPane().removeAll();
			getContentPane().add(setScholarship_UI);
			revalidate();
			repaint();
			break;
			
		}
	}
	
	public Student getStudent() {
		return st;
	}
	public void setStudent(String ID, String Name) {
		st.setsID(ID);
		st.setsName(Name);
	}
	public void setStudentAdmin(String ID) {
		st.setsID(ID);
	}
}