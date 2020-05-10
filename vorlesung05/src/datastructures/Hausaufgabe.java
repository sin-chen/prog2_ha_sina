package datastructures;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hausaufgabe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ein Objekt von der Klasse Contact wird erstellt, und in die Text Datei geschrieben.
		try {
			File file = new File("test.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Contact test = new Contact("Test",123);
			oos.writeObject(test);
			
			oos.close();
			fos.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		// ein Objekt wird in die Text Datei eingelesen: Wenn dieses Objekt eine Instanz von der Klasse Contact ist, wird sie neu deklariert? und 
		// name und Nummer ausgegeben
		try {
			
			File file = new File("test.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			
			if( obj instanceof Contact) {
				Contact bla = (Contact) obj;
				System.out.println(bla.getName() + "" + bla.getPhoneNumber());
			}
			//TODO bitte schliesse alle Reader
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		//Aufgabe 2 :)
		
		try {
			File file = new File("file.txt");
			FileWriter out = new FileWriter(file);
			PrintWriter writer = new PrintWriter(out);
			
			writer.println("boop");
			writer.close();
			out.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//Scanner:)))))) eine Line wird mit dem Scanner gelesen, und dann in die File geschrieben
		
		try {
			File file = new File("file.txt");
			
			Scanner scanner = new Scanner(file);
			
			String line = scanner.nextLine();
			System.out.println(line);
			
			scanner.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
			
		}

}
