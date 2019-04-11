package clinic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Clinic {

	private Map<String,Person> persmap = new HashMap<>();
	private Map<Integer,Doctor> docmap = new HashMap<>();
	
	public void addPatient(String first, String last, String ssn) {
		persmap.put(ssn, new Person(first,last,ssn));
		return;
	}

	public void addDoctor(String first, String last, String ssn, int docID, String specialization) {
		docmap.put(docID, new Doctor(first,last,ssn,docID,specialization));
		return;
	}

	public Person getPatient(String ssn) throws NoSuchPatient {
		if(!persmap.containsKey(ssn)){
			throw new NoSuchPatient();
		}
		else{
			return persmap.get(ssn);
		}
		
	}

	public Doctor getDoctor(int docID) throws NoSuchDoctor {
		if(!docmap.containsKey(docID)){
			throw new NoSuchDoctor();
		}
		return docmap.get(docID);
	}
	
	public void assignPatientToDoctor(String ssn, int docID) throws NoSuchPatient, NoSuchDoctor {
		Person x=this.getPatient(ssn);
		Doctor y=this.getDoctor(docID);
		x.doc=y;
		y.patients.add(x);
		return;
	}

	/**
	 * returns the collection of doctors that have no patient at all, sorted in alphabetic order.
	 */
	Collection<Doctor> idleDoctors(){ 
		return docmap.values().stream()
			.filter(p->p.patients.isEmpty()==true)
			.sorted((p,e)->p.cognome.compareTo(e.cognome))
			.collect(Collectors.toList());
	}

	/**
	 * returns the collection of doctors that a number of patients larger than the average.
	 */
	Collection<Doctor> busyDoctors(){
		int tot=0,x;
		for(Doctor tmp:docmap.values()){
			tot=tot+tmp.patients.size();
		}
		x=tot/docmap.size();
		return docmap.values().stream()
				.filter(p->p.patients.size()>x)
				.collect(Collectors.toList())
				;
	}

	/**
	 * returns list of strings
	 * containing the name of the doctor and the relative number of patients
	 * with the relative number of patients, sorted by decreasing number.<br>
	 * The string must be formatted as "<i>### : ID SURNAME NAME</i>" where <i>###</i>
	 * represent the number of patients (printed on three characters).
	 */
	Collection<String> doctorsByNumPatients(){
		Collection<Doctor> x = 
				docmap.values().stream()
				.sorted((p,e)->Integer.compare(
						p.patients.size(), e.patients.size()))
				.collect(Collectors.toList())
				;
		List<String> y = new LinkedList<>();
		for(Doctor tmp:x){
			y.add(String.format("%03d", tmp.patients.size())
					+" : "+tmp.getId()+" "
					+tmp.getLast()+" "+tmp.getFirst());
		}
		return y;
	}
	
	/**
	 * computes the number of
	 * patients per (their doctor's) specialization.
	 * The elements are sorted first by decreasing count and then by alphabetic specialization.<br>
	 * The strings are structured as "<i>### - SPECIALITY</i>" where <i>###</i>
	 * represent the number of patients (printed on three characters).
	 */
	public Collection<String> countPatientsPerSpecialization(){
		return persmap.values().stream()
				.filter(p->p.getDoctor()!=null)
				.collect(Collectors.groupingBy((Person p)->p.getDoctor().getSpecialization(),counting()))
				.entrySet().stream().sorted((p,e)->e.getValue().compareTo(p.getValue()))
				.map(e->String.format("%3d", e.getValue())+" : "+e.getKey())
				.collect(Collectors.toList())
				;
		/*return persmap.values().stream()
				.filter(p->p.getDoctor()!=null)
				.collect(groupingBy( (Person p) -> p.getDoctor().getSpecialization(),
									 ()->new TreeMap<>(reverseOrder()),counting()
						))
				.entrySet().stream()
				.sorted(comparing(Map.Entry::getValue,reverseOrder()))
				.map( e -> String.format("%3d", e.getValue()) + " : " + e.getKey() ) 
				.collect(toList())
				;*/
		//return null;
	}
	
	public void loadData(String path) throws IOException {
		File x = new File(path);
		if(!x.exists()||x.isDirectory()){
			throw new IOException();
		}
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while((line=br.readLine())!=null){
			String parsedstring[]=line.split("[;]");
			if(parsedstring.length<4||parsedstring.length>6){
				continue;
			}
			else if(parsedstring[0].equals("P")){
				this.addPatient(parsedstring[1], parsedstring[2], parsedstring[3]);
			}
			else if(parsedstring[0].equals("M")){
				this.addDoctor(parsedstring[1], parsedstring[2], parsedstring[3],
						Integer.parseInt(parsedstring[4]), parsedstring[5]);
			}
		}
		br.close();
	}


}
