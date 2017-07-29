package notepad.classes;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {
	private boolean isStarted;

	public ElectronicSecuredNotepad(String password) {
		super(password);
	}

	private boolean checkIsStarted() {
		if (!isStarted) {
			System.out.println("First start the notepad!");
			return false;
		}
		return true;
	}

	@Override
	public void start() {
		isStarted = true;
	}

	@Override
	public void stop() {
		isStarted = false;
	}

	@Override
	public boolean isStarted() {
		return isStarted;
	}

	@Override
	public void replaceTextInPage(int pageNumber, String newText) {
		if (checkIsStarted()) {
			super.replaceTextInPage(pageNumber, newText);
		}
	}

	@Override
	public void addTextInPage(int pageNumber, String text) {
		if (checkIsStarted()) {
			super.addTextInPage(pageNumber, text);
		}
	}

	@Override
	public Page deletePage(int pageNumber) {
		if (checkIsStarted()) {
			return super.deletePage(pageNumber);
		}
		return null;
	}

	@Override
	public void deleteTextInPage(int pageNumber) {
		if (checkIsStarted()) {
			super.deleteTextInPage(pageNumber);
		}
	}

	@Override
	public String printText() {
		if (checkIsStarted()) {
			return super.printText();
		}
		return null;
	}

	@Override
	public String printText(int pageNumber) {
		if (checkIsStarted()) {
			return super.printText(pageNumber);
		}
		return null;
	}

	@Override
	public int searchWord(int pageNumber, String word) {
		if (checkIsStarted()) {
			return super.searchWord(pageNumber, word);
		}
		return -1;
	}

	@Override
	public int searchWord(String word) {
		if (checkIsStarted()) {
			return super.searchWord(word);
		}
		return -1;
	}

	@Override
	public void printAllPages() {
		if (checkIsStarted()) {
			super.printAllPages();
		}
	}

	@Override
	public void addNewPage(String title) {
		if (checkIsStarted()) {
			super.addNewPage(title);
		}
	}

	@Override
	public boolean checkPassword(String password) {
		if (checkIsStarted()) {
			return super.checkPassword(password);
		}
		return false;
	}
}
