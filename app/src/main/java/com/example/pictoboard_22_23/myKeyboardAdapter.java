package com.example.pictoboard_22_23;

import android.view.inputmethod.InputConnection;
import java.util.List;


public class myKeyboardAdapter extends MyAdapter{

    private final InputConnection mInputConnection;


    public myKeyboardAdapter(List<Picto> data, InputConnection mInputConnection) {
        super(data);
        this.mInputConnection = mInputConnection;
    }


    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        Picto item = this.data.get(position);
        holder.bindData(item);
        holder.itemView.setOnClickListener(view -> mInputConnection.commitText(" " + ((Picto)view).getText(), 1));
    }
}


