package com.example.florian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

//        Defined Array values to show in ListView
        String[] values = new String[] {"Android List View", "Adapter implementation",
                "Simple List View in Android", "Create List View Android", "Android Example",
                "List View Source Code", "List View Array Adapter", "Android Example List View"};

//        Define a new Adapter
        /* First parameter - Context, Second parameter - Layout for the row,
        Third parameter - ID of the TextView to which the data is written
        Forth parameter - the Array of data
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

//        Assign adapter to ListView
        listView.setAdapter(adapter);

//        ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                ListView Clicked item index
                int itemPosition = i;
//                ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(i);

//                Show Alert
                Toast.makeText(getApplicationContext(), "Position: "+ itemPosition
                        +" ListItem: " +itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItem = item.getItemId();
        switch (menuItem){
            case R.id.settings:
                Toast.makeText(this, "settings", Toast.LENGTH_LONG).show();
                return true;
            case R.id.others:
                Toast.makeText(this, "others", Toast.LENGTH_LONG).show();
                return true;
            case R.id.search:
                Toast.makeText(this,"search", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
