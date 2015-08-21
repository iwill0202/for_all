
import java.time.*;
import java.time.format.*;
import java.util.*;
/**
 �@��ҵ{
*/
public class DayCourse implements Iterable<DayCourse.DaySession> {
	
	private LocalDate date = null;//���
	public final DaySession  MorningSessions = new DaySession("Morning");//�W�Ȯɬq
	public final DaySession  AfternoonSessions = new DaySession("Afternoon");//�U�Ȯɬq
	public final DaySession  NightSessions = new DaySession("Night");//�ߤW�ɬq
	
	private List<DayCourse.DaySession> sessions = new ArrayList<DayCourse.DaySession>();

	public DayCourse(LocalDate date) {
		this.date = date;
		sessions.add(this.MorningSessions);
		sessions.add(this.AfternoonSessions);
		sessions.add(this.NightSessions);
	}
	
	
	public void setAllCourseIfNotEmpty(String courseName){
		this.forEach(	(session)->{
			if(!session.getCourseName().equals(""))
				session.setCourseName(courseName);
			});
	}
	public void setAllClassroomIfNotEmpty(String classroom){
		this.forEach(	(session)->{
			if(!session.getClassroom().equals(""))
				session.setClassroom(classroom);
			});
	}
	public void setAllTeacherIfNotEmpty(String teachersName){
		this.forEach(	(session)->{
			if(!session.getTeachersName().equals(""))
				session.setTeachersName(teachersName);
			});
	}
	
	public void allSessionReset(){
		this.forEach(	(session)->session.reset() );
	}
	@Override
	public Iterator<DayCourse.DaySession> iterator() {
		return sessions.iterator();
	}
	
	/**
	 json�榡�Ƹ��<br>
	 : <br>
	 { date :2015-05-09,<br>
  		sessions : [<br>
	    { session : Morning , coursue : R �y�� ,classroom : 310 ,teacher : �C��޳ },<br>
	    { session : Afternoon , coursue : R �y�� ,classroom : 310 ,teacher : �C��޳ },<br>
	    { session : Night , coursue :  ,classroom :  ,teacher :  }<br>
	   ]<br>
	 }<br>
	 */
	@Override	
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append("{ date :")
			.append(date+",\n")
			.append("  sessions : [\n");
		
		for( DayCourse.DaySession s : sessions){
			sb.append("    "+s+",\n");
		}
		sb.deleteCharAt(sb.length()-2).append("   ]\n }");
		return sb.toString();
	}

	/**
	 �@�餤���ɬq
	 */
	public static class DaySession{
		
		public final static DayCourse.DaySession EMPTY = new DaySession("");
		
		private String sessionName;//�ɬq�W��
		private String courseName = "";//�ҵ{�W��
		private String classroom = "";//�ЫǦW��
		private String teachersName ="";//�Ѯv�W��
		
		public DaySession(String sessionName){
			this.sessionName = sessionName;
		}
		public DaySession(String sessionName, String coursueName,String classromm ,String teachersName){
			this(sessionName);
			this.courseName = coursueName;
			this.classroom = classromm;
			this.teachersName = teachersName;
		}
		
		public String getCourseName() {
			return courseName;
		}
		public DaySession setCourseName(String courseName) {
			this.courseName = courseName;
			return this;
		}
		public String getClassroom() {
			return classroom;
		}
		public DaySession setClassroom(String classroom) {
			this.classroom = classroom;
			return this;
		}
		public String getTeachersName() {
			return teachersName;
		}
		public DaySession setTeachersName(String teachersName) {
			this.teachersName = teachersName;
			return this;
		}
		public String getSessionName(){
			return this.sessionName;
		}
		
		/**
		 �Ӯɬq���e��ӶǤJ��sessiom
		 */
		public void asSession(DaySession session){
			Objects.requireNonNull(session);
			this.setCourseName(session.courseName)
				.setClassroom(session.classroom)
				.setTeachersName(session.teachersName);
		}
		/**
		 �Ӯɬq���e���](�M��)
		 */
		public void reset(){
			this.asSession(EMPTY);
		}
		
		public boolean equals(DaySession session) {
			return 	this.courseName.equals(session.courseName) 
					&& this.classroom.equals(session.classroom)
					&& this.teachersName.equals(session.teachersName);
			
		}
		@Override
		public boolean equals(Object obj) {
			 if (obj instanceof DaySession) {
				DaySession s = (DaySession) obj;
				return equals(s);
				
			}
			return false;
		}
		
		@Override
		public String toString() {
			return String.format("{ session : %s , coursue : %s ,classroom : %s ,teacher : %s }",
				this.sessionName,this.courseName,this.classroom,this.teachersName);
		}
		
	}
	
	
	
	//Test 
	public static void main(String... args){
		
		//����! �إߤ@��ҵ{
		DayCourse dc = new DayCourse(LocalDate.parse("2015/05/09",DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		
		//����! �]�w�W�Ȯɬq
		dc.MorningSessions.setCourseName("R �y��").setClassroom("310").setTeachersName("�C��޳");	//�]�w���e
		//�]�w�U�Ȯɬq ���e��ӤW��
		dc.AfternoonSessions.asSession(dc.MorningSessions);//�ҵ{���e��� �W��
		System.out.println("�W�Ȯɬq�P�U�Ȯɬq�ۦP �H"+dc.MorningSessions.equals(dc.AfternoonSessions));//����  asSeesion 
		
		System.out.println(dc.toString());
		 
		System.out.println("=================================================");
		
		//����! �N�Ҧ����ЫǦW�٪��ɬq�A�令 206 �Ы� �A�æL�X���G
		dc.setAllClassroomIfNotEmpty("206");
		dc.setAllCourseIfNotEmpty("RDB");
		dc.setAllTeacherIfNotEmpty("���ӽ�");
		System.out.println("�ܧ��\n"+dc);
		
		System.out.println("=================================================");
		
		//����! �N�ɬq���](�M��)
		dc.allSessionReset();
		dc.NightSessions.setCourseName("�]������").setClassroom("310").setTeachersName("�S���H");
		System.out.println("���s�]�w��\n"+dc);
		
		System.out.println("=================================================");
		
		
	}
}
