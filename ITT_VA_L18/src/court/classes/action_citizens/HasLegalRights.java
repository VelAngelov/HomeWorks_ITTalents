package court.classes.action_citizens;

import court.classes.law_positions.Jurist;
import court.classes.law_positions.Loyer;
import court.classes.lists.JuristList;

public abstract class HasLegalRights {
	protected JuristList loyers;

	abstract boolean addLoyer(Loyer l);

	abstract void addLoyers(Loyer... loyers);

	abstract boolean hasJurist(Jurist j);
	abstract boolean hasLoyer();

	abstract Jurist[] getLoyersWithoutRemove();
}
