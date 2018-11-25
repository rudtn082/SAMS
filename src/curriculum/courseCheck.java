package curriculum;

import javax.swing.ImageIcon;

public class courseCheck {
	public ImageIcon[] courseCheck(String year) {
		ImageIcon[] courseList = new ImageIcon[10]; 
		String[] major = {"korean","english","fe","mind","trade","buliding","green","mechanical","ground","computer"};
		
		for(int i = 0; i<10; i++) {
			courseList[i] = new ImageIcon("Resource/curriculum/" + major[i] + year + ".JPG");
		}
		
		return courseList;
	}
}
