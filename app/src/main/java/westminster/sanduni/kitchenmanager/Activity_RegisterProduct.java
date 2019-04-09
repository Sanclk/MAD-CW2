package westminster.sanduni.kitchenmanager;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import westminster.sanduni.kitchenmanager.Database.DatabaseHelper;
import westminster.sanduni.kitchenmanager.Model.Product;

public class Activity_RegisterProduct extends AppCompatActivity {

    EditText etProdName, etWeight, etPrice, etdescription; //editTexts for Model.Product Name, weight, price and description respectively
    Button btnSave;
    public static Context context;
    private boolean newProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register_product);

        //initializing the components of the layout
        initComponents();
    }

    private void addProduct(View view){

        DatabaseHelper objDatabaseHelper = new DatabaseHelper(this);

        try{

            String prodName = etProdName.getText().toString().toUpperCase();
            double weight = Integer.valueOf(etWeight.getText().toString());
            double price = Integer.valueOf(etPrice.getText().toString());
            String description = etdescription.getText().toString();
            Product product = new Product(prodName,weight,price,description,0);

            objDatabaseHelper.addProductHandler(product);
            Toast.makeText(getApplicationContext(), "Ingredient Added Successfully!", Toast.LENGTH_LONG).show();
            finish();

        }catch (SQLiteException ex){
            Toast.makeText(getApplicationContext(), "ALREADY EXISTS!", Toast.LENGTH_LONG).show();
        }

    }

    //initializing all the components of the Register product layout
    private void initComponents(){

        //getting the editText values of product name, weight, price and description
        etProdName = findViewById(R.id.et_productName);
        etWeight = findViewById(R.id.et_productWeight);
        etPrice = findViewById(R.id.et_productPrice);
        etdescription = findViewById(R.id.et_prodctDescription);

        btnSave = findViewById(R.id.btn_register);

        context = getApplicationContext();
    }

    public void loadRegisterProduct(View view) {
        addProduct(view);
    }
}
