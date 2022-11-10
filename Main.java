package ch.fhgr.jenb.snake;

	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/* Funktion, um die Application abzuspielen*/
public class View extends Application {
	@Override
	/*void sagt es hat keinen return-Wert*/
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/* Funktion, die es abspielen soll auf der Applikation von unserem Code*/
		testSnake();
	}
	

	public void testSnake() {
		SnakeGrid brd = new SnakeGrid();
		System.out.println(brd);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

