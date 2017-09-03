package vinetki.classes;

public abstract class Vehicle {
	String type;
	Vinetka vinetka;
	String godinaProizvodstvo;
	Driver owner;

	Vehicle(String type, String godinaProizvodstvo) {
		this.type = type;
		this.godinaProizvodstvo = godinaProizvodstvo;
	}

	public Driver getOwner() {
		return owner;
	}

	public String getType() {
		return type;
	}

	public void setOwner(Driver owner) {
		this.owner = owner;
	}

	void setVinetka(Vinetka vinetka) {
		this.vinetka = vinetka;
	}

	public Vinetka getVinetka() {
		return vinetka;
	}

	@Override
	public String toString() {
		return String.format("Vehicle:%s Vinetka:%s", this.type, (this.vinetka == null ? "no" : vinetka));
	}

}
