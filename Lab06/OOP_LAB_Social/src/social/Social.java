package social;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;


public class Social {
	private Map<String,Person> persmap=new HashMap<>();
	private Map<String,Integer> groupmap=new HashMap<>();
	
	public void addPerson(String code, String name, String surname)
			throws PersonExistsException {
		if(persmap.containsKey(code)){
			throw new PersonExistsException();
		}
		else{
			persmap.put(code, new Person(code,name,surname));
		}
	}

	public String getPerson(String code) throws NoSuchCodeException {
		if(persmap.containsKey(code)==false){
			throw new NoSuchCodeException();
		}
		else{
			Person e = persmap.get(code);
			return e.getcode()+" "+e.getname()+" "
					+e.getsurname();
		}
	}

	public void addFriendship(String codePerson1, String codePerson2)
			throws NoSuchCodeException {
		if(persmap.containsKey(codePerson2)==false||
				persmap.containsKey(codePerson1)==false){
			throw new NoSuchCodeException();
		}
		else{
			Person f1=persmap.get(codePerson1);
			Person f2=persmap.get(codePerson2);
			f1.addfriend(codePerson2);
			f2.addfriend(codePerson1);
			return;
		}
	}

	public Collection<String> listOfFriends(String codePerson)
			throws NoSuchCodeException {
		if(persmap.containsKey(codePerson)==false){
			throw new NoSuchCodeException();
		}
		return persmap.get(codePerson).getfriendlist();
	}

	public Collection<String> friendsOfFriends(String codePerson)
			throws NoSuchCodeException {
		if(persmap.containsKey(codePerson)==false){
			throw new NoSuchCodeException();
		}
		Collection<String> res=new LinkedList<>();
		String[] tmp=(String[]) persmap.get(codePerson).getfriendlist().toArray();
		for(String x:tmp){
			res.addAll(persmap.get(x).getfriendlist());
			res.remove(codePerson);
		}
		return res;
	}

	public Collection<String> friendsOfFriendsNoRepitition(String codePerson)
			throws NoSuchCodeException {
		if(persmap.containsKey(codePerson)==false){
			throw new NoSuchCodeException();
		}
		Collection<String> res=new LinkedList<>();
		String[] tmp=(String[]) persmap.get(codePerson).getfriendlist().toArray();
		for(String x:tmp){
			String[] y=(String[]) persmap.get(x).getfriendlist().toArray();
			for(int i=0;i<y.length;i++){
				if(res.contains(y[i])==false){
					res.add(y[i]);
				}
			}
		}
		res.remove(codePerson);
		return res;
	}

	public void addGroup(String groupName) {
		if(groupmap.containsKey(groupName)==false){
			groupmap.put(groupName, 0);
		}
		return;
	}

	public Collection<String> listOfGroups() {
		return groupmap.keySet();
	}

	public void addPersonToGroup(String codePerson, String groupName) {
		if(groupmap.containsKey(groupName)){
			if(persmap.containsKey(codePerson)){
				int x=groupmap.get(groupName);
				x=x+1;
				groupmap.put(groupName, x);
				persmap.get(codePerson).joingroup(groupName);
			}
		}
		return;
	}

	public Collection<String> listOfPeopleInGroup(String groupName) {
		return persmap.values().stream()
				.filter(p->p.getgroup().equals(groupName))
				.map(e->e.getcode())
				.collect(Collectors.toList())
				;
	}

	public String personWithLargestNumberOfFriends() {
		int tmp,max=0;
		Person MrkZkmb=null;
		for(Person x:persmap.values()){
			tmp=x.getfriendlist().size();
			if(tmp>max){
				max=tmp;
				MrkZkmb=x;
			}
		}
		if(MrkZkmb==null){
			return "";
		}
		return MrkZkmb.getcode();
	}

	public String personWithMostFriendsOfFriends() throws NoSuchCodeException {
		int tmp,max=0;
		Person MrkZkmb=null;
		for(Person x:persmap.values()){
			tmp=friendsOfFriendsNoRepitition(x.getcode()).size();
			if(tmp>max){
				max=tmp;
				MrkZkmb=x;
			}
		}
		if(MrkZkmb==null){
			return "";
		}
		return MrkZkmb.getcode();
	}

	public String largestGroup() {
		int tmp,max=0;
		String maxgroup=null;
		for(String tmp_s:groupmap.keySet()){
			tmp=groupmap.get(tmp_s);
			if(tmp>max){
				maxgroup=tmp_s;
				max=tmp;
			}
		}
		if(maxgroup==null){
			return "";
		}
		return maxgroup;
	}

	public String personInLargestNumberOfGroups() {
		return null;
	}

}