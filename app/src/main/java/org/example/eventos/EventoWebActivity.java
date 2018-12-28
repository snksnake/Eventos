package org.example.eventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class EventoWebActivity extends AppCompatActivity {

    WebView navegador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_web);
        navegador = (WebView) findViewById(R.id.webkit);
        navegador.loadUrl("https://eventos-51c1f.firebaseapp.com/index.html");
    }
}
