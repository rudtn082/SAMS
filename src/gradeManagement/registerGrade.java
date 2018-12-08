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
		setSID(null);
		setGpa(0.00);
		setSub1(null);
		setSub2(null);
		setSub3(null);
		setSub4(null);
		setSub5(null);
		setSub6(null);
		setSub7(null);
		setSub8(null);
		setSub9(null);
		setSub10(null);
	}

	// �й� �ο�
	public String setSGrade(int sID, double gpa, String sub1, String sub2, String sub3, String sub4, String sub5,
			String sub6, String sub7, String sub8, String sub9, String sub10) {
		grade_read(); // ������ ���� �о�´�.
		if (array.isEmpty() == false) {
			// ������ �迭�� �޾ƿ´�.
			String[] splitString = new String[12];
			for (int i = 0; i < array.size(); i++) {
				splitString = array.get(i).split("[,]");
				if (sID == Integer.parseInt(splitString[0])) {// �й��� ��ġ�ϴ� �ʵ尡 ������
					if (isStringEqualToTemp(splitString[2])) {// �й��� ��ġ�ϴ� �ʵ忡 ���� ���� ������
						return "�л��� ������ �̹� �ֽ��ϴ�.";
					} else if (splitString[2] == null) {// �й��� �ְ� ������ ������ ������ �����.
						saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5
								+ "," + sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
						grade_save4();
						grade_save3(sID, gpa, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10);
						return "���� ������ �����Ͽ����ϴ�.";
					}
				} // �й��� ��ġ�ϴ� �ʵ尡 ������ �л������Ͱ� �����Ƿ� ������ �����Ѵ�.
				saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + ","
						+ sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
				grade_save1();
				grade_save3(sID, gpa, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10);
				return "���� ������ �����Ͽ����ϴ�.";
			}
		} else {// array�� null�̸� ������ ���� ��(�л� �����Ͱ� ����)�̹Ƿ� ���θ����.
			saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + "," + sub6
					+ "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
			grade_save2();
			grade_save3(sID, gpa, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10);
			return "���� ������ �����Ͽ����ϴ�.";
		}
		return "���� ������ �����Ͽ����ϴ�.";
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

	// ���� ���� �Լ� (�л��� txt ����)
	public void grade_save3(int sID, double gpa, String sub1, String sub2, String sub3, String sub4, String sub5,
			String sub6, String sub7, String sub8, String sub9, String sub10) {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/gradeManagement/" + sID + ".txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			saveString3 = gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + "," + sub6 + "," + sub7
					+ "," + sub8 + "," + sub9 + "," + sub10;
			writer.write(saveString3);
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
		/*
		 * grade_read(); // ������ ���� �о�´�. if (array.isEmpty() == false) { } String path =
		 * System.getProperty("user.dir"); File file = new File(path +
		 * "/Resource/gradeManagement/grades.txt"); FileWriter writer = null; try {
		 * writer = new FileWriter(file, true);
		 * writer.write(System.getProperty("line.separator")); writer.write(saveString);
		 * writer.flush(); } catch (IOException e) { e.printStackTrace(); } finally {
		 * try { if (writer != null) writer.close(); } catch (IOException e) {
		 * e.printStackTrace(); } }
		 */
		try {
			String path = System.getProperty("user.dir");
			BufferedReader re11 = new BufferedReader(new FileReader(path + "/Resource/gradeManagement/grades.txt"));
			String str11;
			StringBuffer write = new StringBuffer(); // ���ڿ��� ����
			FileWriter fw11 = null;

			while ((str11 = re11.readLine()) != null) {
				if (str11.indexOf(sID) > -1) { // �ش� ���ڿ��� �ִ����� üũ
					write.append(saveString).append("\n"); // �ش繮�ڿ� ������ ��� ���ο� ���ڿ��� ��ü
				} else {
					write.append(str11).append("\n"); // ���� ��� ���� ���ڿ��� ����
				}
			}

			fw11 = new FileWriter(path + "/Resource/gradeManagement/grades.txt", false); // ���� ���Ͽ� ���
			fw11.write(write.toString()); // ���ο� ������ ���Ͽ� ����
			fw11.flush(); // ���� ����
			fw11.close(); // ���� �ݱ�
		} catch (Exception a1) {
			a1.printStackTrace();
		}
	}

	// getset
	public Double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getSub1() {
		return subject1;
	}

	public void setSub1(String sub1) {
		this.subject1 = sub1;
	}

	public String getSub2() {
		return subject2;
	}

	public void setSub2(String sub2) {
		this.subject2 = sub2;
	}

	public String getSub3() {
		return subject3;
	}

	public void setSub3(String sub3) {
		this.subject3 = sub3;
	}

	public String getSub4() {
		return subject4;
	}

	public void setSub4(String sub4) {
		this.subject4 = sub4;
	}

	public String getSub5() {
		return subject5;
	}

	public void setSub5(String sub5) {
		this.subject5 = sub5;
	}

	public String getSub6() {
		return subject6;
	}

	public void setSub6(String sub6) {
		this.subject6 = sub6;
	}

	public String getSub7() {
		return subject7;
	}

	public void setSub7(String sub7) {
		this.subject7 = sub7;
	}

	public String getSub8() {
		return subject8;
	}

	public void setSub8(String sub8) {
		this.subject8 = sub8;
	}

	public String getSub9() {
		return subject9;
	}

	public void setSub9(String sub9) {
		this.subject9 = sub9;
	}

	public String getSub10() {
		return subject10;
	}

	public void setSub10(String sub10) {
		this.subject10 = sub10;
	}

	public String getSID() {
		return sID;
	}

	public void setSID(String sID) {
		this.sID = sID;
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
