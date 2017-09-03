package imoti.lib;

import java.util.Random;

import imoti.lib.imoti.Apartament;
import imoti.lib.imoti.Kyshta;
import imoti.lib.imoti.Parcel;

/*
 * Продавачите имат имот, който искат да продадат.
 * • Ако е продавач – да регистрира имота си за продажба в агенцията. В такъв случай от
агенцията му се причислява агент на произволен принцип. Имотът влиза в каталога на
агенцията, а клиента – в списъка с продавачи на агента.
 */
public class Prodavach extends Klient{

	public Prodavach(String name, String telNumber,Imot imot) {
		super(Klient.KLIENTS[1], name, telNumber);
		this.imoti.add(imot);
		imot.setOwner(this);
	}
	
	public void registerInAgencia(Agencia agencia) {
		this.agencia = agencia;
		this.agent = agencia.registerNewProdavach(this);
	}
	
	/** return null ako nqma imot */
	Imot getImot() {
		if(imoti.size()!=0) {
			return imoti.get(0);
		}
		return null;
	}

	/*
	 * За всеки продавач да се създаде имот на
произволен принцип – 33% шанс да е апартамент, 33% шанс да е къща и 33% шанс за
парцел. Останалите характеристики също да са на произволен принцип. Цените на
имотите да варират – за къщите между 50 000 и 80 000 евро, за апартаментите – между
70 000 и 150 000 евро; за парцелите – между 30 000 и 85 000 евро.
	 */
	public static Imot generateNewRandomImot() {
		int chance = new Random().nextInt(3);
		if(chance==0) {
			return new Kyshta(Imot.KYSHTA_TIP[new Random().nextInt(Imot.KYSHTA_TIP.length)],
					100+new Random().nextInt(100), "Unknown", null, Kyshta.addInfo[new Random().nextInt(Kyshta.addInfo.length)],
					50_000+new Random().nextInt(80_001-50_000), 50+new Random().nextInt(51), new Random().nextInt(4),null);
		}else if(chance==1) {
			return new Apartament(Imot.APARTAMENT_TIP[new Random().nextInt(Imot.APARTAMENT_TIP.length)],
					80+new Random().nextInt(100), "Unknown", null, Apartament.addInfo[new Random().nextInt(Apartament.addInfo.length)],
					70_000+new Random().nextInt(150_001-70_000),null);
		}else {
			return new Parcel(Imot.PARCEL_TIP[new Random().nextInt(Imot.PARCEL_TIP.length)],
					100+new Random().nextInt(400),"Unknown", null,"no info",
					30_000+new Random().nextInt(85_000-30000),null);
		}
	}
}