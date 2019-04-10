package westminster.sanduni.kitchenmanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import westminster.sanduni.kitchenmanager.Model.Product;

public class Activity_EditProduct extends AppCompatActivity {

    private EditText etProdName, etWeight, etPrice, etdescription; //editTexts for Model.Product Name, weight, price and description respectively
    private Button btnSave;
    private Spinner spnAvailability;
    private static Context context;
    public boolean newProduct;
    private Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__edit_product);

        initComponents();

        newProduct = true;
        int index = getIntent().getIntExtra("Index", -1);
        if (index != -1) {
            newProduct = false;
            final Product product = MainActivity.databaseHelper.getAllProductsHandler().get(index);
            etProdName.setText(product.getProd_name());
            etWeight.setText(String.valueOf(product.getWeight()));
            etPrice.setText(String.valueOf(product.getPrice()));
            etdescription.setText(product.getDescription());
        }
    }



    public void updateProduct(View view) {
        String productName = etProdName.getText().toString();
        Double weight = Double.parseDouble(etWeight.getText().toString());
        Double price = Double.parseDouble(etPrice.getText().toString());
        String description = etdescription.getText().toString();
        int availability = Integer.parseInt(spnAvailability.getSelectedItem().toString());

        product = new Product(productName, weight,price,description, availability);
        if (newProduct) {
            MainActivity.databaseHelper.addProductHandler(product);
        } else {
            MainActivity.databaseHelper.updateProductHandler(product);
        }
        finish();
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
}
