package com.example.pictoboard_22_23;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.AlignContent;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;


public class MyInputMethodService extends InputMethodService{
    private InputConnection mInputConnection;
    LayoutInflater inflater;
    Context ctx;

    @Override
    public View onCreateInputView() {
        ctx = getLayoutInflater().getContext();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inputView = getLayoutInflater().inflate(R.layout.main_board, null);

        List<Picto> topData = getTopPictos();

        RecyclerView topRecyclerView = inputView.findViewById(R.id.top_block);
        LinearLayoutManager topLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topRecyclerView.setLayoutManager(topLayoutManager);

        MyAdapter topAdapter = new MyAdapter(topData);
        topRecyclerView.setAdapter(topAdapter);


        List<Picto> leftData = getTopPictos();

        RecyclerView leftRecyclerView = inputView.findViewById(R.id.left_block);
        FlexboxLayoutManager leftLayoutManager = new FlexboxLayoutManager(this);
        leftLayoutManager.setFlexDirection(FlexDirection.COLUMN);
        leftLayoutManager.setFlexWrap(FlexWrap.NOWRAP);


        leftRecyclerView.setLayoutManager(leftLayoutManager);
        MyAdapter leftAdapter = new MyAdapter(leftData);
        leftRecyclerView.setAdapter(leftAdapter);


        List<Picto> rightData = getRightPictos();

        RecyclerView rightRecyclerView = inputView.findViewById(R.id.right_block);
        FlexboxLayoutManager rightLayoutManager = new FlexboxLayoutManager(this);
        rightLayoutManager.setFlexDirection(FlexDirection.ROW);
        rightLayoutManager.setJustifyContent(JustifyContent.CENTER);
        rightLayoutManager.setAlignItems(AlignItems.CENTER);

        rightRecyclerView.setLayoutManager(rightLayoutManager);

        MyAdapter rightAdapter = new MyAdapter(rightData);
        rightRecyclerView.setAdapter(rightAdapter);

        return inputView;
    }

    @NonNull
    private List<Picto> getTopPictos() {
        List<Picto> data = new ArrayList<>();
        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c", 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", 1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606", 2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606", 3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606", 4));
        data.add(new Picto(ctx, R.drawable.yes, "yes", "#2986cc", 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));

        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c", 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", 1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606", 2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606", 3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606", 4));
        data.add(new Picto(ctx, R.drawable.yes, "yes", "#2986cc", 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));



        return data;
    }

    @NonNull
    private List<Picto> getRightPictos() {
        List<Picto> data = new ArrayList<>();

        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", 1));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));




        return data;
    }



    @Override
    public void onStartInput(EditorInfo info, boolean restarting) {
        super.onStartInput(info, restarting);
        mInputConnection = getCurrentInputConnection();
    }
}



