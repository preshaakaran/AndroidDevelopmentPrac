package com.example.jsonresponse;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable edge-to-edge display if necessary
        // EdgeToEdge.enable(this);

        String url = "https://jsonplaceholder.typicode.com/users";
        ListView listView = findViewById(R.id.listView);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        ArrayList<String> arrNames = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("MainActivity", "Response: " + response.toString());
                        try {
                            // Loop through each item in the array
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject user = response.getJSONObject(i);
                                int userId = user.getInt("id");
                                String userName = user.getString("name");
                                arrNames.add(userId + ": " + userName);

                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrNames);
                                listView.setAdapter(adapter);
                                // Example: Logging user id and name
                                Log.d("MainActivity", "User ID: " + userId + ", Name: " + userName);
                            }
                        } catch (JSONException e) {
                            // JSON parsing error
                            Log.e("MainActivity", "Error parsing JSON response", e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle Volley error
                        Log.e("MainActivity", "Volley error", error);
                    }
                }
        );

        // Add the request to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }
}
