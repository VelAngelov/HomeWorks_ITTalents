package json_streams;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import xml_streams.Animal;

public class ObjectsToJson {
	public static void main(String[] args) {
		// write in file:
		Gson stream = new Gson();
		Animal cat = new Animal("Kotio", "cat", 2);
		String catJSON = stream.toJson(cat);
		System.out.println(catJSON);
		writeInFile(catJSON, "kote.json");

		// read from file:
		Animal newCat = stream.fromJson(readFromFile("kote.json"), Animal.class);
		System.out.println(newCat.sayMiuau());

		// read from external File
		// 1.Json parser
		JsonParser parser = new JsonParser();
		// 2.Obtain the root:
		JsonElement root = parser.parse(readFromFile("Movie.json"));
		JsonObject movie = root.getAsJsonObject();
		// 3.Get attributes:
		String title = movie.get("Title").getAsString();
		int year = movie.get("Year").getAsInt();
		JsonArray ratings = movie.get("Ratings").getAsJsonArray();
		// 4.Print results:
		System.out.println(title);
		System.out.println(year);
		for (int i = 0; i < ratings.size(); i++) {
			System.out.print(ratings.get(i).getAsJsonObject().get("Source").getAsString());
			System.out.println(" - "+ratings.get(i).getAsJsonObject().get("Value").getAsString());
		}
	}

	private static void writeInFile(String stringJSON, String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error on creating file!");
				return;
			}
		}
		try (PrintWriter writer = new PrintWriter(file)) {
			writer.write(stringJSON);
			writer.flush();
		} catch (IOException e) {
			System.out.println("Error on writing file!");
		}
	}

	private static String readFromFile(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("File not found");
			return null;
		}
		StringBuilder sb = new StringBuilder();
		try (Scanner reader = new Scanner(file)) {
			while (reader.hasNextLine()) {
				sb.append(reader.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error on reading file!");
		}
		return sb.toString();
	}
}
