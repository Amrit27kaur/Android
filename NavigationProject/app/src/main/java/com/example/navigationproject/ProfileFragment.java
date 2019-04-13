package com.example.navigationproject;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    private TextView na;
    private TextView des;
      Button btn;
    Context context;
    public  int id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        na = (TextView)view.findViewById(R.id.txtName);

        des = (TextView)view.findViewById(R.id.txtDesc);
        Button delete = (Button)view.findViewById(R.id.delBtn);
        Button update=(Button)view.findViewById(R.id.delUpdate) ;

        String name1 = getArguments().getString("name");

        String descri = getArguments().getString("desc");

       String str_id = getArguments().getString("Id");

        this.id = Integer.parseInt(str_id);

        // Integer pos1 = getIntent().getIntExtra("integer" , 1);
        na.setText(name1);
        des.setText(descri);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBhelper dbH = new DBhelper(getContext());

                dbH.deleteData(id);

                Toast.makeText(getContext(), "Successfully" , Toast.LENGTH_SHORT).show();

                //getFragmentManager().popBackStackImmediate();


                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment mfrag = new showList();
                ft.replace(R.id.FrameLayout , mfrag);
                ft.commit();

            }
        });
        return  view;
    }



}
