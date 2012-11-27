package com.darlose.pokerdrome;

public class Player
{
  private int credits;
  public Player()
  {
    credits = 10;
  }
  public void setCredits(int cr)
  {
    this.credits+=cr;
  }
  public int getCredits()
  {
    return this.credits;
  }
}
