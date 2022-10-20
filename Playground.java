package ch.fhgr.jenb.snake.modell;

public class Playground {
	
	private Grid[][] grids; 
	
	public Playground() {
		
	    grids = new Grid[10][10];   
	    // Anfangswerte setzen für alle 100 Felder   
	    for (int i = 0; i < 10; i++) { 
	      // senkrecht     
	      for (int j = 0; j < 10; j++){ 
	        //waagerecht
	        grids[j][i]=new Grid(); 
	
		
			}
		}

	}

}
