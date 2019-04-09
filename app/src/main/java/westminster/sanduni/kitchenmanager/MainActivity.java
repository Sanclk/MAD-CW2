package westminster.sanduni.kitchenmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import westminster.sanduni.kitchenmanager.Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    public static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
    }
}
