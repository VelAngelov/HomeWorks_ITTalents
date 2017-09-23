package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReadFilesAndSort {
	public static final Comparator<File> COMPARE_BY_LENGTH = (o1,o2)-> (int)(o1.length()-o2.length());
	public static void main(String[] args) {
		//root of the system
		File root = new File("sistemaFailove");
		//get files from root:
		List<File> files = null;
		try {
			files = getFilesFromDirectory(root, new LinkedList<>());
			Collections.sort(files,COMPARE_BY_LENGTH);
		}catch( FileNotFoundException e) {
			System.out.println("Directory not found!");
		}
		for(File f:files) {
			System.out.println(f.getName() + " size:" + f.length());
		}
	}

	public static List<File> getFilesFromDirectory(File directory, LinkedList<File> files)
			throws FileNotFoundException {
		if (!directory.isDirectory()) {
			return null;
		}
		for (File f : directory.listFiles()) {
			if (f.isDirectory()) {
				getFilesFromDirectory(f, files);
			} else {
				files.add(f);
			}
		}
		return files;
	}
}
