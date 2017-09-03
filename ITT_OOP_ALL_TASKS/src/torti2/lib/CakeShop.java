package torti2.lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import torti2.lib.cakes.Cake;
import torti2.lib.cakes.Cake.ChildCakes;
import torti2.lib.cakes.Cake.SpecialCakes;
import torti2.lib.cakes.Cake.StandartCakes;
import torti2.lib.cakes.Cake.WedingCakes;
import torti2.lib.cakes.ChildCake;
import torti2.lib.cakes.SpecialCake;
import torti2.lib.cakes.StandartCake;
import torti2.lib.cakes.WedingCake;
import torti2.lib.clients.Client;


public class CakeShop {
	private static Random rnd = new Random();
	private String name;
	private String adress;
	private String telNumber;
	private HashSet<Provider> providers;
	private HashMap<String,HashMap<String,ArrayList<Cake>>> cakes;
	private double cash;
	private HashMap<String,Integer> kindCakesSold;
	
	public CakeShop(String name, String adress, String telNumber) {
		this.name = name;
		this.adress = adress;
		this.telNumber = telNumber;
		
		this.providers = new HashSet<>();
		this.cakes = new HashMap<>();
		this.kindCakesSold = new HashMap<>();
	}
	
	private void addCake(Cake cake) {
		if(!cakes.containsKey(cake.getKind())) {
			this.cakes.put(cake.getKind(), new HashMap<>());
		}
		if(!cakes.get(cake.getKind()).containsKey(cake.getType())) {
			this.cakes.get(cake.getKind()).put(cake.getType(), new ArrayList<>());
		}
		cakes.get(cake.getKind()).get(cake.getType()).add(cake);
	}
	private void sortCakes() {
		for(String kind:cakes.keySet()) {
			for(String type:cakes.get(kind).keySet()) {
				Collections.sort(cakes.get(kind).get(type));
			}
		}
	}

	public void generateProviders(int count) {
		for (int i = 0; i < count; i++) {
			this.providers.add(new Provider("Provider"+i, "0898444654"+i%10+i/10,this));
		}
	}

	public void generateCakes(int count) {
		for (int i = 0; i < count; i++) {
			int chance = rnd.nextInt(4);
			Cake cake=null;
			switch (chance) {
			case 0:
				cake = new StandartCake("opisanie na standarten cake", "naimenovanie na cake", 20+rnd.nextInt(10), 6+rnd.nextInt(15),
						StandartCakes.values()[rnd.nextInt(StandartCakes.values().length)], rnd.nextBoolean());
				break;
			case 1:
				cake = new ChildCake("opisanie na standarten cake", "naimenovanie na cake", 20+rnd.nextInt(10), 6+rnd.nextInt(15),
						ChildCakes.values()[rnd.nextInt(ChildCakes.values().length)], "Ime na dete");
				break;
			case 2:
				cake = new WedingCake("opisanie na standarten cake", "naimenovanie na cake", 20+rnd.nextInt(10), 6+rnd.nextInt(15),
						WedingCakes.values()[rnd.nextInt(WedingCakes.values().length)],rnd.nextInt(4));
				break;
			default:
				cake = new SpecialCake("opisanie na standarten cake", "naimenovanie na cake", 20+rnd.nextInt(10), 6+rnd.nextInt(15),
						SpecialCakes.values()[rnd.nextInt(SpecialCakes.values().length)], "Sybitie");
				break;
			}
			addCake(cake);
		}
		sortCakes();
	}
	
	public void getOrderFromClient(String[] orders,Client client,String adress,LocalDate deliveryDate) {
		ArrayList<Cake> orderedCakes = new ArrayList<>();
		for (int i = 0; i < orders.length; i++) {
			String[] oneOrder = orders[i].split(",");
			if(!cakes.containsKey(oneOrder[0])) {
				continue;
			}
			if(!cakes.get(oneOrder[0]).containsKey(oneOrder[1])) {
				continue;
			}
			if(cakes.get(oneOrder[0]).get(oneOrder[1]).size()==0) {
				continue;
			}
			Cake cake = cakes.get(oneOrder[0]).get(oneOrder[1]).remove(0);
			orderedCakes.add(cake);
			addKindSold(cake.getKind());
		}
		Order order = new Order(client, adress, orders, deliveryDate);
		order.addTorti(orderedCakes);
		Provider provider = getRndProvider();
		provider.addOrder(order);
		provider.deliverOrders();
	}

	private void addKindSold(String kind) {
		if(!this.kindCakesSold.containsKey(kind)){
			this.kindCakesSold.put(kind, 1);
			return;
		}
		this.kindCakesSold.put(kind, kindCakesSold.get(kind)+1);
	}

	private Provider getRndProvider() {
		Provider[] providers = new Provider[this.providers.size()];
		providers = this.providers.toArray(providers);
		return providers[rnd.nextInt(providers.length)];
	}

	public void payDelivery(double cost) {
		this.cash+=cost;
	}
	public void printCakes() {
		for(String kind:cakes.keySet()) {
			System.out.println(kind);
			for(String type:cakes.get(kind).keySet()) {
				System.out.println("\t"+type);
				for(Cake c:cakes.get(kind).get(type)) {
					System.out.println("\t\t"+c);
				}
			}
		}
	}

	public String getCash() {
		return this.cash+"lv";
	}
	
	public void printProvidersByCashEarned() {
		ArrayList<Provider> providers = new ArrayList<>();
		providers.addAll(this.providers);
		Collections.sort(providers, (o1,o2)->Double.compare(o1.getCash(), o2.getCash()));
		for(Provider p:providers) {
			System.out.println(p);
		}
	}

	public void prinMostSoldCakesKind() {
		String key = null;
		int maxSold = 0;
		for(String s:this.kindCakesSold.keySet()) {
			if(maxSold<this.kindCakesSold.get(s)) {
				key = s;
				maxSold = this.kindCakesSold.get(s);
			}
		}
		System.out.println("Sold "+key +"torti prodadeni:" +maxSold+"br");
	}

	public void printProviderWithMaxOrders() {
		Provider p = null;
		int orders = 0;
		for(Provider pr:providers) {
			if(orders<pr.getNumberOrders()) {
				orders = pr.getNumberOrders();
				p = pr;
			}
		}
		System.out.println(p + " Orders "+orders);
	}
}
