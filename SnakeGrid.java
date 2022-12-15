package ch.fhgr.jenb.snake;

import java.util.Random;


/*Raster bei der die Snakecell angezeigt wird. Länge und Breite wird definiert und die fixe Tabelle mit den 
 * definiert */
 
/*Hoch, unten, rechts, links, Frucht, keine Frucht, Rand, kein Rand, Zelle mit Snake besetzt*/

public class SnakeGrid {
	


public static int MAX_LENGTH = 10;


/*SnakeGrid= Raster vom Spiel*/
	/*Initialisierung mit einer Variable und einem Wert*/
	private int headX = 5;
	private int headY = 5;
	private Snake schlange = new Snake();
	int placeAppleX = 3;
	int placeAppleY = 5;
	
	/* Arrays ist ein nicht primitiver Datentyp*/
	private SnakeCell[][] snakecell = new SnakeCell[MAX_LENGTH][MAX_LENGTH];
	
	
	/*public,private und default sind Attribute einer Variable*/
	public SnakeGrid() {
	    // Anfangswerte setzen für alle 100 Felder   
	    for (int i = 0; i < snakecell.length; i++)
	    	for (int j = 0; j < snakecell.length; j++)
	    		snakecell[i][j] = new SnakeCell();
	}
	
	public void initGrid() {
		placeSnake();
		placeApple();
	}
	
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
	
	public int random() {
		Random random = new Random();
		int i = random.nextInt(MAX_LENGTH);
		return i;	
		
			
	}
	
	private void placeSnake() {
		schlange.init(snakecell[headX][headY]);
		//random verwenden, j i merken wo snake ist , ob die Snake umzingelt ist von Früchten (inti Snkae und Fruits)

	}
	

	public boolean snakeUp() {
	    headX = headX -1;
	    // oberster Rand erreicht = Game Over
	    if (headX == -1) return false;
	    
		SnakeCell cell = snakecell[headX][headY];
		if (cell.isSnakeonfield()) return false;
		
		schlange.move(cell);
		if (cell.isFruitonfield()) {
			cell.setFruitonfield(false);
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
		
	
	// Koordinate des Schlangenkopfs muss man wissen, damit wir noch ein Feld hinzufügen können
	// Schlagenkopf mit koordinate x und y / erste Abfrage ob koordinate nicht gleich am rand ist  
	// move up, down, left, right erstellen mit boolean (if) 
	



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


	  
} 
