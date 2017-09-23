package fundamentals;

import java.util.LinkedList;
import java.util.Queue;

public class DemoCars {
	public static void main(String[] args) {
		Runnable tire = createProcess("tire", 2000, 4);
		Runnable seat = createProcess("seat", 3000, 5);
		Runnable engine = createProcess("engine", 7000, 1);
		Runnable frame = createProcess("frame", 5000, 1);

		Thread tires = new Thread(tire);
		Thread seats = new Thread(seat);
		Thread engines = new Thread(engine);
		Thread frames = new Thread(frame);

		Queue<Thread> assemblyLine = new LinkedList<>();
		assemblyLine.add(seats);
		assemblyLine.add(tires);
		assemblyLine.add(engines);
		assemblyLine.add(frames);

		Thread[] process = new Thread[3];
		while (!assemblyLine.isEmpty()) {
			for (int i = 0; i < 3; i++) {
				if (process[i] == null || !process[i].isAlive()) {
					process[i] = assemblyLine.poll();
					process[i].start();
				}
				if (assemblyLine.isEmpty()) {
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Main process interupted!");
			}
		}

		try {
			for (Thread thr : process) {
				thr.join();
			}
		} catch (InterruptedException e) {
			System.out.println("Main process interupted!");
		}

		System.out.println("Parts for one car is provided!");
	}

	public static Runnable createProcess(String processName, int timePerPart, int numberParts) {
		return () -> {
			for (int i = 0; i < numberParts; i++) {
				try {
					Thread.sleep(timePerPart);
					System.out.println("new " + processName + " provided");
				} catch (InterruptedException e) {
					System.out.println("intereputed process!");
				}
			}
		};
	}
}
