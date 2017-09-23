package music_instruments.classes;

import java.util.LinkedList;
import java.util.List;

import music_instruments.classes.MusicInstrument.KindsInstruments;

public class InstrumentProvider {
	private Shop shop;
	boolean interuptAutoDelivery;
	Thread specialDelivery;
	Thread diamonDelivery;

	public InstrumentProvider(Shop shop, int deliveryTime) {
		this.shop = shop;
		shop.addProvider(this);
		diamonDelivery = new Thread(() -> {
			while (true) {
				try {
					// delivery time elapsed;
					Thread.sleep(deliveryTime);
					List<MusicInstrument> delivery = delivery(shop.checkForMissingInstruments());
					shop.addInstrumentsByProvider(delivery);
				} catch (InterruptedException e) {
					break;
				}
				if (interuptAutoDelivery) {
					break;
				}
			}
			System.out.println("Delivery Interupted");
		});
		diamonDelivery.start();
	}

	private List<MusicInstrument> delivery(List<KindsInstruments> list) {
		List<MusicInstrument> instruments = new LinkedList<MusicInstrument>();
		for (KindsInstruments kind : list) {
			instruments.add(new MusicInstrument(kind, 800));
		}
		return instruments;
	}

	public void stopAutoDelivery() {
		this.interuptAutoDelivery = true;
		diamonDelivery.interrupt();
	}

	void deliverKindInstrumetn(KindsInstruments kind) {
		synchronized (shop) {
			specialDelivery = new Thread(() -> {
				LinkedList<MusicInstrument> instr = new LinkedList<>();
				instr.add(new MusicInstrument(kind, 850));
				try {
					Thread.sleep(kind.getTimeToArrive());
				} catch (InterruptedException e) {
					System.out.println("Provder interuppted to bring new "+ kind);
				}
				shop.addInstrumentsByProvider(instr);
			});
			specialDelivery.start();
		}
	}
}
