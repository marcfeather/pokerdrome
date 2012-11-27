package com.darlose.pokerdrome;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.res.Resources;
import android.content.Intent;
import android.content.DialogInterface;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Resources res = getResources();
        String[] options  = res.getStringArray(R.array.menuitems_array);
        ListView menulist = (ListView) findViewById(R.id.menulist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
          android.R.layout.simple_list_item_1, android.R.id.text1, options);
        menulist.setAdapter(adapter);

        menulist.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
          int position, long id) {
          if(position==0)
          {
            Intent intent = new Intent(MainActivity.this, VideoPokerActivity.class);
            startActivity(intent);
          }
          else if(position==1)
          {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(getString(R.string.info_text))
            .setPositiveButton("OK",new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog,int id) {
                dialog.cancel();}});
            AlertDialog dialog = builder.create();
            dialog.show();
          }
          }
        }); 
    }
}
