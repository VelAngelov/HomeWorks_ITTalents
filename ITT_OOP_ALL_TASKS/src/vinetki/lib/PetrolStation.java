package vinetki.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PetrolStation {
	private double cash;
	private ArrayList<Vignette> vignettes;

	public PetrolStation() {
		vignettes = new ArrayList<Vignette>(10000);
		generateVignettes(10000);
		sortVignettesByPrice();
	}

	private void generateVignettes(int count) {
		for (int i = 0; i < count; i++) {
			this.vignettes.add(Vignette.rndVignette());
		}
	}

	private void sortVignettesByPrice() {
		Collections.sort(vignettes);
	}

	public void printVignettes() {
		for (Vignette vignette : vignettes) {
			System.out.println(vignette);
		}
	}

	Vignette buyVignetteByColor(String color, Driver d) {
		Vignette v = null;
		String period = Vignette.PERIODS[new Random().nextInt(Vignette.PERIODS.length)];
		for (int i = 0; i < vignettes.size(); i++) {
			if (vignettes.get(i).getColor().equals(color) && vignettes.get(i).getPeriod().equals(period)) {
				v = vignettes.remove(i);
				break;
			}
		}
		if (v == null) {
			return null;
		}
		double cash = d.payForVignette(v);
		if (cash > 0) {
			this.cash += cash;
			return v;
		} else {
			vignettes.add(v);
		}
		return null;
	}

	public double getCash() {
		return cash;
	}
}
