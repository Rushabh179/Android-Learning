package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.ArrayList;

public class WidgetsExampleActivity extends AppCompatActivity {

    private Button widgetBtn;
    private ToggleButton widgetToggleBtn;
    private CheckBox widgetCheckBox;
    private RadioGroup widgetRadioGroup;
    private ImageButton widgetImageBtn;
    private Spinner widgetSpinner;
    private Switch widgetSwitch;

    private Toast widgetCustomToast;
    private LayoutInflater widgetLayoutInflater;
    private View widgetToastView;
    private TextView widgetToastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_example);

        widgetLayoutInflater = getLayoutInflater();

        widgetCustomToast = new Toast(this);
        widgetToastView = widgetLayoutInflater.inflate(R.layout.view_custom_toast, (ViewGroup) findViewById(R.id.constraintlayout_custom_toast), false);
        widgetCustomToast.setView(widgetToastView);
        widgetCustomToast.setGravity(Gravity.CENTER, 0, 0);
        widgetCustomToast.setDuration(Toast.LENGTH_LONG);

        widgetToastText = widgetToastView.findViewById(R.id.textview_custom_toast);

        widgetBtn = findViewById(R.id.btn_widget);
        widgetToggleBtn = findViewById(R.id.togglebtn_widget);
        widgetCheckBox = findViewById(R.id.checkbox_widget);
        widgetRadioGroup = findViewById(R.id.radiogroup_widget);
        widgetImageBtn = findViewById(R.id.imagebtn_widget);
        widgetSpinner = findViewById(R.id.spinner_widget);
        widgetSwitch = findViewById(R.id.switch_widget);

        widgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), getString(R.string.widget_btn_click), Toast.LENGTH_SHORT).show();
            }
        });

        widgetBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                widgetToastText.setText(getString(R.string.widget_btn_long_click));
                widgetCustomToast.show();
                return true;
            }
        });

        widgetToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    widgetToastText.setText(getString(R.string.widget_togglebtn_on));
                    widgetCustomToast.show();
                } else {
                    // The toggle is disabled
                    Toast.makeText(getBaseContext(), getString(R.string.widget_togglebtn_off), Toast.LENGTH_SHORT).show();

                }
            }
        });

        widgetCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    widgetToastText.setText(getString(R.string.widget_checkbox_checked));
                    widgetCustomToast.show();
                } else {
                    Toast.makeText(getBaseContext(), getString(R.string.widget_checkbox_unchecked), Toast.LENGTH_SHORT).show();
                }
            }
        });

        widgetRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radiobtn_widget_1) {
                    widgetToastText.setText(getString(R.string.widget_radiobtn_1));
                    widgetCustomToast.show();
                } else if (checkedId == R.id.radiobtn_widget_2) {
                    Toast.makeText(getBaseContext(), getString(R.string.widget_radiobtn_2), Toast.LENGTH_SHORT).show();
                }
            }
        });

        widgetImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), getString(R.string.widget_imagebtn_clicked), Toast.LENGTH_SHORT).show();
            }
        });

        widgetImageBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                widgetToastText.setText(getString(R.string.widget_imagebtn_long_clicked));
                widgetCustomToast.show();
                return true;
            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("--Select and item--");
        arrayList.add("Item 1");
        arrayList.add("item 2");
        arrayList.add("item 3");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        widgetSpinner.setAdapter(adapter);
        widgetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 1:
                        Toast.makeText(getBaseContext(), getString(R.string.widget_spinner_item1), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        widgetToastText.setText(getString(R.string.widget_spinner_item2));
                        widgetCustomToast.show();
                        break;
                    case 3:
                        widgetToastText.setText(getString(R.string.widget_spinner_item3));
                        widgetCustomToast.show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        widgetSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    widgetToastText.setText(getString(R.string.widget_switch_on));
                    widgetCustomToast.show();
                } else {
                    Toast.makeText(getBaseContext(), getString(R.string.widget_switch_off), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
