package com.emc.planetario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HighScoreActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_score);

        Intent intent = getIntent();
        int puntaje = intent.getIntExtra("puntaje", 0);

        TextView puntajeTxt = findViewById(R.id.puntaje);

        puntajeTxt.setText(puntaje + " puntos");
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, EleccionActivity.class);
        startActivity(intent);
        finish();
    }
}
