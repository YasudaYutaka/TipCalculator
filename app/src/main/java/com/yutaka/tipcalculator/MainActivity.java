package com.yutaka.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextTotal;
    SeekBar seekBarTip, seekBarSplit;
    TextView textViewTipValue, textViewTotalValue, textViewTipPersonValue, textViewTotalPersonValue;
    TextView textViewTipPercent, textViewSplitPersonQuantity;
    double percent = 0;
    int people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTotal                   = findViewById(R.id.editTextTotal);
        seekBarTip                      = findViewById(R.id.seekBarTip);
        seekBarSplit                    = findViewById(R.id.seekBarSplit);
        textViewTipValue                = findViewById(R.id.textViewTipValue);
        textViewTotalValue              = findViewById(R.id.textViewTotalValue);
        textViewTipPersonValue          = findViewById(R.id.textViewTipPersonValue);
        textViewTotalPersonValue        = findViewById(R.id.textViewTotalPersonValue);
        textViewTipPercent              = findViewById(R.id.textViewTipPercent);
        textViewSplitPersonQuantity     = findViewById(R.id.textViewSplitPersonQuantity);


        // Listener seekBarTip
        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

               // percent = i;
                textViewTipPercent.setText(Math.round(i) + "%"); // arredonda o número
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Listener seekBarSplit
        seekBarSplit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //people = i;
                textViewSplitPersonQuantity.setText(Integer.toString(i));
                calculate(); // maybe ?
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        editTextTotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void calculate() {

        String sValue = editTextTotal.getText().toString();
        if(sValue.equals("") || sValue == null) {

            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);

        } else {

            double dValue = Double.parseDouble(sValue);
            //seekBarSplit.getProgress();
            percent = seekBarTip.getProgress();
            double dTip = dValue * (percent / 100);
            double dTotal = dValue + dTip;
            textViewTipValue.setText("$" + String.format("%.2f", dTip));
            textViewTotalValue.setText("$" + String.format("%.2f", dTotal));

            // split part
            people = seekBarSplit.getProgress();
            double dTipValuePerson = dTip / people;
            double dTotalValuePerson = dTotal / people;
            textViewTipPersonValue.setText("$" + String.format("%.2f", dTipValuePerson));
            textViewTotalPersonValue.setText("$" + String.format("%.2f", dTotalValuePerson));

        }

    }

}