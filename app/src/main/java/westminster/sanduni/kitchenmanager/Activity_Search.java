package westminster.sanduni.kitchenmanager;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import westminster.sanduni.kitchenmanager.Model.Product;

import static westminster.sanduni.kitchenmanager.Activity_Availability.productStringArrayList;

public class Activity_Search extends AppCompatActivity {

    ListView listView;
    ArrayList<String> productList;
    ArrayAdapter<String > adapter;

//    Referred Source : https://www.youtube.com/watch?v=QY-O49a_Ags

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__search);

        listView = (ListView) findViewById(R.id.lv_search);

        for(Product product: MainActivity.databaseHelper.getAllProductsHandler()){
            productStringArrayList.add(product.getProd_name());
            productStringArrayList.add(product.getDescription());
        }

        productList = productStringArrayList;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productList);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.item_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
               if(productList.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    //Toast.makeText(Activity_Search.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
