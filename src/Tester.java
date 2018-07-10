import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Tester {

	public static void main(String[] args) {
		File dir1 = new File("C:\\Users\\Vladislav\\Desktop\\1\\one.docx");
		File dir2 = new File("C:\\Users\\Vladislav\\Desktop\\1\\two.docx");
		
        Blended.saveWords(dir1, dir2, new File("C:\\Users\\Vladislav\\Desktop\\1\\blended.docx"));
	}

}
