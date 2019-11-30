package fr.utt.jestcardgame.model;

public class DefensiveStrategy implements ChooseStrategy {

	private int weakestCardValue;
	private int index;

	@Override
	public void makeOfferStrategy(Player player) {
		weakestCardValue = player.hand.get(0).cardValue();
		for (int i = 0; i < player.hand.size(); i++){
			if (player.hand.get(i).cardValue() < weakestCardValue){
				weakestCardValue = player.hand.get(i).cardValue();
				index = i;
			}
		}
		System.out.println(player.hand.get(index) + " card selected");
		player.hand.get(index).hidden = false;
	}

	@Override
	public void pickOfferStrategy(Player player){

	}
}
