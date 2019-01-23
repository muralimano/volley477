package com.muralimanohar.volley47;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    List<Studendconstant> studendconstantslist;
    private static final String main_URL = "http://192.168.0.113/volley47/showStudent.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studendconstantslist = new ArrayList<>();
        recyclerView = findViewById(R.id.myrecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adding some items to our list
//        studendconstantslist.add(
//                new Studendconstant("Murali",
//                        "Manohar",
//                        "28"));
//        studendconstantslist.add(
//                new Studendconstant("Vignesh",
//                        "waran",
//                        "26"));
//        studendconstantslist.add(
//                new Studendconstant("Ram",
//                        "Kumar",
//                        "39"));
        //  studentserverdata();
        studentserverobj();
    }

    private void studentserverdata() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, main_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray studentda = new JSONArray(response);

                    for (int i = 0; i < studentda.length(); i++) {
                        JSONObject studentobj = studentda.getJSONObject(i);
                        String firstname = studentobj.getString("firstname");
                        String lastname = studentobj.getString("lastname");
                        String age = studentobj.getString("age");

                        Studendconstant studentcons = new Studendconstant(firstname, lastname, age);
                        studendconstantslist.add(studentcons);

                    }
                    studentAdapter = new StudentAdapter(MainActivity.this, studendconstantslist);
                    recyclerView.setAdapter(studentAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void studentserverobj() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, main_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //JSONArray studentda  = new JSONArray(response);
                    JSONArray studentda = response.getJSONArray("student");


                    for (int i = 0; i < studentda.length(); i++) {
                        JSONObject studentobj = studentda.getJSONObject(i);
                        String firstname = studentobj.getString("firstname");
                        String lastname = studentobj.getString("lastname");
                        String age = studentobj.getString("age");

                        Studendconstant studentcons = new Studendconstant(firstname, lastname, age);
                        studendconstantslist.add(studentcons);

                    }
                    studentAdapter = new StudentAdapter(MainActivity.this, studendconstantslist);
                    recyclerView.setAdapter(studentAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }


}
