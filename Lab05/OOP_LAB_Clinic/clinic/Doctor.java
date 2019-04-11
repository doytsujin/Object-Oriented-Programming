package clinic;

import java.util.Collection;
import java.util.LinkedList;

public class Doctor extends Person {
	
	private int badge;
	private String spec;
	Collection<Person> patients=new LinkedList<>();
	
	Doctor(String first, String last, String ssn2, int docID, String specialization) {
		super(first, last, ssn2);
		this.badge=docID;
		this.spec=specialization;
		return;
	}

	public int getId(){
		return this.badge;
	}
	
	public String getSpecialization(){
		return this.spec;
	}
	
	public Collection<Person> getPatients() {
		return this.patients;
	}

}
