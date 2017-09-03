package torti2.lib;

import java.util.ArrayList;

import torti2.lib.clients.Client;


public class Provider {
	private String name;
	private String telNumber;
	private ArrayList<Order> orders;
	private double cash;
	private CakeShop shop;
	private int numberOrders;
	
	public Provider(String name, String telNumber,CakeShop shop) {
		this.name = name;
		this.telNumber = telNumber;
		orders = new ArrayList<>();
		this.shop= shop;
	}

	public void addOrder(Order order) {
		this.orders.add(order);
		this.numberOrders++;
		return;
	}

	public void deliverOrders() {
		for(Order o:orders) {
			Client client = o.getClient();
			client.addTorti(o,this);
		}
	}

	public void payTip(double tip) {
		this.cash+=tip;
	}

	public CakeShop getShop() {
		return this.shop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		result = prime * result + ((telNumber == null) ? 0 : telNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Provider))
			return false;
		Provider other = (Provider) obj;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		if (telNumber == null) {
			if (other.telNumber != null)
				return false;
		} else if (!telNumber.equals(other.telNumber))
			return false;
		return true;
	}

	public double getCash() {
		return this.cash;
	}

	@Override
	public String toString() {
		return "Provider [name=" + name + ", telNumber=" + telNumber + ", cash=" + cash + "]";
	}

	public int getNumberOrders() {
		return this.numberOrders;
	}
	
	
}
