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
		Main_Menu_admin Main_Menu_admin = new Main_Menu_admin(this);
		register_UI register_UI = new register_UI(this);
		schoolRegister schoolRegister = new schoolRegister(this);
		Main_Menu_Student Main_Menu_Student = new Main_Menu_Student(this);
		checkInfo_UI checkInfo_UI = new checkInfo_UI(this);
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
		}
	}
	
	public Student getStudent() {
		return st;
	}
	public void setStudent(String ID, String Name) {
		st.setsID(ID);
		st.setsName(Name);
	}
}