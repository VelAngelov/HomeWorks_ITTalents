package notepad;

import notepad.classes.ElectronicSecuredNotepad;
import notepad.classes.Page;
import notepad.classes.SecuredNotepad;
import notepad.classes.SimpleNotepad;

public class Demo {
	public static void main(String[] args) {
		SimpleNotepad np = new SimpleNotepad();
		np.addNewPage("supa");
		np.addTextInPage(1, "Neobhodimi produkti za supata:...");
		np.addNewPage("pecheno pile");
		np.addTextInPage(2, "Izmiite pileto dobre, sled koeto...");
		np.printAllPages();
		System.out.println();

		ElectronicSecuredNotepad esnp = new ElectronicSecuredNotepad("alabalaParola");
		esnp.addNewPage("What i can do with this notepad?");
		esnp.start();
		esnp.addNewPage("What can I do with this notepad?");
		StringBuilder sb = new StringBuilder();
		sb.append("Commands:\n");
		sb.append("\t.replaceTextInPage(int pageNumber, String newText)\n");
		sb.append("\t.addTextInPage(int pageNumber, String text)\n");
		sb.append("\t.deleteTextInPage(int pageNumber)\n");
		sb.append("\t.printText()\n");
		sb.append("\t.printText(int pageNumber)\n");
		sb.append("\t.searchWord(int pageNumber, String word)\n");
		sb.append("\t.searchWord(String word)\n");
		sb.append("\t.printAllPages()\n");
		sb.append("\t.addNewPage(String title)\n");
		sb.append("\t.deletePage(int pageNumber)\n");
		sb.append("\t.checkPassword(String password)\n");
		sb.append("\t.start()\n");
		sb.append("\t.stop()\n");
		sb.append("\t.isStarted()\n");
		esnp.addTextInPage(1, sb.toString());
		System.out.println(esnp.printText());
	}
}
