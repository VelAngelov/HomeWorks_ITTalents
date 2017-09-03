package torti;

import java.util.ArrayList;

import torti.classes.Klient;
import torti.classes.Sladkarnica;

public class TortiDemo {
	public static void main(String[] args) {
		Sladkarnica talanti = new Sladkarnica("Sladki talanti", "0878533244", "gr.Sofiq,bulBulgaria");
		talanti.generateDostavchici(5);
		talanti.generateTorti(30);
		ArrayList<Klient> klienti = Klient.generateKlients(5, 5);
		talanti.printTorti();
		for (Klient k : klienti) {
			k.poruchaiTorti(talanti);
		}
		talanti.izpylniPorychki();
		talanti.printTorti();
		System.out.printf("Pari v sladkarnicata:%.2flv\n", talanti.getCash());
		talanti.printDostavchik();
		talanti.printNaiProdavanaTorta();
		talanti.topDostavchik();
		double cash = klienti.get(0).getCash();
		Klient top = null;
		for (Klient k : klienti) {
			if (k.getCash() < cash) {
				cash = k.getCash();
				top = k;
			}
		}
		System.out.println("Klienta platil nqi golqma suma za torti e:" + top);
	}
}
