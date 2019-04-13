package com.example.navigationproject;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class addFragment extends Fragment {


    public addFragment() {
        // Required empty public constructor
    }

    //ListView lv;
   Context context;

     private EditText et1;
    private EditText et2;
    View v;

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



      View view = inflater.inflate(R.layout.fragment_add, container, false);

      this.v = view;
        et1 = (EditText)view.findViewById(R.id.name);

        et2 = (EditText)view.findViewById(R.id.des);

        Button add = (Button)view.findViewById(R.id.addBtn);
        //onCall();

        add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view){
            names.add(et1.getText().toString());

            description.add(et2.getText().toString());

            DBhelper dbh = new DBhelper(getContext());

            boolean result = dbh.addUser(et1.getText().toString(), et2.getText().toString());

            //onCall();

            if (result) {
                Toast.makeText(getContext(), "Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "UnSuccessfully", Toast.LENGTH_SHORT).show();
            }
        }

        });
       return view;


    }

    public  void onCall()
    {

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

        ListView lt = (ListView)v.findViewById(R.id.list);

        lt.setAdapter(ca);

        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                onCall();

                ProfileFragment pF = new ProfileFragment();
                Bundle args = new Bundle();
                args.putString("name" ,userDataFromDBname.get(position));
                args.putString("name" ,userDataFromDBdescription.get(position));
                args.putString("name" ,userDataFromDBId.get(position).toString());


                pF.setArguments(args);

                getFragmentManager().beginTransaction().add(R.id.FrameLayout).commit();


               // Intent profile = new Intent(getActivity(),ProfileFragment.class);


                //profile.putExtra("integer" , position);

                startActivity(profile);
            }
        });
    }
}

