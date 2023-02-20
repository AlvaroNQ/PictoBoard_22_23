package com.example.pictoboard_22_23;


import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;

import java.util.List;


public class MyKeyboardAdapter extends MyAdapter<MyKeyboardAdapter.MyKeyboardViewHolder>{

    private final InputConnection mInputConnection;
    private final MyKeyboardCallback callback;

    public MyKeyboardAdapter(List<Picto> data, InputConnection mInputConnection, MyKeyboardCallback callback) {
        super(data);
        this.mInputConnection = mInputConnection;
        this.callback = callback;
    }

    @Override○
    protected MyKeyboardViewHolder instanceViewHolder(Picto view) {
        return new MyKeyboardViewHolder(view, this.mInputConnection, this.callback);
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

        view.setOnLongClickListener(v -> {
            Toast.makeText(view.getContext(), ((Picto)view).getText(), Toast.LENGTH_SHORT).show();
            return true;
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

    public static class MyKeyboardViewHolder extends MyViewHolder {
        private final MyKeyboardCallback callback;

        InputConnection mInputConnection;
        public MyKeyboardViewHolder(View itemView, InputConnection mInputConnection, MyKeyboardCallback callback) {
            super(itemView);
            this.mInputConnection = mInputConnection;
            this.callback = callback;
            itemView.setOnClickListener(v -> onClick());
            itemView.setOnLongClickListener(v -> onLongClick());

        }

        private boolean onLongClick() {
            return true;
        }

        private void onClick() {
            switch (picto.getType()) {
                case HELP:
                    handleHelpClick(picto);
                    break;
                case TTS:
                    handleTTSClick(picto);
                    break;
                case ERASE:
                    handleEraseClick();
                    break;
                case ERASE_ALL:
                    handleEraseAllClick(picto);
                    break;
                case CATEGORY:
                    handleCategoryClick(picto);
                    break;
                case PICO:
                    handlePictoClick(picto);
                    break;

                default:
                    Log.e("MyKeyboardAdapter", "Unexpected value: " + picto);
                    break;
            }
        }


        private void handleEraseClick() {

            String text = mInputConnection.getTextBeforeCursor(50, 0).toString();

            int lastSpaceIndex = text.lastIndexOf(" ");

            if (lastSpaceIndex != -1) {
                mInputConnection.deleteSurroundingText(text.length() - lastSpaceIndex, 0);
            }
            callback.onEraseClicked();
        }
    }
}