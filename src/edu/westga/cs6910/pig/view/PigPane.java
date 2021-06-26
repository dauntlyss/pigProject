package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;
import edu.westga.cs6910.pig.model.strategies.RandomStrategy;
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
	private MenuPane menuPane;
	
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
		
		this.addComputerPlayerInfoPane(theGame);
		
		this.addHumanPlayerInfoPane(theGame);
		
		this.addStatusPaneInfo(theGame);
		
		this.addMenuPane(theGame);
		
		this.setCenter(this.pnContent);
	}
	
	private void addStatusPaneInfo(Game theGame) {
		HBox centerBox = new HBox();
		centerBox.getStyleClass().add("pane-border");	
		this.pnGameInfo = new StatusPane(theGame);
		centerBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(centerBox);
	}
	
	private void addHumanPlayerInfoPane(Game theGame) {
		HBox leftBox = new HBox();
		leftBox.getStyleClass().add("pane-border");	
		this.pnHumanPlayer = new HumanPane(theGame);
		leftBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(leftBox);
	}
	
	private void addComputerPlayerInfoPane(Game theGame) {
		HBox rightBox = new HBox();
		rightBox.getStyleClass().add("pane-border");	
		this.pnComputerPlayer = new ComputerPane(theGame);
		rightBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(rightBox);
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}
	
	private void addMenuPane(Game theGame) {
		HBox menuBox = new HBox();	
		this.menuPane = new MenuPane(this, theGame);
		menuBox.getChildren().add(this.menuPane);
		menuBox.prefWidthProperty().bind(this.widthProperty());
		this.setTop(menuBox);
	}

	/**
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		private RadioButton randomlyDecide;
		
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
			
			this.randomlyDecide = new RadioButton("Random first player");	
			this.randomlyDecide.setOnAction(new RandomListener());
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());
			
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());

			ToggleGroup turnToggle = new ToggleGroup();
			this.randomlyDecide.setToggleGroup(turnToggle);
			this.radComputerPlayer.setToggleGroup(turnToggle);
			this.radHumanPlayer.setToggleGroup(turnToggle);

			HBox hBox = new HBox();
			hBox.setSpacing(20);
			hBox.getChildren().add(this.randomlyDecide);
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
		
		/** 
		 * Defines the listener for randomly determining first player button.
		 */	
		private class RandomListener implements EventHandler<ActionEvent> {
			/** 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the random button.
			 */
			@Override
			public void handle(ActionEvent event) {
				int number = (int) (Math.random() * 10);
				if (number < 5) {
					PigPane.this.pnChooseFirstPlayer.setDisable(true);
					PigPane.this.pnComputerPlayer.setDisable(true);
					PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
				} else {
					PigPane.this.pnComputerPlayer.setDisable(false);
					PigPane.this.pnChooseFirstPlayer.setDisable(true);
					PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
				}
				
			}
		}
	}
	
	private final class MenuPane extends GridPane {
		private MenuBar menuBar;
		private Menu gameMenu;
		private Menu strategyMenu;
		private Game theGame;
		private MenuItem exit;
		private RadioMenuItem cautiousStrategy;
		private RadioMenuItem greedyStrategy;
		private RadioMenuItem randomStrategy;
		private PigPane thePigPane;
		
		private MenuPane(PigPane thePigPane, Game theGame) {
			this.theGame = theGame;
			this.menuBar = new MenuBar();
			this.gameMenu = new Menu("_Game");
			this.strategyMenu = new Menu("_Strategy");
			this.thePigPane = thePigPane;
			
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
			this.cautiousStrategy.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					MenuPane.this.theGame.getComputerPlayer().setStrategy(new CautiousStrategy());
				}
			});
			this.greedyStrategy = new RadioMenuItem("Gr_eedy");
			this.greedyStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + E"));
			this.greedyStrategy.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					MenuPane.this.theGame.getComputerPlayer().setStrategy(new GreedyStrategy());
				}
			});			
			
			this.randomStrategy = new RadioMenuItem("_Random");
			this.randomStrategy.setAccelerator(KeyCombination.keyCombination("shortcut + R"));
			this.randomStrategy.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					MenuPane.this.theGame.getComputerPlayer().setStrategy(new RandomStrategy());
				}
			});

			ToggleGroup toggleGroup = new ToggleGroup();
			this.cautiousStrategy.setToggleGroup(toggleGroup);
			this.cautiousStrategy.setSelected(true);
			this.greedyStrategy.setToggleGroup(toggleGroup);
			this.randomStrategy.setToggleGroup(toggleGroup);
			
			this.strategyMenu.getItems().addAll(this.cautiousStrategy, this.greedyStrategy, this.randomStrategy);
			this.strategyMenu.setMnemonicParsing(true);
			this.menuBar.getMenus().addAll(this.gameMenu, this.strategyMenu);
			this.menuBar.prefWidthProperty().bind(this.thePigPane.widthProperty());
			this.add(this.menuBar, 0, 0);
			
		}	
		
	}
}
