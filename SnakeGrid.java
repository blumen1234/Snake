package ch.fhgr.jenb.snake.main.logik;

import java.util.Random;

public class SnakeGrid {

	public int MAX_LENGTH = 10;
	private int headX = 4;
	private int headY = 4;

	private boolean gameover = false;
	private boolean ateApple = false;

	private Snake schlange = new Snake();

	private SnakeCell[][] snakecell = new SnakeCell[MAX_LENGTH][MAX_LENGTH];


	public SnakeGrid() {
		for (int i = 0; i < snakecell.length; i++)
			for (int j = 0; j < snakecell.length; j++)
				snakecell[i][j] = new SnakeCell();
	}


	public int random() {
		Random random = new Random();
		int i = random.nextInt(MAX_LENGTH);
		return i;

	}

	
	private void placeApple() {
		boolean placed = false;

		while (!placed) {
			int x = random();
			int y = random();

			SnakeCell cell = snakecell[x][y];

			if (!cell.isSnakeonfield()) {
				cell.setFruitonfield(true);
				placed = true;
			}

		}

	}


	private void placeSnake() {
		schlange.init(snakecell[headX][headY]);

	}

	
	public boolean snakeUp() {
		headX = headX - 1;
	
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

		snakeEat();

		return true;

	}

	
	public boolean snakeDown() {
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

		snakeEat();

		return true;

	}


	public boolean snakeLeft() {
	
		headY = headY - 1;
		// Rand erreicht -- Gameover
		if (headY == -1) {
			gameover = true;
			return false;
		}
		// Schlange trifft Schlange -- Gameover
		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) {
			gameover = true;
			return false;
		}
		snakeEat();

		return true;

	}


	public boolean snakeRight() {
		headY = headY + 1;
		if (headY == 10) {
			gameover = true;
			return false;
		}

		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) {
			gameover = true;
			return false;
		}

		snakeEat();

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

	public void initGrid() {
		placeApple();
		placeSnake();
	}


	public void toReset() {
		gameover = false;
		schlange.getSchlange().clear();

		headX = 4;
		headY = 4;

		for (int i = 0; i < snakecell.length; i++)
			for (int j = 0; j < snakecell.length; j++)
				snakecell[i][j] = new SnakeCell();

		initGrid();

		System.out.println("Game reset");
	}

	public boolean isGameover() {
		return gameover;
	}
	
	
	public void snakeEat() {
		SnakeCell cell = snakecell[headX][headY];
		// Schlange isst Frucht
		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			placeApple();
			ateApple = true;
		}
		
	}
	
	public boolean ateApple() {
		return ateApple;
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
