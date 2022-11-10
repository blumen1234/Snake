package ch.fhgr.jenb.snake;





/*Raster bei der die Snakecell angezeigt wird. Länge und Breite wird definiert und die fixe Tabelle mit den 
 * definiert */
 
/*Hoch, unten, rechts, links, Frucht, keine Frucht, Rand, kein Rand, Zelle mit Snake besetzt*/

public class SnakeGrid {
	

public static int MAX_LENGTH = 10;


/*SnakeGrid= Raster vom Spiel*/
	/*Initialisierung mit einer Variable und einem Wert*/
	boolean isSnakelonger = false;
	boolean isSnake = false;
	/* Arrays ist ein nicht primitiver Datentyp*/
	SnakeCell[][] snakecell = new SnakeCell[10][10];	
	/*public,private und default sind Attribute einer Variable*/
	public SnakeGrid() {
	    // Anfangswerte setzen für alle 100 Felder   
	    for (int i = 0; i < snakecell.length; i++)
	    	for (int j = 0; j < snakecell.length; j++)
	    System.out.println(snakecell[i][j]);
	    
	}
	
	
	
	/*
	public boolean fruitSnake() {
		fruitonfield = true;
		if (isSnakeonfield) {
			eatFruit();
			snakePlus();
			return true;
		} else
			return false;

	}*/
	
	/*public boolean eatSnake() {
	isSnake = true;
	if (isSnakeonfield) {
		gameover();
		return true;
	} else
		return false;
}
*/

}

/* Fragen an Weissgerber: ist das Raster so richtig?*/

