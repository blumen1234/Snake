package ch.fhgr.jenb.snake;

import java.util.Random;

public class SnakeGrid {

	// Membervariablen
	// Länge des Rasters wird hier initialisiert mit einer Variable und Wert
	public int MAX_LENGTH = 10;
	// Variable mit Wert, welcher den Ort der Schlange auf dem Feld definiert
	private int headX = 5;
	private int headY = 5;

	// Anfangsstatus des Spiels ist kein Gameover
	private boolean gameover = false;

	// Instanzierung
	private Snake schlange = new Snake();

	// Instanzierung der max. Rasterelemente
	private SnakeCell[][] snakecell = new SnakeCell[MAX_LENGTH][MAX_LENGTH];

	/* public,private und default sind Attribute einer Variable */
	public SnakeGrid() {
		// Anfangswerte setzen für alle 100 Felder
		for (int i = 0; i < snakecell.length; i++)
			for (int j = 0; j < snakecell.length; j++)
				snakecell[i][j] = new SnakeCell();
	}

	// Random Funktion und Definition das nur bis Variable Max_lenght darf zählen
	public int random() {
		Random random = new Random();
		int i = random.nextInt(MAX_LENGTH);
		return i;

	}

	/*
	 * Der Apfel wird gesetzt, wenn keine Frucht gesetzt ist und es wird überprüft
	 * ob schon eine Schlange auf diesem Feld ist
	 */
	private void placeApple() {
		boolean placed = false;

		while (!placed) {
			int x = random();
			int y = random();

			// Instanzierung der SnakeCell / Abfrage wo was sein könnte
			SnakeCell cell = snakecell[x][y];

			if (!cell.isSnakeonfield()) {
				cell.setFruitonfield(true);
				placed = true;
			}

		}

	}

	// Beim Start soll es die definierte Initialisierung nehmen und das Objekt Snake
	private void placeSnake() {
		// hier wird die Definiton von der Schlange integriert und sie mit den
		// Anfangswerten bestückt
		schlange.init(snakecell[headX][headY]);

	}

	
	public boolean snakeUp() {
		// Wenn up, dann nimmt es die Koordinaten von headX und geht eins hoch
		headX = headX - 1;
		// oberster Rand erreicht = Game Over
		if (headX == -1) {
			gameover = true;
			return false;
		}

		// Schlange auf einer Zelle = Game Over
		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) {
			gameover = true;
			return false;
		}

		// Ruft das File Snake auf und spielt die Funktion move ab. Wenn die Frucht die
		// gleiche Zelle wie die Schlange hat, verschwindet die Frucht
		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			// neuer Apfel wird gesetzt
			placeApple();
		}

		return true;

	}

	
	public boolean snakedown() {
		// Wenn down, dann nimmt es die Koordinaten von headX und geht eins runter
		headX = headX + 1;
		// oberster Rand erreicht = Game Over
		if (headX == 10) {
			gameover = true;
			return false;
		}

		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) {
			gameover = true;
			return false;
		}

		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			placeApple();
		}

		return true;

	}


	public boolean snakeleft() {
		// Wenn left, dann nimmt es die Koordinaten von headY und geht eins links
		headY = headY - 1;
		// oberster Rand erreicht = Game Over
		if (headY == -1) {
			gameover = true;
			return false;
		}

		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) {
			gameover = true;
			return false;
		}

		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			placeApple();
		}

		return true;

	}


	public boolean snakeright() {
		// Wenn right, dann nimmt es die Koordinaten von headY und geht eins rechts
		headY = headY + 1;
		// oberster Rand erreicht = Game Over
		if (headY == 10) {
			gameover = true;
			return false;
		}

		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) {
			gameover = true;
			return false;
		}

		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			placeApple();
		}

		return true;
	}

	// Abfrage wo die Schlange sich befindet und eine Funktion mit Parameter
	// erstellt, welche wiederverwendet werden kann
	public boolean isSnakeOnfield(int x, int y) {
		SnakeCell cell = snakecell[x][y];

		return cell.isSnakeonfield();

	}

	// Abfrage wo die Frucht sich befindet und eine Funktion mit Parameter erstellt,
	// welche wiederverwendet werden kann
	public boolean isFruitOnfield(int x, int y) {
		SnakeCell cell = snakecell[x][y];

		return cell.isFruitonfield();

	}

	// die Logik von Frucht und Snake zusammenführen in eine Funktion
	public void initGrid() {
		placeApple();
		placeSnake();
	}

	// Die Funktion, um das Spiel auf Anfang zu wechseln
	public void toReset() {
		// Status is kein Gameover -- es ist nur ein reset
		gameover = false;
		// Anbfrage wo die Schlange ist und löschen
		schlange.getSchlange().clear();

		headX = 5;
		headY = 5;

		for (int i = 0; i < snakecell.length; i++)
			for (int j = 0; j < snakecell.length; j++)
				snakecell[i][j] = new SnakeCell();

		placeApple();
		placeSnake();

		System.out.println("Game reset");
	}

	public boolean isGameover() {
		return gameover;
	}

	// Raster für die Ausgabe in der Konsole wird hier gezeichnet - für die
	// Überprüfung der Logik
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < snakecell.length; i++)
			for (int j = 0; j < snakecell.length; j++)
				sb.append(snakecell[i][j] + "\n");

		return sb.toString();

	}

	// Raster für die Ausgabe in der Konsole wird hier gezeichnet - für die
	// Überprüfung der Logik
	public String toStringLetters() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < snakecell.length; i++) {
			sb.append("\n|");
			for (int j = 0; j < snakecell.length; j++)
				sb.append(snakecell[i][j].toStringLetters() + "|");

		}

		return sb.toString();

	}

}
	  

