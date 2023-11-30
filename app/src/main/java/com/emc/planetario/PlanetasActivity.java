package com.emc.planetario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PlanetasActivity extends AppCompatActivity {
    private ImageView regreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sistema);

        regreso = findViewById(R.id.backButton);
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlanetasActivity.this, EleccionActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.sunImage).setOnClickListener(v -> {
            openDetailActivity(R.string.sun_info, R.drawable.sun);
        });
        findViewById(R.id.mercuryImage).setOnClickListener(v -> {
            openDetailActivity(R.string.mercurio_info, R.drawable.mercury);
        });
        findViewById(R.id.venusImage).setOnClickListener(v -> {
            openDetailActivity(R.string.venus_info, R.drawable.venus);
        });
        findViewById(R.id.tierraImage).setOnClickListener(v -> {
            openDetailActivity(R.string.tierra_info, R.drawable.earth);
        });
        findViewById(R.id.marteImage).setOnClickListener(v -> {
            openDetailActivity(R.string.marte_info, R.drawable.mars);
        });
        findViewById(R.id.jupiterImage).setOnClickListener(v -> {
            openDetailActivity(R.string.jupiter_info, R.drawable.jupiter);
        });
        findViewById(R.id.saturnoImage).setOnClickListener(v -> {
            openDetailActivity(R.string.saturno_info, R.drawable.saturn);
        });
        findViewById(R.id.uranoImage).setOnClickListener(v -> {
            openDetailActivity(R.string.urano_info, R.drawable.uranus);
        });
        findViewById(R.id.neptunoImage).setOnClickListener(v -> {
            openDetailActivity(R.string.neptuno_info, R.drawable.neptune);
        });
    }

    private void openDetailActivity(int planetInfo, int planetImageResId) {
        Intent intent = new Intent(PlanetasActivity.this, DetailActivity.class);
        String planetName = getString(planetInfo);
        intent.putExtra("planetName", planetName);
        intent.putExtra("planetImageResId", planetImageResId);
        startActivity(intent);
    }
}
