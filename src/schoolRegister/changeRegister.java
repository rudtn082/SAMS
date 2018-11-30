package schoolRegister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import People.Student;

public class changeRegister {
	ArrayList<String> array = new ArrayList<String>(); // ���� ���� ���� �����ϴ� arraylist
	
	private String sName; // �̸�
	private String sAddress; // �ּ�
	private String sGender; // ����
	
	public String changeInfo(int id, String name, String address, String gender) {
		if (name.equals("") && address.equals("") && gender.equals("")) {
			return "���� ������ �Է����ּ���.";
		}
		else {
			register_read(); // ������ ���� �о�´�.
			if (array.isEmpty() == false) {
				for (int i = 0; i < array.size(); i++) {
					String[] splitString = array.get(i).split(" ");
					if (id == Integer.parseInt(splitString[1])) {
						// ���� �й� ���� ��
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
						return "������ ����Ǿ����ϴ�.";
					}
				}
			}
			else { // array�� null�̸� ������ ���� ��(�л� �����Ͱ� ����)�̹Ƿ� ����
				return "���� ������ �����Ͽ����ϴ�.";
			}
		}
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

	// ���� ���� �Լ� (�����)
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
}
