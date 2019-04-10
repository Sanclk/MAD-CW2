package westminster.sanduni.kitchenmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import westminster.sanduni.kitchenmanager.Adapter.RV_recipeList;
import westminster.sanduni.kitchenmanager.Model.Recipe;

public class Activity_RecipeList extends AppCompatActivity implements RV_recipeList.ItemClickListener {

    //    private static final String API_KEY = "c921e9f05842b5f41786e26eaa8645f7"; // sanclk
    private static final String API_KEY = "4218e955723c7b2174f711da9abbd6f9"; // nepuzam@easymail.top qwerty123
    public static final String URL = "https://www.food2fork.com/api/";
//    https://www.food2fork.com/api/search?key=c921e9f05842b5f41786e26eaa8645f7&q=chicken,oregano

    private RecyclerView recyclerView;
    private RV_recipeList mAdapter;

    private ArrayList<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipelist);

        // Get query from previous Intent & remove last "," character
        String query = getIntent().getStringExtra("query");
        query = query.substring(0, query.length() - 1);
        Toast.makeText(this, query, Toast.LENGTH_SHORT).show();

        //////////// Volley ///////////////////

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String query_url = URL + "search?key=" + API_KEY + "&q=" + query;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, query_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Gson gson = new Gson();
                            recipeList = new ArrayList<>();
                            JSONArray recipesArray = (new JSONObject(response)).getJSONArray("recipes");
                            if (recipesArray != null && recipesArray.length() > 0) {
                                for (int i = 0; i < recipesArray.length(); i++) {
                                    Recipe recipe = gson.fromJson(recipesArray.get(i).toString(), Recipe.class);
                                    recipeList.add(recipe);
                                }

                                setupRecyclerView();

                            } else {
                                Toast.makeText(getApplicationContext(), "No results found", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error occurred !", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter (see also next example)
        mAdapter = new RV_recipeList(this, recipeList);
        mAdapter.setClickListener(this);
        recyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onItemClick(View view, int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipeList.get(position)
                .getSourceUrl()));
        startActivity(browserIntent);
    }
}

