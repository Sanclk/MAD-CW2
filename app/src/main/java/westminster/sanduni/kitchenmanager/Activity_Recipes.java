package westminster.sanduni.kitchenmanager;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Activity_Recipes extends AppCompatActivity implements View.OnClickListener{

    private CheckBox checkChicken, checkFish, checkEgg, checkOregano;
    private String query = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkChicken = findViewById(R.id.checkChicken);
        checkFish = findViewById(R.id.checkFish);
        checkEgg = findViewById(R.id.checkEgg);
        checkOregano = findViewById(R.id.checkOregano);

        checkChicken.setOnClickListener(this);
        checkFish.setOnClickListener(this);
        checkEgg.setOnClickListener(this);
        checkOregano.setOnClickListener(this);
    }

    public void findRecipes(View view) {
        if (query.trim().length() > 0) {
            Intent intent = new Intent(Activity_Recipes.this, ListActivity.class);
            intent.putExtra("query", query);
            startActivity(intent);
        } else {
            Toast.makeText(this, "ERROR : No any product selected!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkChicken:
                if (checkChicken.isChecked()) {
                    checkChicken.setChecked(true);
                    query += "chicken,";
                } else {
                    checkChicken.setChecked(false);
                    query = query.replaceAll("chicken,", "");
                }
                break;

            case R.id.checkEgg:
                if (checkEgg.isChecked()) {
                    checkEgg.setChecked(true);
                    query += "egg,";
                } else {
                    checkEgg.setChecked(false);
                    query = query.replaceAll("egg,", "");
                }
                break;

            case R.id.checkFish:
                if (checkFish.isChecked()) {
                    checkFish.setChecked(true);
                    query += "fish,";
                } else {
                    checkFish.setChecked(false);
                    query = query.replaceAll("fish,", "");
                }
                break;

            case R.id.checkOregano:
                if (checkOregano.isChecked()) {
                    checkOregano.setChecked(true);
                    query += "oregano,";
                } else {
                    checkOregano.setChecked(false);
                    query = query.replaceAll("oregano,", "");
                }
                break;
        }
    }
}