package com.darlose.pokerdrome;

import java.util.Map;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.view.View;
import android.view.View.OnClickListener;
import android.graphics.PorterDuff;

public class VideoPokerActivity extends Activity
{
    private Game g;
    private Player p;
    private int tempbet;
    private String[] cards;
    private TextView credtext, bettext;
    private Button betb;
    private Context context;
    private Boolean secondTurn, hasStarted;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        tempbet = 0;
        secondTurn = false;
        hasStarted = false;
        /* The Hash Table below saves used a LOT of computations, getIdentifier 
         * is expensive as FUCK */
        

        p = new Player();
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videopoker);

        context = getApplicationContext();
        CharSequence text = "Place your bet, touch the deck to start";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();

        credtext = (TextView) findViewById(R.id.creditstextview);
        credtext.setText("Credits: "+(CharSequence)(""+p.getCredits()));

        bettext = (TextView) findViewById(R.id.bettextview);

        //Deck
        ImageView deck = (ImageView) findViewById(R.id.cardback);
        deck.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            if(!secondTurn)
              startGame();
            else
              finalTurn();
            secondTurn=!secondTurn;
        }
        });

        //Table Cards
        for(int i=1;i<6;i++)
        {
          final int tvar = i-1;
          ImageView timv = (ImageView) findViewById(getResources().getIdentifier("card"+i, "id", getPackageName()));
          timv.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            if(secondTurn && hasStarted)
              holdCard((ImageView)v, tvar);
          }});
        }
        
        //Bet Button
        betb = (Button) findViewById(R.id.betbutton);
        betb.setOnClickListener(new OnClickListener() {
          public void onClick(View v)
          {
            if(tempbet+1<6 &tempbet<p.getCredits())
            {
              tempbet++;
              bettext.setText("Bet: "+(CharSequence)(""+tempbet));
            }
            else
              v.setEnabled(false);
          }});
    }

    private void startGame()
    {
      hasStarted=true;
      if(tempbet==0)
        tempbet=1;
      g = new Game(p, tempbet);
      betb.setEnabled(false);
      p.setCredits(-g.bet);
      credtext.setText("Credits: "+(CharSequence)(""+p.getCredits()));
      bettext.setText("Bet: "+(CharSequence)(""+g.bet));
      Context context = getApplicationContext();
      cards = g.getCards();
      Toast toast = Toast.makeText(context, g.getRank(), Toast.LENGTH_SHORT);

      for(int i=1;i<6;i++)
      {
        ImageView card = (ImageView) findViewById(getResources().getIdentifier("card"+i, "id", getPackageName()));
        card.setImageResource(g.t.cntable.get(cards[i-1]));

      }
      toast.show();
    }

    private void finalTurn()
    {
      g.dealCards();
      cards = g.getCards();
      g.showdown();
      g.score();

      credtext.setText("Credits: "+(CharSequence)(""+p.getCredits()));
      for(int i=1;i<6;i++)
      {
        ImageView card = (ImageView) findViewById(getResources().getIdentifier("card"+i, "id", getPackageName()));
        card.setImageResource(g.t.cntable.get(cards[i-1]));
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) card.getLayoutParams();
        lp.setMargins(0, 0, 8, 0);
        card.getDrawable().setColorFilter(null);
      }
      Toast toast = Toast.makeText(context, g.getRank(), Toast.LENGTH_SHORT);
      toast.show();
      g.bet=0;
      tempbet=0;
      bettext.setText("Bet: "+(CharSequence)(""+g.bet));
      betb.setEnabled(true);
      if(p.getCredits()<1)
      {
        Toast t = Toast.makeText(context, "GAME OVER!", Toast.LENGTH_SHORT);
        t.show();
        Intent intent = new Intent(VideoPokerActivity.this, MainActivity.class);
        startActivity(intent);      
      }
    }
    
    private void holdCard(ImageView v, int i)
    {
      RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) v.getLayoutParams();
      Card thiscard = g.getSingleCard(i);
      if(thiscard.isHeld()==false)
      {
        lp.setMargins(0, 8, 8, 0);
        v.getDrawable().setColorFilter(0xEC0CF588, PorterDuff.Mode.MULTIPLY );
        
      }
      else
      {
        lp.setMargins(0, 0, 8, 0);
        v.getDrawable().setColorFilter(null);
      }
      thiscard.Held();
      v.setLayoutParams(lp);
    }
}   
