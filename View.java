package ch.fhgr.jenb.snake.main;

import ch.fhgr.jenb.snake.main.logik.SnakeGrid;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class Main extends Application {

	private GridPane grid = new GridPane();
	private Timeline timeline = new Timeline();
	private SnakeGrid snakegrid = new SnakeGrid();
	

	private static final String STYLE_RASTER = "-fx-background-color: grey; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 60; -fx-min-height: 60; -fx-max-width:40; -fx-max-height: 40;";
	private static final String STYLE_SNAKE = "-fx-background-color: green; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 60; -fx-min-height:60; -fx-max-width:40; -fx-max-height: 40;";
	private static final String STYLE_APPLE = "-fx-background-color: red; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 60; -fx-min-height:60; -fx-max-width:40; -fx-max-height: 40;";

			
	private KeyCode direction = KeyCode.DOWN;
	private int SPEED = 800;

	@Override
	public void start(Stage stage) throws Exception {

		Timeline();

		stage.setTitle("Snake");

		snakegrid.initGrid();
		snakeinterface();

		Scene scene = new Scene(grid, 600, 600);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {

			if (e.getCode() == KeyCode.UP) {

				direction = KeyCode.UP;
				moveSnake();
				System.out.println("up");
			}

			else if (e.getCode() == KeyCode.LEFT) {

				direction = KeyCode.LEFT;
				moveSnake();
				System.out.println("left");
			}

			else if (e.getCode() == KeyCode.DOWN) {
				direction = KeyCode.DOWN;
				moveSnake();
				System.out.println("down");
			}

			else if (e.getCode() == KeyCode.RIGHT) {
				direction = KeyCode.RIGHT;
				moveSnake();
				System.out.println("right");
			}

		}

		);
		stage.show();

	}

	public void snakeinterface() {
		for (int row = 0; row < snakegrid.MAX_LENGTH; row++) {
			for (int col = 0; col < snakegrid.MAX_LENGTH; col++) {
				Region r2 = new Region();
				if (snakegrid.isSnakeOnfield(row, col)) {
					r2.setStyle(STYLE_SNAKE);

				} else if (snakegrid.isFruitOnfield(row, col)) {
					r2.setStyle(STYLE_APPLE);
				} else
					r2.setStyle(STYLE_RASTER);
				grid.add(r2, col, row);

			}
		}

	}

	public void moveSnake() {

		switch (direction) {
		case UP:

			snakegrid.snakeUp();

			snakeinterface();

			break;
		case DOWN:

			snakegrid.snakeDown();

			snakeinterface();

			break;
		case LEFT:

			snakegrid.snakeLeft();

			snakeinterface();

			break;
		case RIGHT:

			snakegrid.snakeRight();
			snakeinterface();

			break;
		default:
			break;
		}

		if (snakegrid.isGameover()) {
			timeline.stop();
			ButtonType okButton = new ButtonType("OK");
			Alert alert = new Alert(AlertType.INFORMATION, "Game Over!", okButton);
			alert.show();
			alert.setOnCloseRequest(event -> {
				ButtonType result = alert.getResult();
				if (result == okButton) {
					snakegrid.toReset();
					restartTimeline();
					System.out.println("gameover");
				}
			});
		}

	}

	private void Timeline() {
		timeline.setCycleCount(Timeline.INDEFINITE);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(SPEED), event -> moveSnake());
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();

	}

	private void restartTimeline() {
		timeline.stop();
		timeline.getKeyFrames().clear();
		Timeline();
	}

	public static void main(String[] args) {
		launch(args);

	}
}
