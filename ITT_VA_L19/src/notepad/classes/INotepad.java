package notepad.classes;

public interface INotepad {
	void replaceTextInPage(int pageNumber, String newText);

	void addTextInPage(int pageNumber, String text);

	void deleteTextInPage(int pageNumber);

	String printText();

	String printText(int pageNumber);

	int searchWord(int pageNumber, String word);

	int searchWord(String word);

	void printAllPages();

	void addNewPage(String title);

	Page deletePage(int pageNumber);

}
