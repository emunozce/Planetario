package mx.jjpg.proyecto_final;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private ImageView toggleMusic;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);

        // Obtener el botón para controlar la música
        toggleMusic = findViewById(R.id.btnToggleMusic);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean musicEnabled = sharedPreferences.getBoolean("musicEnabled", true);
        toggleMusic.setImageResource(musicEnabled ? R.drawable.volume_up : R.drawable.volume_off);
        toggleMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleMusic();
            }
        });

        Button planetario = findViewById(R.id.planetario);
        planetario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, PlanetarioActivity.class);
                startActivity(intent);
            }
        });
        Button preguntas = findViewById(R.id.preguntas);
        preguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
    private void toggleMusic() {
        MediaPlayer mediaPlayer = MainActivity.getMediaPlayer();
        if (mediaPlayer != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                toggleMusic.setImageResource(R.drawable.volume_off);
                editor.putBoolean("musicEnabled", false);
            } else {
                mediaPlayer.start();
                toggleMusic.setImageResource(R.drawable.volume_up);
                editor.putBoolean("musicEnabled", true);
            }
            editor.apply(); // Guardar los cambios en SharedPreferences
        }
    }
}

