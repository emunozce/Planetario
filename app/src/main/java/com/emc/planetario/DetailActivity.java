package com.emc.planetario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        // Receive information about the clicked planet
        Intent intent = getIntent();
        String planetName = intent.getStringExtra("planetName");
        int planetImageResId = intent.getIntExtra("planetImageResId", 0);

        // Set the planet name to the TextView
        TextView planetNameTextView = findViewById(R.id.textView);
        planetNameTextView.setText(planetName);

        // Set the planet image to the ImageView
        ImageView planetImageView = findViewById(R.id.imageView);
        planetImageView.setImageResource(planetImageResId);
    }
}
