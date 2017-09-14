package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VoinaIMir {
	public static void main(String[] args) {
		//1.Sybirane na tomovete v edin fail:
		String directory = "VoinaIMir";
		File f1 = new File(directory+File.separator+"VoinaIMir_I.txt");
		File f2 = new File(directory+File.separator+"VoinaIMir_II.txt");
		File f = new File(directory+File.separator+"VoinaIMir.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			}catch (Exception e){
				System.out.println("Error on creating new File!");
				return;
			}
		}
		
		Scanner read = null;
		FileWriter write = null;
		
		try {
			read = new Scanner(f1);
			write = new FileWriter(f);
			while(read.hasNextLine()) {
				write.write(read.nextLine());
			}
			read.close();
			read = new Scanner(f2);
			while(read.hasNextLine()) {
				write.write(read.nextLine());
			}
		}catch (FileNotFoundException e) {
			System.out.println("File not found!");
			return;
		}catch (IOException e) {
			System.out.println("Error occured during write!");
			return;
		}finally {
			if(read!=null) {
				read.close();
			}
			if(write!=null) {
				try {
					write.close();
				} catch (IOException e) {
					System.out.println("Error on closing writer!");
					return;
				}
			}
		}
		
		//2.Sort words by count
		TreeMap<String,Integer> words = new TreeMap<>();
		String longetWord = "";
		read = null;
		try {
			read = new Scanner(f);
			while(read.hasNextLine()) {
				//2.0. Get one line from text
				String line = read.nextLine();
				//2.1.Separate line by words
				//There is no words in .txt file separated in new line with symbol "-"!
				line = line.replaceAll("-", " ");
				String[] lineWords = line.split("\\s");
				for(String word:lineWords) {
					//2.2.Clean word from punctuation marks and symbols,numbers
					word = word.replaceAll("[^а-яА-Я]", "");
					//2.3.change  word with lowerCase
					word = word.toLowerCase();
					if(word.isEmpty()) {
						continue;
					}
					if(words.containsKey(word)) {
						words.put(word, words.get(word) + 1);
					}else {
						words.put(word, 1);
					}
					//2.4.check for bigger words
					if(longetWord.length()<word.length()) {
						longetWord = word;
					}
				}
			}
		}catch (FileNotFoundException exc) {
			System.out.println("File not find!");
		}finally {
			if(read!=null) {
				read.close();
			}
		}
		
		//3.Results in directory Results:
		String directoryForResults = "ResultsVoinaIMir";
		File dirResults = new File(directoryForResults);
		if(!dirResults.exists()) {
			dirResults.mkdir();
		}
		//3.1.Write results in file ResultsSortedLexicographic.txt
		write = null;
		File resultsSortedLexicographic = new File(directoryForResults+File.separator+"ResultsSortedLexicographic.txt");
		if(!resultsSortedLexicographic.exists()) {
			try {
				resultsSortedLexicographic.createNewFile();
			}catch(IOException e) {
				System.out.println("Error on creating new File!");
				return;
			}
		}
		try {
			write = new FileWriter(resultsSortedLexicographic);
			for(Map.Entry<String, Integer> entry:words.entrySet()) {
				write.write(entry.getKey() + " count:"+ entry.getValue()+"\r\n");
			}
		}catch(IOException e){
			System.out.println("Error occured during write!");
			return;
		}finally {
			if(write!=null) {
				try {
					write.close();
				} catch (IOException e) {
					System.out.println("Error on closing file!");
					return;
				}
			}
		}
		//3.2.Write results in file ResultSortedByCount.txt
		write = null;
		File resultsSortedByCount = new File(directoryForResults+File.separator+"ResultSortedByCount.txt");
		if(!resultsSortedByCount.exists()) {
			try {
				resultsSortedByCount.createNewFile();
			}catch(IOException e) {
				System.out.println("Error on creating new File!");
				return;
			}
		}
		TreeMap<Integer,String> sortedByCount = new TreeMap<>();
		for(Map.Entry<String, Integer> entry:words.entrySet()) {
			if(sortedByCount.containsKey(entry.getValue())) {
				sortedByCount.put(entry.getValue(), sortedByCount.get(entry.getValue())+", "+entry.getKey());
			}else {
				sortedByCount.put(entry.getValue(), entry.getKey());
			}
		}
		
		try {
			write = new FileWriter(resultsSortedByCount);
			for(Map.Entry<Integer, String> entry:sortedByCount.entrySet()) {
				write.write(entry.getKey() + " words:"+ entry.getValue()+"\r\n");
			}
		}catch(IOException e){
			System.out.println("Error occured during write!");
			return;
		}finally {
			if(write!=null) {
				try {
					write.close();
				} catch (IOException e) {
					System.out.println("Error on closing file!");
					return;
				}
			}
		}
		//3.3.War or piece, longest word -> AnotherResults.txt
		write = null;
		File anotherResults = new File(directoryForResults+File.separator+"AnotherResults.txt");
		if(!anotherResults.exists()) {
			try {
				anotherResults.createNewFile();
			}catch(IOException e) {
				System.out.println("Error on creating new File!");
				return;
			}
		}
		try {
			write = new FileWriter(anotherResults);
			write.write("Longest word:"+longetWord+"\r\n");
			write.write("War word count:"+words.get("война")+"\r\n");
			write.write("Piece word count:"+words.get("мир")+"\r\n");
		}catch(IOException e){
			System.out.println("Error occured during write!");
			return;
		}finally {
			if(write!=null) {
				try {
					write.close();
				} catch (IOException e) {
					System.out.println("Error on closing file!");
					return;
				}
			}
		}
		
	}
}
