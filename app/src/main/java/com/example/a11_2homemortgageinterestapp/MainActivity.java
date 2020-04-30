package com.example.a11_2homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float payment;
    int year;
    int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText payments = (EditText) findViewById(R.id.monthlyPayment);
        final EditText years = (EditText) findViewById(R.id.numYears);
        final EditText principal = (EditText) findViewById(R.id.initAmount);
        Button calc = (Button) findViewById(R.id.btnCalc);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment = Float.parseFloat(payments.getText().toString());
                year = Integer.parseInt(years.getText().toString());
                amount = Integer.parseInt(principal.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", payment);
                editor.putInt("key2", year);
                editor.putInt("key3", amount);
                editor.commit();
                startActivity(new Intent(MainActivity.this, results.class));
            }
        });
    }
}
