package com.example.lab3;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Value value;
    List<TextView> textViewList = new ArrayList<>();
    RadioButton meter;
    RadioButton kilometer;
    RadioButton centimeter;
    RadioButton feet;
    RadioButton mile;
    RadioButton inch;
    TextView language;
    TextView textMeter;
    TextView textMiles;
    TextView textFeet;
    TextView textCentimeter;
    TextView textKilometer;
    TextView textInch;


    static Locale enLocale = new Locale("en");
    static Locale ruLocale = new Locale("ru");
    static Configuration enConfig = new Configuration();
    static Configuration ruConfig = new Configuration();
    static String tmp = "Русский";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        if (tmp == "Русский") spinner.setSelection(1);
        textMeter = (TextView) findViewById(R.id.textMeter);
        textViewList.add(textMeter);
        textMiles = (TextView) findViewById(R.id.textMile);
        textViewList.add(textMiles);
        textFeet = (TextView) findViewById(R.id.textFeet);
        textViewList.add(textFeet);
        textCentimeter = (TextView) findViewById(R.id.textCentimeter);
        textViewList.add(textCentimeter);
        textKilometer = (TextView) findViewById(R.id.textKilometer);
        textViewList.add(textKilometer);
        textInch = (TextView) findViewById(R.id.textInch);
        textViewList.add(textInch);

        Locale.setDefault(enLocale);
        enConfig.locale = enLocale;
        ruConfig.locale = ruLocale;


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.meter:
                        value = Value.METER;
                        break;
                    case R.id.kilometer:
                        value = Value.KILOMETER;
                        break;
                    case R.id.centimeter:
                        value = Value.CENTIMETER;
                        break;
                    case R.id.feet:
                        value = Value.FEET;
                        break;
                    case R.id.mile:
                        value = Value.MILE;
                        break;
                    case R.id.inch:
                        value = Value.INCH;
                        break;
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, final long id) {
        meter = (RadioButton) findViewById(R.id.meter);
        kilometer = (RadioButton) findViewById(R.id.kilometer);
        centimeter = (RadioButton) findViewById(R.id.centimeter);
        feet = (RadioButton) findViewById(R.id.feet);
        mile = (RadioButton) findViewById(R.id.mile);
        inch = (RadioButton) findViewById(R.id.inch);
        language = (TextView) findViewById(R.id.language);
        TextView textMeterValue = (TextView) findViewById(R.id.textMeterValue);
        TextView textMilesValue = (TextView) findViewById(R.id.textMilesValue);
        TextView textFeetValue = (TextView) findViewById(R.id.textFeetValue);
        TextView textCentimeterValue = (TextView) findViewById(R.id.textCentimeterValue);
        TextView textKilometerValue = (TextView) findViewById(R.id.textKilometerValue);
        TextView textInchValue = (TextView) findViewById(R.id.textInchValue);
        final String selectedItem = parent.getItemAtPosition(position).toString();
        final EditText editText = (EditText) findViewById(R.id.editTextText);
        String valueLanguage = selectedItem;

        if (selectedItem.equals("English") && tmp == "Русский") {
            tmp = "English";
            getBaseContext().getResources().updateConfiguration(enConfig, null);
            Intent refresh = new Intent(this, MainActivity.class);
            finish();
            startActivity(refresh);
        }
            /*meter.setText(R.string.meter);
            kilometer.setText(R.string.kilometer);
            centimeter.setText(R.string.centimeter);
            feet.setText(R.string.feet);
            mile.setText(R.string.mile);
            inch.setText(R.string.inch);
            language.setText(R.string.language);
            textMeterValue.setText(R.string.meter);
            textMilesValue.setText(R.string.mile);
            textFeetValue.setText(R.string.feet);
            textCentimeterValue.setText(R.string.centimeter);
            textKilometerValue.setText(R.string.kilometer);
            textInchValue.setText(R.string.inch);
            editText.setText(editText.getText().toString().replace(",", "."));
            for (TextView t : textViewList) {
                t.setText(t.getText().toString().replace(",", "."));
            }*/


        if (selectedItem.equals("Русский") && tmp == "English") {
            tmp = "Русский";
            getBaseContext().getResources().updateConfiguration(ruConfig, null);
            Intent refresh = new Intent(this, MainActivity.class);
            finish();
            startActivity(refresh);
        }
           /* meter.setText(R.string.meterR);
            kilometer.setText(R.string.kilometerR);
            centimeter.setText(R.string.centimeterR);
            feet.setText(R.string.feetR);
            mile.setText(R.string.mileR);
            inch.setText(R.string.inchR);
            language.setText(R.string.languageR);
            language.setText(R.string.languageR);
            textMeterValue.setText(R.string.meterR);
            textMilesValue.setText(R.string.mileR);
            textFeetValue.setText(R.string.feetR);
            textCentimeterValue.setText(R.string.centimeterR);
            textKilometerValue.setText(R.string.kilometerR);
            textInchValue.setText(R.string.inchR);
            editText.setText(editText.getText().toString().replace(".", ","));
            for (TextView t : textViewList) {
                t.setText(t.getText().toString().replace(".", ","));
            }
        }*/

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (selectedItem.equals("English") && !editText.getText().toString().equals("")) {
                    String tmp = String.valueOf(editText.getText()).replace(",", ".");
                    countValue(Double.parseDouble(tmp));
                }
                if (selectedItem.equals("Русский") && !editText.getText().toString().equals("")) {
                    Double tmp = Double.parseDouble(String.valueOf(editText.getText()).replace(',', '.'));
                    countValue(tmp);
                    for (TextView t : textViewList) {
                        t.setText(t.getText().toString().replace(".", ","));
                    }
                }
            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void countValue(Double editTextValue) {

        Double meterValue = editTextValue * value.getMeterValue();

        Double tmpValue = meterValue * Value.METER.getValue();
        textMeter.setText(tmpValue.toString());

        tmpValue = meterValue * Value.CENTIMETER.getValue();
        textCentimeter.setText(tmpValue.toString());

        tmpValue = meterValue * Value.KILOMETER.getValue();
        textKilometer.setText(tmpValue.toString());

        tmpValue = meterValue * Value.FEET.getValue();
        textFeet.setText(tmpValue.toString());

        tmpValue = meterValue * Value.MILE.getValue();
        textMiles.setText(tmpValue.toString());

        tmpValue = meterValue * Value.INCH.getValue();
        textInch.setText(tmpValue.toString());

    }
}