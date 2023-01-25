package com.example.pictoboard_22_23;


import android.util.Log;
import android.view.View;
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

        switch (item.getType()) {
            case HELP:
                handleHelpClick(holder.itemView);
                break;
            case TTS:
                handleTTSClick(holder.itemView);
                break;
            case ERASE:
                handleEraseClick(holder.itemView);
                break;
            case ERASE_ALL:
                handleEraseAllClick(holder.itemView);
                break;
            case CATEGORY:
                handleCategoryClick(holder.itemView);
                break;
            case PICTO:
                handlePictoClick(holder.itemView);
                break;
            
            default:
                Log.e("MyKeyboardAdapter", "Unexpected value: " + item);
                break;
        }
    }

    private void handleHelpClick(View itemView) {
    }

    private void handleCategoryClick(View itemView) {
    }

    private void handleTTSClick(View itemView) {
    }

    /**
     * Handles click event for Picto type
     *
     * @param view the view that was clicked
     */
    private void handlePictoClick(View view) {
        view.setOnClickListener(v -> {
            mInputConnection.setComposingText(" " + ((Picto)view).getText(), 1);
            mInputConnection.finishComposingText();
        });
    }
    
    /**
     * Handles click event for Erase type
     *
     * @param view the view that was clicked
     */
    private void handleEraseClick(View view) {
        view.setOnClickListener(v -> {
            String text = mInputConnection.getTextBeforeCursor(50, 0).toString();

            int lastSpaceIndex = text.lastIndexOf(" ");

            if (lastSpaceIndex != -1) {
                mInputConnection.deleteSurroundingText(text.length() - lastSpaceIndex, 0);
            }
        });
    }

    /**
     * Handles click event for Erase All type
     *
     * @param view the view that was clicked
     */
    private void handleEraseAllClick(View view) {
        view.setOnClickListener(v -> mInputConnection.deleteSurroundingText(256, 0));
    }


}


