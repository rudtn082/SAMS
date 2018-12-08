package UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scholarshipManagement.scholarshipDAO;

public class scholarshipStandard_UI extends JPanel {
	JButton register_bt, grade_bt, scholarship_bt, re;
	JLabel aID;
	UI_Main ui;
	scholarshipDAO sc = new scholarshipDAO();

	public scholarshipStandard_UI(UI_Main ui) {
		this.ui = ui;

		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/schedule_UI.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		// scholarshipManegementDAO ����, ������ ������
		ImageIcon timeTable = sc.checkScholarshipStandard();

		// �ð�ǥ �̹��� ���========================================
		JLabel timeTableLabel = new JLabel("");
		timeTableLabel.setIcon(timeTable);
		timeTableLabel.setBounds(205, 190, 580, 440);
		timeTableLabel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));

		// �α��� ���� ��
		aID = new JLabel("admin");
		aID.setBounds(807, 133, 100, 20);
		aID.setForeground(Color.WHITE);

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

		// �α��� ���� ��
		aID = new JLabel("admin");
		aID.setBounds(807, 133, 100, 20);
		aID.setForeground(Color.WHITE);

		// ���ư��� �߰�
		re = new JButton("���ư���");
		re.setBackground(new Color(114, 137, 218));
		re.setForeground(Color.WHITE);
		re.setBounds(307, 647, 350, 60);
		re.setBorderPainted(false);
		re.setFocusPainted(false);

		add(re);
		add(scholarship_bt);
		add(register_bt);
		add(grade_bt);
		add(aID);
		add(timeTableLabel);
		add(lblNewLabel);

		scholarship_bt.addActionListener(new MyActionListener());
		register_bt.addActionListener(new MyActionListener());
		grade_bt.addActionListener(new MyActionListener());
		re.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
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
