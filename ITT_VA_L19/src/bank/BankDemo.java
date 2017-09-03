package bank;

import java.util.Random;

import bank.classes.Bank;
import bank.classes.Client;

public class BankDemo {
	public static void main(String[] args) {
		Bank bulBank = new Bank("Pari Bank", "Sofiq", 15000000000d);
		Client[] clients = new Client[10];
		for (int i = 0; i < clients.length; i++) {
			clients[i] = new Client("Client" + i, "Sofiq", 5000 + new Random().nextInt(5000),
					1000 + new Random().nextInt(1000));
			if (new Random().nextBoolean()) {
				bulBank.createLongDeposit(clients[i], clients[0].getCash() * (80 + new Random().nextInt(20)) / 100);
			} else {
				bulBank.createShortDeposit(clients[i], clients[0].getCash() * (80 + new Random().nextInt(20)) / 100);
			}
		}
		System.out.println(bulBank);
		for (int i = 0; i < clients.length; i++) {
			if (new Random().nextBoolean()) {
				bulBank.createConsumerCredit(clients[i],  new Random().nextInt(5000),
						48 + new Random().nextInt(60 - 48 + 1));
			} else {
				bulBank.createHomeCredit(clients[i],  new Random().nextInt(5000),
						24 + new Random().nextInt(60 - 24 + 1));
			}
		}
		System.out.println(bulBank);
		for (int i = 0; i < clients.length; i++) {
			System.out.println(clients[i]);
		}
	}
}
