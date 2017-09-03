package imoti.classes;

public class Apartament extends Property {
	private static int id;
	private static String[] typesConstruction = { "EPK", "Tuhla", "Panel" };
	private static String[] types = { "studio", "garsoniera", "dvustaen", "tristaen", "mezonet" };

	private Apartament() {
		id++;
	}

	public Apartament(String adress, double price, double area, String typeConstruction, String type, Client owner) {
		this();
		super.type = "Apartament";
		super.adress = Validator.validateString(adress) ? adress : ("Sofiq kv.Studentski grad ul.Izmislena N=" + id);
		super.area = area > 0 ? area : 100;
		super.price = price > 0 ? price : Validator.rnd(70000, 150000);
		typeConstruction = Validator.validateString(typeConstruction) ? typeConstruction
				: typesConstruction[Validator.rnd(0, typesConstruction.length)];
		type = Validator.validateString(type) ? type : types[Validator.rnd(0, types.length)];
		this.description = String.format("%s,construction type:%s", type, typeConstruction);
		this.owner = owner;
	}
}
