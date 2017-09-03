package torti2.lib.clients;
/*
 * Клиентите биват корпоративни и ча�?тни.
Корпоративните имат 10% от�?тъпка от в�?ички продукти.
Ча�?тните клиенти имат ваучери за покупка на торти на �?тойно�?т между 10 и 30 лв. В�?еки
ча�?тен клиент разполага �? между един и четири ваучера.
В�?еки клиент може да изпълн�?ва �?ледните дей�?тви�?:
• �?ко е ча�?тен – да прави поръчка за произволен брой (между една и три) торти от
произволен вид и тип, като предо�?тав�? в�?ичките �?и ваучери за от�?тъпка (колкото има).
В такъв �?лучай �?е �?ъздава поръчка, в ко�?то влизат необходимите торти (ако �?а
налични), като �?ъщо така �?е причи�?л�?ва до�?тавчик на произволен принцип, който да
зане�?е тортите. От цената на поръчката �?е при�?падат парите от ваучерите �?поред
техни�? брой и �?тойно�?т. До�?тавчикът зана�?�? поръчката, при което клиентът му
заплаща дължимата �?ума заедно �? 2% бакшиш. Сумата влиза в ка�?ата на
�?ладкарницата, а бакшишът о�?тава за до�?тавчика.
 */
public class ChastenClient extends Client{
	private double cashFromValchers;
	public ChastenClient(String name, String telNumber,int numberOfVAlchers,int valueOfOneValcher) {
		super(name, telNumber, 0.02);
		this.cashFromValchers = numberOfVAlchers*valueOfOneValcher;
	}

	@Override
	protected String[] generateOrderCakes() {
		return generateOrderCakes(1+rnd.nextInt(3));
	}

	@Override
	protected double calculateDiscount(double cost, double tip) {
		if(cashFromValchers>0) {
			if(cost<cashFromValchers) {
				cashFromValchers-=cost;
				return tip;
			}else {
				cost-=cashFromValchers;
				return tip+cost;
			}
		}
		return cost+tip;
	}
	
}
