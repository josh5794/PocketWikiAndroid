package com.pocketwiki.pocketwiki;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.rey.material.widget.FrameLayout;

public class FilterActivity extends AppCompatActivity {

    public String TAG = getClass().getSimpleName();
    View header1, header2;
    TextView tvHeader1, tvHeader2;
    RelativeLayout cityListLayout,categoryListLayout, rltHeaderArrow1, rltHeaderArrow2, parentView;
    ImageView headerArrow1, headerArrow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        parentView = (RelativeLayout) findViewById(R.id.filteractivity_parentView);

        String[] alphabetArray = getResources().getStringArray(R.array.alphabets_english);
        ViewPager viewPager1 = (ViewPager) findViewById(R.id.filteractivity_viewpager1);
        ViewPager viewPager2 = (ViewPager) findViewById(R.id.filteractivity_viewpager2);
        viewPager1.setAdapter(new AlphabetsFragmentPagerAdapter(getSupportFragmentManager(),alphabetArray));
        viewPager2.setAdapter(new AlphabetsFragmentPagerAdapter(getSupportFragmentManager(),alphabetArray));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip1 = (PagerSlidingTabStrip) findViewById(R.id.filteractivity_tabs1);
        PagerSlidingTabStrip tabsStrip2 = (PagerSlidingTabStrip) findViewById(R.id.filteractivity_tabs2);
        // Attach the view pager to the tab strip
        tabsStrip1.setViewPager(viewPager1);
        tabsStrip2.setViewPager(viewPager2);

        cityListLayout = (RelativeLayout) findViewById(R.id.filteractivity_rlt_city_list);
        categoryListLayout = (RelativeLayout) findViewById(R.id.filteractivity_rlt_category_list);
        cityListLayout.setVisibility(View.GONE);
        categoryListLayout.setVisibility(View.GONE);

        header1 = findViewById(R.id.filteractivity_header1);
        header2 = findViewById(R.id.filteractivity_header2);
        tvHeader1 = (TextView) header1.findViewById(R.id.listheader_tv);
        tvHeader2 = (TextView) header2.findViewById(R.id.listheader_tv);
        rltHeaderArrow1 = (RelativeLayout) header1.findViewById(R.id.listheader_rlt_arrow);
        rltHeaderArrow2 = (RelativeLayout) header2.findViewById(R.id.listheader_rlt_arrow);
        rltHeaderArrow1.setVisibility(View.VISIBLE);
        rltHeaderArrow2.setVisibility(View.VISIBLE);
        headerArrow1 = (ImageView) header1.findViewById(R.id.listheader_iv_arrow);
        headerArrow2 = (ImageView) header2.findViewById(R.id.listheader_iv_arrow);
        tvHeader1.setText(getResources().getString(R.string.list_header_select_city));
        tvHeader2.setText(getResources().getString(R.string.list_header_select_category));
        header1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cityListLayout.getVisibility() == View.VISIBLE){
                    cityListLayout.setVisibility(View.GONE);
                    headerArrow1.setImageResource(R.drawable.right_arrow_gray);
                }
                else if(cityListLayout.getVisibility() == View.GONE){
                    cityListLayout.setVisibility(View.VISIBLE);
                    headerArrow1.setImageResource(R.drawable.down_arrow_gray);
                    if(categoryListLayout.getVisibility() == View.VISIBLE){
                        categoryListLayout.setVisibility(View.GONE);
                        headerArrow2.setImageResource(R.drawable.right_arrow_gray);
                    }
                }
            }
        });
        header2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(categoryListLayout.getVisibility() == View.VISIBLE){
                    categoryListLayout.setVisibility(View.GONE);
                    headerArrow2.setImageResource(R.drawable.right_arrow_gray);

                }
                else if(categoryListLayout.getVisibility() == View.GONE){
                    categoryListLayout.setVisibility(View.VISIBLE);
                    headerArrow2.setImageResource(R.drawable.down_arrow_gray);
                    if(cityListLayout.getVisibility() == View.VISIBLE){
                        cityListLayout.setVisibility(View.GONE);
                        headerArrow1.setImageResource(R.drawable.right_arrow_gray);
                    }
                }
            }
        });

        /*Snackbar snackbar = Snackbar
                .make(parentView, "Had a snack at Snackbar", Snackbar.LENGTH_INDEFINITE);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.DKGRAY);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackbarView.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        snackbarView.setLayoutParams(params);
        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();*/

    }

}
