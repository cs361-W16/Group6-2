package models;

/**
 * Created by apple on 16/2/13.
 */
public class US extends Game{
    public void buildDeck2() {
        for(int i = 1; i < 14; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
            deck_count+=4;
        }
    }
}
