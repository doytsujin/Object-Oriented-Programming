package social;

import java.util.Collection;
import java.util.LinkedList;

class Person {
	private String codice,nome,cognome;
	private Collection<String> friends=new LinkedList<>();
	private String group;
	
	Person(String code,String name,String surname){
		this.codice=code;
		this.nome=name;
		this.cognome=surname;
		return;
	}
	String getcode(){
		return this.codice;
	}
	String getname(){
		return this.nome;
	}
	String getsurname(){
		return this.cognome;
	}
	void addfriend(String fcode){
		this.friends.add(fcode);
		return;
	}
	Collection<String> getfriendlist(){
		return this.friends;
	}
	int numberoffriends(){
		return this.friends.size();
	}
	void joingroup(String groupname){
		this.group=groupname;
		return;
	}
	String getgroup(){
		return this.group;
	}
}
