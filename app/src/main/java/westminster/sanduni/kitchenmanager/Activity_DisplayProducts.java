package westminster.sanduni.kitchenmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import westminster.sanduni.kitchenmanager.Adapter.RV_Adapter_display;
import westminster.sanduni.kitchenmanager.Model.Product;

public class Activity_DisplayProducts extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter wordListAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static ArrayList<String> productStringArrayList = new ArrayList<>();
    public static ArrayList<String> selectedProductList = new ArrayList<>();
//    private DatabaseHelper databaseHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__display_products);

        addProductsToRecyclerView();
    }

    private void addProductsToRecyclerView(){

        recyclerView = findViewById(R.id.rv_display_availability);

        recyclerView.setHasFixedSize(true);

        productStringArrayList.clear();

        for(Product product: MainActivity.databaseHelper.getAllProductsHandler()){
            Log.d("ArrayList","addProductsToRecyclerView: "+ product.getProd_name());
            productStringArrayList.add(product.getProd_name());

            recyclerView = findViewById(R.id.rv_display_availability);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            wordListAdapter = new RV_Adapter_display(this,productStringArrayList);
            recyclerView.setAdapter(wordListAdapter);
        }
    }

    public void addToKitchen(View view) {
        for (Product product : MainActivity.databaseHelper.getAllProductsHandler()) {
            product.setAvailability(0);
            MainActivity.databaseHelper.updateProductHandler(product);
        }
        for (String string : selectedProductList) {
            Product product = MainActivity.databaseHelper.findProductHandler(string);
            product.setAvailability(1);
            MainActivity.databaseHelper.updateProductHandler(product);
            Toast.makeText(getApplicationContext(),"Added to the Kitchen!", Toast.LENGTH_LONG);
        }
        finish();
    }
}