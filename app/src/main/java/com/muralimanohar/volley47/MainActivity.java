package com.muralimanohar.volley47;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText firstname,lastname,age;
    TextView studentdata;
    Button savedata, viewdata;

    RequestQueue  requestQueue;
    String insertUrl = "http://192.168.1.9/volley47/insertStudent.php";
    String viewUrl = "http://192.168.1.9/volley47/showStudent.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.usr_firstname);
        lastname = findViewById(R.id.usr_lastname);
        age = findViewById(R.id.usr_age);

        studentdata = findViewById(R.id.user_data);

        savedata = findViewById(R.id.savedata);
        viewdata = findViewById(R.id.viewdata);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello test",Toast.LENGTH_SHORT).show();

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        viewUrl, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray students = response.getJSONArray("student");

                            for (int i = 0 ; i < students.length(); i++ ){

                                JSONObject student =  students.getJSONObject(i);

                                String firstname = student.getString("firstname");
                                String lastname = student.getString("lastname");
                                String age = student.getString("age");

                                studentdata.append(firstname+ "adasd " + lastname + " asdasd" + age + "\n");
                            }
                            studentdata.append("=========== \n");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}
