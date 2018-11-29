package courseManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

public class courseManagementDAO {
	

	
	public String signUp(String ID, int courseNum) {
		String Y = "Y";
		String N = "N";
		String[] checkSignUp = readCourseStudentNumber(ID);
		if(checkSignUp[courseNum].equals("1")) {
			return N;
			
		}
		else {
			writeCourseStudentNumber(ID, courseNum, "1");
			return Y;
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
}
