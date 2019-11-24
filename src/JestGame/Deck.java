package JestGame;

import java.util.Iterator;
import java.util.LinkedList;

import static JestGame.GameOptions.nbPlayer;

/**
 * This class is where the Deck for one game is created.
 * It contains all the method needed to interact with the deck.
 *
 * @author Edgar
 * @version 1.0
 */

public class Deck {
	
	private LinkedList<Card> cards;
	
	public Deck() {
		
		cards = new LinkedList<Card>();
		
		getCards().add(new Card(Kind.Joker,Suit.None,Trophy.None));
		getCards().add(new Card(Kind.Ace,Suit.Hearts,Trophy.Joker));
		getCards().add(new Card(Kind.Four,Suit.Spades,Trophy.Lowest));
		getCards().add(new Card(Kind.Four,Suit.Clubs,Trophy.Lowest));
		getCards().add(new Card(Kind.Two,Suit.Hearts,Trophy.Joker));
		getCards().add(new Card(Kind.Four,Suit.Diamonds,Trophy.BJnoJoke));
		getCards().add(new Card(Kind.Four,Suit.Hearts,Trophy.Joker));
		getCards().add(new Card(Kind.Three,Suit.Hearts,Trophy.Joker));
		getCards().add(new Card(Kind.Ace,Suit.Spades,Trophy.Highest));
		getCards().add(new Card(Kind.Ace,Suit.Clubs,Trophy.Highest));
		getCards().add(new Card(Kind.Ace,Suit.Diamonds,Trophy.Majority));
		getCards().add(new Card(Kind.Two,Suit.Spades,Trophy.Majority));
		getCards().add(new Card(Kind.Two,Suit.Clubs,Trophy.Lowest));
		getCards().add(new Card(Kind.Two,Suit.Diamonds,Trophy.Highest));
		getCards().add(new Card(Kind.Three,Suit.Spades,Trophy.Majority));
		getCards().add(new Card(Kind.Three,Suit.Clubs,Trophy.Lowest));
		getCards().add(new Card(Kind.Three, Suit.Diamonds, Trophy.Lowest));
	}

	public LinkedList<Card> getCards() {
		return this.cards;
	}
	
	public void shuffle() {
		for (int i = 0; i < getCards().size(); i++) {
			int position = (int) Math.round((getCards().size() - 1)* Math.random());
			Card cardShuffled = getCards().pop();
			getCards().add(position,cardShuffled);
		}
	}
	//Methode pour l'instant pas utile
	public Card topCard() {
		return getCards().pop();
	}

	public void deal(){
		System.out.println("\n Start dealing cards to the players");
		
		/*
		if (!getCards().isEmpty()){
			for (int i=0; i < 2*nbPlayer; i++) {
				//Instruction faussée car on devrait surcharger le constructeur par exemple...
				Iterator<Player> iterator = new RoundsManager().listPlayers.iterator();
				while (iterator.hasNext()) {
					Player p = (Player) iterator.next();
					p.receiveCard(this.topCard());
				}
			}
		}*/
		
	}


	
}
