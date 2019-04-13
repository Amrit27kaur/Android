package com.example.navigationproject;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class showList extends Fragment {


    public showList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_list, container, false);


        final ArrayList<String> userDataFromDBname = new ArrayList<>();
        final ArrayList<String> userDataFromDBdescription = new ArrayList<>();
        final ArrayList<Integer> userDataFromDBId = new ArrayList<>();


        DBhelper dbh = new DBhelper(getContext());
        Cursor data = dbh.getData();

        while(data.moveToNext())
        {
            userDataFromDBname.add(data.getString(1));
            userDataFromDBdescription.add(data.getString(2));
            userDataFromDBId.add(data.getInt(0));
        }

        // CustomAdapter ca = new CustomAdapter(this.getContext(), names, description);
        CustomAdapter ca = new CustomAdapter(getContext(), userDataFromDBname ,userDataFromDBdescription);

        ListView lt = (ListView)view.findViewById(R.id.list);

        Log.i("length ------- ", Integer.toString(userDataFromDBdescription.size()));
        lt.setAdapter(ca);
        return view;




    }



}
