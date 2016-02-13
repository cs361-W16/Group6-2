package models;


/**
 * Created by apple on 16/2/13.
 */
public class SP extends Game {

    public void buildDeck1() {
        for (int i = 1; i < 10; i++) {
            deck.add(new Card(i, Suit.Cups));
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Coins));
            deck.add(new Card(i, Suit.Swords));
            deck_count+=4;

        }
    }
}
