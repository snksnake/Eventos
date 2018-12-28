package org.example.eventos;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class EventosWeb extends AppCompatActivity {

    WebView navegador;
    private ProgressBar barraProgreso;
    final InterfazComunicacion miInterfazJava = new InterfazComunicacion(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventos_web);
        navegador = (WebView) findViewById(R.id.webkit);
        navegador.getSettings().setJavaScriptEnabled(true);




        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.getSettings().setBuiltInZoomControls(false);

        //navegador.loadUrl("https://eventos-51c1f.firebaseapp.com/index.html");
        navegador.loadUrl("file:///android_asset/index.html");

        navegador.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String url_filtro = "http://www.androidcurso.com/";
                if (!url.toString().equals(url_filtro)) {
                    view.loadUrl(url_filtro);
                }
                return false;
            }
        });
        barraProgreso = (ProgressBar) findViewById(R.id.barraProgreso);
        navegador.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progreso) {
                barraProgreso.setProgress(0);
                barraProgreso.setVisibility(View.VISIBLE);
                EventosWeb.this.setProgress(progreso * 1000);
                barraProgreso.incrementProgressBy(progreso);
                if (progreso == 100) {
                    barraProgreso.setVisibility(View.GONE);
                }
            }
        });

        navegador.addJavascriptInterface(miInterfazJava, "jsInterfazNativa");
    }

    public class InterfazComunicacion {
        Context mContext;
        InterfazComunicacion(Context c) {
            mContext = c;
        }
        @JavascriptInterface
        public void volver(){
            finish();
        }
    }
}
