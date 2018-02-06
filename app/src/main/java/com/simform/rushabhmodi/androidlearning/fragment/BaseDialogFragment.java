package com.simform.rushabhmodi.androidlearning.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.Objects;

/**
 * Created by rushabh.modi on 05/02/18.
 */

public class BaseDialogFragment extends DialogFragment {

    private String dialogType;
    private AlertDialog.Builder dialogBuilder;

    private EditText usernameEditText;
    private LayoutInflater layoutInflater;
    private View view;
    private String[] items = new String[]{"Item 1", "Item 2", "Item 3"};

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialogType = getArguments().getString(getString(R.string.dialog_type_tag));

        layoutInflater = getActivity().getLayoutInflater();
        view = layoutInflater.inflate(R.layout.dialog_fragment_custom, null);
        usernameEditText = view.findViewById(R.id.edittext_custom_dialog_username);

        if (Objects.equals(dialogType, getString(R.string.dialog_type_alert))) {
            dialogBuilder = new AlertDialog.Builder(getActivity())
                    .setTitle("Alert Dialog")
                    .setIcon(R.drawable.ic_warning)
                    .setMessage("A custom message")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Pressed Ok", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else if (Objects.equals(dialogType, getString(R.string.dialog_type_custom))) {
            dialogBuilder = new AlertDialog.Builder(getActivity())
                    .setTitle("Custom Dialog")
                    .setView(view)
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getActivity(), "Hi "+ usernameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
        } else if (Objects.equals(dialogType, getString(R.string.dialog_type_list))) {
            dialogBuilder = new AlertDialog.Builder(getActivity())
                    .setTitle("List Dialog")
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            Toast.makeText(getActivity(), "item "+ Integer.toString(which+1), Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        return dialogBuilder.create();
    }
}
