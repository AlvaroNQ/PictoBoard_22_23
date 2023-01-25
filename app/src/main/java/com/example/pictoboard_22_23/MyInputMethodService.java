package com.example.pictoboard_22_23;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pictoboard_22_23.enums.PictoType;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;


public class MyInputMethodService extends InputMethodService{
    LayoutInflater inflater;
    Context ctx;

    @Override
    public View onCreateInputView() {
        ctx = getLayoutInflater().getContext();
        InputConnection mInputConnection = getCurrentInputConnection();

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inputView = View.inflate(ctx,R.layout.main_board, null);

        List<Picto> topData = getTopPictos();

        RecyclerView topRecyclerView = inputView.findViewById(R.id.top_block);
        LinearLayoutManager topLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topRecyclerView.setLayoutManager(topLayoutManager);

        MyAdapter topAdapter = new myKeyboardAdapter(topData, mInputConnection);
        topRecyclerView.setAdapter(topAdapter);


        List<Picto> leftData = getCategories();

        RecyclerView leftRecyclerView = inputView.findViewById(R.id.left_block);
        FlexboxLayoutManager leftLayoutManager = new FlexboxLayoutManager(this);
        leftLayoutManager.setFlexDirection(FlexDirection.COLUMN);
        leftLayoutManager.setFlexWrap(FlexWrap.NOWRAP);


        leftRecyclerView.setLayoutManager(leftLayoutManager);
        MyAdapter leftAdapter = new myKeyboardAdapter(leftData, mInputConnection);
        leftRecyclerView.setAdapter(leftAdapter);


        List<Picto> rightData = getPictos();

        RecyclerView rightRecyclerView = inputView.findViewById(R.id.right_block);
        FlexboxLayoutManager rightLayoutManager = new FlexboxLayoutManager(this);
        rightLayoutManager.setFlexDirection(FlexDirection.ROW);
        rightLayoutManager.setJustifyContent(JustifyContent.CENTER);
        rightLayoutManager.setAlignItems(AlignItems.FLEX_START);

        rightRecyclerView.setLayoutManager(rightLayoutManager);

        MyAdapter rightAdapter = new myKeyboardAdapter(rightData, mInputConnection);
        rightRecyclerView.setAdapter(rightAdapter);

        return inputView;
    }

    @NonNull
    private List<Picto> getTopPictos() {
        List<Picto> data = new ArrayList<>();
        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c", PictoType.HELP, 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", PictoType.CATEGORY,1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606", PictoType.TTS,2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606", PictoType.ERASE,3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606",PictoType.ERASE_ALL, 4));
        data.add(new Picto(ctx, R.drawable.yes, "Yes", "#2986cc",PictoType.PICTO, 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc",PictoType.PICTO, 6));

        return data;
    }

    @NonNull
    private List<Picto> getCategories() {
        List<Picto> data = new ArrayList<>();
        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c", PictoType.CATEGORY, 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", PictoType.CATEGORY,1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606", PictoType.CATEGORY,2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606", PictoType.CATEGORY,3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606",PictoType.CATEGORY, 4));
        data.add(new Picto(ctx, R.drawable.yes, "Yes", "#2986cc",PictoType.CATEGORY, 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc",PictoType.CATEGORY, 6));

        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c",PictoType.CATEGORY, 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d",PictoType.CATEGORY, 1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606",PictoType.CATEGORY, 2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606",PictoType.CATEGORY, 3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606",PictoType.CATEGORY, 4));
        data.add(new Picto(ctx, R.drawable.yes, "Yes", "#2986cc",PictoType.CATEGORY, 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc",PictoType.CATEGORY, 6));

        return data;
    }

    @NonNull
    private List<Picto> getPictos() {
        List<Picto> data = new ArrayList<>();
        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c", PictoType.PICTO, 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", PictoType.PICTO,1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606", PictoType.PICTO,2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606", PictoType.PICTO,3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606",PictoType.PICTO, 4));
        data.add(new Picto(ctx, R.drawable.yes, "Yes", "#2986cc",PictoType.PICTO, 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc",PictoType.PICTO, 6));

        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c",PictoType.PICTO, 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d",PictoType.PICTO, 1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606",PictoType.PICTO, 2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606",PictoType.PICTO, 3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606",PictoType.PICTO, 4));
        data.add(new Picto(ctx, R.drawable.yes, "Yes", "#2986cc",PictoType.PICTO, 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc",PictoType.PICTO, 6));

        return data;
    }




}



