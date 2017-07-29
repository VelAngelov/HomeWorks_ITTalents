package notepad.classes;

import java.util.ArrayList;

public class SimpleNotepad implements INotepad {
	ArrayList<Page> pages;

	public SimpleNotepad() {
		pages = new ArrayList<Page>();
	}

	protected boolean isValidPageNumber(int pageNumber) {
		return (pageNumber - 1 < pages.size()) && (pageNumber - 1 >= 0);
	}

	@Override
	public void replaceTextInPage(int pageNumber, String newText) {
		if (!isValidPageNumber(pageNumber)) {
			System.out.printf("p:%d not found\n", pageNumber);
			return;
		}
		newText = Validator.validateString(newText);
		pages.get(--pageNumber).removeText();
		pages.get(pageNumber).addText(newText);
	}
	/**
	 * delete text in existing page
	 */
	@Override
	public void deleteTextInPage(int pageNumber) {
		if (!isValidPageNumber(pageNumber)) {
			System.out.printf("p:%d not found\n", pageNumber);
			return;
		}
		pages.get(--pageNumber).removeText();
	}

	/**
	 * return String with all pages content
	 */
	@Override
	public String printText() {
		StringBuilder sb = new StringBuilder();
		for (Page p : pages) {
			sb.append(p);
		}
		return sb.toString();
	}

	/**
	 * return pageNumber if word is found
	 */
	@Override
	public int searchWord(String word) {
		for (int i = 0; i < pages.size(); i++) {
			int found = searchWord(i, word);
			if (found != -1) {
				return i + 1;
			}
		}
		return -1;
	}

	/**
	 * print in console all pages
	 */
	@Override
	public void printAllPages() {
		for (Page p : pages) {
			System.out.println(p);
		}
	}

	/**
	 * add text in existing page
	 */
	@Override
	public void addTextInPage(int pageNumber, String text) {
		if (!isValidPageNumber(pageNumber)) {
			System.out.printf("p:%d not found\n", pageNumber);
			return;
		}
		pages.get(--pageNumber).addText(text);
	}

	/**
	 * return String from text in page
	 */
	@Override
	public String printText(int pageNumber) {
		if (!isValidPageNumber(pageNumber)) {
			System.out.printf("p:%d not found\n", pageNumber);
			return null;
		}
		return pages.get(--pageNumber).printText();
	}

	/**
	 * return index of word in page
	 */
	@Override
	public int searchWord(int pageNumber, String word) {
		if (!isValidPageNumber(pageNumber)) {
			System.out.printf("p:%d not found\n", pageNumber);
			return -1;
		}
		return pages.get(--pageNumber).printText().indexOf(word);
	}
	/**
	 * create new page with title
	 */
	@Override
	public void addNewPage(String title) {
		pages.add(new Page(title));
	}
	/**
	 * remove page if exist:
	 */
	@Override
	public Page deletePage(int pageNumber) {
		if (!isValidPageNumber(pageNumber)) {
			System.out.printf("p:%d not found\n", pageNumber);
			return null;
		}
		return pages.remove(--pageNumber);
	}
	
}
