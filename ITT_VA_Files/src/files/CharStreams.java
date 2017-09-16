package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreams {
	public static void main(String[] args) {
		File file  = new File("tekst.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("error on creating file occured!");
			}
		}
		//Writing in file:
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			String s = "Този текст не се чете лесно с байтов поток!";
			String s1 = "tozi teks po lesno se chete";
			writer.write(s);
			writer.write(s1);
			writer.close();
		}catch (IOException e) {
			System.out.println("There is a problem to write in file!");
		}
		//Reading form file:
		Scanner reader = null;
		try {
			reader = new Scanner(file,"UTF-8");
			while(reader.hasNext()) {
				System.out.print(reader.nextLine());
			}
		}catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}catch (IllegalArgumentException e){
			System.out.println("Incorrect encoding!");
		}finally {
			if(reader != null) {
				reader.close();
			}
		}
		//deleting file:
		if(file.exists()) {
			file.delete();
		}
	}
}
