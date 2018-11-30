package schoolRegister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import People.Student;

public class changeRegister {
	ArrayList<String> array = new ArrayList<String>(); // 파일 읽은 값을 저장하는 arraylist
	
	private String sName; // 이름
	private String sAddress; // 주소
	private String sGender; // 성별
	
	public String changeInfo(int id, String name, String address, String gender) {
		if (name == null && address == null && gender == null) {
			return "학적 변경을 실패하였습니다.";
		}
		else {
			register_read(); // 파일을 먼저 읽어온다.
			if (array.isEmpty() == false) {
				for (int i = 0; i < array.size(); i++) {
					String[] splitString = array.get(i).split(" ");
					
					if (id == Integer.parseInt(splitString[1])) {
						// 같은 학번 있을 때
					}
				// 변경
				return "진행중..";
				}
			}
			else { // array가 null이면 파일이 없는 것(학생 데이터가 없음)이므로 실패
				return "학적 저장을 실패하였습니다.";
			}
		}
//		if 일치하는 학번이 존재
//	     if 저장된 이름과 입력받은 이름이 다르면         
//	        입력받은 이름 값으로 저장된 이름 값을 대체
//	     if 저장된 주소와 입력받은 주소가 다르면
//	        입력받은 주소 값으로 저장된 주소 값을 대체
//	     if 저장된 성별과 입력받은 성별이 다르면
//	        입력받은 성별 값으로 저장된 성별 값을 대체
//	     return Y
//	else
//	    return N
		return "학적 변경을 실패하였습니다.";
	}
	

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

	// 파일 읽어오기 함수(register)
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
}
