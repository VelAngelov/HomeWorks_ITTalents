package imoti.lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/*
 * Купувачите имат бюджет, с който разполагат за покупка на имот, както и списък с огледи,
които са направили.
 Ако е купувач – да регистрира запитване за търсене на имот към агенцията. В такъв
случай от агенцията му се причислява агент на произволен принцип. Клиентът се
регистрира в списъка с купувачи на агента.
+ Ако е купувач – да заяви оглед на определен имот от каталога с имоти. Огледът може
да се осъществи само ако цената на имота е под бюджета на купувача. При
осъществяване на оглед, той влиза в списъка с огледи на купувача, както и на агента.
+ Ако е купувач – да заяви покупка на имот. Покупката може да бъде само на имот, на
който купувачът е ходил на оглед. При покупка купувачът дължи 3% от цената ха
имота на агенцията. Агенцията дава половината от комисионната на агента, а
останалата половина влиза в нейния бюджет. Продавачът на имота също дължи 3%
комисионна на агенцията, като и от тази комисионна половината остава за агента под
формата на хонорар.
 */
public class Kupovach extends Klient{
	private ArrayList<Ogled> ogledi;
	
	public Kupovach(String name, String telNumber,double initialCash) {
		super(Klient.KLIENTS[0], name, telNumber);
		super.cash = initialCash>0?initialCash:0;
		this.ogledi = new ArrayList<>();
	}

	@Override
	public void registerInAgencia(Agencia agencia) {
		this.agencia = agencia;
		this.agent = agencia.registerNewKupovach(this);
	}
	
	public void zaqviOgled(LocalDate date) {
		if(agent==null) {
			return ;
		}
		Imot imot=agent.findFromCatalog(this.cash/(1+Agencia.COMISIONNA));
		if(imot!=null) {
			Ogled o = new Ogled(imot, this.agent, this, date);
			agent.registerNewOgled(o);
			this.ogledi.add(o);
			return;
		}
		System.out.println(agent + "ne moje da nameri imot za cena "+ cash+"lv");
	}
	public void napraviPokupkaNaEdinImot() {
		if(ogledi.size()==0) {
			System.out.println(this+"ne e hodil na ogledi ili nqma imot koito da kupi!");
			return;
		}
		Ogled o = ogledi.get(new Random().nextInt(ogledi.size()));
		Imot i = o.getImot();
		if(!agencia.chechImotForSale(i)) {
			System.out.println("Imota veche e kupen,sorry"+this);
			return;
		}
		double comisionna = i.getPrice()*Agencia.COMISIONNA;
		double totalCost = i.getPrice()*Agencia.COMISIONNA;
		this.cash-=totalCost;
		agencia.addCash(comisionna/2);
		agent.addCash(comisionna/2+i.getPrice());
		agent.payToOwnerOfImot(i,this);
		//remove from agency:
		agent=null;
		agencia=null;
		System.out.println(this+" buyed new"+i);
	}

}
