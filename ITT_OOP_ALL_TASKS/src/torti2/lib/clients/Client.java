package torti2.lib.clients;

import java.time.LocalDate;
import java.util.Random;

import torti2.lib.*;
import torti2.lib.cakes.Cake.ChildCakes;
import torti2.lib.cakes.Cake.KindsCakes;
import torti2.lib.cakes.Cake.SpecialCakes;
import torti2.lib.cakes.Cake.StandartCakes;
import torti2.lib.cakes.Cake.WedingCakes;


public abstract class Client {
	protected static Random rnd = new Random();
	private String name;
	private String telNumber;
	private final double TIP_RATE;
	private double cashForCakes;
	
	public Client(String name, String telNumber,double tipRate) {
		this.name = name;
		this.telNumber = telNumber;
		this.TIP_RATE = tipRate;
	}
	/** String order = kind,type*/
	protected String[] generateOrderCakes(int count) {
		String[] order = new String[count];
		for (int i = 0; i < count; i++) {
			KindsCakes cakeKind =  KindsCakes.values()[rnd.nextInt(KindsCakes.values().length)];
			String kind = cakeKind.toString();
			String type=null;
			switch(cakeKind) {
			case CHILD:
				type = ChildCakes.values()[rnd.nextInt(ChildCakes.values().length)].toString();
				break;
			case SPECIAL:
				type = SpecialCakes.values()[rnd.nextInt(SpecialCakes.values().length)].toString();
				break;
			case STANDART:
				type = StandartCakes.values()[rnd.nextInt(StandartCakes.values().length)].toString();
				break;
			case WEDING:
				type = WedingCakes.values()[rnd.nextInt(WedingCakes.values().length)].toString();
				break;
			}
			order[i] = kind+","+type;
		}
		return order;
	}
	protected abstract String[] generateOrderCakes();
	
	public void makeOrderForCakes(CakeShop shop,String adress,LocalDate deliveryDate) {
		shop.getOrderFromClient(generateOrderCakes(), this, adress, deliveryDate);
	}
	public void addTorti(Order o,Provider p) {
		double cost = o.getCost();
		o.removeCakes();
		double tip = cost*TIP_RATE;
		p.payTip(tip);
		p.getShop().payDelivery(cost);
		this.cashForCakes+=calculateDiscount(cost,tip);
	}
	protected abstract double calculateDiscount(double cost, double tip);
	
	public double getCashForCakes() {
		return this.cashForCakes;
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", telNumber=" + telNumber + "]";
	}
	
	
}
