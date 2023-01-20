package com.example.pictoboard_22_23;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pictoboard_22_23.ui.main.Picto;
import java.util.ArrayList;
import java.util.List;


public class MyInputMethodService extends InputMethodService{
    LayoutInflater inflater;
    Context ctx;

    @Override
    public View onCreateInputView() {
        ctx = getLayoutInflater().getContext();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inputView = inflater.inflate(R.layout.main_board, null);

        List<Picto> data = new ArrayList<>();
        data.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c", 0));
        data.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", 1));
        data.add(new Picto(ctx, R.drawable.read, "Read", "#d50606", 2));
        data.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606", 3));
        data.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606", 4));
        data.add(new Picto(ctx, R.drawable.yes, "yes", "#2986cc", 5));
        data.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));

        List<Picto> categories = new ArrayList<>();
        categories.add(new Picto(ctx, R.drawable.help, "Help", "#03c03c", 0));
        categories.add( new Picto(ctx, R.drawable.numbers, "Numbers", "#e6a91d", 1));
        categories.add(new Picto(ctx, R.drawable.read, "Read", "#d50606", 2));
        categories.add(new Picto(ctx, R.drawable.erase, "Erase", "#d50606", 3));
        categories.add(new Picto(ctx, R.drawable.erase_all, "Erase All", "#d50606", 4));
        categories.add(new Picto(ctx, R.drawable.yes, "yes", "#2986cc", 5));
        categories.add(new Picto(ctx, R.drawable.no, "No", "#2986cc", 6));


        RecyclerView recyclerView = inputView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);




        return inputView;
    }
}



