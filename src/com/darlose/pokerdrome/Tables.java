package com.darlose.pokerdrome;

import java.util.Map;
import java.util.HashMap;

public class Tables
{
    public Map<String, Integer> cntable;
    public Map<String, int[]> wintable;
    public Tables()
    {
        cntable = new HashMap<String, Integer>();
        cntable.put("c2",R.drawable.c2);
        cntable.put("c3",R.drawable.c3);
        cntable.put("c4",R.drawable.c4);
        cntable.put("c5",R.drawable.c5);
        cntable.put("c6",R.drawable.c6);
        cntable.put("c7",R.drawable.c7);
        cntable.put("c8",R.drawable.c8);
        cntable.put("c9",R.drawable.c9);
        cntable.put("ct",R.drawable.ct);
        cntable.put("cj",R.drawable.cj);
        cntable.put("cq",R.drawable.cq);
        cntable.put("ck",R.drawable.ck);
        cntable.put("ca",R.drawable.ca);
        cntable.put("d2",R.drawable.d2);
        cntable.put("d3",R.drawable.d3);
        cntable.put("d4",R.drawable.d4);
        cntable.put("d5",R.drawable.d5);
        cntable.put("d6",R.drawable.d6);
        cntable.put("d7",R.drawable.d7);
        cntable.put("d8",R.drawable.d8);
        cntable.put("d9",R.drawable.d9);
        cntable.put("dt",R.drawable.dt);
        cntable.put("dj",R.drawable.dj);
        cntable.put("dq",R.drawable.dq);
        cntable.put("dk",R.drawable.dk);
        cntable.put("da",R.drawable.da);
        cntable.put("h2",R.drawable.h2);
        cntable.put("h3",R.drawable.h3);
        cntable.put("h4",R.drawable.h4);
        cntable.put("h5",R.drawable.h5);
        cntable.put("h6",R.drawable.h6);
        cntable.put("h7",R.drawable.h7);
        cntable.put("h8",R.drawable.h8);
        cntable.put("h9",R.drawable.h9);
        cntable.put("ht",R.drawable.ht);
        cntable.put("hj",R.drawable.hj);
        cntable.put("hq",R.drawable.hq);
        cntable.put("hk",R.drawable.hk);
        cntable.put("ha",R.drawable.ha);
        cntable.put("s2",R.drawable.s2);
        cntable.put("s3",R.drawable.s3);
        cntable.put("s4",R.drawable.s4);
        cntable.put("s5",R.drawable.s5);
        cntable.put("s6",R.drawable.s6);
        cntable.put("s7",R.drawable.s7);
        cntable.put("s8",R.drawable.s8);
        cntable.put("s9",R.drawable.s9);
        cntable.put("st",R.drawable.st);
        cntable.put("sj",R.drawable.sj);
        cntable.put("sq",R.drawable.sq);
        cntable.put("sk",R.drawable.sk);
        cntable.put("sa",R.drawable.sa);
        
        wintable = new HashMap<String, int[]>();
        wintable.put("NoValue",new int[]{0,0,0,0,0});
        wintable.put("JacksorBetter",new int[]{1,2,3,4,5});
        wintable.put("TwoPair",new int[]{2,4,6,8,10});
        wintable.put("ThreeofaKind",new int[]{3,6,9,12,15});
        wintable.put("Straight",new int[]{4,8,12,16,20});
        wintable.put("Flush",new int[]{6,12,18,24,30});
        wintable.put("FullHouse",new int[]{9,18,27,36,45});
        wintable.put("FourofaKind",new int[]{25,50,75,100,125});
        wintable.put("StraightFlush",new int[]{50,100,150,200,250});
        wintable.put("RoyalFlush",new int[]{250,500,750,1000,4000});
    }
}
