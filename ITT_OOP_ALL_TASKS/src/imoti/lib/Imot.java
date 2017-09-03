package imoti.lib;

import java.util.Arrays;

import imoti.lib.imoti.*;

/*
 * Агенцията разполага с каталог с обяви, който съдържа всички имоти, регистрирани в нея.
Всеки имот съдържа следните характеристики:
• описание;
• адрес;
• цена на имота;
• тип на имота (описани по-долу);
• площ (кв.м.);
• агент, който отговаря и разпространява имота.


Имотите биват:
1. апартаменти (студио, гарсониера, двустаен, тристаен, мезонет);
2. къщи (етаж от къща, цяла къща);
3. парцели (нива, поляна, гора).
Апартаментите и къщите разполагат с информация за вид строителство: ЕПК, Тухла, Панел
или Кирпич.
Къщите разполагат допълнително с брой паркоместа и площ на двора.
За парцелите има информация дали са в регулация или не.
Имотите са категоризирани по вид (апартаменти, къщи, парцели), като за всяка категория
подредбата е по цена в низходящ ред.
 */
public abstract class Imot implements Comparable<Imot>{
	/** 0-"KYSHTA",1-"APARTAMENT",2-"PARCEL" */
	public static final String[] IMOTI_VID = {"KYSHTA","APARTAMENT","PARCEL"};
	/** 0-"ETAJ_OT_KYSHTA",1-"CIALA_KYSHTA" */
	public static final String[] KYSHTA_TIP = {"ETAJ_OT_KYSHTA","CIALA_KYSHTA"};
	/** 0-"STUDIO",1-"GARSONIERA",2-"DVUSTAEN",3-"TRISTAEN",4-"MEZONET" */
	public static final String[] APARTAMENT_TIP = {"STUDIO","GARSONIERA","DVUSTAEN","TRISTAEN","MEZONET"};
	/** 0-"NIVA",1-"POLIANA",2-"GORA" */
	public static final String[] PARCEL_TIP = {"NIVA","POLIANA","GORA"};
	
	private static int uniqueId;
	private int id;
	private String tip;
	private String vid;
	private double plosht;
	private String adres;
	private Agent agent;
	private String opisanie;
	private double price;
	private Klient owner;
	
	protected Imot(String tip, String vid, double plosht, String adres, Agent agent, String opisanie,double price,Klient owner) {
		this.tip = tip;
		this.vid = vid;
		this.plosht = plosht;
		this.adres = adres;
		this.agent = agent;
		this.opisanie = opisanie;
		this.owner = owner;
		this.price = price;
		this.id=uniqueId++;
	}
	
	@Override
	public int compareTo(Imot o) {
		if(this.id==o.id) {
			return this.id-o.id;
		}
		return Double.compare(this.price, o.price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Imot))
			return false;
		Imot other = (Imot) obj;
		if (id != other.id)
			return false;
		return true;
	}

	void setOwner(Klient klient){
		this.owner = klient;
	}

	public double getPrice() {
		return this.price;
	}

	public Klient getOwner() {
		return this.owner;
	}

	@Override
	public String toString() {
		return "Imot [tip=" + tip + ", vid=" + vid + ", plosht=" + plosht + ", adres=" + adres + ", opisanie="
				+ opisanie + ", price=" + price +  "]";
	}
	
}
