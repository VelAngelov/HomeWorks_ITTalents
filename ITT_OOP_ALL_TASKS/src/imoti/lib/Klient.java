package imoti.lib;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Всеки клиент има следните характеристики:
• име;
• телефонен номер;
Клиентите биват продавачи и купувачи.
Продавачите имат имот, който искат да продадат.
Купувачите имат бюджет, с който разполагат за покупка на имот, както и списък с огледи,
които са направили.

Всеки клиент може да изпълнява следните действия:
• Ако е продавач – да регистрира имота си за продажба в агенцията. В такъв случай от
агенцията му се причислява агент на произволен принцип. Имотът влиза в каталога на
агенцията, а клиента – в списъка с продавачи на агента.
• Ако е купувач – да регистрира запитване за търсене на имот към агенцията. В такъв
случай от агенцията му се причислява агент на произволен принцип. Клиентът се
регистрира в списъка с купувачи на агента.
• Ако е купувач – да заяви оглед на определен имот от каталога с имоти. Огледът може
да се осъществи само ако цената на имота е под бюджета на купувача. При
осъществяване на оглед, той влиза в списъка с огледи на купувача, както и на агента.
• Ако е купувач – да заяви покупка на имот. Покупката може да бъде само на имот, на
който купувачът е ходил на оглед. При покупка купувачът дължи 3% от цената ха
имота на агенцията. Агенцията дава половината от комисионната на агента, а
останалата половина влиза в нейния бюджет. Продавачът на имота също дължи 3%
комисионна на агенцията, като и от тази комисионна половината остава за агента под
формата на хонорар.
 */
public abstract class Klient {
	/** 0-"KUPOVACH",1-"PRODAVACH" */
	public static final String[] KLIENTS = {"KUPOVACH","PRODAVACH"};
//	public static String[] klients() {
//		return Arrays.copyOf(KLIENTS, KLIENTS.length);
//	}
	private String type;
	private String name;
	private String telNumber;
	protected double cash;
	protected ArrayList<Imot> imoti;
	protected Agencia agencia;
	protected Agent agent;
	
	protected Klient(String type, String name, String telNumber) {
		this.type = type;
		this.name = name;
		this.telNumber = telNumber;
		this.imoti = new ArrayList<>();
	}
	
	public abstract void registerInAgencia(Agencia agencia);

	void addCash(double totalCost) {
		this.cash+=totalCost;
	}
	/** return null ako nqma imot */
	void removeImot(Imot i) {
		if(imoti.size()!=0) {
			imoti.remove(i);
			return ;
		}
		return ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((agent == null) ? 0 : agent.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telNumber == null) ? 0 : telNumber.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Klient))
			return false;
		Klient other = (Klient) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telNumber == null) {
			if (other.telNumber != null)
				return false;
		} else if (!telNumber.equals(other.telNumber))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Klient [type=" + type + ", name=" + name + ", telNumber=" + telNumber + ", cash=" + cash + "lv, imoti="
				+ imoti.toString() + "]";
	}
	
	
}
