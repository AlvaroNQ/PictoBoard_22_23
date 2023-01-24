package com.example.pictoboard_22_23;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<Picto> data;

    public MyAdapter(List<Picto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Picto view = new Picto(parent.getContext());
        FlexboxLayoutManager.LayoutParams lp = new FlexboxLayoutManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setFlexGrow(1);
        lp.setFlexShrink(0.0f);
        view.setLayoutParams(lp);
        return new MyViewHolder(view);
    }

    @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
        Picto item = data.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final Picto picto;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.picto = (Picto) itemView;
        }

        public void bindData(Picto item) {
            this.picto.setPicto(item);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Picto data);
    }
}


