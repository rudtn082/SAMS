package curriculum;

import javax.swing.ImageIcon;

public class altCourseDAO {
	ImageIcon[] altCourseList = new ImageIcon[10];
	String[] major = {"korean","english","fe","mind","trade","buliding","green","mechanical","ground","computer"};
	
	public ImageIcon[] altCourseDAO() {
		for(int i = 0; i<10; i++) {
			altCourseList[i] = new ImageIcon("Resource/altCourse/" + major[i] + ".jpg");
		}
		
		return altCourseList;
	}

}
