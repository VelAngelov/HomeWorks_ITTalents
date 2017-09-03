package imoti;

import imoti.classes.Agency;
import imoti.classes.Buyer;
import imoti.classes.Seller;
import imoti.classes.Validator;

public class ImotiDemo {
	public static void main(String[] args) {
		Agency agenciq = new Agency(null, null, null);
		agenciq.generateAgents(5);
		Seller[] sellers = new Seller[30];
		for (int i = 0; i < sellers.length; i++) {
			sellers[i] = new Seller(null, null);
			sellers[i].generateProperty(33, 33, 33);
			agenciq.registerPropertyForSale(sellers[i]);
		}
		Buyer[] buyers = new Buyer[10];
		for (int i = 0; i < buyers.length; i++) {
			buyers[i] = new Buyer(null, null, Validator.rnd(30000, 150000));
			agenciq.registerNewBuyer(buyers[i]);
		}
		for (int i = 0; i < 3; i++) {
			agenciq.goToViewPropertiesWithAgents();
		}
		for (int i = 0; i < 10; i++) {
			buyers[i].buyRndProperty();
		}
		System.out.println(agenciq);
		agenciq.printResultsForAgents();
	}
}
