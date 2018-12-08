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
		} else { // array�� null�̸� ������ ���� ��(�л� �����Ͱ� �����̹Ƿ�
			return null;
		}
	}
	
	public boolean checkSID(String sID) {
		grade_read(); 
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				String[] splitString = array.get(i).split(",");
				if (sID.equals(splitString[0])) {
					return true;
				}
			}
			return false;
		} else { // array�� null�̸� ������ ���� ��(�л� �����Ͱ� �����̹Ƿ�
			return false;
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
		} else { // array�� null�̸� ������ ���� ��(�л� �����Ͱ� �����̹Ƿ�
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
		} else { // array�� null�̸� ������ ���� ��(�л� �����Ͱ� �����̹Ƿ�
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
}


