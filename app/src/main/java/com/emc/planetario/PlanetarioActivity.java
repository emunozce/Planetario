package com.emc.planetario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetarioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planetario);

        Button galaxias = findViewById(R.id.button_galaxias_activity);
        galaxias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanetarioActivity.this, GalaxiasActivity.class);
                startActivity(intent);
            }
        });
        Button planetas = findViewById(R.id.button_planetas_activity);
        planetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanetarioActivity.this, PlanetasActivity.class);
                startActivity(intent);
            }
        });
    }
}

