package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamsExample {
	public static void main(String[] args) {
		// creating new File
		File file = new File("Tekst.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Sorry, error occured");
			}
		}
		// writing some data:
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			String hello = "Hello, this is byte stream";
			for (int i = 0; i < hello.length(); i++) {
				out.write((int) (hello.charAt(i)));
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, file not found!");
		} catch (IOException e) {
			System.out.println("Sorry, error occured");
		}
		// reading some data:
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int oneSymbol = in.read();
			while (oneSymbol != -1) {
				System.out.print((char) oneSymbol);
				oneSymbol = in.read();
			}
		} catch (IOException e) {
			System.out.println("Sorry, error occured");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("error on exit from reading file!");
				}
			}
		}
		// deleting file.
		if (file.exists()) {
			file.delete();
		}
	}
}
