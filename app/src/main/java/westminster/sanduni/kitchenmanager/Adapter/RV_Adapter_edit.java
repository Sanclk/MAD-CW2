package westminster.sanduni.kitchenmanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import westminster.sanduni.kitchenmanager.Activity_EditProduct;
import westminster.sanduni.kitchenmanager.Activity_EditProduct_List;
import westminster.sanduni.kitchenmanager.R;

public class RV_Adapter_edit extends RecyclerView.Adapter<RV_Adapter_edit.ProductViewHolder> {
    private List<String> productList;
    private LayoutInflater mInflater;

    public RV_Adapter_edit(Context context, List<String> productList) {
        mInflater = LayoutInflater.from(context);
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.rv__adapter__editlist, viewGroup, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder productViewHolder, int i) {
        final String mCurrent = productList.get(i);
        productViewHolder.wordItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final RV_Adapter_edit mAdapter;

        public ProductViewHolder(View itemView, RV_Adapter_edit adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.tv_productName);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            // Getting the position of clicked item
            int mPosition = getLayoutPosition();
            editProductIntent("Edit Product", mPosition);
        }

        private void editProductIntent(String name, int index) {
            Intent intent = new Intent(Activity_EditProduct_List.context, Activity_EditProduct.class);
            intent.putExtra("TitleType", name);
            intent.putExtra("Index", index);
            Activity_EditProduct_List.context.startActivity(intent);
        }
    }



}
