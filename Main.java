package ch.fhgr.jenb.snake;

	
import java.awt.Button;
import java.awt.Insets;
import java.awt.Label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/* Funktion, um die Application abzuspielen*/
public class View extends Application {
	
	private BorderPane root;
	@Override
	/*void sagt es hat keinen return-Wert*/
	public void start(Stage primaryStage) {
		try {
			this.root = new BorderPane();
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			 // Top pane
		      this.buildTopLine();
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();	
		}
	}
		private void buildTopLine() {
		      HBox toppane = new HBox();

		      // Label
		      Label label = new Label("My first label");
		      TextField textfield = new TextField();
		      Button clickButton = new Button("Click");
		      toppane.setSpacing(30.0);
		      //toppane.setPadding(new Insets(20, 100, 50, 0));
		      toppane.getChildren().addAll();
		      toppane.getChildren().add(textfield);
		      toppane.getChildren().add(toppane);

		      root.setTop(toppane);
		}
		
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
