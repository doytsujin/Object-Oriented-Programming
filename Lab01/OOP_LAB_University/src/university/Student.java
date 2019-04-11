package university;

class Student {
	private String name,surname;
	private int matr,coursenum=0;
	private int courses[] = new int[25];
	
	public Student(String first, String last, int i) {
		matr = i;
		name=new String(first);
		surname=new String(last);
	}

	int getMatricola() {
		// TODO Auto-generated method stub
		return matr;
	}

	String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	String getSurname() {
		// TODO Auto-generated method stub
		return surname;
	}
	void addcourse(int course){
		if(coursenum<25){
			courses[coursenum++]=course;
			return;
		}
		return;
	}
	int[] getCourses(){
		return courses;
	}
	
}
