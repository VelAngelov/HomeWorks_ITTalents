package court.classes.lists;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ListWithoutRepetition<E> extends ArrayList<E> {
	private static final long serialVersionUID = 8683452581122892189L;
	//!in the class E we must override method equals!
	@Override
	public boolean add(E e) {
		// add item only if !contain's e in the list!
		if(this.contains(e)) {
			return false;
		}
		return super.add(e);
	}
	@Override
	public void add(int index, E element) {
		if(this.contains(element)) {
			return;
		}
		super.add(index, element);
	}
	//we must override unnecessary methods!
	/**
	 * unnecessary methods:
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		System.out.println("You cant use this feature!");
		return false;
	}
	@Override
	public boolean addAll(Collection<? extends E> c) {
		System.out.println("You cant use this feature!");
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		System.out.println("You cant use this feature!");
		return false;
	}
	//....
}
