package xml_streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import object_streams.Person;

public class ObjectToXMLExample {
	public static void main(String[] args) {
		Person ivan = new Person("Vanka", 23);
		ivan.addFriend(new Person("Toni"));
		ivan.addFriend(new Person("Tedi"));

		XStream stream = new XStream(new DomDriver());
		String xml = stream.toXML(ivan);
		writeInFile("vankata", xml);

		xml = stream.toXML(new Animal("Kotio", "Cat", 2));
		writeInFile("kote", xml);
		Animal cat = (Animal) readFromFileXml("kote.xml");
		System.out.println(cat.sayMiuau());
	}

	public static void writeInFile(String fileName, String xml) {
		File file = new File(fileName + ".xml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error on creating file");
				return;
			}
		}
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(xml);
			writer.flush();
		} catch (IOException e) {
			System.out.println("Problem with writing file");
		}
	}

	public static Object readFromFileXml(String fileName) {
		XStream stream = new XStream(new DomDriver());
		File file = new File(fileName);
		if (!file.exists()) {
			return null;
		}
		Object o = null;
		try (Scanner reader = new Scanner(file)) {
			StringBuilder xml = new StringBuilder();
			while(reader.hasNextLine()) {
				xml.append(reader.nextLine());
			}
			o = stream.fromXML(xml.toString());
		} catch (IOException e) {
			System.out.println("Error on reading file!");
		}
		return o;
	}

	public static void deleteFiles(String... files) {
		for (String name : files) {
			name = name + ".xml";
			File file = new File(name);
			if (file.exists()) {
				file.delete();
			}
		}
	}
}
