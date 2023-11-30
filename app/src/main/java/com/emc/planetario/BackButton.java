package com.emc.planetario;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;


public class BackButton extends AppCompatImageView {
    public BackButton(Context context) {
        super(context);
        init();
    }

    public BackButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BackButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Manejar el clic para regresar aquí
                if (getContext() instanceof AppCompatActivity) {
                    ((AppCompatActivity) getContext()).onBackPressed();
                }
            }
        });
    }
}
