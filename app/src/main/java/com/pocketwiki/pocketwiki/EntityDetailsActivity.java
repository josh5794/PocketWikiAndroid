package com.pocketwiki.pocketwiki;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class EntityDetailsActivity extends AppCompatActivity {

    ImageView ivEntityImage;
    CustomListView lvEntityList;
    LinearLayout btnDownload;
    EntityListAdapter entityListAdapter;
    View headerView;
    TextView tvHeaderTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_entity_details);

        View v = getSupportActionBar().getCustomView();
        TextView textView = (TextView) findViewById(R.id.action_bar_title);
        textView.setText("Entity Name");

        ivEntityImage = (ImageView) findViewById(R.id.entitydetailsactivity_iv);
        lvEntityList = (CustomListView) findViewById(R.id.entitydetailsactivity_lv);
        btnDownload = (LinearLayout) findViewById(R.id.entitydetailsactivity_llt_download);

        List<String> entityList = new ArrayList<>();
        entityList.add("itmename1");
        entityList.add("itmename2");
        entityList.add("itmename3");
        entityList.add("itmename4");
        entityList.add("itmename5");
        entityListAdapter = new EntityListAdapter(entityList,this);
        lvEntityList.setAdapter(entityListAdapter);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,width*3/4);
        ivEntityImage.setLayoutParams(layoutParams);


        headerView = (View) inflater.inflate(R.layout.list_city_category_header,lvEntityList, false);
        tvHeaderTitle = (TextView) headerView.findViewById(R.id.listheader_tv);
        tvHeaderTitle.setText(getResources().getString(R.string.list_header_sub_entities));
        lvEntityList.addHeaderView(headerView);

        setListViewHeightBasedOnChildren(lvEntityList);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EntityDetailsActivity.this,"Download button pressed",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public static void setListViewHeightBasedOnChildren(ListView listView)
    {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight=0;
        View view = null;

        for (int i = 1; i < listAdapter.getCount(); i++)
        {
            view = listAdapter.getView(i, view, listView);

            if (i == 1)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth,
                        LinearLayout.LayoutParams.MATCH_PARENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + ((listView.getDividerHeight()) * (listAdapter.getCount()));

        listView.setLayoutParams(params);
        listView.requestLayout();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entity_details, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
