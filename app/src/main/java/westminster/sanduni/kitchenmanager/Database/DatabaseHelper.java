package westminster.sanduni.kitchenmanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import westminster.sanduni.kitchenmanager.Model.Product;


/**
 * Created by Sanduni Chamika
 * w1673755
 * 2017541
 * on 3/20/19
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //details of the data in the database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Products";
    private static final String TABLE_NAME = "product_table";
    private static final String COL_Name = "prod_name";
    private static final String COL_WEIGHT = "weight";
    private static final String COL_PRICE = "price";
    private static final String COL_DESCRIPTION = "description";
    private static final String COL_AVAILABILITY = "availability";

    //initialize the database
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+
                COL_Name + " TEXT PRIMARY KEY, " +COL_WEIGHT+" DOUBLE, " +
                "" +COL_PRICE+" DOUBLE, " +COL_DESCRIPTION+" TEXT , " +COL_AVAILABILITY+" TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    //add a product to the database
    public boolean addProductHandler(Product product){
        try{
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_Name, product.getProd_name());
            values.put(COL_WEIGHT, product.getWeight());
            values.put(COL_PRICE, product.getPrice());
            values.put(COL_DESCRIPTION, product.getDescription());
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_NAME, null, values);
            db.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //find the product in the database
    public Product findProductHandler(String prodName){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, new String[]{COL_Name, COL_WEIGHT, COL_PRICE,
                        COL_DESCRIPTION, COL_AVAILABILITY}, COL_Name + "=?", new String[]{prodName},
                null, null, null, null
        );
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Product product = new Product(cursor.getString(0), cursor.getDouble(1),
                cursor.getDouble(2), cursor.getString(3),cursor.getInt(4));
        database.close();
        return product;
    }

    //get all the produvts in the database
    public List<Product> getAllProductsHandler(){
        List<Product> productList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setProd_name(cursor.getString(0));
                product.setWeight(cursor.getDouble(1));
                product.setPrice(cursor.getDouble(2));
                product.setDescription(cursor.getString(3));
                product.setAvailability(cursor.getInt(4));
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return productList;
    }

    //delete a product from the database
    public void deleteProductHandler(Product product) {

        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, COL_Name + " =?", new String[]{product.getProd_name()});
        database.close();
    }

    //update product details in the database
    public void updateProductHandler(Product product) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_Name, product.getProd_name());
        values.put(COL_WEIGHT, product.getWeight());
        values.put(COL_PRICE, product.getPrice());
        values.put(COL_DESCRIPTION, product.getDescription());
        values.put(COL_AVAILABILITY, String.valueOf(product.isAvailability()));
        database.update(TABLE_NAME, values, COL_Name + " =?", new String[]{product.getProd_name()});
        database.close();
    }
}
