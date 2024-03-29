package courseManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;

public class courseManagementDAO {

	// 수강 신청 버튼 눌렀을 때
	public String signUp(String ID, int courseNum) {
		String Y = "Y";
		String N = "N";
		String[] checkSignUp = readCourseStudentNumber(ID);
		if(checkSignUp[courseNum].equals("1")) {
			return N;
		}
		else if(checkSignUp[courseNum].equals("0")){
			writeCourseStudentNumber(ID, courseNum, "1");
			return Y;
		}
		else {	// 대체 여기에 왜들어오는겨 미친놈으 새끼가 저리꺼졍
			writeCourseStudentNumber(ID, courseNum, "1");
			return N;
		}
		
	}
	
	// 현재 수강인원 불러오기 함수
	public String[] readCourseStudentNumber(String ID) {
		String line[] = null;
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/signUp/" + ID + ".txt");
			BufferedReader r = new BufferedReader(new FileReader(file));
			line = r.readLine().split(" ");
			r.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return line;
	}
	
	// 해당 학생의 수강 현황 txt 파일 업데이트
	public void writeCourseStudentNumber(String ID, int courseNum, String check) {
		String[] line = {""};
		String toWrite = "";
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/signUp/" + ID + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			line = br.readLine().split(" ");
			br.close();
			line[courseNum] = check;
			System.out.print("line : " + line);
			
			for(int i=0; i<line.length; i++) {
				toWrite += line[i] + " ";
			}
			FileWriter fw = new FileWriter(file, false);
			fw.write(toWrite);
			fw.flush();
			fw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public ImageIcon coursePlan(String majorNum, String courseNum) {
		ImageIcon imageicon = new ImageIcon("Resource/coursePlan/" + majorNum + "/" + courseNum + ".jpg");
		
		return imageicon;
	}
}
