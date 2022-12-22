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

public class View extends Application {

	// Membervariablen
	private SnakeGrid snakegrid = new SnakeGrid();

	private static final String style_raster = "-fx-background-color: grey; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 40; -fx-min-height:40; -fx-max-width:40; -fx-max-height: 40;";
	private static final String style_snake = "-fx-background-color: green; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 40; -fx-min-height:40; -fx-max-width:40; -fx-max-height: 40;";
	private static final String style_apple = "-fx-background-color: red; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 40; -fx-min-height:40; -fx-max-width:40; -fx-max-height: 40;";

	@Override
	public void start(Stage stage) throws Exception {

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

				} else if (snakegrid.isFruitOnfield(row, col)) {
					r1.setStyle(style_apple);
				} else
					r1.setStyle(style_raster);
				grid.add(r1, col, row);

			}

		}

		for (int i = 0; i < columns; i++) {
			ColumnConstraints column = new ColumnConstraints(40);
			grid.getColumnConstraints().add(column);
		}
		for (int i = 0; i < rows; i++) {
			RowConstraints row = new RowConstraints(40);
			grid.getRowConstraints().add(row);
		}

		FlowPane root = new FlowPane();
		root.setVgap(6);
		root.setHgap(5);
		root.setPrefWrapLength(250);
		Button b = new Button();
		root.getChildren().add(b);
		b.setOnAction(event -> {
			System.out.println("Button clicked");
            snakegrid.toReset();
      
 	       
        });
		
	   
		root.getChildren().add(grid);

		Scene scene = new Scene(root, (columns * 40) + 100, (rows * 40) + 100, Color.GRAY);

		stage.setScene(scene);

		stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			
	

						if (e.getCode() == KeyCode.UP) {
							snakegrid.snakeUp();
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
							System.out.println("up");
						}

						if (e.getCode() == KeyCode.LEFT) {
							snakegrid.snakeleft();
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
							System.out.println("left");
						}

						if (e.getCode() == KeyCode.DOWN) {
							snakegrid.snakedown();
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
							System.out.println("down");
						}

						if (e.getCode() == KeyCode.RIGHT) {
							snakegrid.snakeright();
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
