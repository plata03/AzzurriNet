package com.ildreamteamjsx.azzurrinet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class TeamSite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_site);

        WebView wv = findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);

        wv.setWebChromeClient(new WebChromeClient());

        String sito = getIntent().getStringExtra("url");
        wv.loadUrl(sito);

    }
}