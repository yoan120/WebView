package com.yoan.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText urlEditText;
    private WebView webView;
    private Button tampilkanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen UI
        urlEditText = findViewById(R.id.urlEditText);
        webView = findViewById(R.id.webView1);
        tampilkanButton = findViewById(R.id.tampilkanButton);

        // Aktifkan JavaScript agar WebView bisa menampilkan halaman dengan benar
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // Event listener untuk tombol "Tampilkan"
        tampilkanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUrl();
            }
        });
    }

    private void loadUrl() {
        String url = urlEditText.getText().toString().trim();

        // Pastikan URL memiliki prefix http/https
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        webView.loadUrl(url);
    }
}
