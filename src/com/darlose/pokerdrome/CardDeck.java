package com.darlose.pokerdrome;

import java.util.Random;

public class CardDeck 
{
  public Card[] cards;
  private int count;
  CardDeck()
  {
    Random r = new Random();
    cards = new Card[52];
    count = 0;
    for(int i=0;i<4;i++)
    {
      for(int j=0;j<13;j++)
      {
        cards[count] = new Card(Card.Rank.values()[j], Card.Suit.values()[i]);
        ++count;
      }
    }
    //Fisher-Yates/Knuth shuffling algorithm
    for(int i=0;i<52;i++)
    {
      int j = r.nextInt(51);
      Card temp = cards[j];
      cards[j] = cards[i];
      cards[i] = temp;
    }
  }
  public Card[] deal(int dcards)
  {
    Card[] dealt = new Card[dcards];
    for(int i=0;i<dcards;i++)
    {
      dealt[i] = cards[this.count-1];
      --this.count;
    }
    return dealt;
  }
}
