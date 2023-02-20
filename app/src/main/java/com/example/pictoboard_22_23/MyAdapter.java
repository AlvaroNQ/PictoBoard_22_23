package com.example.pictoboard_22_23;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.List;


public abstract class MyAdapter<T extends MyViewHolder> extends RecyclerView.Adapter<T> {
    protected final List<Picto> data;

    public MyAdapter(List<Picto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        Picto view = new Picto(parent.getContext());
        FlexboxLayoutManager.LayoutParams lp = new FlexboxLayoutManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setFlexGrow(1);
        lp.setFlexShrink(0.0f);
        view.setLayoutParams(lp);
        return instanceViewHolder(view);
    }

    protected abstract T instanceViewHolder(Picto view);

    @Override
        public final void onBindViewHolder(T holder, int position) {
        Picto item = data.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}


