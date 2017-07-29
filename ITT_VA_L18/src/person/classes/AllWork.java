package person.classes;

public class AllWork {
	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;

	public AllWork() {
		int n = 10;
		this.tasks = new Task[n];
		this.freePlacesForTasks = n;
		this.currentUnassignedTask = 0;
	}

	public void addTask(Task task) {
		this.tasks[this.tasks.length - freePlacesForTasks--] = task;
	}

	public Task getNextTask() {
		if (currentUnassignedTask < tasks.length - freePlacesForTasks) {
			return this.tasks[currentUnassignedTask++];
		}
		return null;
	}

	public boolean isAllWorkDone() {
		for(Task task:tasks) {
			if(task.getWorkingHours()!=0) {
				return false;
			}
		}
		return true;
	}

}
