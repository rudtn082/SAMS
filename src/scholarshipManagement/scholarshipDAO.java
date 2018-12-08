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

	public String[] getStatusByMaj(String maj) { // 현재 학과별 장핵승을 보여준다.
		scholarship_read();
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				String[] splitString = array.get(i).split("[,]");
				if (maj.equals(splitString[0])) {
					return splitString;
				}
			}
			return null;
		} else { // array가 null이면 파일이 없는 것(장학생 데이터가 없음이므로
			return null;
		}
	}

	public boolean checkStuMatch(String sID) { // 해당 학생이 장학생 기준에 적합한지 알려준다.
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

	// 학번 부여
	public String setScholarshipStu(String maj, String sID1, String sID2, String sID3, String sID4, String sID5, String sID6) {

		scholarship_read(); // 파일을 먼저 읽어온다.
		if (array.isEmpty() == false) {
			String[] splitString = new String[7];
			for (int i = 0; i < array.size(); i++) {// 정보를 배열로 받아온다.
				splitString = array.get(i).split("[,]");
				if (maj == splitString[0]) {// 학과가 일치하는 필드가 있으면
					saveString = maj + "," + sID1 + "," + sID2 + "," + sID3 + "," + sID4 + "," + sID5 + "," + sID6;
					scholarship_save1(maj);
					return "해당 학과의 장학생 설정을 성공하였습니다.";
				}
			}
		} else {
			// 장학현황이 일치하는 필드가 없으면 데이터가 없으므로 파일을 생성한다.
			saveString = maj + "," + sID1 + "," + sID2 + "," + sID3 + "," + sID4 + "," + sID5 + "," + sID6;
			scholarship_save2();
			return "해당 학과의 장학생 설정을 성공하였습니다.";
		}
		return "장학생 설정을 실패하였습니다.";
	}

	// 파일 저장 함수 (새로만들기)
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

	// 파일 저장 함수 (덮어쓰기)
	public void scholarship_save1(String maj) {
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
			BufferedReader re11 = new BufferedReader(
					new FileReader(path + "/Resource/scholarshipManagement/scholarships.txt"));
			String str11;
			StringBuffer write = new StringBuffer(); // 문자열을 저장
			FileWriter fw11 = null;

			while ((str11 = re11.readLine()) != null) {
				if (str11.indexOf(maj) > -1) { // 해당 문자열이 있는지를 체크
					write.append(saveString).append("\n"); // 해당문자열 존재할 경우 새로운 문자열로 대체
				} else {
					write.append(str11).append("\n"); // 없을 경우 기존 문자열을 저장
				}
			}

			fw11 = new FileWriter(path + "/Resource/scholarshipManagement/scholarships.txt", false); // 기존 파일에 덮어씀
			fw11.write(write.toString()); // 새로운 내용을 파일에 쓰기
			fw11.flush(); // 파일 갱신
			fw11.close(); // 파일 닫기
		} catch (Exception a1) {
			a1.printStackTrace();
		}
	}
}
