package com.example.lab3;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView textMeterValue = (TextView) findViewById(R.id.textMeterValue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final TextView textView1 = (TextView) findViewById(R.id.textFeet);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        RadioButton meter = (RadioButton) findViewById(R.id.meter);
        RadioButton kilometer = (RadioButton) findViewById(R.id.kilometer);
        RadioButton centimeter = (RadioButton) findViewById(R.id.centimeter);
        RadioButton feet = (RadioButton) findViewById(R.id.feet);
        RadioButton mile = (RadioButton) findViewById(R.id.mile);
        RadioButton inch = (RadioButton) findViewById(R.id.inch);

        String selectedItem = parent.getItemAtPosition(position).toString();
        if (selectedItem.equals("English"))
        {
            meter.setText(R.string.meterE);
            kilometer.setText(R.string.kilometerE);
            centimeter.setText(R.string.centimeterE);
            feet.setText(R.string.feetE);
            mile.setText(R.string.mileE);
            inch.setText(R.string.inchE);
        }
        if (selectedItem.equals("Русский"))
        {
            meter.setText(R.string.meterR);
            kilometer.setText(R.string.kilometerR);
            centimeter.setText(R.string.centimeterR);
            feet.setText(R.string.feetR);
            mile.setText(R.string.mileR);
            inch.setText(R.string.inchR);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}