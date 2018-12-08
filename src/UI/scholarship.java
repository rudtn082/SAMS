package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class scholarship extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, scholarshipStatus_bt, scholarshipStandard_bt,
			setScholarship_bt, ok, cancel;
	UI_Main ui;

	public scholarship(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/scholarship.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// �������� ��ư �߰�
		register_bt = new JButton("��������");
		register_bt.setContentAreaFilled(false);
		register_bt.setFocusPainted(false);
		register_bt.setForeground(Color.WHITE);
		register_bt.setBounds(44, 23, 200, 55);

		// �������� ��ư �߰�
		grade_bt = new JButton("��������");
		grade_bt.setContentAreaFilled(false);
		grade_bt.setFocusPainted(false);
		grade_bt.setForeground(Color.WHITE);
		grade_bt.setBounds(300, 23, 200, 55);

		// ���а��� ��ư �߰�
		scholarship_bt = new JButton("���а���");
		scholarship_bt.setContentAreaFilled(false);
		scholarship_bt.setFocusPainted(false);
		scholarship_bt.setForeground(Color.WHITE);
		scholarship_bt.setBounds(556, 23, 200, 55);

		// ���� ���л� ���� ��ư �߰�
		scholarshipStatus_bt = new JButton("���л�����");
		scholarshipStatus_bt.setBackground(new Color(114, 137, 218));
		scholarshipStatus_bt.setForeground(Color.WHITE);
		scholarshipStatus_bt.setBounds(50, 280, 350, 60);
		scholarshipStatus_bt.setBorderPainted(false);
		scholarshipStatus_bt.setFocusPainted(false);

		// ���� ���� ���� ��ư �߰�
		scholarshipStandard_bt = new JButton("���б���");
		scholarshipStandard_bt.setBackground(new Color(114, 137, 218));
		scholarshipStandard_bt.setForeground(Color.WHITE);
		scholarshipStandard_bt.setBounds(520, 280, 350, 60);
		scholarshipStandard_bt.setBorderPainted(false);
		scholarshipStandard_bt.setFocusPainted(false);
		
		// ���л� �����ϱ� ��ư �߰�
		setScholarship_bt = new JButton("���л�����");
		setScholarship_bt.setBackground(new Color(114, 137, 218));
		setScholarship_bt.setForeground(Color.WHITE);
		setScholarship_bt.setBounds(520, 530, 350, 60);
		setScholarship_bt.setBorderPainted(false);
		setScholarship_bt.setFocusPainted(false);

		add(register_bt);
		add(grade_bt);
		add(scholarship_bt);
		add(scholarshipStatus_bt);
		add(scholarshipStandard_bt);
		add(setScholarship_bt);
		add(lblNewLabel);
		scholarship_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		scholarshipStatus_bt.addActionListener(new MyActionListener());
		scholarshipStandard_bt.addActionListener(new MyActionListener());
		setScholarship_bt.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "��������":
				ui.update_UI("register");
				break;
			case "��������":
				ui.update_UI("gradeAdminSetID");
				break;
			case "���а���":
				ui.update_UI("scholarship");
				break;
			case "���л�����":
				ui.update_UI("scholarshipStatus_UI");
				break;
			case "���б���":
				ui.update_UI("scholarshipStandard_UI");
				break;
			case "���л�����":
				ui.update_UI("setScholarship_UI");
				break;
			}
		}
	}
}
