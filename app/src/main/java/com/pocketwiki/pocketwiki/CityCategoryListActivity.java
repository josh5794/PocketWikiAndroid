package com.pocketwiki.pocketwiki;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class CityCategoryListActivity extends AppCompatActivity {

    public String TAG = getClass().getSimpleName();
    CityCategoryListAdapter listAdapter;
    ListView listView;
    View headerView;
    TextView tvHeaderTitle;
    Button btnFilter;
    ArrayList<CityCategoryListItemDTO> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_city_category_list);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.color_primary_dark));
        }

        //code for initializing itemList based on intent_key
        itemList = new ArrayList<>();
        itemList.add(new CityCategoryListItemDTO("itemName1",35));
        itemList.add(new CityCategoryListItemDTO("itemName2",65));
        itemList.add(new CityCategoryListItemDTO("itemName3",25));
        itemList.add(new CityCategoryListItemDTO("itemName4",95));

        btnFilter = (Button) findViewById(R.id.citycategorylistactivity_btn_filter);
        listView = (ListView) findViewById(R.id.citycategorylistactivity_lv);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        headerView = (View) inflater.inflate(R.layout.list_city_category_header,listView, false);
        tvHeaderTitle = (TextView) headerView.findViewById(R.id.listheader_tv);
        if(getIntent().getBooleanExtra(Constants.INTENT_KEY_CITY_DISPLAY,false)){
            tvHeaderTitle.setText(getResources().getString(R.string.list_header_select_city));
            Log.i(TAG,"here");
        }else {
            tvHeaderTitle.setText(getResources().getString(R.string.list_header_select_category));
        }
        listView.addHeaderView(headerView);
        listAdapter = new CityCategoryListAdapter(itemList,this);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position==0 for header view
                if(position!=0) {
                    if (getIntent().getBooleanExtra(Constants.INTENT_KEY_CITY_DISPLAY, false)) {
                        Intent intent = new Intent(CityCategoryListActivity.this, EntityDetailsActivity.class);
                        intent.putExtra(Constants.INTENT_KEY_CATEGORY_DISPLAY, true);
                        intent.putExtra(Constants.INTENT_KEY_CITY_NAME, itemList.get(position - 1).getItemName());
                        intent.putExtra(Constants.INTENT_KEY_CITY_DISPLAY, false);
                        startActivity(intent);
                    } else {

                    }
                }
            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CityCategoryListActivity.this,FilterActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
