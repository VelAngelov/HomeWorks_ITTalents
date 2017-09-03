package imigrants.lib;

import imigrants.lib.imigrants.Imigrant;

/*
 * В приложението имаме и полицейски служители. Всеки от тях има следните
данни:
• Име
• Град и държава, в който работи.

 *  Полицейските служители биват:
• Полицаи – те залавят около 50% от нелегалните имигранти (радикални и
екстремисти). Не могат да залавят обаче имигранти, които носят бомба в
себе си. Те проверят всички имигранти, независимo от типа им и дали
имат паспорт.
• Спец-части – залавят около 90% от нелегалните имигранти, каквито и да
са те. Те проверяват само имигрантите, които са радикални и екстремисти.
 */
public abstract class Policemans {
	public enum PolicemanType{
		POLICE(0.50),SWAT(0.90);
		private double rateToCatchImigrant;
		private PolicemanType(double rate) {
			this.rateToCatchImigrant = rate;
		}
		public double getRateToCatchImigrant() {
			return rateToCatchImigrant;
		}
	}
	private Town town;
	@SuppressWarnings("unused")
	private Country country;
	private PolicemanType type;
	
	public Policemans(PolicemanType type,Town town) {
		this.type = type;
		this.town = town;
		this.country = town.getCountry();
		registerInTown();
	}
	private void registerInTown() {
		this.town.addPolicemans(this);
	}
	
	public PolicemanType getType() {
		return type;
	}
	
	public Town getTown() {
		return town;
	}
	
	public abstract boolean passInBorder(Imigrant imigrant);
}
