package com.example.a11_2homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView out = (TextView) findViewById(R.id.outputDisplay);
        ImageView pic = (ImageView) findViewById(R.id.imgYear);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float payment = sharedPref.getFloat("key1", 0);
        int year = sharedPref.getInt("key2", 0);
        int amount = sharedPref.getInt("key3", 0);

        float interest = (payment * (year*12)) - amount;
                //total interest = (Monthly payment * num of months) - initial principal
        DecimalFormat money = new DecimalFormat("$###,###.00");
        out.setText("Total interest paid\n" + money.format(interest));

        if(year == 10) {
            pic.setImageResource(R.drawable.ten);
        } else if (year == 20) {
            pic.setImageResource(R.drawable.twenty);
        } else if (year == 30) {
            pic.setImageResource(R.drawable.thirty);
        }
    }
}
