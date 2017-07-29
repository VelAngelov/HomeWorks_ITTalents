package notepad.classes;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad {
	private String password;
	private static Scanner in = new Scanner(System.in);

	public SecuredNotepad(String password) {
		super();
		password = Validator.validateString(password);
		password = Validator.validateWeakPassword(password);
		this.password = password;
	}

	@Override
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}

	private String enterPassword(String password) {
		if (password == null || password.isEmpty() || !password.equals(this.password)) {
			System.out.println("Enter password:");
			password = in.nextLine();
			return enterPassword(password);
		}
		return password;
	}

	@Override
	public void replaceTextInPage(int pageNumber, String newText) {
		enterPassword(null);
		super.replaceTextInPage(pageNumber, newText);
	}

	@Override
	public void addTextInPage(int pageNumber, String text) {
		enterPassword(null);
		super.addTextInPage(pageNumber, text);
	}

	@Override
	public void addNewPage(String title) {
		enterPassword(null);
		super.addNewPage(title);
	}

	@Override
	public Page deletePage(int pageNumber) {
		enterPassword(null);
		return super.deletePage(pageNumber);
	}

	@Override
	public String printText() {
		enterPassword(null);
		return super.printText();
	}

	@Override
	public String printText(int pageNumber) {
		enterPassword(null);
		return super.printText(pageNumber);
	}

	@Override
	public int searchWord(int pageNumber, String word) {
		enterPassword(null);
		return super.searchWord(pageNumber, word);
	}

	@Override
	public int searchWord(String word) {
		enterPassword(null);
		return super.searchWord(word);
	}

	@Override
	public void printAllPages() {
		enterPassword(null);
		super.printAllPages();
	}

	@Override
	public void deleteTextInPage(int pageNumber) {
		enterPassword(null);
		super.deleteTextInPage(pageNumber);
	}
}
