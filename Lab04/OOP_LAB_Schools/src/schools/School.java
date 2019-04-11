package schools;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class School {
	
	private String nome,codice,descr,tipoman,poslegal;
	private int grado;
	Map<Integer,Branch> sedimap = new HashMap<>();
	
	School(String name, String code, int grade, String description, String managementType,
			String legalPosition) {
		this.nome=name;
		this.codice=code;
		this.grado=grade;
		this.descr=description;
		this.tipoman=managementType;
		this.poslegal=legalPosition;
		return;
	}

	public String getName() {
		return this.nome;
	}

	public String getCode() {
		return this.codice;
	}

	public int getGrade() {
		return this.grado;
	}

	public String getDescription() {
		return this.descr;
	}

	public String getManagementType() {
		return this.tipoman;
	}

	public String getLegalPosition() {
		return this.poslegal;
	}

	public Collection<Branch> getBranches() {
		return sedimap.values();
	}

}
