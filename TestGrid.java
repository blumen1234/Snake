package ch.fhgr.jenb.snake.mains;

import ch.fhgr.jenb.snake.SnakeGrid;

public class TestGrid {

	public static void main(String[] args) {
		SnakeGrid grid = new SnakeGrid();
		grid.initGrid();
		System.out.println(grid.toStringLetters());
		System.out.println(grid.snakeUp());
		System.out.println(grid.snakeUp());
		System.out.println(grid.snakeleft());
		System.out.println(grid.snakeleft());
		
	}
	
}
