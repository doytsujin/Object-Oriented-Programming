package hydraulic;
import java.util.*;
/**
 * Main class that act as a container of the elements for
 * the simulation of an hydraulics system 
 * 
 */
public class HSystem {
	
	/**
	 * Adds a new element to the system
	 * @param elem
	 */
	private LinkedList<Element> vett=new LinkedList<Element>();
	
	public void addElement(Element elem){
		vett.add(elem);
	}
	
	/**
	 * returns the element added so far to the system
	 * @return an array of elements whose length is equal to the number of added elements
	 */
	public Element[] getElements(){
		Element vx[]=new Element[vett.size()];
		int j=0;
		while(j<vett.size()){
			vx[j]=vett.get(j++);
		}
		return (Element[]) vx;
	}
	
	/**
	 * Prints the layout of the system starting at each Source
	 */
	public String layout(){
		// TODO: to be implemented
		return null;
	}
	
	/**
	 * starts the simulation of the system
	 */
	public void simulate(){
		Element v1[]=getElements();
		for(Element i:v1){
			if(i instanceof Source){
				double flow=((Source) i).getFlow();
				calcola(i.getOutput(),flow);
			}
		}
	}
	private void calcola(Element input,double flow){
		System.out.println(input.getName());
		if(input instanceof Sink){
			System.out.println("Flow input="+flow+"- Sink\n");
			return;
		}
		else if(input instanceof Tap){
			if((boolean)((Tap) input).isOpen()){
				System.out.println("Flow input="+flow+" Flow output="+flow+"\n");
				calcola(input.getOutput(),flow);
				return;
			}
			else{
				System.out.println("Flow input="+flow+"\nFlow output=0 - Tap is closed.\n");
				return;
			}
		}
		else if(input instanceof Split){
			System.out.println("Flow input="+flow+
					" Flow output="+flow/2+"\n");
			calcola(((Split) input).getSingleOutput(0),flow/2);
			calcola(((Split) input).getSingleOutput(1),flow/2);
			return;
		}
		else{
			System.out.println("Errore tipo non riconosciuto.\n");
			return;
		}
	}
}
