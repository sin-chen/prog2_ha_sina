package fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

public class FileMain {

	
	// man erstellt eine Text Datei "name"
	
	public static void main(String[] args) {
		File file = new File("src\\fileIO\\name.txt");
		if (file.exists()) {
			System.out.println("Die Datei existiert");
		} else {
			System.out.println("Die Datei wird angelegt");
			
			//Wenn die Datei nicht existiert wird sie erstellt :) im File IO Ordner
			try {
//				file.mkdir();
				file.createNewFile();
				
			// Programm soll nicht crashen:
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Beweis, dass das Programm noch läuft:
			System.out.println("läuft noch");
		}
		//andere Variante, mit true/false lässt sich der File Writer aktivieren (muss nicht geschlossen werden)!
		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

//			zu schreibender text
			bufferedWriter.write("iloveyou");
			
//			zeilenumbruch
			bufferedWriter.newLine();
			
//			schreib es
			bufferedWriter.flush();

//				fileWriter.write("test boi :)\r\n");
//				flush für Mac just in case
//				fileWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String text = bufferedReader.readLine();
			System.out.println(text);
			
			bufferedReader.close();
			fileReader.close();
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
