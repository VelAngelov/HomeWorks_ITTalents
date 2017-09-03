package vinetki.classes;

import java.util.ArrayList;
import java.util.Collections;

public class Station {
	double cash;
	double dayCash;
	ArrayList<Vinetka> vinetki;

	public Station(String date, int broiVinetki) {
		vinetki = new ArrayList<Vinetka>();
		generiraiVinetki(date, broiVinetki);
		Collections.sort(vinetki, Vinetka.generiraiVinetka(date));
	}

	private void generiraiVinetki(String date, int count) {
		Vinetka v;
		for (int i = 0; i < count; i++) {
			v = Vinetka.generiraiVinetka(date);
			vinetki.add(v);
		}
	}

	public Vinetka sellVinetka(String typeVehicle, String validnost) {
		int typeN = 0;
		String[] types = Vinetka.types;
		String[] colors = Vinetka.colors;
		for (int i = 0; i < types.length; i++) {
			if (typeVehicle.equals(types[i])) {
				typeN = i;
				break;
			}
		}
		String color = colors[typeN];
		Vinetka v = new Vinetka(validnost, color);
		int index = vinetki.indexOf(v);
		return this.vinetki.remove(index);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vinetki.size(); i++) {
			sb.append(vinetki.get(i) + "\n");
		}
		return sb.toString();
	}
}
