package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Defines a GUI for the Pig game.
 * This class was started by CS6910
 * 
 * @author Alyssa Harris
 * @version 6-7-2021
 */
public class PigPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	private Pane menuPane;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param theGame	the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game argument.");
		} 
		
		this.theGame = theGame;
		
		this.pnContent = new BorderPane();
		
		this.addFirstPlayerChooserPane(theGame);
		
		this.addMenuPane();
		
		HBox leftBox = new HBox();
		leftBox.getStyleClass().add("pane-border");	
		this.pnHumanPlayer = new HumanPane(theGame);
		leftBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(leftBox);

		HBox centerBox = new HBox();
		centerBox.getStyleClass().add("pane-border");	
		this.pnGameInfo = new StatusPane(theGame);
		centerBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(centerBox);

		HBox rightBox = new HBox();
		rightBox.getStyleClass().add("pane-border");	
		this.pnComputerPlayer = new ComputerPane(theGame);
		rightBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(rightBox);
		
		this.setCenter(this.pnContent);
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}
	
	private void addMenuPane() {
		VBox menuBox = new VBox();
		menuBox.getStyleClass().add("pane-border");	
		this.menuPane = new MenuPane();
		menuBox.getChildren().add(this.menuPane);
		this.pnContent.setBottom(menuBox);
	}

	/**
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
		}
		
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());
			
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());

			ToggleGroup turnToggle = new ToggleGroup();
			this.radComputerPlayer.setToggleGroup(turnToggle);
			this.radHumanPlayer.setToggleGroup(turnToggle);

			HBox hBox = new HBox();
			hBox.setSpacing(20);
			hBox.getChildren().add(this.radHumanPlayer);
			hBox.getChildren().add(this.radComputerPlayer);
			this.getChildren().add(hBox);

		}
		
		/** 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				PigPane.this.pnComputerPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		/** 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/** 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.pnComputerPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);

			}
		}
	}
	
	private final class MenuPane extends GridPane {
		private MenuBar menuBar;
		private Menu gameMenu;
		private Menu strategyMenu;
		
		private MenuItem exit;
		private RadioMenuItem cautiousStrategy;
		private RadioMenuItem greedyStrategy;
		private RadioMenuItem randomStrategy;
		
		private MenuPane() {
			this.menuBar = new MenuBar();
			this.gameMenu = new Menu("_Game");
			this.strategyMenu = new Menu("_Strategy");
			
			this.buildMenuPane();	
		}
		
		private void buildMenuPane() {
			this.exit = new MenuItem("E_xit");
			this.exit.setAccelerator(KeyCombination.keyCombination("shortcut + X"));
			this.gameMenu.getItems().addAll(this.exit);
			this.gameMenu.setMnemonicParsing(true);
			this.exit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.exit(0);
				}
			});			
			
			this.cautiousStrategy = new RadioMenuItem("_Cautious");
			this.cautiousStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + C"));
			this.greedyStrategy = new RadioMenuItem("Gr_eedy");
			this.greedyStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + E"));
			this.randomStrategy = new RadioMenuItem("_Random");
			this.randomStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + R"));

			ToggleGroup toggleGroup = new ToggleGroup();
			this.cautiousStrategy.setToggleGroup(toggleGroup);
			this.cautiousStrategy.setSelected(true);
			this.greedyStrategy.setToggleGroup(toggleGroup);
			this.randomStrategy.setToggleGroup(toggleGroup);
			
			this.strategyMenu.getItems().addAll(this.cautiousStrategy, this.greedyStrategy, this.randomStrategy);
			this.strategyMenu.setMnemonicParsing(true);
			this.menuBar.getMenus().addAll(this.gameMenu, this.strategyMenu);
			
			VBox vBox = new VBox();
			vBox.setSpacing(240);
			vBox.getChildren().add(this.menuBar);
			this.getChildren().add(vBox);
			
		}	
		
	}
}
