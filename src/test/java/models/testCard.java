package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/26/16.
 */
public class testCard {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals(Suit.Clubs,c.getSuit());
    }

    @Test
    public void testGetSuit1(){
        Card c = new Card(5,Suit.Coins);
        assertEquals(Suit.Coins,c.getSuit());
        Card c1 = new Card(4,Suit.Cups);
        assertEquals(Suit.Cups,c1.getSuit());
        Card c2 = new Card(3,Suit.Swords);
        assertEquals(Suit.Swords,c2.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals("5Clubs",c.toString());
    }

    @Test
    public void testMoveCard(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).size());
        assertEquals(0,g.cols.get(0).size());
    }

    @Test
    public void test1forUS() {
        US s = new US();
        s.buildDeck2();
        s.customDeal(0,3,6,9);
        s.remove(2);
        assertEquals(0,s.cols.get(2).size());
        s.move(0,2);
        assertEquals(1,s.cols.get(2).size());
        assertEquals(0,s.cols.get(0).size());

    }
    @Test
    public void test2forSP() {
        SP s1 = new SP();
        s1.buildDeck1();
        s1.customDeal(0,3,6,9);
        s1.move(0,2);
        assertEquals(1,s1.cols.get(2).size());
        assertEquals(0,s1.cols.get(0).size());
        s1.remove(2);
        assertEquals(0,s1.cols.get(2).size());

    }


}
