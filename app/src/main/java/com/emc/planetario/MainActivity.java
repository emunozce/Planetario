package com.emc.planetario;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static MediaPlayer mediaPlayer;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private boolean isShaking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Iniciar la música automáticamente
        startMusic();

        // Botón para iniciar la siguiente actividad
        Button inicio = findViewById(R.id.button);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EleccionActivity.class);
                startActivity(intent);
            }
        });

        // Inicializar el sensor y el sensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelerometer != null) {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
    }
    private void startMusic() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.musica);
            mediaPlayer.setLooping(true); // Repetir la música
            mediaPlayer.start();
        }
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMusic();

        // Se desregistra el listener para evitar leaks.
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    private void toggleMusic() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        double acceleration = Math.sqrt(x * x + y * y + z * z);
        if (acceleration > 30) {
            // Se detecta un shake
            if (!isShaking) {
                // Se empieza o se pause la musica
                toggleMusic();
                isShaking = true;

                // Se hace un delay para escuchar cada cierto tiempo.
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isShaking = false;
                    }
                }, 500); // 1/2 segundo de delay
            }
        }
    }
}
