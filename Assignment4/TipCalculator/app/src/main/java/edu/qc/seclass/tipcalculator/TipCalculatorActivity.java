package edu.qc.seclass.tipcalculator;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tipcalculator.R;
import com.google.android.material.textfield.TextInputEditText;

public class TipCalculatorActivity extends AppCompatActivity {

    double checkAmount;
    double partySize;
    Button computeButton;
    EditText tipValue15Percent;
    EditText tipValue20Percent;
    EditText tipValue25Percent;
    EditText totalValue15Percent;
    EditText totalValue20Percent;
    EditText totalValue25Percent;
    EditText checkAmountVal;
    EditText partySizeVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAmountVal = (EditText) findViewById(R.id.checkAmountValue);
        partySizeVal = (EditText) findViewById(R.id.partySizeValue);
        tipValue15Percent = (EditText) findViewById(R.id.fifteenPercentTipValue);
        tipValue20Percent = (EditText) findViewById(R.id.twentyPercentTipValue);
        tipValue25Percent = (EditText) findViewById(R.id.twentyfivePercentTipValue);
        totalValue15Percent = (EditText) findViewById(R.id.fifteenPercentTotalValue);
        totalValue20Percent = (EditText) findViewById(R.id.twentyPercentTotalValue);
        totalValue25Percent = (EditText) findViewById(R.id.twentyfivePercentTotalValue);
        computeButton = (Button) findViewById(R.id.buttonCompute);
        System.out.println("On Create Called");
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void onClick(View view) {
        if (checkAmountVal.getText().length() == 0) {
            Toast.makeText(this, "Enter a valid number for check amount.", Toast.LENGTH_LONG).show();
        } else if (partySizeVal.getText().length() == 0) {
            Toast.makeText(this, "Enter a valid number for the number of people.", Toast.LENGTH_LONG).show();
        } else if (!isNumeric(checkAmountVal.getText().toString())) {
            Toast.makeText(this, "Enter a number for check amount.", Toast.LENGTH_LONG).show();
        } else if (!isNumeric(partySizeVal.getText().toString())) {
            Toast.makeText(this, "Enter a number for the number of people.", Toast.LENGTH_LONG).show();
        } else if (Integer.valueOf(checkAmountVal.getText().toString()) <= 0) {
            Toast.makeText(this, "Enter a positive number for check amount.", Toast.LENGTH_LONG).show();
        } else if (Integer.valueOf(partySizeVal.getText().toString()) <= 0) {
            Toast.makeText(this, "Enter a positive number of people.", Toast.LENGTH_LONG).show();
        } else {
            checkAmount = Double.valueOf(checkAmountVal.getText().toString());
            partySize = Double.valueOf(partySizeVal.getText().toString());
            double TipsPerPerson = checkAmount / partySize;

            Integer Tip15PerPerson = (int) Math.ceil(TipsPerPerson * 0.15);
            Integer Tip20PerPerson = (int) Math.ceil(TipsPerPerson * 0.20);
            Integer Tip25PerPerson = (int) Math.ceil(TipsPerPerson * 0.25);

            Integer Total15PerPerson = (int) Math.ceil(TipsPerPerson + Tip15PerPerson);
            Integer Total20PerPerson = (int) Math.ceil(TipsPerPerson + Tip20PerPerson);
            Integer Total25PerPerson = (int) Math.ceil(TipsPerPerson + Tip25PerPerson);

            tipValue15Percent.setText(Tip15PerPerson.toString());
            tipValue20Percent.setText(Tip20PerPerson.toString());
            tipValue25Percent.setText(Tip25PerPerson.toString());
            totalValue15Percent.setText(Total15PerPerson.toString());
            totalValue20Percent.setText(Total20PerPerson.toString());
            totalValue25Percent.setText(Total25PerPerson.toString());

        }

        if (this.getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}


