package com.example.navigationproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    private TextView na;
    private TextView des;


    public  int id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        na = (TextView)view.findViewById(R.id.txtName);

        des = (TextView)view.findViewById(R.id.txtDesc);

        String name1 = getArguments().getString("name");

        String descri = getArguments().getString("desc");
        String str_id = getArguments().getString("Id");

        this.id = Integer.parseInt(str_id);

        // Integer pos1 = getIntent().getIntExtra("integer" , 1);
        na.setText(name1);
        des.setText(descri);
        return  view;
    }

}
