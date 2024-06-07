package com.ildreamteamjsx.azzurrinet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class TeamDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        ImageView img = findViewById(R.id.logo);
        TextView nome = findViewById(R.id.titolo);
        TextView citta = findViewById(R.id.citta);
        TextInputEditText city = findViewById(R.id.desc);

        nome.setText(getIntent().getStringExtra("name"));
        city.setText(getIntent().getStringExtra("desc"));
        citta.setText(getIntent().getStringExtra("city"));
        img.setImageResource(getIntent().getIntExtra("logo", 0));

        int color = Color.parseColor(getIntent().getStringExtra("color"));

        img.setBackgroundColor(color);

        String url = getIntent().getStringExtra("link");
        Button sitobutton = findViewById(R.id.bottonesito);

        sitobutton.setOnClickListener(v -> {
            Intent intento = new Intent(TeamDetail.this, TeamSite.class);
            intento.putExtra("url", url);
            startActivity(intento);
        });

    }
}