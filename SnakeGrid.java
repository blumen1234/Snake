package ch.fhgr.jenb.snake;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnakeGrid {
	

/*public static  MAX_LENGTH = 10;
/*public static MAX_WIDTH = 20;*/


	boolean isSnakelonger = false;
	boolean isSnake = false;

	
	List<SnakeCell> snakegrid = new ArrayList<SnakeCell>();
	
	
	
	
	public SnakeGrid() {
		
		
	   /* snakegrid = new SnakeGrid[10][10];   
	    // Anfangswerte setzen für alle 100 Felder   
	    for (int i = 0; i < 10; i++) { 
	      // senkrecht     
	      for (int j = 0; j < 10; j++){ 
	        //waagerecht
	        grids[j][i]=new Grid(); 
		
		snakegrid.add(new SnakeCell(2,1));
		snakegrid.add(new SnakeCell(3,1));
		System.out.println("f***");*/
	
		
	}
	
	
	public String toString () {
		StringBuffer sb = new StringBuffer();
		Iterator it = snakegrid.iterator();
		while (it.hasNext()) {
			SnakeCell sc = (SnakeCell)it.next();
			sb.append(sc.toString() + "\n");
		}
		
		return sb.toString();
	}
	

}

