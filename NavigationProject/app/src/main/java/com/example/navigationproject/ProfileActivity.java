package com.example.navigationproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static com.example.navigationproject.R.layout.activity_profile;

public class ProfileActivity extends AppCompatActivity {

     TextView na;
    TextView des;
    Button btn;
    Context context;
    public  int id;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_profile);

        na = (TextView)findViewById(R.id.txtName);

        des = (TextView)findViewById(R.id.txtDesc);
        btn = (Button)findViewById(R.id.delBtn);

        String name1 = getIntent().getStringExtra("name");
        String descri = getIntent().getStringExtra("desc");
        //String name1 = getIntent().getStringExtra("name");

       // String descri = getArguments().getString("desc");

       // String str_id = getIntent().getStringExtra("Id");

       // this.id = Integer.parseInt(str_id);

        // Integer pos1 = getIntent().getIntExtra("integer" , 1);
        na.setText(name1);
        des.setText(descri);

    }
}
