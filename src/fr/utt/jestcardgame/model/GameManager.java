package fr.utt.jestcardgame.model;


import fr.utt.jestcardgame.view.*;


public class GameManager extends AbstractGameManager{
	

    
	@Override
    public void play(){
    	RoundsManager currentGame = new RoundsManager();
    	currentGame.firstRound();
    	//currentGame.nextRound();
    	//currentGame.giveTrophy();
    	//currentGame.finalScore();
    	//currentGame.showRanking();
    }    

    public void executeUserChoice(int userChoice) throws setupException {
        switch (userChoice) {
            case 1:
                try {
                    GameOptions.setup();
                }
                catch (setupException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.exit(0);
                break;
            default:
                //Gestion d'exception à faire
                System.out.println("Une exception est levée");
        }
    }
    
    
    
    	public void mainMenu() throws setupException {
		//Main menu
		ConsoleGameView.display(ConsoleOutput.MainMenu);

	    ConsoleUserInput input = new ConsoleUserInput();
	    
        executeUserChoice(input.nextInt());
        
        //Start a game
        play();
        
	}

	

	
}