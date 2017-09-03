package music_instruments.lib.instruments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/*
 * Съществуват различно видове музикални инструменти в каталога на магазина:
• струнни (цигулка, виола, контрабас, арфа, китара, гъдулка, ...)
• ударни (барабани, тарамбука, тъпан, дайре, ...)
• духови (тромпет, тромбон, туба, флейта, кларинет, ...)
• клавишни (орган, пиано, акордеон, ...)
• електронни (синтезатор, бас-китара, електрическа цигулка, ...)
 */

public abstract class MusicalInstrument {
	/**
	 * 0-"STRINGS", 1-"PERCUSSION", 2-"BRASS", 3-"KEYBOARDS", 4-"ELECTRONIC"
	 */
	public static final String[] MUSIC_TOOLS_TYPE = { "STRINGS", "PERCUSSION", "BRASS", "KEYBOARDS", "ELECTRONIC" };
	
	public static final String[] STRINGS = { "VIOLIN", "VIOLA", "BASS", "HARP", "GUITAR", "GADULKA" };
	public static final String[] PERCUSSION = { "DRUMS", "TARAMBUK", "DRUM", "DAIRE" };
	public static final String[] BRASS = { "TRUMPET", "TROMBONE", "TUBE", "FLUTE", "CLARINET" };
	public static final String[] KEYBOARDS = { "ORGAN", "PIANO", "ACCORDION" };
	public static final String[] ELECTRONIC = { "SYNTHESIZER", "BASS GUITAR", "ELECTRIC VIOLIN" };
	public static final String[] ALL_INSTRUMENTS= new String[5];

	public static final Comparator<MusicalInstrument> ARRANGE_BY_PRICE = new Comparator<MusicalInstrument>() {
		@Override
		public int compare(MusicalInstrument o1, MusicalInstrument o2) {
			int result = (int)(100*(o1.price-o2.price));
			if(result==0) {
				result = o1.id-o2.id;
			}
			return result;
		}
		
	};

	private static final String STRINGS_STRING = Arrays.toString(STRINGS);
	private static final String PERCUSSION_STRING = Arrays.toString(PERCUSSION);
	private static final String BRASS_STRING = Arrays.toString(BRASS);
	private static final String KEYBOARDS_STRING = Arrays.toString(KEYBOARDS);
	private static final String ELECTRONIC_STRING = Arrays.toString(ELECTRONIC);
	
	static {
		ALL_INSTRUMENTS[0] = STRINGS_STRING;
		ALL_INSTRUMENTS[1] = PERCUSSION_STRING;
		ALL_INSTRUMENTS[2] = BRASS_STRING;
		ALL_INSTRUMENTS[3] = KEYBOARDS_STRING;
		ALL_INSTRUMENTS[4] = ELECTRONIC_STRING;
	}
	
	private static int uniqueId;

	private String type;
	private String name;
	private double price;
	private int id;

	protected MusicalInstrument(String type, String name, double price) {
		this.id = ++uniqueId;
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	public static MusicalInstrument createRandomInstrument(double price) {
		int type = new Random().nextInt(MUSIC_TOOLS_TYPE.length);
		switch (type) {
			case 0:
				return createNewStringInstrument(STRINGS[new Random().nextInt(STRINGS.length)], price);
			case 1:
				return createNewPercussionInstrument(PERCUSSION[new Random().nextInt(PERCUSSION.length)], price);
			case 2:
				return createNewBrassInstrument(BRASS[new Random().nextInt(BRASS.length)], price);
			case 3:
				return createNewKeyboardInstrument(KEYBOARDS[new Random().nextInt(KEYBOARDS.length)], price);
			case 4:
				return createNewElectronicInstrument(ELECTRONIC[new Random().nextInt(ELECTRONIC.length)], price);
			default:
				return null;
		}
	}
	
	/**
	 * 
	 * @param name
	 * "VIOLIN", "VIOLA", "BASS", "HARP", "GUITAR", "GADULKA"
	 * @param price>0
	 */
	public static StringInstrument createNewStringInstrument(String name, double price) {
		initialCheckStringAndPrice(name, price);
		name = name.toUpperCase();
		if (STRINGS_STRING.contains(name)) {
			return new StringInstrument(name, price);
		}
		System.out.println("Cant create instrument with name" + name);
		return null;
	}
	/**
	 * 
	 * @param name
	 * "DRUMS", "TARAMBUK", "DRUM", "DAIRE"
	 * @param price>0
	 */
	public static PercussionInstrument createNewPercussionInstrument(String name, double price) {
		initialCheckStringAndPrice(name, price);
		name = name.toUpperCase();
		if (PERCUSSION_STRING.contains(name)) {
			return new PercussionInstrument(name, price);
		}
		System.out.println("Cant create instrument with name" + name);
		return null;
	}
	/**
	 * 
	 * @param name
	 * "TRUMPET", "TROMBONE", "TUBE", "FLUTE", "CLARINET"
	 * @param price>0
	 */
	public static BrassInstrument createNewBrassInstrument(String name, double price) {
		initialCheckStringAndPrice(name, price);
		name = name.toUpperCase();
		if (BRASS_STRING.contains(name)) {
			return new BrassInstrument(name, price);
		}
		System.out.println("Cant create instrument with name" + name);
		return null;
	}
	/**
	 * 
	 * @param name
	 * "ORGAN", "PIANO", "ACCORDION"
	 * @param price>0
	 */
	public static KeyboardsInstrument createNewKeyboardInstrument(String name, double price) {
		initialCheckStringAndPrice(name, price);
		name = name.toUpperCase();
		if (KEYBOARDS_STRING.contains(name)) {
			return new KeyboardsInstrument(name, price);
		}
		System.out.println("Cant create instrument with name" + name);
		return null;
	}
	/**
	 * 
	 * @param name
	 * "SYNTHESIZER", "BASS GUITAR", "ELECTRIC VIOLIN"
	 * @param price>0
	 */
	public static ElectronicInstrument createNewElectronicInstrument(String name, double price) {
		initialCheckStringAndPrice(name, price);
		name = name.toUpperCase();
		if (ELECTRONIC_STRING.contains(name)) {
			return new ElectronicInstrument(name, price);
		}
		System.out.println("Cant create instrument with name" + name);
		return null;
	}

	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return name.toLowerCase() + "(" + type.toLowerCase() + "), " + " price=" + price+"lv";
	}
	
	private static void initialCheckStringAndPrice(String name, double price) {
		if (name == null) {
			throw new IllegalArgumentException("Instrument with name null");
		}
		if (price <= 0) {
			throw new IllegalArgumentException("Invalid price" + price);
		}
	}
	
}
