package gradeManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class registerGrade {
	ArrayList<String> array = new ArrayList<String>(); // 파일 읽은 값을 저장하는 arraylist
	private String sID, subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9,
			subject10; // 과목
	private double gpa;
	private String saveString, saveString3; // 저장 시 임시 string 변수

	public registerGrade() {
	}

	// 학번 부여
	public String setSGrade(int sID, double gpa, String sub1, String sub2, String sub3, String sub4, String sub5,
			String sub6, String sub7, String sub8, String sub9, String sub10) {
		this.sID = String.valueOf(sID);
		grade_read(); // 파일을 먼저 읽어온다.
		if (array.isEmpty() == false) {
			// 정보를 배열로 받아온다.
			String[] splitString = new String[12];
			for (int i = 0; i < array.size(); i++) {
				splitString = array.get(i).split(",");
				if (sID == Integer.parseInt(splitString[0])) {// 학번이 일치하는 필드가 있으면
					if (!splitString[2].equals("null")) {// 학번이 일치하는 필드에 성적 값이 있으면
						return "학생의 성적이 이미 있습니다.";
					} else {// 학번이 있고 정보가 없으면 성적을 덮어쓴다.
						saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5
								+ "," + sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
						grade_save4();
						return "성적 저장을 성공하였습니다.";
					}
				}
			}
			// 학번이 일치하는 필드가 없으면 학생데이터가 없으므로 파일을 생성한다.
			saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + ","
					+ sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
			grade_save1();
			return "성적 저장을 성공하였습니다.";
		} else {// array가 null이면 파일이 없는 것(학생 데이터가 없음)이므로 새로만든다.
			saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + "," + sub6
					+ "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
			grade_save2();
			return "성적 저장을 성공하였습니다.";
		}
	}

	// 파일 읽어오기 함수
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

	// 파일 저장 함수 (이어쓰기)
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

	// 파일 저장 함수 (새로만들기)
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

	// 파일 저장 함수 (덮어쓰기)
	public void grade_save4() {
		try {
			String path = System.getProperty("user.dir");
			BufferedReader re11 = new BufferedReader(new FileReader(path + "/Resource/gradeManagement/grades.txt"));
			String str11;
			StringBuffer write = new StringBuffer(); // 문자열을 저장
			FileWriter fw11 = null;

			while ((str11 = re11.readLine()) != null) {
				String[] a = str11.split(",");
				System.out.println(a[0]);
				if (a[0].equals(sID)) { // 해당 문자열이 있는지를 체크
					str11 = str11.replace(str11, saveString);
				}
				write.append(str11); // 없을 경우 기존 문자열을 저장
				write.append(System.getProperty("line.separator"));
			}

			fw11 = new FileWriter(path + "/Resource/gradeManagement/grades.txt", false); // 기존 파일에 덮어씀
			fw11.write(write.toString()); // 새로운 내용을 파일에 쓰기
			fw11.flush(); // 파일 갱신
			fw11.close(); // 파일 닫기
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
