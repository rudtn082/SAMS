package curriculum;

import javax.swing.ImageIcon;

public class scheduleCheckDAO {
	ImageIcon timeTabel;
	public ImageIcon scheduleCheckDAO(String sID) {
		timeTabel = new ImageIcon("Resource/schedule/" + sID + ".jpg");
		
		return timeTabel;
	}
}