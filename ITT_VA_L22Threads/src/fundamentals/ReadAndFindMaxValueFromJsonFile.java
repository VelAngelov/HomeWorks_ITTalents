package fundamentals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.gson.Gson;

public class ReadAndFindMaxValueFromJsonFile {
	public static final int NUMBER_THREADS = 20;
	public static final int NUMBER_FILES = 20;
	public static final String JSON_DIRECTORY = "src" + File.separator + "fundamentals" + File.separator + "jsons"
			+ File.separator;
	public static Random rnd = new Random();

	public static void creatingJsons(int numberOfFiles) throws IOException {
		Gson gson = new Gson();
		for (int j = 0; j < numberOfFiles; j++) {
			// generating length of arr:
			int[] arr = new int[100 + rnd.nextInt(500)];
			// generating numbers in arr:
			for (int i = 0; i < arr.length; i++) {
				arr[i] = rnd.nextInt(10000);
			}
			File file = new File(JSON_DIRECTORY + "numbers" + j + ".json");
			if (!file.exists()) {
				file.createNewFile();
			}
			String json = gson.toJson(arr);
			writeInFile(file, json);
		}
	}

	private static void writeInFile(File file, String json) throws IOException {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.write(json);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			throw new IOException();
		}
	}

	private static int findMaxFromArr(int[] arr) {
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[maxIndex] < arr[i]) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}

	private static int[] getArrFromFileWithNumber(int number) {
		Gson gson = new Gson();
		File file = new File(JSON_DIRECTORY + "numbers" + number + ".json");
		if (!file.exists()) {
			return null;
		}
		try (Scanner sc = new Scanner(file)) {
			StringBuilder sb = new StringBuilder();
			while (sc.hasNextLine()) {
				sb.append(sc.nextLine());
			}
			return gson.fromJson(sb.toString(), int[].class);
		} catch (FileNotFoundException e) {
			System.out.println("File with number " + number + " was not found!");
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			creatingJsons(NUMBER_FILES);
		} catch (IOException e) {
			System.out.println("Error on creating files!");
		}

		Queue<Runnable> filesWaitingForWork = new LinkedList<Runnable>();
		Queue<Future<?>> works = new LinkedList<>();
		CopyOnWriteArrayList<Integer> maksNumbers = new CopyOnWriteArrayList<>();

		for (int i = 0; i < NUMBER_FILES; i++) {
			int number = i;
			filesWaitingForWork.add(() -> {
				int max = findMaxFromArr(getArrFromFileWithNumber(number));
				maksNumbers.add(max);
			});
		}
		ExecutorService threads = Executors.newFixedThreadPool(NUMBER_THREADS);
		long start = System.currentTimeMillis();
		for (Runnable w : filesWaitingForWork) {
			Future<?> f = threads.submit(w);
			works.add(f);
		}
		while (true) {
			boolean isReady = true;
			for (Future<?> f : works) {
				isReady = isReady && f.isDone();
			}
			if (isReady) {
				threads.shutdown();
				break;
			}
		}

		System.out.println(maksNumbers.toString());
		String result = "Number of Files:" + NUMBER_FILES + ", Number of threads:" + NUMBER_THREADS
				+ ", time for calculcation:" + (System.currentTimeMillis() - start);
		System.out.println(result);
		File results = new File(JSON_DIRECTORY + "results.txt");
		if(!results.exists()) {
			try {
				results.createNewFile();
			} catch (IOException e) {
				System.out.println("Error on creating file");
			}
		}
		try(PrintWriter writer = new PrintWriter(new FileWriter(results,true))){
			writer.println(result);
		}catch(IOException e) {
			System.out.println("Error on writing file!");
		}
	}
}
