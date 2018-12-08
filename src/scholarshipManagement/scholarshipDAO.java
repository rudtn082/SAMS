package scholarshipManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import gradeManagement.grade;

public class scholarshipDAO {
	ArrayList<String> array = new ArrayList<String>();
	String saveString;

	public String[] getStatusByMaj(String maj) { // ���� �а��� ���ٽ��� �����ش�.
		scholarship_read();
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				String[] splitString = array.get(i).split("[,]");
				if (maj.equals(splitString[0])) {
					return splitString;
				}
			}
			return null;
		} else { // array�� null�̸� ������ ���� ��(���л� �����Ͱ� �����̹Ƿ�
			return null;
		}
	}

	public boolean checkStuMatch(String sID) { // �ش� �л��� ���л� ���ؿ� �������� �˷��ش�.
		grade gr = new grade();
		String stuGrade = gr.getGradeAll(sID);
		String stuMaj = sID.substring(2, 5);
		String[] topSixStu = getStatusByMaj(stuMaj);

		for (int i = 0; i < 7; i++) {
			if (Double.parseDouble(gr.getGradeAll(topSixStu[i])) < Double.parseDouble(stuGrade)) {
				return true;
			}
		}
		return false;
	}

	public ImageIcon checkScholarshipStandard() {
		ImageIcon scholarshipStandard;
		scholarshipStandard = new ImageIcon("Resource/scholarshipManagement/scholarshipStandard.png");
		return scholarshipStandard;
	}

	public void scholarship_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/scholarshipManagement/scholarships.txt");
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

	// �й� �ο�
	public String setScholarshipStu(String maj, String sID1, String sID2, String sID3, String sID4, String sID5, String sID6) {

		scholarship_read(); // ������ ���� �о�´�.
		if (array.isEmpty() == false) {
			String[] splitString = new String[7];
			for (int i = 0; i < array.size(); i++) {// ������ �迭�� �޾ƿ´�.
				splitString = array.get(i).split("[,]");
				if (maj == splitString[0]) {// �а��� ��ġ�ϴ� �ʵ尡 ������
					saveString = maj + "," + sID1 + "," + sID2 + "," + sID3 + "," + sID4 + "," + sID5 + "," + sID6;
					scholarship_save1(maj);
					return "�ش� �а��� ���л� ������ �����Ͽ����ϴ�.";
				}
			}
		} else {
			// ������Ȳ�� ��ġ�ϴ� �ʵ尡 ������ �����Ͱ� �����Ƿ� ������ �����Ѵ�.
			saveString = maj + "," + sID1 + "," + sID2 + "," + sID3 + "," + sID4 + "," + sID5 + "," + sID6;
			scholarship_save2();
			return "�ش� �а��� ���л� ������ �����Ͽ����ϴ�.";
		}
		return "���л� ������ �����Ͽ����ϴ�.";
	}

	// ���� ���� �Լ� (���θ����)
	public void scholarship_save2() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/scholarshipManagement/scholarships.txt");
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
	public void scholarship_save1(String maj) {
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
			BufferedReader re11 = new BufferedReader(
					new FileReader(path + "/Resource/scholarshipManagement/scholarships.txt"));
			String str11;
			StringBuffer write = new StringBuffer(); // ���ڿ��� ����
			FileWriter fw11 = null;

			while ((str11 = re11.readLine()) != null) {
				if (str11.indexOf(maj) > -1) { // �ش� ���ڿ��� �ִ����� üũ
					write.append(saveString).append("\n"); // �ش繮�ڿ� ������ ��� ���ο� ���ڿ��� ��ü
				} else {
					write.append(str11).append("\n"); // ���� ��� ���� ���ڿ��� ����
				}
			}

			fw11 = new FileWriter(path + "/Resource/scholarshipManagement/scholarships.txt", false); // ���� ���Ͽ� ���
			fw11.write(write.toString()); // ���ο� ������ ���Ͽ� ����
			fw11.flush(); // ���� ����
			fw11.close(); // ���� �ݱ�
		} catch (Exception a1) {
			a1.printStackTrace();
		}
	}
}
