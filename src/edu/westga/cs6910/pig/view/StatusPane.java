package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Defines the pane that lets the user tell the computer player to
 * take its turn and that displays the die values the computer
 * player took on its turn.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class StatusPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblStatus;
	private Button instructions;
	
	/**
	 * Creates a new status pane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public StatusPane(Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game argument.");
		}
		
		this.theGame = theGame;
		
		this.theGame.addListener(this);
		
		this.buildPane();
	}

	private void buildPane() {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("box-padding");
		this.instructions = new Button("Instructions");
		this.instructions.setOnAction(new InstructionsListener());
		topBox.getChildren().add(this.instructions);
		this.add(topBox, 0, 0);
		
		HBox middleBox = new HBox();
		middleBox.getStyleClass().add("box-center");	
		middleBox.getStyleClass().add("box-padding");
		middleBox.getChildren().addAll(new Label("~~ Game Info ~~"));
		this.add(middleBox, 0, 1);
		
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("box-padding");
		this.lblStatus = new Label(this.theGame.toString());
		bottomBox.getChildren().add(this.lblStatus);
		this.add(bottomBox, 0, 2);
		
	}

	@Override
	public void invalidated(Observable observable) {
		this.lblStatus.setText(this.theGame.toString());
	}
	
	private class InstructionsListener implements EventHandler<ActionEvent> {
		/** 
		 * Allows a dialog box with the instructions to pop up for the player
		 * if needed.	
		 */
		@Override
		public void handle(ActionEvent event) {
			final String instructions = "Gameplay Rules:\n\n" 
					+ "Take turns rolling a single "
					+ "die as many times as you want. \nEach time you roll, add the result " 
					+ "to your running total. \nHowever, if you roll a 1, you lose all your " 
					+ "points for that round!";
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText(instructions);
			alert.setTitle("Instructions");
			alert.setHeaderText(null);
			alert.showAndWait();
			
		}
	}
}
