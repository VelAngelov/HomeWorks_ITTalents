package fundamentals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CountCommasInWarAndPeaceWithThreads {
	public static final int N = 1;

	public static void main(String[] args) {
		
		//Read the file and transport to StringBuilder:
		File file = new File("..\\ITT_VA_Files\\VoinaIMir\\VoinaIMir.txt");
		StringBuilder tekst = new StringBuilder();
		
		try (Scanner getString = new Scanner(file,"UTF-8")) {
			while (getString.hasNextLine()) {
				tekst.append(getString.nextLine());
				tekst.append("\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not fount!");
		}
		//Threads to count
		Thread[] threads = new Thread[N];
		AtomicInteger count = new AtomicInteger();
		int length = tekst.length();
		int endingIndex = 0;
		int startingIndex ;
		for (int i = 0; i < N; i++) {
			startingIndex = endingIndex;
			endingIndex += length / N;
			if (i == N - 1) {
				endingIndex = length;
			}
			
			int begin = startingIndex;
			int finall = endingIndex;
			
			threads[i] = new Thread(() -> {
				count.addAndGet(countCommas(tekst.toString(), begin, finall));
			});
		}
		//Start counting:
		long start = System.currentTimeMillis();
		for(Thread t:threads) {
			t.start();
		}
		for(Thread t:threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("oops");
			}
		}
		//Results:
		System.out.println("Coomas count:"+count.toString()+ " time for count:"+(System.currentTimeMillis()-start));
	}
	
	public static int countCommas(String tekst,int start,int end) {
		int count = 0;
		for (int j = start; j < end; j++) {
			if(tekst.charAt(j)==',') {
				count++;
			}
		}
		return count;
	}
}
