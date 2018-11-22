package schoolRegister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class register {
	ArrayList<String> array = new ArrayList<String>(); // ���� ���� ���� �����ϴ� arraylist
	private String sName; // �̸�
	private String sAddress; // �ּ�
	private String sGender; // ����
	private Boolean sStatus; // ������Ȳ
	private int sBOD; // �������
	private String saveString; // ���� �� �ӽ� string ����

	public register() {
		setsName(null);
		setsAddress(null);
		setsGender(null);
		setsStatus(null);
		setsBOD(0);
		array.clear();
	}

	// �й� �ο�
	public String setSID(String sName, int sID, String sAddress, String sGender, Boolean sStatus, int sDOB) {
		if (sName != null && sID != 0 && sAddress != null && sGender != null && sStatus != null && sDOB != 0) {
			register_read(); // ������ ���� �о�´�.
			if (array.isEmpty() == false) {
				for (int i = 0; i < array.size(); i++) {
					String[] splitString = array.get(i).split(" ");
					if (sID == Integer.parseInt(splitString[1])) {
						return "���� �й��� �л��� �ֽ��ϴ�.";
					}
				}
				saveString = sName + " " + sID + " " + sAddress + " " + sGender + " " + sStatus + " " + sDOB;
				register_save1();
				return "�й� �ٸ���,,, �����ؾ�¡ ����";
			} else { // array�� null�̸� ������ ���� ��(�л� �����Ͱ� ����)�̹Ƿ� �����Ѵ�.
				saveString = sName + " " + sID + " " + sAddress + " " + sGender + " " + sStatus + " " + sDOB;
				System.out.println("���� ����");
				register_save2();
				return "���� ������ �����Ͽ����ϴ�.";
			}
		} else
			return "���� ������ �����Ͽ����ϴ�.";
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

	// ���� �о���� �Լ�
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

	// ���� ���� �Լ� (�̾��)
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

	// ���� ���� �Լ� (�����)
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
}
