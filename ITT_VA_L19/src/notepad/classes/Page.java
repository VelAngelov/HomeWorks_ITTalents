package notepad.classes;

public class Page {
	private String title;
	private StringBuilder text;

	Page(String title) {
		title = Validator.validateString(title);
		this.title = title;
		this.text = new StringBuilder();
	}

	public boolean addText(String text) {
		if (text == null || text.isEmpty()) {
			return false;
		}
		this.text.append(text);
		return true;
	}

	public void removeText() {
		this.text = new StringBuilder();
	}

	public String printText() {
		return this.text.toString();
	}

	public int searchWord(String word) {
		word = (word.split(" "))[0];
		return text.toString().indexOf(word);
	}

	public boolean containsDigits() {
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) >= '0' && text.charAt(i) <= '9') {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("=========%s=========\n", this.title));
		sb.append(this.text);
		return sb.toString();
	}
}
