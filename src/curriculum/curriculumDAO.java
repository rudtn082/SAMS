package curriculum;

import javax.swing.ImageIcon;

public class curriculumDAO {
   String lectureList;
   ImageIcon schedule = new ImageIcon();
   ImageIcon curriculum = new ImageIcon();
   ImageIcon alteSubject = new ImageIcon();
   
   ImageIcon[] altCourseList = new ImageIcon[10];
   String[] major = {"korean","english","fe","mind","trade","buliding","green","mechanical","ground","computer"};
   
   ImageIcon[][] courseList = new ImageIcon[3][10];
   String[] year = {"2018", "2017", "2016"};
   
   ImageIcon timeTabel;
   
   // ----------------------------------------------------  altCourseDAO

   
   public ImageIcon[] altCourseDAO() {
      for(int i = 0; i<10; i++) {
         altCourseList[i] = new ImageIcon("Resource/altCourse/" + major[i] + ".jpg");
      }
      
      return altCourseList;
   }
   
   
   // ----------------------------------------------------  courseCheckDAO

   
   public ImageIcon[][] courseCheckDAO() {
      for(int i = 0; i<3; i++) {
         for(int j = 0; j<10; j++) {
            courseList[i][j] = new ImageIcon("Resource/curriculum/" + major[j] + "/" + year[i] + ".JPG");
         }
      }
      return courseList;
   }
   
   // ----------------------------------------------------  scheduleCheckDAO

   public ImageIcon scheduleCheckDAO(String sID) {
      timeTabel = new ImageIcon("Resource/schedule/" + sID + ".jpg");
      
      return timeTabel;
   }

   // ----------------------------------------------------  subCheckDAO
   public String[][] subCheckDAO() {
      String[][] course = {
            {"����Ҽ�����","���������","�÷�","�����Ҽ�����","�����л�","�����ǹ̷�","�μ���������","����Թ���","�����","�ƹ�����������"},
            {"����ȸȭ","���۹�","������","��������������","��������������","����̱��Ҽ�","�����а���","�����","��������","���̹��к���"},
            {"����ö���Ǳ���","������ö�л�","����ö���Ǳ���","�ұ�����","�ε�ö�л�","�߱�ö�л�","�ѱ�ö�л�","����","�м�ö��","����ö��"},
            {"��ȸ�ɸ���","���ݽɸ���","�Ƶ��ɸ���","����ɸ���","�̻�ɸ���","�н��ɸ���","�����ɸ���","�ǰ��ɸ���","���ɸ���","û�ҳ�ɸ���"},
            {"�����п���","�����濵��","�����󹫷�","�ؿ�������������","�����м��̳�","��������ȸȭ","���������FTA","����â����","����������","�����繫����"},
            {"����ȯ�����","���������","���౸���ý���","���౸��","���༳�񰳷�","�ǹ���ü�׿�����","��Ὺ��","���౸������","HVAC�ý��۵�����","ö����ũ��Ʈ����"},
            {"ȯ����а���","ȯ��������ռ���","���ȯ����","�����������ü�����","�����������ó����������","����ȭ������ó����������","ȯ���ġ�ؼ�","��ü����","ȯ�汸������","ȯ��ȭ��"},
            {"��������","�����б���","������","����Ҽ���","��������������","�ý����ؼ�","������۰���","���������","��������","�ٺо߱��ý��ۼ���"},
            {"���İ���","��ü����","��������","�ϼ����н���","������","��������","���μ���","�Ϲݰ��н���","�ϼ�ó������","ö����ũ��Ʈ����"},
            {"��ǻ�����α׷���","Ȯ�������","�ڷᱸ��","��ǻ�ͱ���","�˰���","�����ͺ��̽�","�ü���׽ǽ�","��ǻ�ͳ�Ʈ��ũ","���α׷��־���","����Ʈ�������"}
      };
      return course;
   }
   
}