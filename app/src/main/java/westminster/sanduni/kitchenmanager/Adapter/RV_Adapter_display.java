package westminster.sanduni.kitchenmanager.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import westminster.sanduni.kitchenmanager.Activity_DisplayProducts;
import westminster.sanduni.kitchenmanager.MainActivity;
import westminster.sanduni.kitchenmanager.R;

public class RV_Adapter_display extends RecyclerView.Adapter<RV_Adapter_display.ProductViewHolder> {
    private List<String> productList;
    private LayoutInflater mInflater;

    public RV_Adapter_display(Context context, List<String> productList) {
        mInflater = LayoutInflater.from(context);
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.rv_adapter_display, viewGroup, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder productViewHolder, int i) {
        final String mCurrent = productList.get(i);
        productViewHolder.wordItemView.setText(mCurrent);
        if (MainActivity.databaseHelper.findProductHandler(mCurrent).isAvailability() == 1) {
            productViewHolder.checkBox.setChecked(true);
            productViewHolder.checkBox.setEnabled(false);
            Activity_DisplayProducts.selectedProductList.add(mCurrent);
        } else {
            productViewHolder.checkBox.setChecked(false);
            Activity_DisplayProducts.selectedProductList.remove(mCurrent);
        }
        productViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productViewHolder.checkBox.isChecked()) {
                    for (String string : Activity_DisplayProducts.selectedProductList) {
                        if (string.equals(mCurrent)) {
                            break;
                        }
                    }
                    Activity_DisplayProducts.selectedProductList.add(mCurrent);
                    Log.d("OnChecked", "onClick: " + mCurrent);
                } else {
                    Activity_DisplayProducts.selectedProductList.remove(mCurrent);
                    Log.d("OnChecked", "onClick: " + mCurrent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final RV_Adapter_display mAdapter;
        CheckBox checkBox;

        public ProductViewHolder(View itemView, RV_Adapter_display adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            checkBox = itemView.findViewById(R.id.checkBox);
            this.mAdapter = adapter;
        }
    }
}
