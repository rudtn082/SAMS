package schoolRegister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class schoolRegister {
	ArrayList<String> array = new ArrayList<String>(); // 파일 읽은 값을 저장하는 arraylist
	private String sName; // 이름
	private String sAddress; // 주소
	private String sGender; // 성별
	private Boolean sStatus; // 제적상황
	private int sBOD; // 생년월일
	private String saveString; // 저장 시 임시 string 변수

	public schoolRegister() {
		setsName(null);
		setsAddress(null);
		setsGender(null);
		setsStatus(null);
		setsBOD(0);
		array.clear();
	}

	// 학번 부여
	public String setSID(String sName, int sID, String sAddress, String sGender, Boolean sStatus, int sDOB) {
		if (sName != null && sID != 0 && sAddress != null && sGender != null && sStatus != null && sDOB != 0) {
			register_read(); // 파일을 먼저 읽어온다.
			if (array.isEmpty() == false) {
				for (int i = 0; i < array.size(); i++) {
					String[] splitString = array.get(i).split(" ");
					if (sID == Integer.parseInt(splitString[1])) {
						return "같은 학번의 학생이 있습니다.";
					}
				}
				saveString = sName + " " + sID + " " + sAddress + " " + sGender + " " + sStatus + " " + sDOB;
				register_save1();
				register_grades1(sID);
				register_save3(sID);
				return "학적 저장을 성공하였습니다.";
			} else { // array가 null이면 파일이 없는 것(학생 데이터가 없음)이므로 진행한다.
				saveString = sName + " " + sID + " " + sAddress + " " + sGender + " " + sStatus + " " + sDOB;
				System.out.println("파일 없음");
				register_save2();
				register_grades2(sID);
				register_save3(sID);
				return "학적 저장을 성공하였습니다.";
			}
		} else
			return "학적 저장을 실패하였습니다.";
	}
	
	public String changeInfo(int id, String name, String address, String gender) {
		if (name.equals("") && address.equals("") && gender.equals("")) {
			return "변동 사항을 입력해주세요.";
		}
		else {
			register_read(); // 파일을 먼저 읽어온다.
			if (array.isEmpty() == false) {
				for (int i = 0; i < array.size(); i++) {
					String[] splitString = array.get(i).split(" ");
					if (id == Integer.parseInt(splitString[1])) {
						// 같은 학번 있을 때
						String str_name = null, str_address = null, str_gender = null;
						if(name.equals("")) str_name = splitString[0];
						else str_name = name;
						if(address.equals("")) str_address = splitString[2];
						else str_address = address;
						if(gender.equals("")) str_gender = splitString[3];
						else str_gender = gender;
						
						System.out.println(str_gender);
						String str = str_name + " " + id + " " + str_address + " " + str_gender + " " + splitString[4] + " " + splitString[5];
						array.remove(i);
						array.add(str);
						register_save();
						return "학적이 변경되었습니다.";
					}
				}
			}
			else { // array가 null이면 파일이 없는 것(학생 데이터가 없음)이므로 실패
				return "학적 변경을 실패하였습니다.";
			}
		}
		return "학적 변경을 실패하였습니다.";
	}
	
	public String checkInfo(String ID) {
		
		register_read(); // 파일을 먼저 읽어온다.
		if (array.isEmpty() == false) {
			for (int i = 0; i < array.size(); i++) {
				String[] splitString = array.get(i).split(" ");
				if (ID.equals(splitString[1])) {
					return array.get(i);
				}
			}
			return null;
		} else { // array가 null이면 파일이 없는 것(학생 데이터가 없음이므로
			return null;
		}
	}

	// getset
	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public Boolean getsStatus() {
		return sStatus;
	}

	public void setsStatus(Boolean sStatus) {
		this.sStatus = sStatus;
	}

	public int getsBOD() {
		return sBOD;
	}

	public void setsBOD(int sBOD) {
		this.sBOD = sBOD;
	}

	// 파일 읽어오기 함수
	public void register_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/Resource/register.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				array.add(line);
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// 파일 저장 함수 (덮어쓰기)
	public void register_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/register.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			for(int i = 0; i< array.size(); i++) {
				writer.write(array.get(i));
				writer.write(System.getProperty("line.separator"));
			}
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

	// 파일 저장 함수 (이어쓰기)
	public void register_save1() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/register.txt");
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

	// 파일 저장 함수 (덮어쓰기)
	public void register_save2() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/register.txt");
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
	public void register_save3(int studentNum) {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/signUp/" + studentNum + ".txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			writer.write("0 0 0 0 0 0 0 0 0 0");
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
	
	// 파일 저장 함수 (grades 이어쓰기)
	public void register_grades1(int studentNum) {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/gradeManagement/grades.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, true);
			writer.write(System.getProperty("line.separator"));
			writer.write(studentNum + ",null,null,null,null,null,null,null,null,null,null,null");
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
	
	// 파일 저장 함수 (grades 이어쓰기)
	public void register_grades2(int studentNum) {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/Resource/gradeManagement/grades.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			writer.write(studentNum + ",null,null,null,null,null,null,null,null,null,null,null");
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

}
