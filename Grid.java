package ch.fhgr.jenb.snake.modell;

public class Grid {
	private boolean isSnake = false;
	private boolean fruit = false;
	private boolean gameover = false;
	private boolean isSnakebody = false;
	public boolean isSnake() {
		return isSnake;
	}
	public boolean isFruit() {
		return fruit;
	}
	public void setFruit(boolean fruit) {
		this.fruit = fruit;
	}
	public boolean isGameover() {
		return gameover;
	}
	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}
	public void setSnake(boolean isSnake) {
		this.isSnake = isSnake;
	}
	
	public void eat() {
		this.fruit = true;
		if (isSnake) {
			this.setSnakebody(true);
		}
	}
	public boolean isSnakebody() {
		return isSnakebody;
	}
	public void setSnakebody(boolean isSnakebody) {
		this.isSnakebody = isSnakebody;
	}

}
