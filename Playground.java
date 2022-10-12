package ch.fhgr.jenb.snake.modell;

public class Playground {
	private Grid[][] grids = new Grid[10][10];
	
	public Playground() {
		
		
	}
public boolean eatGrid(int x, int y) {
	
	Grid grid = grids[x][y];
	grid.eat();
	return grid.isSnakebody();
}
}
