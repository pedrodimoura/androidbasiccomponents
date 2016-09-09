package com.fafica.aulaviews.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.fafica.aulaviews.R;
import com.fafica.aulaviews.util.Constants;

/**
 * Created by pedrodimoura on 06/09/16.
 */

public class MyAlertDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return
                new AlertDialog.Builder(getActivity())
                        .setIcon(R.drawable.ic_planet)
                        .setTitle(getResources().getString(R.string.progress_dialog_title))
                        .setMessage(getResources().getString(R.string.progress_dialog_message))
                        .setPositiveButton(R.string.button_positive, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.d(Constants.DEBUG_KEY, "onClick | positiveButton -> " + dialogInterface + ", i -> " + i);
                            }
                        })
                        .setNegativeButton(R.string.button_negative, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.d(Constants.DEBUG_KEY, "onClick | negativeButton -> " + dialogInterface + ", i -> " + i);
                            }
                        })
                        .create();
    }
}
