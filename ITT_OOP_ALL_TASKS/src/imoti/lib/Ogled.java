package imoti.lib;

import java.time.LocalDate;

/*
 * Всеки оглед има следните характеристики:
• имот;
• агент;
• купувач;
• дата на провеждане на огледа.
 */
public class Ogled {
	private Imot imot;
	private Agent agent;
	private Klient kupuvach;
	private LocalDate date;
	
	public Ogled(Imot imot, Agent agent, Klient kupuvach, LocalDate date) {
		super();
		this.imot = imot;
		this.agent = agent;
		this.kupuvach = kupuvach;
		this.date = date;
	}
	public Imot getImot() {
		return imot;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ogled))
			return false;
		Ogled other = (Ogled) obj;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (imot == null) {
			if (other.imot != null)
				return false;
		} else if (!imot.equals(other.imot))
			return false;
		if (kupuvach == null) {
			if (other.kupuvach != null)
				return false;
		} else if (!kupuvach.equals(other.kupuvach))
			return false;
		return true;
	}
	

}
