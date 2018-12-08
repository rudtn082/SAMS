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

	// 학번 부여
	public String setSGrade(int sID, double gpa, String sub1, String sub2, String sub3, String sub4, String sub5,
			String sub6, String sub7, String sub8, String sub9, String sub10) {
		grade_read(); // 파일을 먼저 읽어온다.
		if (array.isEmpty() == false) {
			// 정보를 배열로 받아온다.
			String[] splitString = new String[12];
			for (int i = 0; i < array.size(); i++) {
				splitString = array.get(i).split("[,]");
				if (sID == Integer.parseInt(splitString[0])) {// 학번이 일치하는 필드가 있으면
					if (isStringEqualToTemp(splitString[2])) {// 학번이 일치하는 필드에 성적 값이 있으면
						return "학생의 성적이 이미 있습니다.";
					} else if (splitString[2] == null) {// 학번이 있고 정보가 없으면 성적을 덮어쓴다.
						saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5
								+ "," + sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
						grade_save4();
						grade_save3(sID, gpa, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10);
						return "성적 저장을 성공하였습니다.";
					}
				} // 학번이 일치하는 필드가 없으면 학생데이터가 없으므로 파일을 생성한다.
				saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + ","
						+ sub6 + "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
				grade_save1();
				grade_save3(sID, gpa, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10);
				return "성적 저장을 성공하였습니다.";
			}
		} else {// array가 null이면 파일이 없는 것(학생 데이터가 없음)이므로 새로만든다.
			saveString = sID + "," + gpa + "," + sub1 + "," + sub2 + "," + sub3 + "," + sub4 + "," + sub5 + "," + sub6
					+ "," + sub7 + "," + sub8 + "," + sub9 + "," + sub10;
			grade_save2();
			grade_save3(sID, gpa, sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10);
			return "성적 저장을 성공하였습니다.";
		}
		return "성적 저장을 실패하였습니다.";
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

	// 파일 저장 함수 (학생별 txt 생성)
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

	// 파일 저장 함수 (덮어쓰기)
	public void grade_save4() {
		/*
		 * grade_read(); // 파일을 먼저 읽어온다. if (array.isEmpty() == false) { } String path =
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
			StringBuffer write = new StringBuffer(); // 문자열을 저장
			FileWriter fw11 = null;

			while ((str11 = re11.readLine()) != null) {
				if (str11.indexOf(sID) > -1) { // 해당 문자열이 있는지를 체크
					write.append(saveString).append("\n"); // 해당문자열 존재할 경우 새로운 문자열로 대체
				} else {
					write.append(str11).append("\n"); // 없을 경우 기존 문자열을 저장
				}
			}

			fw11 = new FileWriter(path + "/Resource/gradeManagement/grades.txt", false); // 기존 파일에 덮어씀
			fw11.write(write.toString()); // 새로운 내용을 파일에 쓰기
			fw11.flush(); // 파일 갱신
			fw11.close(); // 파일 닫기
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
