package xml_streams;

import java.io.Serializable;

public class Animal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private int age;

	public Animal(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String sayMiuau() {
		return this.name + " says:Miauu!";
	}
}
