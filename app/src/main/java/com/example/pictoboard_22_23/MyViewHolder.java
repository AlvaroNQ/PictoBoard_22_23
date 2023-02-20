package com.example.pictoboard_22_23;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    protected final Picto picto;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.picto = (Picto) itemView;
    }

    public final void bindData(Picto item) {
        this.picto.setPicto(item);
        onBindData();
    }

    protected void onBindData() {
    }

    protected void initListeners() {
    }
}
