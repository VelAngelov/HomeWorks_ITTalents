package imigrants.classes;

public abstract class Existing {
	private boolean isAlive;
	Existing(){
		isAlive=true;
	}
	boolean isAlive() {
		return isAlive;
	}
	void die() {
		isAlive=false;
	}
	abstract void refreshDB(); 
}
