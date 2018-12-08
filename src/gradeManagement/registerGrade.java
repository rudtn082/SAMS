package gradeManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class registerGrade {
	ArrayList<String> array = new ArrayList<String>(); // ���� ���� ���� �����ϴ� arraylist
	private String sID, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9,
			subject10; // ����
	private double gpa;
	private String saveString, saveString3; // ���� �� �ӽ� string ����

	public registerGrade() {
	}

	// �й� �ο�
	public String setSGrade(int sID, double gpa, String sub1, String sub2, String sub3, String sub4, String sub5,
			String sub6, String sub7, String sub8, String sub9, String sub10) {
		this.sID = String.valueOf(sID);
		grade_read(); // ������ ���� �о�´�.
		if (array.isEmpty() == false) {
			// ������ �迭�� �޾ƿ´�.
			String[] splitString = new String[12];
			for (int i = 0; i < array.size(); i++) {
				splitString = array.get(i).split(",");
				if (sID == Integer.parseInt(splitString[0])) {// �й��� ��ġ�ϴ� �ʵ尡 ������
					if (!splitString[2].equals("null")) {// �й��� ��ġ�ϴ� �ʵ忡 ���� ���� ������
						return "�л��� ������ �̹� �ֽ��ϴ�.";
					} else {// �й��� �ְ� ������ ������ ������ �����.
						saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5
								+ "," + sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
						grade_save4();
						return "���� ������ �����Ͽ����ϴ�.";
					}
				}
			}
			// �й��� ��ġ�ϴ� �ʵ尡 ������ �л������Ͱ� �����Ƿ� ������ �����Ѵ�.
			saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + ","
					+ sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
			grade_save1();
			return "���� ������ �����Ͽ����ϴ�.";
		} else {// array�� null�̸� ������ ���� ��(�л� �����Ͱ� ����)�̹Ƿ� ���θ����.
			saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + "," + sub6
					+ "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
			grade_save2();
			return "���� ������ �����Ͽ����ϴ�.";
		}
	}

	// ���� �о���� �Լ�
	public void grade_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/gradeManagement/grades.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = "";
			while ((line = br.readLine()) != null) {
				array.add(line);
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// ���� ���� �Լ� (�̾��)
	public void grade_save1() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/gradeManagement/grades.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write(System.getProperty("line.separator"));
			writer.write(saveString);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ���� ���� �Լ� (���θ����)
	public void grade_save2() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/gradeManagement/grades.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			writer.write(saveString);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ���� ���� �Լ� (�����)
	public void grade_save4() {
		try {
			String path = System.getProperty("user.dir");
			BufferedReader re11 = new BufferedReader(new FileReader(path + "/Resource/gradeManagement/grades.txt"));
			String str11;
			StringBuffer write = new StringBuffer(); // ���ڿ��� ����
			FileWriter fw11 = null;

			while ((str11 = re11.readLine()) != null) {
				String[] a = str11.split(",");
				System.out.println(a[0]);
				if (a[0].equals(sID)) { // �ش� ���ڿ��� �ִ����� üũ
					str11 = str11.replace(str11, saveString);
				}
				write.append(str11); // ���� ��� ���� ���ڿ��� ����
				write.append(System.getProperty("line.separator"));
			}

			fw11 = new FileWriter(path + "/Resource/gradeManagement/grades.txt", false); // ���� ���Ͽ� ���
			fw11.write(write.toString()); // ���ο� ������ ���Ͽ� ����
			fw11.flush(); // ���� ����
			fw11.close(); // ���� �ݱ�
		} catch (Exception a1) {
			a1.printStackTrace();
		}
	}

	public boolean isStringEqualToTemp(String s) {
		switch (s) {
		case "A+":
			return true;
		case "A0":
			return true;
		case "B+":
			return true;
		case "B0":
			return true;
		case "C+":
			return true;
		case "C0":
			return true;
		case "D":
			return true;
		case "F":
			return true;
		case "N/A":
			return true;
		default:
			return false;
		}
	}

}
