package university;

public class University {
	private String name,r_name,r_last;
	private int num_stud=0,num_course=0,offset = 10000,offsetcourse=10;
	private Student vett[] = new Student[1000]; //Vett of student objects
	private Course vettc[] = new Course[50]; //Vettc of Course objects
	
	public University(String name){
		this.name=new String(name);
	}
	
	public String getName(){
		//TODO: to be implemented
		return name;
	}
	
	public void setRector(String first, String last){
		r_name=new String(first); r_last=new String(last);
	}
	
	public String getRector(){
		//TODO: to be implemented
		return r_name+" "+r_last;
	}
	
	public int enroll(String first, String last){
		vett[num_stud]=new Student(first,last,offset+num_stud);
		return vett[num_stud++].getMatricola();
	}
	
	public String student(int id){
		//TODO: to be implemented
		return id+" "+vett[id-offset].getName() + " "+vett[id-offset].getSurname();
	}
	
	public int activate(String title, String teacher){
		vettc[num_course]=new Course(title,teacher,num_course+offsetcourse);
		return vettc[num_course++].getCod();
	}
	
	public String course(int code){
		int i = code - offsetcourse;
		return vettc[i].getCod()+" "+vettc[i].getName()+" "+vettc[i].getProf();
	}
	
	public void register(int studentID, int courseCode){
		vett[studentID-offset].addcourse(courseCode);
		vettc[courseCode-offsetcourse].addStud(studentID);
		return;
	}
	
	public String listAttendees(int courseCode){
		StringBuilder x = new StringBuilder();
		for(int i:vettc[courseCode-offsetcourse].getStudents()){
			if(i>=offset){
				x.append(this.student(i)+"\n");
			}
		}
		return x.toString();
	}

	public String studyPlan(int studentID){
		StringBuilder x = new StringBuilder();
		for(int i:vett[studentID-offset].getCourses()){
			if(i>=offsetcourse){
				x.append(this.course(i)+"\n");
			}
		}
		return x.toString();
	}
}
