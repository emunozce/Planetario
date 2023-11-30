package com.emc.planetario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GalaxiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galaxias);

        findViewById(R.id.galaxia_eliptica).setOnClickListener(v -> {
            openDetailActivity(R.string.eliptica_info, R.drawable.galaxy_eliptica);
        });

        findViewById(R.id.galaxia_enana).setOnClickListener(v -> {
            openDetailActivity(R.string.enana_info, R.drawable.galaxia_enana);
        });

        findViewById(R.id.galaxia_irregular).setOnClickListener(v -> {
            openDetailActivity(R.string.irregular_info, R.drawable.galaxia_irregular);
        });

        findViewById(R.id.agujero_negro).setOnClickListener(v -> {
            openDetailActivity(R.string.agujero_info, R.drawable.hoyo_negro);
        });
    }

    private void openDetailActivity(int planetInfo, int planetImageResId) {
        Intent intent = new Intent(GalaxiasActivity.this, DetailActivity.class);
        String planetName = getString(planetInfo);
        intent.putExtra("planetName", planetName);
        intent.putExtra("planetImageResId", planetImageResId);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, EleccionActivity.class);
        startActivity(intent);
        finish();
    }
}
