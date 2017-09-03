package music_instruments.lib;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import music_instruments.lib.instruments.MusicalInstrument;

/*
 * В магазинът могат да се извършват следните операции:
+1. продажба на инструмент (по наименование и бройка). Продажбата увеличава парите в
наличност на магазина и премахва броят продадени инструменти от наличните в
магазина. Продажбата може да се осъществи само ако има достатъчно налични
бройки от инструмента. При невъзможност да се продадат инструментите, да се върне
подходящо съобщение към потребителя.
+2. Приемане на нови инструменти за продажба в магазина (наименование и бройка).
+3. Изготвяне на каталог на инструментите в магазина:
+ списък с инструментите, подредени по вид
+ списък с инструментите, подредени по наименование в азбучен ред
+ списък с инструментите, подредени по цена (възможност за избор на възходящо
или низходящо подреждане)
+ списък с инструментите, които са налични в магазина в момента
4. Изготвяне на справки за работата на магазина
+ генериране на списък с продадени инструменти, подредени по брой продажби
+ генериране на обща сума, получена при продажба на инструменти
?(като4.1) актуална информация за най-продаван инструмент (като бройка спрямо
останалите)
? актуална информация за най-непродаван инструмент
?(като4.1) актуална информация за вид инструменти, които най-много се харчат (с найголяма обща бройка продадени от този вид)
+ актуална информация за вид инструменти, от които магазинът има най-голям
приход (с най-голяма обща сума от продажбите)
 */
public class MusicalShop {
	private HashMap<String, TreeMap<String, Deque<MusicalInstrument>>> forSale;
	private HashMap<String, TreeMap<String, Deque<MusicalInstrument>>> sold;
	private double cash;

	public MusicalShop() {
		forSale = new HashMap<>();
		sold = new HashMap<>();
		initializeKeys(forSale);
		initializeKeys(sold);
	}
	
	public boolean addNewInstrument(MusicalInstrument instrument) {
		return addNewInstrument(instrument, forSale);
	}
	
	public void addNewInstruments(MusicalInstrument... instruments) {
		for(MusicalInstrument i:instruments) {
			addNewInstrument(i);
		}
	}
	
	public MusicalInstrument buyMusicalInstrumentByName(String name) {
		MusicalInstrument instrument = getOneMusicalInstrumentByName(name);
		if(instrument == null) {
			System.out.println("Instrument " + name + " not found");
		}
		return instrument;
	}
	
	public ArrayList<MusicalInstrument> buyMusicalInstrumentByNameAndNumber(String name,int number){
		if(number<0) {
			throw new IllegalArgumentException("Number of instruments cant be"+number);
		}
		ArrayList<MusicalInstrument> list = new ArrayList<MusicalInstrument>(number);
		int[] info = infoMusicalInstrumentByName(name);
		if(info==null) {
			System.out.println("Name of instrument \""+name+"\" is incorrect!");
		}
		int initialInstruments = info[2];
		if(initialInstruments<number) {
			System.out.println("Sorry,we dont have enough instruments to sell!You can buy only"+initialInstruments);
		}
		for (int i = 0; i < number; i++) {
			list.add(getOneMusicalInstrumentByName(name));
		}
		return list;
	}
	
	public void printForSaleInstrumentByType() {
		System.out.println("FOR SALE LIST BY TYPE AND NAMES:");
		for(String type:forSale.keySet()) {
			System.out.println(type);
			TreeMap<String,Deque<MusicalInstrument>> inst = forSale.get(type);
			for(String name:inst.keySet()) {
				System.out.println("\t"+name);
				Deque<MusicalInstrument> instrument = inst.get(name);
				for(MusicalInstrument i:instrument) {
					System.out.println("\t\t"+i);
				}
			}
		}
	}
	
	public void printForSaleInstrumentByName() {
		System.out.println("FOR SALE LIST BY NAMES:");
		TreeMap<String,Deque<MusicalInstrument>> sortedByName = new TreeMap<>();
		//sorting in TreeMap
		for(String type:forSale.keySet()) {
			TreeMap<String,Deque<MusicalInstrument>> inst = forSale.get(type);
			for(String name:inst.keySet()) {
				Deque<MusicalInstrument> instrument = inst.get(name);
				for(MusicalInstrument i:instrument) {
					if(!sortedByName.containsKey(i.getName())) {
						sortedByName.put(i.getName(), new LinkedList<>());
					}
					sortedByName.get(i.getName()).add(i);
				}
			}
		}
		//print sorted:
		for(String name:sortedByName.keySet()) {
			System.out.println(name);
			Deque<MusicalInstrument> inst = sortedByName.get(name);
			for(MusicalInstrument i:inst) {
				System.out.println("\t"+i);
			}
		}
	}
	
	public void printForSaleInstrumentByPrice(boolean isAsc) {
		System.out.println("FOR SALE LIST BY PRICE:");
		TreeMap<Double,Deque<MusicalInstrument>> sortedByPrice = new TreeMap<>();
		//sorting in TreeMap
		for(String type:forSale.keySet()) {
			TreeMap<String,Deque<MusicalInstrument>> inst = forSale.get(type);
			for(String name:inst.keySet()) {
				Deque<MusicalInstrument> instrument = inst.get(name);
				for(MusicalInstrument i:instrument) {
					if(!sortedByPrice.containsKey(i.getPrice())) {
						sortedByPrice.put(i.getPrice(), new LinkedList<>());
					}
					sortedByPrice.get(i.getPrice()).add(i);
				}
			}
		}
		//print sorted asc:
		if(isAsc) {
			for(Double price:sortedByPrice.keySet()) {
				Deque<MusicalInstrument> inst = sortedByPrice.get(price);
				for(MusicalInstrument i:inst) {
					System.out.println(i);
				}
			}
			return;
		}
		
		for(Double price:sortedByPrice.descendingKeySet()) {
			Deque<MusicalInstrument> inst = sortedByPrice.get(price);
			for(MusicalInstrument i:inst) {
				System.out.println(i);
			}
		}
	}
	
	public void printSoldInstrumentsByNumberOfSales() {
		System.out.println("\nSOLD ITEMS BY NUMBER OF SALES\n");
		TreeMap<Integer,Queue<Deque<MusicalInstrument>>> sortedByCount = new TreeMap<>();
		//sorting in TreeMap
		for(String type:sold.keySet()) {
			TreeMap<String,Deque<MusicalInstrument>> inst = sold.get(type);
			for(String name:inst.keySet()) {
				Deque<MusicalInstrument> instrument = inst.get(name);
				if(sortedByCount.get(instrument.size())==null) {
					sortedByCount.put(instrument.size(),new LinkedList<Deque<MusicalInstrument>>());
				}
				sortedByCount.get(instrument.size()).offer(instrument);
			}
		}
		//printing:
		for(int i: sortedByCount.descendingKeySet()) {
			if(i!=0) {
				Queue<Deque<MusicalInstrument>> q = sortedByCount.get(i);
				if(q.size()!=0) {
					for(Deque<MusicalInstrument> instr:q) {
						if(instr.size()!=0) {
							System.out.println(instr.peek().getName().toLowerCase()+"("+instr.peek().getType().toLowerCase()+") "+i+" times");
						}
					}
				}
			}else {
				break;
			}
		}
	}
	
	public void printInstrumentsByPriceEarnFromSale() {
		System.out.println("\nSOLD ISTRUMENTS BY EARNED MONEY\n");
		TreeMap<Double,Queue<Deque<MusicalInstrument>>> sortedByPriceEarned = new TreeMap<>();
		//sorting in TreeMap
		for(String type:sold.keySet()) {
			TreeMap<String,Deque<MusicalInstrument>> inst = sold.get(type);
			for(String name:inst.keySet()) {
				Deque<MusicalInstrument> instrument = inst.get(name);
				double totalPrice = calculatePriceForDequeOfInstruments(instrument);
				if(sortedByPriceEarned.get(totalPrice) == null) {
					sortedByPriceEarned.put(totalPrice,new LinkedList<Deque<MusicalInstrument>>());
				}
				sortedByPriceEarned.get(totalPrice).offer(instrument);
			}
		}
		//print from map:
		for(double d: sortedByPriceEarned.descendingKeySet()) {
			if(d!=0) {
				Queue<Deque<MusicalInstrument>> q = sortedByPriceEarned.get(d);
				if(q.size()!=0) {
					for(Deque<MusicalInstrument> instr:q) {
						if(instr.size()!=0) {
							System.out.println(instr.peek().getName().toLowerCase()+"("+instr.peek().getType().toLowerCase()+") totalEarned:" + d+"lv");
						}
					}
				}
			}else {
				break;
			}
		}
	}
	
	public double getCash() {
		return cash;
	}
	
	private double calculatePriceForDequeOfInstruments(Deque<MusicalInstrument> d) {
		double price = 0;
		if(d == null) {
			return price;
		}
		for(MusicalInstrument i: d) {
			price+=i.getPrice();
		}
		return price;
	}
	
	private boolean addNewInstrument(MusicalInstrument instrument,HashMap<String, TreeMap<String, Deque<MusicalInstrument>>> list) {
		if(instrument==null) {
			return false;
		}
		list.get(instrument.getType().toUpperCase()).get(instrument.getName().toUpperCase()).add(instrument);
		return true;
	}
	private boolean addNewInstrumentInSold(MusicalInstrument instrument) {
		return addNewInstrument(instrument, sold);
	}
	
	private void initializeKeys(HashMap<String, TreeMap<String, Deque<MusicalInstrument>>> instruments) {
		for (int i = 0; i < MusicalInstrument.MUSIC_TOOLS_TYPE.length; i++) {
			instruments.put(MusicalInstrument.MUSIC_TOOLS_TYPE[i], new TreeMap<>());
			String[] type;
			switch (i) {
			case 0:
				type = MusicalInstrument.STRINGS;
				break;
			case 1:
				type = MusicalInstrument.PERCUSSION;
				break;
			case 2:
				type = MusicalInstrument.BRASS;
				break;
			case 3:
				type = MusicalInstrument.KEYBOARDS;
				break;
			case 4:
				type = MusicalInstrument.ELECTRONIC;
				break;
			default:
				type = new String[0];
			}
			for (int j = 0; j < type.length; j++) {
				instruments.get(MusicalInstrument.MUSIC_TOOLS_TYPE[i]).put(type[j], new LinkedList<>());
			}
		}

	}
	private MusicalInstrument getOneMusicalInstrumentByName(String name) {
		int[] info = infoMusicalInstrumentByName(name);
		name = name.toUpperCase();
		if(info==null) {
			return null;
		}
		int count = info[2];
		if(count<1) {
			return null;
		}
		//Sell the instrument:
		MusicalInstrument instrument = forSale.get(MusicalInstrument.MUSIC_TOOLS_TYPE[info[0]]).get(name).poll();
		addNewInstrumentInSold(instrument);
		this.cash += instrument.getPrice();
		System.out.println("Instrument:"+instrument.getName()+" sold for "+instrument.getPrice()+"lv");
		return instrument;
	}
	/**
	 * return null if no name is not correct,String[3] -TypeIndex,NameIndex,count;
	 */
	private int[] infoMusicalInstrumentByName(String name) {
		int[] info = new int[3];
		name = name.toUpperCase();
		String[] types = MusicalInstrument.ALL_INSTRUMENTS;
		int indexType=-1;
		
		for (int i = 0; i < types.length; i++) {
			if(types[i].contains(name)) {
				indexType=i;
				break;
			}
		}
		if(indexType == -1) {
			return null;
		}
		
		int indexName=-1;
		String[] names;
		switch (indexType) {
		case 0:
			names = MusicalInstrument.STRINGS;
			break;
		case 1:
			names = MusicalInstrument.PERCUSSION;
			break;
		case 2:
			names = MusicalInstrument.BRASS;
			break;
		case 3:
			names = MusicalInstrument.KEYBOARDS;
			break;
		case 4:
			names = MusicalInstrument.ELECTRONIC;
			break;
		default:
			names = new String[0];
			break;
		}
		
		for(int i = 0; i < names.length ; i++) {
			if(name.equals(names[i])) {
				indexName = i;
				break;
			}
		}
		if(indexName == -1) {
			return null;
		}
		//type:
		info[0] = indexType;
		//name:
		info[1] = indexName;
		//count
		info[2] =forSale.get(MusicalInstrument.MUSIC_TOOLS_TYPE[indexType]).get(name).size();
		
		return info;
	}
}
