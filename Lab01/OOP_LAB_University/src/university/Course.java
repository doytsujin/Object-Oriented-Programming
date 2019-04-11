package university;

class Course {
	private String titolo,prof;
	private int code,max_stud=0;
	private int totstud[]=new int[100];
	
	Course(String title, String teacher, int i) {
		titolo = new String (title);
		prof=new String ( teacher);
		code = i;
		// TODO Auto-generated constructor stub
	}
	String getName(){
		return titolo;
	}

	String getProf(){
		return prof;
	
	}
	int getCod(){
		return code;
	}
	void addStud(int studentID) {
		// TODO Auto-generated method stub
		if(max_stud<100){
			totstud[max_stud++]=studentID;
		}
	}
	int[] getStudents(){
		return totstud;
	}
}
