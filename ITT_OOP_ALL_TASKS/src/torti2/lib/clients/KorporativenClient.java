package torti2.lib.clients;
/*
 * Клиентите биват корпоративни и ча�?тни.
Корпоративните имат 10% от�?тъпка от в�?ички продукти.
Ча�?тните клиенти имат ваучери за покупка на торти на �?тойно�?т между 10 и 30 лв. В�?еки
ча�?тен клиент разполага �? между един и четири ваучера.
В�?еки клиент може да изпълн�?ва �?ледните дей�?тви�?:
• �?ко е корпоративен – да поръча произволен брой (между три и пет) торти от
произволен вид и тип. В такъв �?лучай �?е �?ъздава поръчка, в ко�?то влизат
необходимите торти (ако �?а налични), като �?ъщо така �?е причи�?л�?ва до�?тавчик на
произволен принцип, който да зане�?е тортите. От цената на поръчката �?е при�?падат
процентът от�?тъпка на корпоративни�?т клиент. От�?тъпките биват произволни между
5% и 15%. До�?тавчикът зана�?�? поръчката, при което клиентът му заплаща дължимата
�?ума заедно �? 5% бакшиш. Сумата влиза в ка�?ата на �?ладкарницата, а бакшишът
о�?тава за до�?тавчика.
 */
public class KorporativenClient extends Client{
	private double discount;
	public KorporativenClient(String name, String telNumber,double discount) {
		super(name, telNumber, 0.05);
		this.discount=(discount>0.05&&discount<0.15)?discount:0.05;
	}

	@Override
	protected String[] generateOrderCakes() {
		return generateOrderCakes(3+rnd.nextInt(3));
	}

	@Override
	protected double calculateDiscount(double cost, double tip) {
		return cost*(1-discount)+tip;
	}

	
	
}
