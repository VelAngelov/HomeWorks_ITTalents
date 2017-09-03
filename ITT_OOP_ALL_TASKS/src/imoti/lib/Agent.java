package imoti.lib;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Всеки агент съдържа:
• име;
• телефонен номер;
• списък с неповтарящи се клиенти, които продават имот (продавачи);
• списък с неповтарящи се клиенти, които търсят имот (купувачи);
• списък с огледи, които купувачи са направили към имоти.
 */
public class Agent {
	public static final String[] NAMES = {"Sasho","Pesho","Iliqn","Denislav"};
	private String name;
	private String adress;
	private Agencia agencia;
	private HashSet<Klient> prodavachi;
	private double cash;

	private HashSet<Klient> kupovachi;
	private ArrayList<Ogled> ogledi;
	
	public Agent(String name, String adress,Agencia agencia) {
		this.name = name;
		this.adress = adress;
		this.agencia = agencia;

		this.kupovachi = new HashSet<>();
		this.prodavachi = new HashSet<>();
		this.ogledi = new ArrayList<>();
	}

	void addProdavach(Prodavach prodavach) {
		this.prodavachi.add(prodavach);
	}

	void addKupovach(Kupovach kupovach) {
		this.kupovachi.add(kupovach);		
	}

	public Imot findFromCatalog(double cash) {
		return this.agencia.showRndImotForCash(cash, this);
	}

	void registerNewOgled(Ogled o) {
		this.ogledi.add(o);
	}

	void addCash(double cash) {
		this.cash+=cash;
	}

	void payToOwnerOfImot(Imot i,Klient kupovach) {
		Klient prodavach = i.getOwner();
		prodavach.removeImot(i);
		i.setOwner(kupovach);
		this.agencia.removeFromKatalog(i);
		double comisionna = i.getPrice()*Agencia.COMISIONNA;
		double totalCost = i.getPrice()-comisionna;
		this.agencia.addCash(comisionna/2);
		this.addCash(-comisionna/2);
		this.addCash(-totalCost);
		prodavach.addCash(totalCost);
		this.kupovachi.remove(kupovach);
		this.prodavachi.remove(prodavach);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Agent))
			return false;
		Agent other = (Agent) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [name=" + name + ", adress=" + adress + ", agencia=" + agencia.getName() + ", cash=" + cash + "lv]";
	}

	public double getCash() {
		return cash;
	}

	public String getName() {
		return name;
	}
	
	
}
