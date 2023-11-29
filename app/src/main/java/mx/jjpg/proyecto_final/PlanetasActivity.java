package mx.jjpg.proyecto_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                Intent intent = new Intent(PlanetasActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.sunImage).setOnClickListener(v -> {
            openDetailActivity("Sun", R.drawable.sun);
        });
        findViewById(R.id.mercuryImage).setOnClickListener(v -> {
            openDetailActivity("Mercurio", R.drawable.mercury);
        });
        findViewById(R.id.venusImage).setOnClickListener(v -> {
            openDetailActivity("Venus", R.drawable.venus);
        });
        findViewById(R.id.tierraImage).setOnClickListener(v -> {
            openDetailActivity("Tierra", R.drawable.earth);
        });
        findViewById(R.id.marteImage).setOnClickListener(v -> {
            openDetailActivity("Marte", R.drawable.mars);
        });
        findViewById(R.id.jupiterImage).setOnClickListener(v -> {
            openDetailActivity("Jupiter", R.drawable.jupiter);
        });
        findViewById(R.id.saturnoImage).setOnClickListener(v -> {
            openDetailActivity("Saturno", R.drawable.saturn);
        });
        findViewById(R.id.uranoImage).setOnClickListener(v -> {
            openDetailActivity("Neptuno", R.drawable.uranus);
        });
        findViewById(R.id.neptunoImage).setOnClickListener(v -> {
            openDetailActivity("Neptuno", R.drawable.neptune);
        });
    }

    private void openDetailActivity(String planetName, int planetImageResId) {
        Intent intent = new Intent(PlanetasActivity.this, DetailActivity.class);
        intent.putExtra("planetName", planetName);
        intent.putExtra("planetImageResId", planetImageResId);
        startActivity(intent);
    }
}
