package ch.fhgr.jenb.snake;

import java.util.ArrayList;

public class Snake {

	private ArrayList<SnakeCell> schlange = new ArrayList <SnakeCell>();

	public ArrayList<SnakeCell> getSchlange() {
		return schlange;
	}

	public void setSchlange(ArrayList<SnakeCell> schlange) {
		this.schlange = schlange;
	}
	// Schlange bewegt sich, wenn keine Frucht auf dem Feld ist
	public void move(SnakeCell newcell) {
		schlange.add(newcell);
		newcell.setSnakeonfield(true);
		
		if (!newcell.isFruitonfield()) {
			SnakeCell back = schlange.get(0);
			back.setSnakeonfield(false);
			schlange.remove(0);
		} 
		
		
	}
	
	public void init(SnakeCell newcell) {
		schlange.clear();
		newcell.setSnakeonfield(true);
		schlange.add(newcell);
		
	}
	public void gameOverSnake(SnakeCell newcell) {
		if (newcell.isSnakeonfield()) {
			System.out.println("Game Over");
			schlange.clear();
		}
		
	}
	
}
