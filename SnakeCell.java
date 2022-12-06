package ch.fhgr.jenb.snake;

/* Die Snakecell hat nur Eigenschaften. Es kann eine Frucht, eine Schlange oder eine leere Zelle
 * haben. Die Zelle ist nur ersichtlich und hat keine weiteren Aktionen.
 */

public class SnakeCell {

	private boolean fruitonfield = false;
	private boolean isSnakeonfield = false;
	private boolean isSnakeheadonfield = false;
	private boolean snakeUp = false;
	private boolean snakeRight = false;
	private boolean snakeLeft = false;
	private boolean snakeDown = false;

	public SnakeCell() {
		

	}

	/*Werte von privaten Attributen abfragen*/
	public boolean isFruitonfield() {
		return fruitonfield;
	}

	/*Wert von privaten Attributen ändern und wird als Parameter weitergegeben*/
	public void setFruitonfield(boolean fruitonfield) {
		/*Verwechslung der Klassenattribute und gleiche Parameter zu vermeiden*/
		this.fruitonfield = fruitonfield;
	}


	public boolean isSnakeonfield() {
		return isSnakeonfield;
	}


	public void setSnakeonfield(boolean isSnakeonfield) {
		this.isSnakeonfield = isSnakeonfield;
	}


	public boolean isNothingOnfield() {
		return !fruitonfield && !isSnakeonfield;
	}

	
	public String toString () {
		return "snakecell: " + this.isSnakeonfield + " fruitcell: "+ this.fruitonfield;

    }
	
	public String toStringLetters() {
		if (isSnakeonfield) return "-";
		if (fruitonfield) return "o";
        return "x";
    }

	public boolean isSnakeheadonfield() {
		return isSnakeheadonfield;
	}

	public void setSnakeheadonfield(boolean isSnakeheadonfield) {
		this.isSnakeheadonfield = isSnakeheadonfield;
	}

	public boolean isSnakeUp() {
		return snakeUp;
	}

	public void setSnakeUp(boolean snakeUp) {
		this.snakeUp = snakeUp;
	}

	public boolean isSnakeRight() {
		return snakeRight;
	}

	public void setSnakeRight(boolean snakeRight) {
		this.snakeRight = snakeRight;
	}

	public boolean isSnakeLeft() {
		return snakeLeft;
	}

	public void setSnakeLeft(boolean snakeLeft) {
		this.snakeLeft = snakeLeft;
	}

	public boolean isSnakeDown() {
		return snakeDown;
	}

	public void setSnakeDown(boolean snakeDown) {
		this.snakeDown = snakeDown;
	}
	
}
