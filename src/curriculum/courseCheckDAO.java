package curriculum;

import javax.swing.ImageIcon;

public class courseCheckDAO {
	ImageIcon[][] courseList = new ImageIcon[3][10];
	String[] year = {"2018", "2017", "2016"};
	String[] major = {"korean","english","fe","mind","trade","buliding","green","mechanical","ground","computer"};
	
	public ImageIcon[][] courseCheckDAO() {
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<10; j++) {
				courseList[i][j] = new ImageIcon("Resource/curriculum/" + major[j] + "/" + year[i] + ".JPG");
			}
		}
		return courseList;
	}
}
