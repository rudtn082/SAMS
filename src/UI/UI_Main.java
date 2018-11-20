package UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UI_Main extends JFrame {
	Login Login = new Login(this);
	Main_Menu_admin Main_Menu_admin = new Main_Menu_admin(this);
	register_UI register_UI = new register_UI(this);
	final static int width = 1024;
	final static int height = 800;

	public UI_Main() {
		setTitle("�л���� �ý���");
		// �ݱ� ��ư �� ����
		add(Login);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setSize(width, height);
		setVisible(true);
	}

	public void update_UI(String panelName) {
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
		}
	}
}