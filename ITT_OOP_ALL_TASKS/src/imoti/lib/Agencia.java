package imoti.lib;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/*
 * Реализирайте структура от класове, която да представлява работата на агенция за недвижими
имоти в София.
Агенцията съдържа следните характеристики:
• наименование;
• адрес;
• телефон за контакти;
В агенцията работят агенти, които отговарят за продажбата на имоти
 */
public class Agencia {
	public static final double COMISIONNA = 0.03;
	
	private String name;
	private String adress;
	private String telNumber;
	private HashSet<Agent> agenti;
	private TreeSet<Imot> katalogImoti;
	private double cash;
	public Agencia(String name, String adress, String telNumber) {
		super();
		this.name = name;
		this.adress = adress;
		this.telNumber = telNumber;
		agenti = new HashSet<>();
		katalogImoti = new TreeSet<>();
	}
	
	Agent registerNewProdavach(Prodavach prodavach) {
		Agent a = getRandomAgent();
		a.addProdavach(prodavach);
		katalogImoti.add(prodavach.getImot());
		return a;
	}

	Agent getRandomAgent() {
		Agent[] agenti=this.agenti.toArray(new Agent[this.agenti.size()]);
		return agenti[new Random().nextInt(agenti.length)];
	}

	Agent registerNewKupovach(Kupovach kupovach) {
		Agent a = getRandomAgent();
		a.addKupovach(kupovach);
		return a;
	}
	/** return null!*/
	Imot showRndImotForCash(double cash,Agent a){
		ArrayList<Imot> imoti = new ArrayList<>();
		for(Imot i:katalogImoti) {
			if(i.getPrice()<cash) {
				imoti.add(i);
			}
		}
		if(imoti.size()!=0) {
			return imoti.get(new Random().nextInt(imoti.size()));
		}
		return null;
	}
	boolean chechImotForSale(Imot i) {
		return katalogImoti.contains(i);
	}

	void addCash(double cash) {
		this.cash+=cash;
	}

	void removeFromKatalog(Imot i) {
		this.katalogImoti.remove(i);
	}

	public String getName() {
		return this.name;
	}

	public void generateRandomAgents(int n) {
		if(n <= 0) {
			return;
		}
		for (int i = 0; i < n; i++) {
			this.agenti.add(new Agent(Agent.NAMES[new Random().nextInt(Agent.NAMES.length)], "IT Talans N"+i, this));
		}
	}

	public double getCash() {
		return this.cash;
	}

	public void printSortedAgentsByIncome() {
		TreeSet<Agent> mySet = new TreeSet<Agent>((o1,o2)->{
				if(o1.getCash()==o2.getCash()) {
					return o1.getName().compareTo(o2.getName());
				}
				return Double.compare(o1.getCash(),o2.getCash());
			});
		mySet.addAll(agenti);
		for(Agent a:mySet) {
			System.out.println(a);
		}
		
	}
}
