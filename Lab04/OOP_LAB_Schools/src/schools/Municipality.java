package schools;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Municipality {
	private String nome;
	private String prov;
	private String codaf,nomeaf;
	private Optional<Community> cmapp;
	Map<Integer,Branch> bramap = new HashMap<>();

	public Municipality(String nome, String provincia, String codiceAF, String nomeAF,Community comunita) {
		this.nome=nome;
		this.prov=provincia;
		this.codaf=codiceAF;
		this.nomeaf=nomeAF;
		cmapp = Optional.ofNullable(comunita);
		if(cmapp.isPresent()){
			comunita.mun2map.put(nome, this);
		}
	}
	public String getName() {
		return this.nome;
}
	public String getProvince() {
		return this.prov;
	}
	public String getCodeAF() {
		return this.codaf;
	}
	public String getNameAF() {
		return this.nomeaf;
	}
	public Collection<Branch> getBranches() {
		return bramap.values();
	}

	public Optional<Community> getCommunity() {
		return cmapp;
	}
	long total(){
		return (long) bramap.values().size();
	}
	
}
