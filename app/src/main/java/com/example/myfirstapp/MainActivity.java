package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        Spinner spinner = (Spinner) findViewById(R.id.department_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.department_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
    public void clearText(int id){
        EditText tempId = findViewById( id);
        tempId.setText("");
    }
    public void resetFrom ( View view){
        clearText(R.id.Employee_ID_value);
        clearText(R.id.Name_value);
        clearText(R.id.Access_code_value);
        clearText(R.id.Confirm_code_value);
        // resetting checkboxes and redio buttions
        ((CheckBox) findViewById(R.id.checkbox_access)).setChecked(false);
        ((RadioButton) findViewById(R.id.radio_female)).setChecked(false);
        ((RadioButton) findViewById(R.id.radio_male)).setChecked(false);
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_access:
                if (checked){

                }
                // Put some meat on the sandwich
                else
                // Remove the meat
                break;
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    break;
            case R.id.radio_female:
                if (checked)
                    break;
        }
    }

}