package ch.fhgr.jenb.snake.mains;

import ch.fhgr.jenb.snake.SnakeGrid;

public class TestGrid {

	public static void main(String[] args) {
		SnakeGrid grid = new SnakeGrid();
		System.out.println(grid.toStringLetters());
		grid.initGrid();
		System.out.println(grid.toStringLetters());
	}
	
}
