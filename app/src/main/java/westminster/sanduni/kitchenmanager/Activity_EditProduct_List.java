package westminster.sanduni.kitchenmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import westminster.sanduni.kitchenmanager.Adapter.RV_Adapter_editList;
import westminster.sanduni.kitchenmanager.Model.Product;

public class Activity_EditProduct_List extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter wordListAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static ArrayList<String> productStringArrayList = new ArrayList<>();
    public static ArrayList<String> selectedProductList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__edit_product__list);

        addProductsToRecyclerView();
    }

    private void addProductsToRecyclerView(){
        recyclerView = findViewById(R.id.rv_edit_productlist);

        recyclerView.setHasFixedSize(true);

        productStringArrayList.clear();

        for(Product product: MainActivity.databaseHelper.getAllProductsHandler()){
            Log.d("ArrayList","addProductsToRecyclerView: "+ product.getProd_name());
            productStringArrayList.add(product.getProd_name());

            recyclerView = findViewById(R.id.rv_edit_productlist);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            wordListAdapter = new RV_Adapter_editList(this,productStringArrayList);
            recyclerView.setAdapter(wordListAdapter);
        }

    }
}
