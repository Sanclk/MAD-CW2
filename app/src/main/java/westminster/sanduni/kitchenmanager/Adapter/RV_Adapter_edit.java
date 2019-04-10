package westminster.sanduni.kitchenmanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import westminster.sanduni.kitchenmanager.Activity_EditProduct;
import westminster.sanduni.kitchenmanager.Activity_EditProduct_List;
import westminster.sanduni.kitchenmanager.R;

public class RV_Adapter_edit extends RecyclerView.Adapter<RV_Adapter_edit.WordViewHolder> {
    private final ArrayList<String> mWordList;
    private LayoutInflater mInflater;

    public RV_Adapter_edit(Context context,
                           ArrayList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View mItemView = mInflater.inflate(R.layout.rv__adapter__editlist,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final RV_Adapter_edit mAdapter;

        public WordViewHolder(View itemView, RV_Adapter_edit adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            // Getting the position of the clicked item
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


