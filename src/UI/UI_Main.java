package UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UI_Main extends JFrame {
	Login Login = new Login(this);
	Main_Menu Main_Menu = new Main_Menu(this);
	final static int width = 1024;
	final static int height = 768;

	public UI_Main() {
		setTitle("학사관리 시스템");
		// 닫기 버튼 시 종료
		add(Login);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(width, height);
		setVisible(true);
	}

	public void update_UI(String panelName) {
		if (panelName.equals("Login")) {
			getContentPane().removeAll();
			getContentPane().add(Login);
			revalidate();
			repaint();
		} else {
			getContentPane().removeAll();
			getContentPane().add(Main_Menu);
			revalidate();
			repaint();
		}
	}
}