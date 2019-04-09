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

public class RV_Adapter_availability extends RecyclerView.Adapter<RV_Adapter_availability.ProductViewHolder> {
    private List<String> productList;
    private LayoutInflater mInflater;

    public RV_Adapter_availability(Context context, List<String> productList) {
        mInflater = LayoutInflater.from(context);
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.rv__adapter__availability, viewGroup, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder productViewHolder, int i) {
        final String mCurrent = productList.get(i);
        productViewHolder.wordItemView.setText(mCurrent);

        //TODO
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final RV_Adapter_availability mAdapter;
        CheckBox checkBox;

        public ProductViewHolder(View itemView, RV_Adapter_availability adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.tv_prodName);
            checkBox = itemView.findViewById(R.id.cb_availability);
            this.mAdapter = adapter;
        }
    }
}
