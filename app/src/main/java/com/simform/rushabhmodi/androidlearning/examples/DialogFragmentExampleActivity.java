package com.simform.rushabhmodi.androidlearning.examples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.fragment.BaseDialogFragment;

public class DialogFragmentExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alertDialogBtn, customDialogBtn, listDialogBtn;
    private Fragment dialogFragment;
    private FragmentManager dialogFragmentManager;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        alertDialogBtn = findViewById(R.id.btn_alert_dialog);
        customDialogBtn = findViewById(R.id.btn_custom_dialog);
        listDialogBtn = findViewById(R.id.btn_list_dialog);

        alertDialogBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);
        listDialogBtn.setOnClickListener(this);

        bundle = new Bundle();
        dialogFragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View view) {
        dialogFragment = dialogFragmentManager.findFragmentByTag(getString(R.string.dialog_fragment_tag));
        if (dialogFragment != null)
            dialogFragmentManager.beginTransaction().remove(dialogFragment).commit();

        BaseDialogFragment baseDialogFragment = new BaseDialogFragment();

        switch (view.getId()) {
            case R.id.btn_alert_dialog:
                bundle.putString(getString(R.string.dialog_type_tag), getString(R.string.dialog_type_alert));
                break;
            case R.id.btn_custom_dialog:
                bundle.putString(getString(R.string.dialog_type_tag), getString(R.string.dialog_type_custom));
                break;
            case R.id.btn_list_dialog:
                bundle.putString(getString(R.string.dialog_type_tag), getString(R.string.dialog_type_list));
        }

        baseDialogFragment.setArguments(bundle);
        baseDialogFragment.show(dialogFragmentManager, getString(R.string.dialog_fragment_tag));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }
}
