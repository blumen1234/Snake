package ch.fhgr.jenb.snake;

import java.util.Random;
import java.util.Scanner;


/*Raster bei der die Snakecell angezeigt wird. Länge und Breite wird definiert und die fixe Tabelle mit den 
 * definiert */
 
/*Hoch, unten, rechts, links, Frucht, keine Frucht, Rand, kein Rand, Zelle mit Snake besetzt*/

public class SnakeGrid {
	

	

public static int MAX_LENGTH = 10;


/*SnakeGrid= Raster vom Spiel*/
	/*Initialisierung mit einer Variable und einem Wert*/
	private int headX = 5;
	private int headY = 5;
	private boolean gameover = false;
	private Snake schlange = new Snake();
	
	
	// Definiertes Raster
	private SnakeCell[][] snakecell = new SnakeCell[MAX_LENGTH][MAX_LENGTH];
	
	
	/*public,private und default sind Attribute einer Variable*/
	public SnakeGrid() {
	    // Anfangswerte setzen für alle 100 Felder   
	    for (int i = 0; i < snakecell.length; i++)
	    	for (int j = 0; j < snakecell.length; j++)
	    		snakecell[i][j] = new SnakeCell();
	}
	
	// Rasteransicht, was es alles drin hat
	public void initGrid() {
		placeApple();
		placeSnake();
	}
	


	/* Der Apfel wird gesetzt und es wird überprüft ob schon eine Schlange auf diesem Feld ist*/
	private void placeApple() {
		boolean placed = false;
		
		while (! placed) {
			int x = random();
			int y = random();
			

			SnakeCell cell = snakecell[x][y];
			
			if (!cell.isSnakeonfield()) {
				cell.setFruitonfield(true);
				placed = true;
			}
			
			
		}
		
		
		//random verwenden, j i / anzahl wie viele Fuits (als konstante definieren) / Testen, ob es belegt ist/ Starten, ob die Snake umzingelt ist von Früchten (inti Snkae und Fruits)
	}
	
	// Random Funktion und Definition wie viele Zahlen das Random beinhalten darf
	
	public int random() {
		Random random = new Random();
		int i = random.nextInt(MAX_LENGTH);
		return i;	
		
			
	}
	
	// Beim Start soll es die definierte Initialisierung nehmen und das Objekt Snake
	private void placeSnake() {
		schlange.init(snakecell[headX][headY]);
		

	}
	
// Wenn up, dann nimmt es die Koordinaten von headX und geht eins hoch
	public boolean snakeUp() {
	    headX = headX -1;
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
		
		// Ruft das File Snake auf und spielt die Funktion move ab. Wenn die Frucht die gleiche Zelle wie die Schlange hat, verschwindet die Frucht
		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			// neuer Apfel wird gesetzt
			placeApple();
		}
		
		return true;
		
		
	} 
	
	public boolean snakedown() {
	    headX = headX +1;
	    // oberster Rand erreicht = Game Over
	    if (headX == 10) return false;
	    
		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) return false;
		
		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			placeApple();
		}
		
		return true;
		
		
	} 
	
	public boolean snakeleft() {
	    headY = headY -1;
	    // oberster Rand erreicht = Game Over
	    if (headY == -1) return false;
	    
		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) return false;
		
		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			placeApple();
		}
		
		return true;
		
		
	} 
	
	public boolean snakeright() {
	    headY = headY +1;
	    // oberster Rand erreicht = Game Over
	    if (headY == 10) return false;
	    
		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) return false;
		
		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
			placeApple();
		}
		
		return true;
	} 
		
	public boolean isSnakeOnfield(int x, int y) {
		SnakeCell cell = snakecell[x][y];
		
		return cell.isSnakeonfield();
		
		
	}
	
	public boolean isFruitOnfield(int x, int y) {
		SnakeCell cell = snakecell[x][y];
		
		return cell.isFruitonfield();
		
		
	}
	// Raster wird gezeichnet mit einem String 

	  public String toString() {
		  StringBuffer sb = new StringBuffer();
		  for (int i = 0; i < snakecell.length; i++)
		    	for (int j = 0; j < snakecell.length; j++)
		    		sb.append(snakecell[i][j]+ "\n");
		  
		  return sb.toString();
		    
	  }
	  
	  public String toStringLetters() {
		  StringBuffer sb = new StringBuffer();
		  for (int i = 0; i < snakecell.length; i++) {
			  sb.append("\n|" );
			  for (int j = 0; j < snakecell.length; j++) 
		    		sb.append(snakecell[i][j].toStringLetters()+ "|"); 
			  
		  }
		    
		  
		  return sb.toString();
		    
	  }

	  public void toReset() {
		    // Reset the grid and place the snake at the starting position
		  
		  	gameover = false;
		  
		    // Reset other game state variables
		    headX = 5;
		    headY = 5;
		    schlange.getSchlange().clear();
		    
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

	
	  
	 
}
	  

