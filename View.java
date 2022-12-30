package ch.fhgr.jenb.snake;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

// Funktion, um die Application abzuspielen

public class View extends Application {

	// Membervariablen werden hier definiert
	
	//Die Klassen aus dem File SnakeGrid werden in View integriert
	private SnakeGrid snakegrid = new SnakeGrid();
	// Farben, Formen und Grössen werden hier für das Spielfeld definiert
	private static final String style_raster = "-fx-background-color: grey; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 60; -fx-min-height: 60; -fx-max-width:40; -fx-max-height: 40;";
	private static final String style_snake = "-fx-background-color: green; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 60; -fx-min-height:60; -fx-max-width:40; -fx-max-height: 40;";
	private static final String style_apple = "-fx-background-color: red; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 60; -fx-min-height:60; -fx-max-width:40; -fx-max-height: 40;";

	// hier wird die Funktion via Import Java aufgerufen
	GridPane grid = new GridPane();
	
	// Die maximale Länge und maximale Breite des Rasters wird hier als variable definiert
	int rows = snakegrid.MAX_LENGTH;
	int columns = snakegrid.MAX_LENGTH;
	
	// Funktion, um das Raster immer wieder zu zeichnen
	public void snakeinterface() {
		
		// die for-Schleife zeichnet immer wieder das Raster für das Spielfeld
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				Region r2 = new Region();
				if (snakegrid.isSnakeOnfield(row, col)) {
					r2.setStyle(style_snake);

				} else if (snakegrid.isFruitOnfield(row, col)) {
					r2.setStyle(style_apple);
				} else
					r2.setStyle(style_raster);
				grid.add(r2, col, row);

			}
		}
		
	}
	@Override
	public void start(Stage stage) throws Exception {
		
		// Titel der Desktopanzeige
		stage.setTitle("Snake");
		
		// ruft die Funktion im SnakeGrid auf
		snakegrid.initGrid();
		
		// ruft die Funktion auf
		snakeinterface();
		
		// In dem Desktop soll folgendes erscheinen, die Funktionen und die Grösse des Desktops
		Scene scene = new Scene(grid, 600, 600);
		// Anzeige des Desktops
		stage.setScene(scene);
	
		// zur Anzeige soll die Tastatur mitverwendet werden, keyEvent wird vom Import Java geholt
		stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			
			if (snakegrid.isGameover()){
				Alert meldung = new Alert(AlertType.INFORMATION);
				meldung.setHeaderText("GAMEOVER");
				meldung.setContentText("Du hast leider verloren");
				meldung.showAndWait().ifPresent(ok -> {
				    if (ok == ButtonType.OK) {
				    	snakegrid.toReset();
				        System.out.println("OK gedrückt");
				    }
				});
				
			}

			if (e.getCode() == KeyCode.UP) {
				if (snakegrid.snakeUp()) {
				snakeinterface();

				}
				
				 System.out.println("up");
					 

			}

			if (e.getCode() == KeyCode.LEFT) {

				if (snakegrid.snakeleft()) {
					// ruft die Funktion auf
					snakeinterface();
			} 
				System.out.println("left");
			}

			if (e.getCode() == KeyCode.DOWN) {
				if(snakegrid.snakedown()) {
					snakeinterface();
				}
				System.out.println("down");
			}

			if (e.getCode() == KeyCode.RIGHT) {
				if (snakegrid.snakeright()) {
					snakeinterface();
				}
				System.out.println("right");
			}

		}

		);
		stage.show();
		
	}


	public static void main(String[] args) {
		launch(args);

	}
}

