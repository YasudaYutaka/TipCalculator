package com.yutaka.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextTotal;
    SeekBar seekBarTip, seekBarSplit;
    TextView textViewTipValue, textViewTotalValue, textViewTipPersonValue, textViewTotalPersonValue;
    TextView textViewTipPercent, textViewSplitPersonQuantity;
    double percent = 0;

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

                percent = i;
                textViewTipPercent.setText(Math.round(percent) + "%"); // arredonda o número

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    

}