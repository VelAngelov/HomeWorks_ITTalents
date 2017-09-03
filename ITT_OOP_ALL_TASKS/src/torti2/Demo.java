package torti2;

import java.time.LocalDate;
import java.util.Random;

import torti2.lib.*;
import torti2.lib.clients.*;


public class Demo {
	public static Random rnd = new Random();
	public static void main(String[] args) {
		//1
		CakeShop shop = new CakeShop("Talanti", "adress na talantite", "089884564");
		shop.generateProviders(5);
		//2
		shop.generateCakes(30);
		shop.printCakes();
		//3.
		Client[] client = new Client[10];
		for (int i = 0; i < 5; i++) {
			client[i] = new KorporativenClient("KorporativenKlient"+i, "0894645646", 0.05+rnd.nextInt(11)/100.0);
		}
		for (int i = 5; i < 10; i++) {
			client[i] = new ChastenClient("ChastenClient"+(i-5), "5465784354",1+ rnd.nextInt(4), 10+rnd.nextInt(10));
		}
		//4.
		for (int i = 0; i < client.length; i++) {
			client[i].makeOrderForCakes(shop, "adress na client"+i, LocalDate.now());
		}
		//5
		System.out.println("========sled porychki========");
		shop.printCakes();
		//6
		System.out.println("Suma v sladkarnicata: "+shop.getCash());
		//7
		shop.printProvidersByCashEarned();
		//8
		shop.prinMostSoldCakesKind();
		//9
		shop.printProviderWithMaxOrders();
		//10
		Client c = null;
		double cash = 0;
		for(Client cl:client) {
			if(cash<cl.getCashForCakes()) {
				cash = cl.getCashForCakes();
				c = cl;
			}
		}
		System.out.println(c + "max cash for cakes "+cash+"lv");
	}
}
