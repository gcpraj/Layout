package com.example.prgc.layout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.prgc.layout.R;

public class MainPage extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RelativeLayout rLayout;
        Resources res = getResources();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        rLayout = (RelativeLayout) findViewById(R.id.rLayout);
        //rLayout.setBackgroundColor(Color.BLACK);

        // Get Listview object from xml
        listview = (ListView) findViewById(R.id.options_list);

        //Add a list as required
        String[] values = new String[]
                { "Create a goal",
                        "View a goal"};

        //Define a new adapter

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                values);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Listview Clicked item index
                int itemPosition = position;

                String itemValue = (String) listview.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Position:"+itemPosition+" ListItem:"+
                        itemValue, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), create_goal.class);
                startActivity(intent);



            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}