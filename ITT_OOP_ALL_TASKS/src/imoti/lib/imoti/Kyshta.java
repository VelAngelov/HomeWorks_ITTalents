package imoti.lib.imoti;

import imoti.lib.Agent;
import imoti.lib.Imot;
import imoti.lib.Klient;

public class Kyshta extends Imot{
	public static final String[] addInfo = {"EPK", "Tuhla", "Panel","Kerpich"};
	private double dvorPlosht;
	private int broiParkomesta;
	public Kyshta(String tip, double plosht, String adres, Agent agent, String opisanie,double price,double dvorPlosht,int broiParkomesta,Klient owner) {
		super(tip, Imot.IMOTI_VID[0], plosht, adres, agent, opisanie,price,owner);
		this.dvorPlosht = dvorPlosht;
		this.broiParkomesta=broiParkomesta;
	}
	@Override
	public String toString() {
		return super.toString()+" Plosht na dvora=" + dvorPlosht + ", broiParkomesta=" + broiParkomesta;
	}
	

}
