package imoti.classes;

public class Plot extends Property {
	private static int id;
	private static String[] types = { "niva", "polqna", "gora" };

	private Plot() {
		id++;
	}

	public Plot(String adress, double price, double area, String type, Client owner) {
		this();
		super.type = "Plot";
		super.adress = Validator.validateString(adress) ? adress : ("Sofiq kv.Studentski grad ul.Izmislena N=" + id);
		super.area = area > 0 ? area : 1000;
		super.price = price > 0 ? price : Validator.rnd(30000, 85000);
		type = Validator.validateString(type) ? type : types[Validator.rnd(0, types.length)];
		this.description = String.format("%s", type);
		this.owner = owner;
	}
}
