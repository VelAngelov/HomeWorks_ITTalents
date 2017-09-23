package object_streams;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private transient List<Person> friends;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.friends = new LinkedList<>();
	}

	public Person(String name) {
		this.name = name;
		this.friends = new LinkedList<>();
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void addFriend(Person person) {
		this.friends.add(person);
	}

}
