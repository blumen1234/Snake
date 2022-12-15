package ch.fhgr.jenb.snake.mains;

import java.awt.event.KeyEvent;
import java.util.Scanner;

import ch.fhgr.jenb.snake.SnakeGrid;

public class TestGrid {
	
	public void testleft() {
		SnakeGrid grid = new SnakeGrid();
		grid.initGrid();
		System.out.println(grid.toStringLetters());

		System.out.println(grid.snakeUp());
		System.out.println(grid.snakeUp());
		System.out.println(grid.snakeleft());
		System.out.println(grid.snakeleft());
		

		System.out.println(grid.snakeleft());
		System.out.println(grid.toStringLetters());
		System.out.println(grid.snakeleft());
		System.out.println(grid.toStringLetters());
		System.out.println(grid.snakeleft());
		System.out.println(grid.toStringLetters());
		System.out.println(grid.snakeleft());
		System.out.println(grid.toStringLetters());
		System.out.println(grid.snakeleft());
		System.out.println(grid.toStringLetters());
		System.out.println(grid.snakeleft());
		
	}
	
	public void interaktiveTest() {
		SnakeGrid grid = new SnakeGrid();
		grid.initGrid();
		Scanner sc = new Scanner(System.in);
		
		boolean ok = true;
		
		while (ok) { 
			
			char c = sc.next().charAt(0);
			if (c=='i') { //KeyEvent
				ok = grid.snakeUp();
				}
			if (c=='j') {
				ok = grid.snakeleft();
				}
			if (c=='k') {
				ok = grid.snakedown();
				}
			if (c=='l') {
				ok = grid.snakeright();
				}
			System.out.println(grid.toStringLetters());
			}
		System.out.println("Game Over");
	}

	public static void main(String[] args) {
		TestGrid test = new TestGrid();
		test.interaktiveTest();
		
		

	}
	
}
