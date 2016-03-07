package com.pocketwiki.pocketwiki;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chinmay on 15/1/16.
 */
public class CityCategoryListFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static CityCategoryListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CityCategoryListFragment fragment = new CityCategoryListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_category_list, container, false);
        ListView listView = (ListView) view.findViewById(R.id.citycategorylistfragment_lv);
        ArrayList itemList = new ArrayList<>();
        itemList.add(new CityCategoryListItemDTO("itemName1",35));
        itemList.add(new CityCategoryListItemDTO("itemName2",65));
        itemList.add(new CityCategoryListItemDTO("itemName3",25));
        itemList.add(new CityCategoryListItemDTO("itemName4",95));
        CityCategoryListAdapter listAdapter = new CityCategoryListAdapter(itemList,getActivity(),true);
        listView.setAdapter(listAdapter);
        return view;
    }
}
