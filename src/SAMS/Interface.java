package SAMS;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Interface extends JFrame {
	final static int width = 1280;
	final static int height = 768;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt;
	JLabel Id, passwd;

	public Interface() {
		super("�л���� �ý��� 7��");

		setSize(1280, 768);
		// �ݱ� ��ư �� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���̾ƿ� ����
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(50, 50, width, height);
		layeredPane.setLayout(null);

		// �α��� �ʵ�
		loginTextField = new JTextField(10);
		loginTextField.setBounds(440, 214, 200, 30);
		layeredPane.add(loginTextField);
		
		Id = new JLabel("���̵�");
		Id.setBounds(380, 214, 200, 30);
		layeredPane.add(Id);

		// �н�����
		passwordField = new JPasswordField(10);
		passwordField.setBounds(440, 254, 200, 30);
		layeredPane.add(passwordField);

		passwd = new JLabel("�н�����");
		passwd.setBounds(380, 254, 200, 30);
		layeredPane.add(passwd);

		// �α��ι�ư �߰�
		bt = new JButton("�α���");
		bt.setBounds(500, 300, 80, 40);
		layeredPane.add(bt);
		
		add(layeredPane);
		setVisible(true);
	}
}