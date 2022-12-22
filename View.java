package ch.fhgr.jenb.snake;





import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.Scanner;

import javax.swing.ImageIcon;

import org.w3c.dom.Text;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;




/* Funktion, um die Application abzuspielen*/
//public class View extends Application {
	
	//private SnakeGrid grid = new SnakeGrid();
	//boolean ok = true;
	//private SnakeCell zelle = new SnakeCell();
	

	//@Override
	/*void sagt es hat keinen return-Wert*/
	//public void start(Stage primaryStage) {
		//try {
		
			//int width = 600;
			//int length = 400;
			//Canvas a = new Canvas(width,length);
			//GraphicsContext gc = a.getGraphicsContext2D();
			
			
			
			//gc.fillRect(0, 0, width, length);
			
			//primaryStage.setTitle("Snake");
			//BorderPane root = new BorderPane();
			
			//Scene scene = new Scene(root,width,length);
		
			
			
			

			//scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
			
				//if (key.getCode() == KeyCode.W) { //KeyEvent
					//ok = grid.snakeUp();
					//}
				//if (key.getCode() == KeyCode.A) {
					//ok = grid.snakeleft();
					//}
				//if (key.getCode() == KeyCode.A) {
					//ok = grid.snakedown();
					//}
				//if (key.getCode() == KeyCode.D) {
					//ok = grid.snakeright();
					//}
			//});
		
			//if (zelle.isSnakeonfield() == false) {
				//gc.setFill(Color.RED);
				//gc.setFont(new Font("",50));
				//gc.fillText("GAME OVER", width, length);
				
			//}

			//if (zelle.isSnakeonfield() == true) {
				//gc.setFill(Color.GREEN);
			//}
				
			
			//if(zelle.isFruitonfield() == true) {
				//gc.setFill(Color.RED);
			//}
				
		
		
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);
			//primaryStage.show();
			
			
			public class View extends Application {
	

			    //Membervariablen
				private SnakeGrid snakegrid = new SnakeGrid();
		
				
					
				private static final String style_raster = "-fx-background-color: grey; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 40; -fx-min-height:40; -fx-max-width:40; -fx-max-height: 40;";
			    private static final String style_snake = "-fx-background-color: green; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 40; -fx-min-height:40; -fx-max-width:40; -fx-max-height: 40;";
			    private static final String style_apple = "-fx-background-color: red; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 40; -fx-min-height:40; -fx-max-width:40; -fx-max-height: 40;";
				
				@Override public void start(Stage stage) throws Exception {
			    	
			         
				     //raster.buttons();
				     
			         int rows = 10;
			         int columns = 10;
			         
			        
			         stage.setTitle("Snake");
			         GridPane grid = new GridPane(); 
			         snakegrid.initGrid();
			         for (int row = 0; row < rows; row++) {
			        	    for (int col = 0; col < columns; col++) {
			        	        Region r1 = new Region();
			        	        if (snakegrid.isSnakeOnfield(row, col)) {
			        	        	r1.setStyle(style_snake);
			        	        	
			        	        } else if(snakegrid.isFruitOnfield(row, col)) {
			        	        	r1.setStyle(style_apple);
			        	        }
			        	        else r1.setStyle(style_raster);
			        	        grid.add(r1, col, row);
			        	        
			        	        
			        	    }
			        	  
	
			        	}
					      
			         
			         
			        		
			         
			         for(int i = 0; i < columns; i++) {
			         ColumnConstraints column = new ColumnConstraints(40);
			         grid.getColumnConstraints().add(column);
			         }
			         for(int i = 0; i < rows; i++) {
			         RowConstraints row = new RowConstraints(40);
			         grid.getRowConstraints().add(row);
			         }
			         
			         
			         FlowPane root = new FlowPane();  
			         root.setVgap(6);  
			         root.setHgap(5);  
			         root.setPrefWrapLength(250);  
			         root.getChildren().add(new Button("Reset"));
			         root.getChildren().add(grid);  
			       
			        
			         //grid.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			   
			         
			         Scene scene = new Scene(root, (columns * 40) + 100, (rows * 40) + 100, Color.GRAY);
			        
			         stage.setScene(scene); 
			         stage.show();  }




	public static void main(String[] args) {
		launch(args);

	}
}
