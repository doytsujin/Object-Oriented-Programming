package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends Element {
	private boolean stato=false;
	public Tap(String name) {
		super(name);
		//TODO: complete
	}
	
	public void setOpen(boolean open){
		this.stato=open;
	}
	public boolean isOpen(){
		return this.stato;
	}

}
