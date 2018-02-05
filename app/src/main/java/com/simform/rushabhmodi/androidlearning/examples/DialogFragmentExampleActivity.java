package com.simform.rushabhmodi.androidlearning.examples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.fragment.AlertDialogFragment;
import com.simform.rushabhmodi.androidlearning.fragment.CustomDialogFragment;

public class DialogFragmentExampleActivity extends AppCompatActivity implements View.OnClickListener{

    private Button alertDialogBtn, customDialogBtn;
    private Fragment dialogFragment;
    private FragmentManager dialogFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment_example);

        alertDialogBtn = findViewById(R.id.btn_alert_dialog);
        customDialogBtn = findViewById(R.id.btn_custom_dialog);

        alertDialogBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dialogFragmentManager = getSupportFragmentManager();
        dialogFragment = dialogFragmentManager.findFragmentByTag(getString(R.string.dialog_fragment_tag));
        if(dialogFragment!=null)
            dialogFragmentManager.beginTransaction().remove(dialogFragment).commit();

        switch (view.getId()){
            case R.id.btn_alert_dialog:
                AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
                alertDialogFragment.show(dialogFragmentManager, getString(R.string.dialog_fragment_tag));
                break;
            case R.id.btn_custom_dialog:
                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.show(dialogFragmentManager, getString(R.string.dialog_fragment_tag));
                break;
        }
    }
}
