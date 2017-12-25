package com.android.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnGo;
    private Button btnPrev;
    private EditText txtUrl;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.btnGo);
        btnPrev = findViewById(R.id.btnPrev);
        txtUrl = findViewById(R.id.txtUrl);

        ButtonInner bi = new ButtonInner();

        btnGo.setOnClickListener(bi);
        btnPrev.setOnClickListener(bi);

        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new MyWebClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
    }

    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnGo:
                    String url = txtUrl.getText().toString();
                    webView.loadUrl("http://" + url);
                    break;

                case R.id.btnPrev:
                    webView.goBack();
                    break;
            }
        }
    }

    private class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
