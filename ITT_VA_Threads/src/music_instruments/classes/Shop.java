package music_instruments.classes;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import music_instruments.classes.MusicInstrument.KindsInstruments;
import music_instruments.classes.MusicInstrument.TypeInstruments;

public class Shop {
	private volatile HashMap<TypeInstruments, HashMap<KindsInstruments, Queue<MusicInstrument>>> catalogForSale;
	private volatile HashMap<TypeInstruments, HashMap<KindsInstruments, Queue<MusicInstrument>>> soldInstruments;
	private transient double cash;
	private InstrumentProvider provider;

	public Shop() {
		catalogForSale = new HashMap<>();
		soldInstruments = new HashMap<>();
	}

	// methods:
	public synchronized List<MusicInstrument> sellInstruments(KindsInstruments kind, int count) {
		if (count < 0) {
			System.out.println("IllegalNumberOfInstruments!");
			return null;
		}
		LinkedList<MusicInstrument> sellList = new LinkedList<>();
		if (checkCountOfKindInstrument(kind) >= count) {
			for (int i = 0; i < count; i++) {
				sellList.add(sellInstrument(kind));
			}
		} else if (provider != null) {
			System.out.println("We have not enought " + kind + " wait some time to deliver it!");
			provider.deliverKindInstrumetn(kind);
			System.out.println("Time needed :" + kind.getTimeToArrive() / 1000 + " sec");
		}
		return sellList;
	}

	public void addInstruments(KindsInstruments kind, int count, int costPerUnit) {
		if (count <= 0) {
			return;
		}
		for (int i = 0; i < count; i++) {
			addInstrumentInCatalog(catalogForSale, new MusicInstrument(kind, costPerUnit));
		}
	}

	// Spravki za nalichni instr:
	public void printCatalogByTypeAndKind() {
		System.out.println("=======Catalog by Type/Kind=======");
		for (TypeInstruments t : catalogForSale.keySet()) {
			System.out.println(t);
			for (KindsInstruments k : catalogForSale.get(t).keySet()) {
				System.out.println("\t" + k);
				for (MusicInstrument instr : catalogForSale.get(t).get(k)) {
					System.out.println("\t\t" + instr);
				}
			}
		}
	}

	public void printCatalogByKindAlphabetically() {
		List<MusicInstrument> list = compareByComparator(catalogForSale, MusicInstrument.COMPARE_BY_KIND);
		System.out.println("=======Catalog by Kind Alphabetically=======");
		for (MusicInstrument instr : list) {
			System.out.println("\t" + instr);
		}
	}

	public void printCatalogByPrice(boolean ascending) {
		List<MusicInstrument> list;
		if (ascending) {
			list = compareByComparator(catalogForSale, MusicInstrument.COMPARE_BY_PRICE_ASC);
		} else {
			list = compareByComparator(catalogForSale, MusicInstrument.COMPARE_BY_PRICE_DSC);
		}
		System.out.println("=======Catalog by Price " + (ascending ? "Ascending" : "Descending") + "=======");
		for (MusicInstrument instr : list) {
			System.out.println("\t" + instr);
		}
	}

	public void printCatalogByCount() {
		List<Queue<MusicInstrument>> instruments = new LinkedList<>();
		synchronized (catalogForSale) {
			for (TypeInstruments type : catalogForSale.keySet()) {
				for (KindsInstruments kind : catalogForSale.get(type).keySet()) {
					instruments.add(catalogForSale.get(type).get(kind));
				}
			}
		}
		instruments.sort((o1, o2) -> o1.size() - o2.size());
		System.out.println("=======Catalog by Quantity=======");
		for (Queue<MusicInstrument> instr : instruments) {
			System.out.println("\t" + instr.peek().getKind().toString() + ", quantity=" + instr.size());
		}
	}

	// Spravki za prodadeni instrumenti:
	private List<Queue<MusicInstrument>> allInstrumentsByComparator(
			HashMap<TypeInstruments, HashMap<KindsInstruments, Queue<MusicInstrument>>> catalog,
			Comparator<Queue<MusicInstrument>> comp) {
		List<Queue<MusicInstrument>> instruments = new LinkedList<>();
		synchronized (soldInstruments) {
			for (TypeInstruments type : soldInstruments.keySet()) {
				for (KindsInstruments kind : soldInstruments.get(type).keySet()) {
					instruments.add(soldInstruments.get(type).get(kind));
				}
			}
		}
		instruments.sort(comp);
		return instruments;
	}

	public void printSoldByCount() {
		List<Queue<MusicInstrument>> instruments = allInstrumentsByComparator(soldInstruments,
				(o1, o2) -> o1.size() - o2.size());
		System.out.println("=======Sold by Quantity=======");
		for (Queue<MusicInstrument> instr : instruments) {
			System.out.println("\t" + instr.peek().getKind().toString() + ", quantity=" + instr.size());
		}
	}

	public void printMostSoldInstrument() {
		List<Queue<MusicInstrument>> instruments = allInstrumentsByComparator(soldInstruments,
				(o1, o2) -> o1.size() - o2.size());
		MusicInstrument instr;
		try {
			instr = instruments.get(instruments.size() - 1).peek();
		} catch (IndexOutOfBoundsException e) {
			return;
		}
		int count = instruments.get(instruments.size() - 1).size();
		System.out.println("Most sold instrument: " + instr.getKind() + ", count=" + count);
	}

	public void prinLeastSoldInstrument() {
		List<Queue<MusicInstrument>> instruments = allInstrumentsByComparator(soldInstruments,
				(o1, o2) -> o1.size() - o2.size());
		MusicInstrument instr;
		instr = instruments.get(0).peek();
		if (instr == null) {
			return;
		}
		int count = instruments.get(0).size();
		System.out.println("Most sold instrument: " + instr.getKind() + ", count=" + count);
	}

	public void printTypeWithMostSells() {
		HashMap<TypeInstruments, Integer> sold = soldTypesByCount();
		TypeInstruments mostSold = null;
		int count = 0;
		for (TypeInstruments type : sold.keySet()) {
			if (count < sold.get(type)) {
				count = sold.get(type);
				mostSold = type;
			}
		}
		System.out.println("Most sold instrument type is " + mostSold + ", sold items=" + count);
	}

	public void printTypeWithMostCostEarned() {
		HashMap<TypeInstruments, Integer> earnedByType = new HashMap<>();
		List<Queue<MusicInstrument>> instruments = allInstrumentsByComparator(soldInstruments,
				(o1, o2) -> o1.size() - o2.size());
		for (Queue<MusicInstrument> kindInstruments : instruments) {
			int totalCostEarned = 0;
			for (MusicInstrument instr : kindInstruments) {
				totalCostEarned += instr.getCost();
			}
			if (kindInstruments.peek() != null) {
				if (earnedByType.containsKey(kindInstruments.peek().getKind().getType())) {
					earnedByType.put(kindInstruments.peek().getKind().getType(),
							earnedByType.get(kindInstruments.peek().getKind().getType()) + totalCostEarned);
				} else {
					earnedByType.put(kindInstruments.peek().getKind().getType(), totalCostEarned);
				}
			}
		}
	}

	private HashMap<TypeInstruments, Integer> soldTypesByCount() {
		HashMap<TypeInstruments, Integer> sold = new HashMap<>();
		synchronized (soldInstruments) {
			for (TypeInstruments type : soldInstruments.keySet()) {
				int countTypeSold = 0;
				for (KindsInstruments kind : soldInstruments.get(type).keySet()) {
					countTypeSold += soldInstruments.get(type).get(kind).size();
				}
				sold.put(type, countTypeSold);
			}
		}
		return sold;
	}

	private MusicInstrument sellInstrument(KindsInstruments kind) {
		MusicInstrument instrument = null;
		synchronized (catalogForSale) {
			if (catalogForSale.containsKey(kind.getType())) {
				if (catalogForSale.get(kind.getType()).containsKey(kind)) {
					if (!catalogForSale.get(kind.getType()).get(kind).isEmpty()) {
						instrument = catalogForSale.get(kind.getType()).get(kind).poll();
						this.cash += instrument.getCost();
						if (catalogForSale.get(kind.getType()).get(kind).isEmpty()) {
							catalogForSale.get(kind.getType()).remove(kind);
						}
						addInstrumentInCatalog(soldInstruments, instrument);
					}
				}
			}
		}
		return instrument;
	}

	private synchronized int checkCountOfKindInstrument(KindsInstruments kind) {
		int count = 0;
		if (catalogForSale.containsKey(kind.getType())) {
			if (catalogForSale.get(kind.getType()).containsKey(kind)) {
				count = catalogForSale.get(kind.getType()).get(kind).size();
				return count;
			}
		}
		return count;
	}

	private List<MusicInstrument> compareByComparator(
			HashMap<TypeInstruments, HashMap<KindsInstruments, Queue<MusicInstrument>>> catalog,
			Comparator<MusicInstrument> comp) {
		List<MusicInstrument> list = getAllFromCatalog(catalog);
		Collections.sort(list, comp);
		return list;
	}

	private List<MusicInstrument> getAllFromCatalog(
			HashMap<TypeInstruments, HashMap<KindsInstruments, Queue<MusicInstrument>>> catalog) {
		List<MusicInstrument> list = new LinkedList<>();
		for (TypeInstruments t : catalog.keySet()) {
			for (KindsInstruments k : catalog.get(t).keySet()) {
				list.addAll(catalog.get(t).get(k));
			}
		}
		return list;
	}

	private void addInstrumentInCatalog(
			HashMap<TypeInstruments, HashMap<KindsInstruments, Queue<MusicInstrument>>> catalog,
			MusicInstrument instr) {
		synchronized (catalog) {
			if (!catalog.containsKey(instr.getKind().getType())) {
				catalog.put(instr.getKind().getType(), new HashMap<>());
			}
			if (!catalog.get(instr.getKind().getType()).containsKey(instr.getKind())) {
				catalog.get(instr.getKind().getType()).put(instr.getKind(), new LinkedList<>());
			}
			catalog.get(instr.getKind().getType()).get(instr.getKind()).add(instr);
		}
	}

	public double getCash() {
		return cash;
	}

	void addInstrumentsByProvider(List<MusicInstrument> delivery) {
		synchronized (catalogForSale) {
			for (MusicInstrument i : delivery) {
				addInstrumentInCatalog(catalogForSale, i);
				System.out.println("Instrument " + i + "provided by provider!");
			}

		}
	}

	List<KindsInstruments> checkForMissingInstruments() {
		List<KindsInstruments> kinds = new LinkedList<>();
		for (KindsInstruments kind : KindsInstruments.values()) {
			if (checkCountOfKindInstrument(kind) == 0) {
				kinds.add(kind);
			}
		}
		return kinds;
	}

	void addProvider(InstrumentProvider provider) {
		this.provider = provider;
	}
}
