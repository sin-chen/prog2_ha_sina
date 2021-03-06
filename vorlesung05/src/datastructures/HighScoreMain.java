package datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class HighScoreMain {

	public static void main(String[] args) {
		ArrayList<HighScore> highscore = new ArrayList<>();
		highscore.add(new HighScore("Pika", 42));
		highscore.add(new HighScore("Chuck", 10000));
		highscore.add(new HighScore("Vegeta", 9001));
		highscore.add(new HighScore("Der krasse Balzer", 42));
		highscore.add(new HighScore("Covid", 19));

		Collections.sort(highscore);

		for (HighScore score : highscore) {
			System.out.println(String.format("%20s:\t%d", score.getName(), score.getPoints()));
		}

	}

}
