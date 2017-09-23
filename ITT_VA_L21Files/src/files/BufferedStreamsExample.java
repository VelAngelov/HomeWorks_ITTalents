package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferedStreamsExample {
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
		BufferedWriter bufWriter = null; 
		try {
			writer = new FileWriter(file);
			bufWriter = new BufferedWriter(writer);
			String s = "По този начин се изпраща голям брой данни наведнъж.";
			String s1 = "Ако трябва да се прати нещо, но буфера не се е напълнил трябва да се използва flush";
			bufWriter.write(s);
			bufWriter.write(s1);
			bufWriter.flush();
			bufWriter.close();
			writer.close();
		}catch (IOException e) {
			System.out.println("There is a problem to write in file!");
		}
		//Reading form file:
		Scanner reader = null;
		BufferedReader bufReader = null;
		FileReader fr = null;
		try {
			reader = new Scanner(file,"UTF-8");
			fr = new FileReader(file);
			bufReader = new BufferedReader(fr);
			System.out.println("With Scanner");
			while(reader.hasNext()) {
				System.out.print(reader.nextLine());
			}
			System.out.println("\nWith Buffered reader");
			String line = null;
			while((line=bufReader.readLine())!=null) {
				System.out.println(line);
			}
		}catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}catch (IllegalArgumentException e){
			System.out.println("Incorrect encoding!");
		}catch(IOException e){
			System.out.println("Error with buffered reader!");
		}finally {

			if(reader != null) {
				reader.close();
			}
			if(bufReader!=null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					System.out.println("Problem with closing bufferedReader!");
				}
			}
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("Problem with closing fileReader!");
				}
			}
		}
		//deleting file:
		while(file.exists()) {
			file.delete();
		}
	}
}
