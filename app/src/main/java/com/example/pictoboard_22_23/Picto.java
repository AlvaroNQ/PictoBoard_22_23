package com.example.pictoboard_22_23;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.pictoboard_22_23.enums.PictoType;

public class Picto extends LinearLayout {

    private FrameLayout.LayoutParams layoutParams;
    public ImageView imageView;
    private int image;
    public TextView textView;
    private final View line;
    private final Drawable rectangle;
    private String color;
    public int id;
    private PictoType type;


    public Picto(Context context, int resource, String text, String color, PictoType type, int id) {
        super(context);
        this.id = id;
        this.type = type;

        this.setClickable(true);

        this.rectangle = ContextCompat.getDrawable(context, R.drawable.rectangle);
        this.setBackground(this.rectangle);
        GradientDrawable myGrad = (GradientDrawable)this.getBackground();
        this.color = color;
        myGrad.setStroke(10, Color.parseColor(this.color));

        this.setOrientation(LinearLayout.VERTICAL);
        this.setGravity(Gravity.CENTER);
        this.setClickable(true);
        this.layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.layoutParams.setMargins(4,2,4,2);
        this.setLayoutParams(this.layoutParams);

        this.imageView = new ImageView(context);
        this.image = resource;
        this.imageView.setImageResource(image);
        this.layoutParams = new FrameLayout.LayoutParams(150, 150);
        this.layoutParams.setMargins(15,15,15,7);
        this.imageView.setLayoutParams(layoutParams);
        this.addView(this.imageView);

        this.line = new View(context);
        this.line.setId(View.generateViewId());
        this.layoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1);
        this.layoutParams.setMargins(30,7,30,0);
        this.line.setLayoutParams(layoutParams);
        this.line.setBackgroundResource(R.color.black);
        this.addView(this.line);

        this.textView = new TextView(context);
        this.textView.setId(View.generateViewId());
        this.layoutParams = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        this.layoutParams.setMargins(15,0,15,2);
        this.textView.setLayoutParams(layoutParams);
        this.textView.setText(text);
        this.textView.setTextSize(18);
        this.addView(this.textView);
    }

    public Picto(Context context) {
        super(context);

        this.setClickable(true);

        this.rectangle = ContextCompat.getDrawable(context, R.drawable.rectangle);
        this.setBackground(this.rectangle);
        GradientDrawable myGrad = (GradientDrawable)this.getBackground();
        myGrad.setStroke(10, Color.BLACK);

        this.setOrientation(LinearLayout.VERTICAL);
        this.setGravity(Gravity.CENTER);
        this.setClickable(true);
        this.layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.layoutParams.setMargins(4,2,4,2);
        this.setLayoutParams(this.layoutParams);

        this.imageView = new ImageView(context);
        this.imageView.setImageResource(R.drawable.ic_launcher_foreground);
        this.layoutParams = new FrameLayout.LayoutParams(150, 150);
        this.layoutParams.setMargins(15,15,15,7);
        this.imageView.setLayoutParams(layoutParams);
        this.addView(this.imageView);

        this.line = new View(context);
        this.line.setId(View.generateViewId());
        this.layoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1);
        this.layoutParams.setMargins(30,7,30,0);
        this.line.setLayoutParams(layoutParams);
        this.line.setBackgroundResource(R.color.black);
        this.addView(this.line);

        this.textView = new TextView(context);
        this.textView.setId(View.generateViewId());
        this.layoutParams = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        this.layoutParams.setMargins(15,0,15,2);
        this.textView.setLayoutParams(layoutParams);
        this.textView.setText(R.string.defaultText);
        this.textView.setTextSize(18);
        this.addView(this.textView);
    }

    public void setColor(String color){
        GradientDrawable myGrad = (GradientDrawable)this.getBackground();
        myGrad.setStroke(10, Color.parseColor(color));
        this.color = color;
    }

    public void setPicto(Picto picto){
        this.setColor(picto.getColor());
        this.setText(picto.getText());
        this.setImage(picto.image);
    }

    public String getColor(){
        return this.color;
    }

    public String getText(){
        return (String) this.textView.getText();
    }

    public void setText(String text){
        this.textView.setText(text);
    }

    public void setImage(int resource){
        this.imageView.setImageResource(resource);
        this.image = resource;
    }

    public PictoType getType() {
        return type;
    }
}
