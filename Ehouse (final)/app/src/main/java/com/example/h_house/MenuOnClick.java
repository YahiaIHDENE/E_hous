package com.example.h_house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOnClick extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_on_click);

        Button LEDs = (Button) findViewById(R.id.LEDs);
        LEDs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOnClick.this, LedOnClick.class));
            }
        });

        final Button temperature = (Button) findViewById(R.id.Temperature);
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuOnClick.this, temperature.class));
            }
        });

        Button Bruit = (Button) findViewById(R.id.Bruit);
        Bruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOnClick.this, BruitOnClick.class));
            }
        });

        Button Garage = (Button) findViewById(R.id.Garage);
        Garage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOnClick.this, PorteOnClick.class));
            }
        });

        Button fumee = (Button) findViewById(R.id.fumée);
        fumee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOnClick.this, FumeeOnClick.class));

            }
        });

        Button ventilation = (Button) findViewById(R.id.Ventilation);
        ventilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOnClick.this, VentilationOnClick.class));
            }
        });



    }

}
