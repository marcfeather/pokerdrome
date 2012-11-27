package com.darlose.pokerdrome;

import java.util.Map;
import java.util.HashMap;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Game 
{
  public int bet;
  private CardDeck d;
  private String hanstr;
  private Card[] dealt;
  private HandRank.Rank rank;
  private Player player;
  public Tables t;

  public void dealCards()
  {
    int count = 0;
    List<Integer> l = new ArrayList<Integer>();
    for(int i=0;i<5;i++)
    {
      if(dealt[i].isHeld())
      {
        count++;
        l.add(i);
      }
    }
    if(count>0)
    {
      Card[] newcards = d.deal(count);
      for(int i=0;i<l.size();i++)
      {
        dealt[l.get(i)]=newcards[i];
      }
    }
  }

  public Card getSingleCard(int i)
  {
    return dealt[i];
  }
  
  public String[] getCards()
  {
    String[] cards = new String[5];
    for(int i=0;i<5;i++)
    {
      StringBuffer buf = new StringBuffer(dealt[i].toString());
      cards[i] = buf.reverse().toString().toLowerCase();
    }
    return cards;
  }
  
  public String getRank()
  {
    return hanstr;
  }

  private int countPair(String str, String pat)
  {
    int c = 0;
    Pattern p = Pattern.compile(pat);
    Matcher m = p.matcher(str);
    while (m.find())
      ++c;
    return c;
  }

  private Boolean countJOB(String hand, String highc)
  {
    Boolean val = false;
    int mat = countPair(hand, highc+"(c|d|h|s)");
    if(mat==2)
      val=true;
    return val;
  }

  public Game(Player p, int b)
  {
    long mask;
    t = new Tables();
    player = p;
    bet = b;
    d = new CardDeck();
    dealt = d.deal(5);
    showdown();
  }

  public Game(Player p)
  {
    this(p,1);
  }

  public String getHandvalue()
  {
    return hanstr;
  }

  public void score()
  {
    player.setCredits(t.wintable.get(hanstr.replaceAll("\\s+",""))[bet-1]);
  }
  public void showdown()
  {
    Cards c = new Cards(dealt[0].toString() + dealt[1].toString()+
                        dealt[2].toString() + dealt[3].toString()+
                        dealt[4].toString());
    HandRank cr = new HandRank(c);
    rank = cr.getRank();
    String handn;
    switch(rank)
    {
      case PAIR:
        String[] win = {"J", "K", "Q", "A"};
        handn = c.toString(); 
        Boolean job =  countJOB(handn, "J")||countJOB(handn, "Q")||
          countJOB(handn, "K") || countJOB(handn, "A");
        if(job)
          hanstr = "Jacks or Better";
        else
          hanstr = "No Value";
        break;
      case TWOPAIR:
        hanstr = "Two Pair";
        break;
      case THREEOFAKIND:
        hanstr = "Three of a Kind";
        break;
      case STRAIGHT:
        hanstr = "Straight";
        break;
      case FLUSH:
        hanstr = "Flush";
        break;
      case FULLHOUSE:
        hanstr = "Full House";
        break;
      case FOUROFAKIND:
        hanstr = "Four of a Kind";
        break;
      case STRAIGHTFLUSH:
        handn = c.toString(); 
        if(handn=="AcKcQcJcTc"  || handn=="AdKdQdJdTd" ||
            handn=="AhKhQhJhTh" || handn=="AhKhQhJhTh")
          hanstr = "Royal Flush";
        else
          hanstr = "Straight Flush";
        break;
      default:
        hanstr = "No Value";
        break;
    }
  }
}

