package imoti.classes;

public class House extends Property {
	private static int id;
	private static String[] typesConstruction = { "Tuhla", "kerpich", "Dyrvo" };
	private static String[] types = { "edin etaj", "cqla kyshta" };
	private int parks;

	private House() {
		id++;
	}

	public House(String adress, double price, double area, String typeConstruction, String type, int parks,
			Client owner) {
		this();
		super.type = "House";
		super.adress = Validator.validateString(adress) ? adress : ("Sofiq kv.Vitosha ul.Izmislena N=" + id);
		super.area = area > 0 ? area : 200;
		super.price = price > 0 ? price : Validator.rnd(50000, 80000 + 1);
		typeConstruction = Validator.validateString(typeConstruction) ? typeConstruction
				: typesConstruction[Validator.rnd(0, typesConstruction.length)];
		type = Validator.validateString(type) ? type : types[Validator.rnd(0, types.length)];
		parks = parks > 0 ? parks : 2;
		this.description = String.format("%s,construction type:%s,park places:%d", type, typeConstruction, parks);
		this.owner = owner;
	}
}
