package schools;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import schools.Community.Type;

public class Community {
	private String nome;
	Map<String,Municipality> mun2map=new HashMap<>();
	
	public enum Type { MONTANA, COLLINARE };
	private Type tipo;
	
	public Community(String name, Type type) {
		this.nome=name;
		this.tipo=type;
		return;
	}

	public String getName() {
		return this.nome;
	}
	
	public Type getType(){
		return this.tipo;
	}

	public Collection<Municipality> getMunicipalities() {
		return mun2map.values();
	}
	
}
