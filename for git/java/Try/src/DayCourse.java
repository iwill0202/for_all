
import java.time.*;
import java.time.format.*;
import java.util.*;
/**
 一日課程
*/
public class DayCourse implements Iterable<DayCourse.DaySession> {
	
	private LocalDate date = null;//日期
	public final DaySession  MorningSessions = new DaySession("Morning");//上午時段
	public final DaySession  AfternoonSessions = new DaySession("Afternoon");//下午時段
	public final DaySession  NightSessions = new DaySession("Night");//晚上時段
	
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
	 json格式化資料<br>
	 : <br>
	 { date :2015-05-09,<br>
  		sessions : [<br>
	    { session : Morning , coursue : R 語言 ,classroom : 310 ,teacher : 丘祐瑋 },<br>
	    { session : Afternoon , coursue : R 語言 ,classroom : 310 ,teacher : 丘祐瑋 },<br>
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
	 一日中的時段
	 */
	public static class DaySession{
		
		public final static DayCourse.DaySession EMPTY = new DaySession("");
		
		private String sessionName;//時段名稱
		private String courseName = "";//課程名稱
		private String classroom = "";//教室名稱
		private String teachersName ="";//老師名稱
		
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
		 該時段內容比照傳入的sessiom
		 */
		public void asSession(DaySession session){
			Objects.requireNonNull(session);
			this.setCourseName(session.courseName)
				.setClassroom(session.classroom)
				.setTeachersName(session.teachersName);
		}
		/**
		 該時段內容重設(清空)
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
		
		//測試! 建立一日課程
		DayCourse dc = new DayCourse(LocalDate.parse("2015/05/09",DateTimeFormatter.ofPattern("yyyy/MM/dd")));
		
		//測試! 設定上午時段
		dc.MorningSessions.setCourseName("R 語言").setClassroom("310").setTeachersName("丘祐瑋");	//設定內容
		//設定下午時段 內容比照上午
		dc.AfternoonSessions.asSession(dc.MorningSessions);//課程內容比照 上午
		System.out.println("上午時段與下午時段相同 ？"+dc.MorningSessions.equals(dc.AfternoonSessions));//測試  asSeesion 
		
		System.out.println(dc.toString());
		 
		System.out.println("=================================================");
		
		//測試! 將所有有教室名稱的時段，改成 206 教室 ，並印出結果
		dc.setAllClassroomIfNotEmpty("206");
		dc.setAllCourseIfNotEmpty("RDB");
		dc.setAllTeacherIfNotEmpty("李志賢");
		System.out.println("變更後\n"+dc);
		
		System.out.println("=================================================");
		
		//測試! 將時段重設(清空)
		dc.allSessionReset();
		dc.NightSessions.setCourseName("夜間輔導").setClassroom("310").setTeachersName("沒有人");
		System.out.println("重新設定後\n"+dc);
		
		System.out.println("=================================================");
		
		
	}
}
