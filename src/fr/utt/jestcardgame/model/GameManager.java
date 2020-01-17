package fr.utt.jestcardgame.model;


import fr.utt.jestcardgame.observer.Observable;
import fr.utt.jestcardgame.observer.Observer;
import fr.utt.jestcardgame.view.ConsoleGameView;
import fr.utt.jestcardgame.view.ConsoleOutput;
import fr.utt.jestcardgame.view.ConsoleUserInput;
import fr.utt.jestcardgame.view.setupException;


public class GameManager extends Observable{

	private static GameManager gm= null;
	private String gameState;
	private Observer board;
	
	public static GameManager getInstance(){

		if(gm == null){
			gm = new GameManager();
		}
		
		return gm;
	}

	public GameManager(){

	}

	public void play(){
		updateGameState("started");
		System.out.println("Game started and notify");
		RoundsManager currentGame = RoundsManager.getInstance();
		currentGame.firstRound();
		currentGame.nextRounds();
		currentGame.giveTrophy();
		currentGame.finalScore();
	}

	public void executeUserChoice(int userChoice) throws setupException {
		switch (userChoice) {
			case 1:
				GameOptions.setup();
				break;
			case 2:
				this.rules();
				break;
			case 3:
				this.setChanged();
				this.notifyObservers();
				System.exit(0);
				break;
			case 4 :
				this.options();
				break;
			default:
				System.out.println("No input given");
				break;
			//Gestion d'exception à faire
		}
	}

	public void mainMenu() throws setupException {
		//Main menu
		System.out.println("Game launched");
		updateGameState("mainMenu");
		ConsoleGameView.display(ConsoleOutput.MainMenu);
		this.executeUserChoice(ConsoleUserInput.getInstance().nextInt());

		//this.executeUserChoice(TextView.nextString());

		//Start a game
		this.play();

	}

	public void rules() throws setupException {
		System.out.println("Rules, press 1 to get back to the menu");
		updateGameState("rules");
		int input = ConsoleUserInput.getInstance().nextInt();
		if(input == 1) {
			this.mainMenu();
		}
	}

	public void options() throws setupException {
	    updateGameState("options");
		GameOptions.setup();
	}

	public void updateGameState(String newState) {
		gameState = newState;
		setChanged();
		notifyObservers();
	}

	public String getGameState() {
		return gameState;
	}

	public Observer getBoard() {
		return board;
	}

	public void setBoard(Observer board) {
		this.board = board;
	}
}