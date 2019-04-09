package westminster.sanduni.kitchenmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import westminster.sanduni.kitchenmanager.Database.DatabaseHelper;

public class Activity_SelectOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__select_options);
        MainActivity.databaseHelper = new DatabaseHelper(this);
    }

    //Load register product activity
    public void loadRegisterProduct(View view) {
        Intent intent = new Intent(Activity_SelectOption.this, Activity_RegisterProduct.class);
        startActivity(intent);
    }

    //Load Display Model.Product activity
    public void loadDisplayProduct(View view){
        Intent intent = new Intent(Activity_SelectOption.this, Activity_DisplayProducts.class);
        startActivity(intent);
    }

    //Load check availability activity
    public void loadAvailability(View view){
        Intent intent = new Intent(Activity_SelectOption.this, Activity_Availability.class);
        startActivity(intent);
    }

    //Load edit the products activity
    public void loadEditProducts(View view){
        Intent intent = new Intent(Activity_SelectOption.this, Activity_EditProduct.class);
        startActivity(intent);
    }

    //Load search activity
    public void loadSearch(View view) {
        Intent intent = new Intent(Activity_SelectOption.this, Activity_Search.class);
        startActivity(intent);
    }

    //load recipeds activity
    public void loadRecipes(View view) {
        Intent intent = new Intent(Activity_SelectOption.this, Activity_Recipes.class);
        startActivity(intent);
    }
}
