package person;

import person.classes.*;

public class DemoEmployee {
	public static void main(String[] args) {
		// creating works:
		AllWork engineringFlow = new AllWork();
		engineringFlow.addTask(new Task("design the roof of the house", 3));
		engineringFlow.addTask(new Task("creating production drawing for roof system", 12));
		engineringFlow.addTask(new Task("designing the main concept for carrying system", 1));
		engineringFlow.addTask(new Task("calculаting entire 3D model of the house", 3));
		engineringFlow.addTask(new Task("calculating model for concrete slabs ", 3));
		engineringFlow.addTask(new Task("creating drawings with formwork plans for the house", 12));
		engineringFlow.addTask(new Task("creating drawings with reinforcement for concrete slabs", 6));
		engineringFlow
				.addTask(new Task("calculating reinforcement for reinforced concrete columns,diaphragms and cores", 3));
		engineringFlow
				.addTask(new Task("creating drawings with reinforcement for concrete columns,diaphragms and cores", 8));
		engineringFlow
				.addTask(new Task("creating drawings with reinforcement for concrete columns,diaphragms and cores", 8));
		// creating all workers:
		Employee[] workers = new Employee[4];

		workers[0] = new Employee("Ivan");
		workers[1] = new Employee("Sasho");
		workers[2] = new Employee("Ivanina");
		workers[3] = new Employee("Sasha");

		workers[0].setAllwork(engineringFlow);
		workers[1].setAllwork(engineringFlow);
		workers[2].setAllwork(engineringFlow);
		workers[3].setAllwork(engineringFlow);

		int day = 1;
		while (true) {
			System.out.printf("=Day:%d=%n", day);
			for (Employee emp : workers) {
				emp.startWorkingDay();
				if (emp.getCurrentTask() == null || emp.getCurrentTask().getWorkingHours() == 0) {
					emp.setCurrentTask(engineringFlow.getNextTask());
				}
			}
			for (int hours = 9; hours < 18; hours++) {
				System.out.printf("=%02d:00=%n", hours);
				if (hours == 12) {
					System.out.println("~LUNCH BREAK~");
					continue;
				}
				for (Employee emp : workers) {
					emp.work();
				}
				if (engineringFlow.isAllWorkDone()) {
					break;
				}
			}
			if (engineringFlow.isAllWorkDone()) {
				break;
			}
			System.out.println("=18:00= END OF THE DAY");
			day++;
		}
		System.out.println("The work end!");
		System.out.printf("=The work ends in %d Days=%n", day);
	}
}
