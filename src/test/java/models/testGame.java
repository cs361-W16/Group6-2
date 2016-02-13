package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testGameInit(){
        Game g = new Game();
        g.buildDeck();
       // g.shuffle();
        assertNotEquals(2,g.deck.get(0).getValue());
    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck_count);
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }
    @Test
    public void testGameStart1(){
        US s = new US();
        s.buildDeck();
        assertEquals(52,s.deck_count);
        s.shuffle();
        s.dealFour();
        assertEquals(1,s.cols.get(0).size());
        assertEquals(1,s.cols.get(1).size());
        assertEquals(1,s.cols.get(2).size());
        assertEquals(1,s.cols.get(3).size());
    }
    @Test
    public void testGameStart2(){
        SP s1 = new SP();
        s1.buildDeck();
        assertEquals(40,s1.deck_count);
        s1.shuffle();
        s1.dealFour();
        assertEquals(1,s1.cols.get(0).size());
        assertEquals(1,s1.cols.get(1).size());
        assertEquals(1,s1.cols.get(2).size());
        assertEquals(1,s1.cols.get(3).size());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs",g.cols.get(0).get(0).toString());
        assertEquals("3Clubs",g.cols.get(1).get(0).toString());
        assertEquals("4Clubs",g.cols.get(2).get(0).toString());
        assertEquals("5Clubs",g.cols.get(3).get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }


}
