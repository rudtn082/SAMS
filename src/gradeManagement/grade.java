package gradeManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class grade {
	ArrayList<String> array = new ArrayList<String>();
	
	public String getGradeAll(String sID) {
		String[] splitString = new String[2];
		
		grade_read(); 
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				splitString = array.get(i).split("[,]");
				if (sID.equals(splitString[0])) {
					return splitString[1];
				}
			}
			return null;
		} else { // array가 null이면 파일이 없는 것(학생 데이터가 없음이므로
			return null;
		}
	}
	
	public String checkSID(String sID) {
		grade_read(); 
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				String[] splitString = array.get(i).split("[,]");
				if (sID.equals(splitString[0])) {
					return splitString[0];
				}
			}
			return null;
		} else { // array가 null이면 파일이 없는 것(학생 데이터가 없음이므로
			return null;
		}
	}
	
	public String checkSubject(String sID, int subNum) {
		grade_read(); 
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				String[] splitString = array.get(i).split("[,]");
				if (sID.equals(splitString[0])) {
					return splitString[subNum+1];
				}
			}
			return null;
		} else { // array가 null이면 파일이 없는 것(학생 데이터가 없음이므로
			return null;
		}
	}

	public String[] getGradeByTerm(String sID) {
				
		grade_read(); 
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				String[] splitString = array.get(i).split("[,]");
				if (sID.equals(splitString[0])) {
					return splitString;
				}
			}
			return null;
		} else { // array가 null이면 파일이 없는 것(학생 데이터가 없음이므로
			return null;
		}
	}
	
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
	
	/*
	public String setGrade ( String[] grade, String sID) {
		String Y = "Y";
		String N = "N";
		String line = "";
		
		
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/signUp/grades.txt");
			
			for( int i=0; i<12; i++) {
				line = grade[i] + ",";;
			}
			
			FileWriter fw = new FileWriter(file, false);
			fw.write(line);
			fw.flush();
			fw.close();
			
		} catch (FileNotFoundException e) {
			return N;
		} catch (IOException e) {
			System.out.println(e);
		}
		return Y;
	}
	*/
		
}


