package notepad.classes;

public interface ISecuredNotepad extends INotepad {
	boolean checkPassword(String password);
}
