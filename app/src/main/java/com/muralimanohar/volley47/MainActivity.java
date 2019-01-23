package com.muralimanohar.volley47;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    List<Studendconstant> studendconstantslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studendconstantslist = new ArrayList<>();
        recyclerView = findViewById(R.id.myrecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adding some items to our list
        studendconstantslist.add(
                new Studendconstant("Murali",
                        "Manohar",
                        "28"));
        studendconstantslist.add(
                new Studendconstant("Vignesh",
                        "waran",
                        "26"));
        studendconstantslist.add(
                new Studendconstant("Ram",
                        "Kumar",
                        "39"));

        studentAdapter = new StudentAdapter(this, studendconstantslist);
        recyclerView.setAdapter(studentAdapter);
    }


}
