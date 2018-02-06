package com.simform.rushabhmodi.androidlearning.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.Objects;

/**
 * Created by rushabh.modi on 05/02/18.
 */

public class BaseDialogFragment extends DialogFragment {

    private String dialogType;
    AlertDialog.Builder dialogBuilder;
    CharSequence[] items = {"potato", "tomato"};

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialogType = getArguments().getString("DIALOG_TYPE");

        if (Objects.equals(dialogType, "Alert")) {
            Toast.makeText(getContext(), "Alert", Toast.LENGTH_SHORT).show();
            dialogBuilder = new AlertDialog.Builder(getActivity())
                    .setTitle("Alert Dialog")
                    .setIcon(R.drawable.ic_warning)
                    .setMessage("A custom message")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Pressed OK", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else if (Objects.equals(dialogType, "Custom")) {
            Toast.makeText(getContext(), "Custom", Toast.LENGTH_SHORT).show();
            dialogBuilder = new AlertDialog.Builder(getActivity())
                    .setView(R.layout.dialog_fragment_custom)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Pressed OK", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            Toast.makeText(getContext(), "List", Toast.LENGTH_SHORT).show();
            dialogBuilder = new AlertDialog.Builder(getActivity())
                    .setTitle("List Dialog")
                    .setItems(android.R.array.emailAddressTypes, null);
        }
        /*new AlertDialog.Builder(getActivity())
                .setView(R.layout.dialog_fragment_custom)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Pressed OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                    }
                }).create();*/

        return dialogBuilder.create();
    }

}
