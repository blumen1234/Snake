package ch.fhgr.jenb.snake.modell;

public class Grid {

	boolean fruitonfield = false;
	boolean isSnakeonfield = false;
	boolean isSnakelonger = false;
	boolean isSnake = false;

	public boolean fruitSnake() {
		fruitonfield = true;
		if (isSnakeonfield) {
			eatFruit();
			snakePlus();
			return true;
		} else
			return false;

	}

	public boolean eatSnake() {
		isSnake = true;
		if (isSnakeonfield) {
			gameover();
			return true;
		} else
			return false;
	}

	public void eatFruit() {
		fruitonfield = false;

	}

	public void snakePlus() {
		// Grid wird hinzugefügt
	}

	public void gameover() {
		System.out.println("Gameover");
	}

	public boolean isSnake() {
		return isSnakeonfield;
	}

}

