package schoolRegister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import People.Student;

public class changeRegister {
	ArrayList<String> array = new ArrayList<String>(); // ���� ���� ���� �����ϴ� arraylist
	
	private String sName; // �̸�
	private String sAddress; // �ּ�
	private String sGender; // ����
	
	public String changeInfo(int id, String name, String address, String gender) {
		if (name == null && address == null && gender == null) {
			return "���� ������ �����Ͽ����ϴ�.";
		}
		else {
			register_read(); // ������ ���� �о�´�.
			if (array.isEmpty() == false) {
				for (int i = 0; i < array.size(); i++) {
					String[] splitString = array.get(i).split(" ");
					
					if (id == Integer.parseInt(splitString[1])) {
						// ���� �й� ���� ��
					}
				// ����
				return "������..";
				}
			}
			else { // array�� null�̸� ������ ���� ��(�л� �����Ͱ� ����)�̹Ƿ� ����
				return "���� ������ �����Ͽ����ϴ�.";
			}
		}
//		if ��ġ�ϴ� �й��� ����
//	     if ����� �̸��� �Է¹��� �̸��� �ٸ���         
//	        �Է¹��� �̸� ������ ����� �̸� ���� ��ü
//	     if ����� �ּҿ� �Է¹��� �ּҰ� �ٸ���
//	        �Է¹��� �ּ� ������ ����� �ּ� ���� ��ü
//	     if ����� ������ �Է¹��� ������ �ٸ���
//	        �Է¹��� ���� ������ ����� ���� ���� ��ü
//	     return Y
//	else
//	    return N
		return "���� ������ �����Ͽ����ϴ�.";
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

	// ���� �о���� �Լ�(register)
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
