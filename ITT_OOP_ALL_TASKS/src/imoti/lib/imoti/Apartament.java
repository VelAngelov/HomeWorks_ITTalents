package imoti.lib.imoti;

import imoti.lib.Agent;
import imoti.lib.Imot;
import imoti.lib.Klient;

public class Apartament extends Imot{
	public static final String[] addInfo = {"EPK", "Tuhla", "Panel","Kerpich"};
	public Apartament(String tip, double plosht, String adres, Agent agent, String opisanie,double price,Klient owner) {
		super(tip, Imot.IMOTI_VID[1], plosht, adres, agent, opisanie,price,owner);
	}
	
}
