package datastructures;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MittelwertMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Mittelwert> mittelwert = new ArrayList<>();
		double summe = 0;

		Scanner scan = new Scanner(System.in);

		while (!scan.hasNext("quit")) {

			mittelwert.add(new Mittelwert(scan.nextDouble()));

		}

		for (Mittelwert a : mittelwert) {
			summe += a.getA();

		}
		System.out.println(summe / mittelwert.size());
		scan.close();

	}
}
