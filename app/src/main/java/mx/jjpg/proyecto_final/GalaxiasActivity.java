package mx.jjpg.proyecto_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GalaxiasActivity extends AppCompatActivity {
    private ImageView regreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galaxias);

        regreso = findViewById(R.id.backButton);
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GalaxiasActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
