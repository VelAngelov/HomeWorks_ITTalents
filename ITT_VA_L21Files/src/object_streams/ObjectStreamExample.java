package object_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamExample {
	public static void main(String[] args) {
		Person pesho = new Person("Pesho", 20);
		pesho.addFriend(new Person("Ivan"));
		pesho.addFriend(new Person("Georgi"));
		pesho.addFriend(new Person("Tosho"));
		pesho.addFriend(new Person("Misho"));

		File peshoFile = new File("pesho.txt");
		createFile(peshoFile);

		// Writing in File
		ObjectOutputStream write = null;
		try {
			write = new ObjectOutputStream(new FileOutputStream(peshoFile));
			write.writeObject(pesho);
		} catch (FileNotFoundException e) {
			System.out.println("There is no file to write!");
		} catch (InvalidClassException ice) {
			System.out.println("Class is invalid!");
		} catch (NotSerializableException nse) {
			System.out.println("Object not serializable!");
		} catch (IOException e) {
			System.out.println("Error on writing file!");
		} catch (NullPointerException e) {
			System.out.println("Pesho not found!");
		} finally {
			if (write != null) {
				try {
					write.close();
				} catch (IOException e) {
					System.out.println("Error on closing file!");
				}
			}
		}

		// Reading file:
		Person peshoResurected = null;
		try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(peshoFile))) {
			peshoResurected = (Person) read.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("Definition of class Person is missing!");
		} catch (FileNotFoundException e) {
			System.out.println("File was not found!");
		} catch (IOException e) {
			System.out.println("Error on reading file!");
		}
		
		if(peshoResurected!=null) {
			System.out.println(peshoResurected.getName());
			System.out.println(peshoResurected.getAge());
			System.out.println(peshoResurected.getFriends());
		}

		// deleteFile(peshoFile);
	}

	public static void createFile(File fileToCreate) {
		if (fileToCreate.exists()) {
			return;
		}
		try {
			fileToCreate.createNewFile();
		} catch (IOException e) {
			System.out.println("error during creating file!");
		}
	}

	public static void deleteFile(File fileToDelete) {
		if (fileToDelete.exists()) {
			fileToDelete.delete();
		}
	}
}
