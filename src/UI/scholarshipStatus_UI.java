package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scholarshipManagement.scholarshipDAO;

public class scholarshipStatus_UI extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, re;
	UI_Main ui;
	JLabel aID;

	JLabel[] scholarStu = new JLabel[10]; // ���л�
	String[] majors = null;
	String[] maj = { "000", "001", "002", "003", "004", "005", "006", "007", "008", "009" };

	scholarshipDAO sc = new scholarshipDAO();

	public scholarshipStatus_UI(UI_Main ui) {
		this.ui = ui;

		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/gradeByTerm_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		for (int k = 0; k < 10; k++) {
			majors = sc.getStatusByMaj(maj[k]);
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				String personLabel = majors[j + 1];
				scholarStu[j] = new JLabel(personLabel);
				scholarStu[j].setBounds((670 + (50 * j)), (235 + (36 * i)), 100, 20);
				scholarStu[j].setForeground(Color.WHITE);
			}
		}

		// �α��� ���� ��
		aID = new JLabel("admin");
		aID.setBounds(807, 133, 100, 20);
		aID.setForeground(Color.WHITE);

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

		// ���а��� ��ư �߰�
		scholarship_bt = new JButton("���а���");
		scholarship_bt.setContentAreaFilled(false);
		scholarship_bt.setFocusPainted(false);
		scholarship_bt.setForeground(Color.WHITE);
		scholarship_bt.setBounds(556, 23, 200, 55);

		// ���ư��� �߰�
		re = new JButton("���ư���");
		re.setBackground(new Color(114, 137, 218));
		re.setForeground(Color.WHITE);
		re.setBounds(307, 647, 350, 60);
		re.setBorderPainted(false);
		re.setFocusPainted(false);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 6; j++) {
				add(scholarStu[j]);
			}
		}

		add(register_bt);
		add(grade_bt);
		add(scholarship_bt);
		add(re);
		add(aID);
		add(lblNewLabel);
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		scholarship_bt.addActionListener(new MyActionListener());
		re.addActionListener(new MyActionListener());

	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("e.getModifiers : " + e.getModifiers());
			switch (e.getActionCommand()) {
			case "��������":
				ui.update_UI("schoolRegister");
				break;
			case "��������":
				ui.update_UI("gradeManagement");
				break;
			case "���а���":
				ui.update_UI("scholarship");
				break;
			case "���ư���":
				ui.update_UI("scholarship");
				break;
			}
		}
	}
}
