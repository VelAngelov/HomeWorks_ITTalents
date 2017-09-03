package torti2.lib;

import java.time.LocalDate;
import java.util.ArrayList;

import torti2.lib.cakes.Cake;
import torti2.lib.clients.Client;


public class Order {
		private Client client;
		private double cost;
		private String adress;
		private String[] orders;
		private ArrayList<Cake> cakes;
		private LocalDate date;
		
		public Order(Client client, String adress, String[] orders, LocalDate date) {
			this.client = client;
			this.adress = adress;
			this.orders = orders;
			this.date = date;
		}
		private void calculateCost() {
			cost=0;
			for(Cake cake:cakes) {
				cost+=cake.getPrice();
			}
		}
		public void addTorti(ArrayList<Cake> cakes) {
			this.cakes = cakes;
			calculateCost();
		}
		
		public Client getClient() {
			return client;
		}
		public double getCost() {
			return cost;
		}
		public ArrayList<Cake> removeCakes(){
			ArrayList<Cake> cakes = new ArrayList<>();
			cakes.addAll(this.cakes);
			this.cakes.clear();
			return cakes;
		}
}
