import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Blended {

	
	public static String fromFileToString(File file) {
		if(file == null) {
			throw new IllegalArgumentException("Null file pointer");
		}
		StringBuilder str = new StringBuilder ();
		try(InputStream fileOne = new FileInputStream(file)){
			byte[] buffer = new byte[1024 * 1024];
			int readByte = 0;
			for (; (readByte = fileOne.read(buffer)) > 0;) {
				str.append(buffer);
				str.append(System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str.toString();
		
	}
	
	public static String[] getWords(String text) {
		String[] words = text.split("[ .,\n!]");
		return words;
	}
	
	public static boolean isWordInText(String word, String[] text) {
	   for(String string : text) {
		   if(string.equals(word)) {
			   return true;
		   }
	   }
	   return false;
	}
	
	public static void saveTextToFile(String text, File file) {
		if (file == null || text == null) {
			throw new IllegalArgumentException("Null pointer");
		}
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (IOException e) {
			System.out.println(e);
		
}
	}
	
	public static void saveWords(File one, File two, File three) {
		String firstString = fromFileToString(one);
		String secondString = fromFileToString(two);
		String[] stringOne = getWords(firstString);
		String[] stringTwo = getWords(secondString);
		StringBuilder sb = new StringBuilder();
		for(String word : stringOne) {
			if(isWordInText(word, stringTwo)) {
				sb.append(word);
				sb.append(System.lineSeparator());
			}
		}
		saveTextToFile(sb.toString(), three);
	}
}
