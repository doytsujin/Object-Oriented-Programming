package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element {

	/**
	 * Constructor
	 * @param name
	 */
	private Element vettout[]=new Element[2];
	public Split(String name) {
		super(name);
		//TODO: complete
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */
    public Element[] getOutputs(){
        return (Element[]) this.vettout;
    }

	public void connect(Element elem, int noutput){
		if(noutput<0||noutput>1){
			System.out.println("Errore - noutput");
			return;
		}
		this.vettout[noutput]=elem;
	}
	public Element getSingleOutput(int i){
		if(i<0||i>1){
			System.out.println("Errore - input i");
			return null;
		}
		return this.vettout[i];
	}
}
