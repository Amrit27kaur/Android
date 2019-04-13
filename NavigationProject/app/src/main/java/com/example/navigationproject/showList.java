package com.example.navigationproject;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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


    View view;
    public showList() {
        // Required empty public constructor
    }

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_list, container, false);
        this.v = view;

        final ArrayList<String> userDataFromDBname = new ArrayList<>();
        final ArrayList<String> userDataFromDBdescription = new ArrayList<>();
        final ArrayList<Integer> userDataFromDBId = new ArrayList<>();


        DBhelper dbh = new DBhelper(getContext());
        Cursor data = dbh.getData();

        while (data.moveToNext()) {
            userDataFromDBname.add(data.getString(1));
            userDataFromDBdescription.add(data.getString(2));
            userDataFromDBId.add(data.getInt(0));
        }

        // CustomAdapter ca = new CustomAdapter(this.getContext(), names, description);
        CustomAdapter ca = new CustomAdapter(getContext(), userDataFromDBname, userDataFromDBdescription);

        ListView lt = (ListView) view.findViewById(R.id.list);
         onCall();
        lt.setAdapter(ca);
        return view;

    }
        public void onCall ()
        {

            final ArrayList<String> userDataFromDBname = new ArrayList<>();
            final ArrayList<String> userDataFromDBdescription = new ArrayList<>();
            final ArrayList<Integer> userDataFromDBId = new ArrayList<>();


            DBhelper dbh = new DBhelper(getContext());
            Cursor data = dbh.getData();

            while (data.moveToNext()) {
                userDataFromDBname.add(data.getString(1));
                userDataFromDBdescription.add(data.getString(2));
                userDataFromDBId.add(data.getInt(0));
            }

            // CustomAdapter ca = new CustomAdapter(this.getContext(), names, description);
            CustomAdapter ca = new CustomAdapter(getContext(), userDataFromDBname, userDataFromDBdescription);

            ListView lt = (ListView) v.findViewById(R.id.list);

            lt.setAdapter(ca);

            lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    onCall();
                    //FragmentTransaction transection=getFragmentManager().beginTransaction();
                    ProfileFragment pF = new ProfileFragment();
                    Bundle args = new Bundle();
                    args.putString("name", userDataFromDBname.get(position));
                    args.putString("desc", userDataFromDBdescription.get(position));
                    args.putString("Id", userDataFromDBId.get(position).toString());

                   // Intent intent =getActivity().getIntent();
                   // intent.putExtras(args);

                    pF.setArguments(args);

                    getFragmentManager().beginTransaction().replace(R.id.FrameLayout, pF).addToBackStack(null).commit();

                     //Intent profile = new Intent(getActivity(),ProfileActivity.class);


                    //profile.putExtra("integer" , position);

                   // startActivity(profile);
                }
            });
        }
    }


