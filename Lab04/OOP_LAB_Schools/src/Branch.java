

public class Branch {
	
	private int codicereg,cap;
	private String tipobra,indirizzo,local,tel,fax;
	private Municipality comune;
	private School scuola;
	
	Branch(int regionalCode, String branchType, Municipality municipality, String indirizzo, int cap,
			String locality, String telephone, String fax, School school) {
		this.codicereg=regionalCode;
		this.tipobra=branchType;
		this.comune=municipality;
		this.indirizzo=indirizzo;
		this.cap=cap;
		this.local=locality;
		this.tel=telephone;
		this.fax=fax;
		this.scuola=school;
		school.sedimap.put(regionalCode, this);
		municipality.bramap.put(regionalCode, this);
		return;
	}
	public int getCode() {
		return this.codicereg;
	}
	public String getBranchType() {
		return this.tipobra;
	}
	public String getAddress() {
		return this.indirizzo;
	}
	public int getCAP() {
		return this.cap;
	}
	public String getLocality() {
		return this.local;
	}
	public String getTelephone() {
		return this.tel;
	}
	public String getFax() {
		return this.fax;
	}

	public Municipality getMunicipality(){
		return this.comune;
	}

	public School getSchool(){
		return this.scuola;
	}

}
