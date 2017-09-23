package music_instruments.classes;

import java.util.Comparator;

public class MusicInstrument {
	public enum TypeInstruments {
		STRING, PERCUSSION, BRASS, KEYBOARD, ELECTRONIC
	}

	public enum KindsInstruments {
		VIOLIN(TypeInstruments.STRING,2000),
		VIOLA(TypeInstruments.STRING,3000),
		BASS(TypeInstruments.STRING,2000),
		GUITAR(TypeInstruments.STRING,2000),
		GADULKA(TypeInstruments.STRING,3000),
		DRUMS(TypeInstruments.PERCUSSION,1000),
		TARAMBUK(TypeInstruments.PERCUSSION,5000),
		DRUM(TypeInstruments.PERCUSSION,2000),
		DAIRE(TypeInstruments.PERCUSSION,51000),
		TRUMPET(TypeInstruments.BRASS,2000),
		TROMBONE(TypeInstruments.BRASS,4000),
		TUBE(TypeInstruments.BRASS,4000),
		FLUTE(TypeInstruments.BRASS,1000),
		CLARINET(TypeInstruments.BRASS,2000),
		ORGAN(TypeInstruments.KEYBOARD,6000),
		PIANO(TypeInstruments.KEYBOARD,6000),
		ACCORDION(TypeInstruments.KEYBOARD,2000),
		SYNTHESIZER(TypeInstruments.ELECTRONIC,2000),
		BASS_GUITAR(TypeInstruments.ELECTRONIC,1000),
		ELECTRIC_VIOLIN(TypeInstruments.ELECTRONIC,1000);
		private TypeInstruments type;
		private int timeToArrive;
		private KindsInstruments(TypeInstruments type,int timeToArrive) {
			this.type = type;
			this.timeToArrive = timeToArrive;
		}

		public TypeInstruments getType() {
			return type;
		}
		
		public int getTimeToArrive() {
			return timeToArrive;
		}
	}
	public static final Comparator<MusicInstrument> COMPARE_BY_PRICE_ASC = (o1,o2)->o1.getCost()-o2.getCost();
	public static final Comparator<MusicInstrument> COMPARE_BY_PRICE_DSC = (o1,o2)->-o1.getCost()+o2.getCost();
	public static final Comparator<MusicInstrument> COMPARE_BY_KIND = (o1,o2)->o1.getKind().toString().compareTo(o2.getKind().toString());
	private KindsInstruments kind;
	private int cost;
	
	public MusicInstrument(KindsInstruments kind, int cost) {
		super();
		this.kind = kind;
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public KindsInstruments getKind() {
		return kind;
	}

	@Override
	public String toString() {
		return "Type"+kind.getType()+", kind=" + kind + ", cost=" + cost;
	}
	
}
