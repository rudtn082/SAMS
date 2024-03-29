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
            {"현대소설강독","국어음운론","시론","고전소설강독","국문학사","국어의미론","민속학의이해","국어규범론","국어사","훈민정음의이해"},
            {"영어회화","영작문","영문법","영국문학의이해","영국문학의이해","현대미국소설","영어학개론","영어교육","영어통사론","영미문학비평"},
            {"서양철학의기초","서양고대철학사","동양철학의기초","불교개론","인도철학사","중국철학사","한국철학사","논리학","분석철학","과학철학"},
            {"사회심리학","성격심리학","아동심리학","실험심리학","이상심리학","학습심리학","가족심리학","건강심리학","상담심리학","청소년심리학"},
            {"무역학원론","국제경영론","무역상무론","해외지역연구개론","무역학세미나","무역영어회화","세계경제와FTA","무역창업론","국제무역론","국제재무관리"},
            {"건축환경공학","건축디자인","건축구조시스템","건축구법","건축설비개론","건물유체및열역학","재료역학","건축구조역학","HVAC시스템디자인","철근콘크리트구조"},
            {"환경공학개론","환경공학종합설계","대기환경학","대기오염방지시설설계","생물학적폐수처리공정설계","물리화학적수처리공정설계","환경수치해석","유체역학","환경구조역학","환경화학"},
            {"기계재료학","계산공학기초","열역학","기계요소설계","공업교과교육론","시스템해석","기계제작공정","기계진동학","최적설계","다분야기계시스템설계"},
            {"발파공학","유체역학","수질공학","암석역학실험","측량학","토질실험","도로설계","암반공학실험","하수처리공학","철근콘크리트설계"},
            {"컴퓨터프로그래밍","확률및통계","자료구조","컴퓨터구조","알고리즘","데이터베이스","운영체제및실습","컴퓨터네트워크","프로그래밍언어개론","소프트웨어공학"}
      };
      return course;
   }
   
}