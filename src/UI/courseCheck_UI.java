package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import People.Student;
import schoolRegister.checkInfo;

public class courseCheck_UI extends JPanel {
	JButton curriculum_bt, register_bt, grade_bt, course_bt, re;
	UI_Main ui;
	JLabel la = new JLabel("No Mouse Event");
	Object seletedYear = "2018";
	Object seletedMajor = "������а�";

	public courseCheck_UI(UI_Main ui) {
		this.ui = ui;
		// ���̾ƿ� ����
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Resource/curriculum.png"));
		lblNewLabel.setBounds(0, 0, 1024, 768);

		////////////////////////////////////////////////////////////////////////// ��ǥ������

		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
		la.setBounds(0, 0, 200, 30);
		la.setForeground(Color.WHITE);

		////////////////////////////////////////////////////////////////////////////

		// ���� ���� �̹��� ��������========================================
		JLabel courseImage = new JLabel("");
		courseImage.setIcon(new ImageIcon("Resource/curriculum/korean/2018.JPG"));
		courseImage.setBounds(205, 190, 580, 440);
		courseImage.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));
		// ���� ���� �̹��� ��������========================================
		
		// �޺� �ڽ� ===============================================
		JPanel panel = new JPanel();
		panel.setBounds(750, 102, 110, 70);
		panel.setOpaque(false);
		panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.blue));
		
		// �޺� �ڽ� �� ���� ���� �޴� ����
		String[] major = {"������а�","������а�","ö�а�","�ɸ��а�","�����а�","������а�","ȯ����а�","�����к�","�����а�","��ǻ�Ͱ��а�"};
		String[] courseYear = {"2018","2017","2016"};
		
		// ���� ���� �޺� �ڽ� ���� �� �߰�
		JComboBox majorCombo = new JComboBox();
		majorCombo.setModel(new DefaultComboBoxModel(major));	
		panel.add(majorCombo);
		
		// �⵵ ���� �ĺ� �ڽ� ���� �� �߰�
		JComboBox courseYearCombo = new JComboBox();
		courseYearCombo.setModel(new DefaultComboBoxModel(courseYear));
		
		// �޺� �ڽ� �⵵ �� ��������
		courseYearCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				// TODO Auto-generated method stub
				seletedYear = ev.getItem();
				
				// TODO Auto-generated method stub
				if(seletedYear.equals("2018")) {
					if(seletedMajor.equals("������а�")) {
						ImageIcon img = new ImageIcon("Resource/curriculum/korean/2018.JPG");
						courseImage.setIcon(img);						
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/english/2018.JPG"));
					}
					else if(seletedMajor.equals("ö�а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/fe/2018.JPG"));
					}
					else if(seletedMajor.equals("�ɸ��а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mind/2018.JPG"));
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/trade/2018.JPG"));
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/buliding/2018.JPG"));
					}
					else if(seletedMajor.equals("ȯ����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/green/2018.JPG"));
					}
					else if(seletedMajor.equals("�����к�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mechanical/2018.JPG"));
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/ground/2018.JPG"));
					}
					else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/computer/2018.JPG"));
					}
				}
				else if(seletedYear.equals("2017")) {
					if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/korean/2017.JPG"));
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/english/2017.JPG"));
					}
					else if(seletedMajor.equals("ö�а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/fe/2017.JPG"));
					}
					else if(seletedMajor.equals("�ɸ��а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mind/2017.JPG"));
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/trade/2017.JPG"));
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/buliding/2017.JPG"));
					}
					else if(seletedMajor.equals("ȯ����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/green/2017.JPG"));
					}
					else if(seletedMajor.equals("�����к�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mechanical/2017.JPG"));
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/ground/2017.JPG"));
					}
					else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/computer/2017.JPG"));
					}
				}
				else if(seletedYear.equals("2016")) {
					if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/korean/2016.JPG"));
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/english/2016.JPG"));
					}
					else if(seletedMajor.equals("ö�а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/fe/2016.JPG"));
					}
					else if(seletedMajor.equals("�ɸ��а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mind/2016.JPG"));
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/trade/2016.JPG"));
					}
					else if(seletedMajor.equals("������а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/buliding/2016.JPG"));
					}
					else if(seletedMajor.equals("ȯ����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/green/2016.JPG"));
					}
					else if(seletedMajor.equals("�����к�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mechanical/2016.JPG"));
					}
					else if(seletedMajor.equals("�����а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/ground/2016.JPG"));
					}
					else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/computer/2016.JPG"));
					}
				}
			}
		});
		
		// �޺� �ڽ� ���� �� ��������
		majorCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				seletedMajor = ev.getItem();

				// TODO Auto-generated method stub
				if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					if (seletedYear.equals("2018")) {
						System.out.println("������а�/2018");
						courseImage.setIcon(new ImageIcon("Resource/curriculum/korean/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						System.out.println("������а�/2017");
						courseImage.setIcon(new ImageIcon("Resource/curriculum/korean/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						System.out.println("������а�/2016");
						courseImage.setIcon(new ImageIcon("Resource/curriculum/korean/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/english/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/english/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/english/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("ö�а�")) {
					System.out.println("ö�а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/fe/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/fe/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/fe/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("�ɸ��а�")) {
					System.out.println("�ɸ��а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mind/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mind/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mind/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/trade/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/trade/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/trade/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("������а�")) {
					System.out.println("������а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/buliding/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/buliding/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/buliding/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("ȯ����а�")) {
					System.out.println("ȯ����а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/green/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/green/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/green/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("�����к�")) {
					System.out.println("�����к�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mechanical/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mechanical/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/mechanical/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("�����а�")) {
					System.out.println("�����а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/ground/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/ground/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/ground/2016.JPG"));
					}
				}
				else if(seletedMajor.equals("��ǻ�Ͱ��а�")) {
					System.out.println("��ǻ�Ͱ��а�");
					if (seletedYear.equals("2018")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/computer/2018.JPG"));
					}
					else if(seletedYear.equals("2017")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/computer/2017.JPG"));
					}
					else if(seletedYear.equals("2016")) {
						courseImage.setIcon(new ImageIcon("Resource/curriculum/computer/2016.JPG"));
					}
				}
			}
		});
		// �޺� �ڽ� ====================================================
		
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

		// ���ư��� ��ư �߰�
		re = new JButton("���ư���");
		re.setBackground(new Color(114, 137, 218));
		re.setForeground(Color.WHITE);
		re.setBounds(307, 647, 350, 60);
		re.setBorderPainted(false);
		re.setFocusPainted(false);
		
		add(re);
		add(curriculum_bt);
		add(register_bt);
		add(grade_bt);
		add(course_bt);
		add(la);
		add(panel);
		panel.add(courseYearCombo);
		add(courseImage);
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
			switch (e.getActionCommand()) {
			case "��������":
				ui.update_UI("schoolRegister");
				break;
			case "��������":
				System.out.println("�������� ��ư");
				break;
			case "��������":
				ui.update_UI("curriculum_UI");
				break;
			case "��������":
				System.out.println("�������� ��ư");
				break;
			case "���ư���":
				ui.update_UI("curriculum_UI");
				break;
			}
		}
	}
	
	public class drawCourse extends JFrame {
	    JScrollPane scrollPane;
	    ImageIcon icon;
	 
	    public drawCourse() {
	        icon = new ImageIcon("Resource/course_2018_01.JPG");
	       
	        //��� Panel ������ �������������� ����      
	        JPanel background = new JPanel() {
	            public void paintComponent(Graphics g) {
	                // Approach 1: Dispaly image at at full size
	                g.drawImage(icon.getImage(), 0, 0, null);
	                // Approach 2: Scale image to size of component
	                // Dimension d = getSize();
	                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	                // Approach 3: Fix the image position in the scroll pane
	                // Point p = scrollPane.getViewport().getViewPosition();
	                // g.drawImage(icon.getImage(), p.x, p.y, null);
	                setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
	                super.paintComponent(g);
	            }
	        };
	       
	        scrollPane = new JScrollPane(background);
	        setContentPane(scrollPane);
	    }
	 
	    public void main(String[] args) {
	    	drawCourse frame = new drawCourse();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 300);
	        frame.setVisible(true);
	    }
	}

	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			la.setText("MouseClicked(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged(" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("MouseMoved(" + e.getX() + "," + e.getY() + ")");
		}

	}
}
