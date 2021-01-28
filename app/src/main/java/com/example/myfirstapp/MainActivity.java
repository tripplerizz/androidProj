package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);

        Spinner spinner = (Spinner) findViewById(R.id.department_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.department_choices, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
    //reseting functions
    public void clearText(int id){
        EditText tempId = findViewById( id);
        tempId.setText("");
    }
    public void resetFrom (View view){
        clearText(R.id.Employee_ID_value);
        clearText(R.id.Name_value);
        clearText(R.id.Access_code_value);
        clearText(R.id.Confirm_code_value);
        clearText(R.id.Email_value);
        // resetting checkboxes and redio buttions
        ((CheckBox) findViewById(R.id.checkbox_access)).setChecked(false);
        ((RadioButton) findViewById(R.id.radio_female)).setChecked(false);
        ((RadioButton) findViewById(R.id.radio_male)).setChecked(false);
        correctHighlight(R.id.Email_text);
        correctHighlight(R.id.Name_text);
        correctHighlight(R.id.Email_text);
        correctHighlight(R.id.Access_text);
        correctHighlight(R.id.Confirm_text);
    }
    //submit functions
    public String getStringValue(int id){
        EditText temp = findViewById(id);
        String word = temp.getText().toString();
        return word;
    }
    public boolean checkEmpValues(String val){
        //checking charectors
        for (int i =0 ; i<val.length();i++){
            char letter = val.charAt(i);
            if (!Character.isLetterOrDigit(letter)){
                return false;
            }
            if (Character.isLetter(letter)){
                if (!Character.isUpperCase(letter)){
                    return false;
                }
            }
        }
        // checking if id matches res
        Resources res = getResources();
        String[] IDs = res.getStringArray(R.array.EmpId);
        for (String emp_id: IDs){
            if (emp_id.equals(val)){
                return true;
            }
        }
        return false;
    }
    public boolean checkName(String Name){
        String [] list;
        list = Name.split(" ");
        for (String val: list){
            if (!Character.isUpperCase(val.charAt(0))){
               return false;
            }
        }
        return true;
    }
    public void submitForm(View view) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = null;
        if (checkForm()){
            CharSequence text = "Information stored in database!";
            toast = Toast.makeText(context, text, duration);
        }
        else{
            CharSequence text = "Incorrect input... please re-enter";
            toast = Toast.makeText(context, text, duration);
        }
        toast.show();
    }
    public void errorHighlight(int id){
        TextView temp =  findViewById(id);
        temp.setTextColor(0xFFD30D0D);
    }
    public void correctHighlight(int id){
        TextView temp =  findViewById(id);
        temp.setTextColor(0xFF090909);

    }
    public boolean checkForm(){
        boolean success = true;
        // getting string value
        String EmpId = getStringValue(R.id.Employee_ID_value);
        if (!checkEmpValues(EmpId) || EmpId.equals("")){
            errorHighlight(R.id.Employe_ID_text);
            success = false;
        }
        else{
            correctHighlight(R.id.Employe_ID_text);
        }
        String Name = getStringValue(R.id.Name_value);
        if ( Name.equals("") || !checkName(Name) ){
            errorHighlight(R.id.Name_text);
            success  =  false;
        }
        else{
            correctHighlight(R.id.Name_text);
        }
        String Email = getStringValue(R.id.Email_value);
        if (Email.equals("")){
            errorHighlight(R.id.Email_text);
           success  =  false;
        }
        else{
            correctHighlight(R.id.Email_text);
        }
        String AccessCode = getStringValue(R.id.Access_code_value);
        if (AccessCode.equals("")){
            errorHighlight(R.id.Access_text);
            success  =  false;
        }
        else{
            correctHighlight(R.id.Access_text);
        }
        String ConfirmCode = getStringValue(R.id.Confirm_code_value);
        if (ConfirmCode.equals("")){
            errorHighlight(R.id.Confirm_text);
           success  =  false;
        }
        else{
            correctHighlight(R.id.Confirm_text);
        }
        return success;
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