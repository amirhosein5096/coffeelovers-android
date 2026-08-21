package shop.coffeelovers.app;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
 WebView web;
 @SuppressLint("SetJavaScriptEnabled")
 @Override protected void onCreate(Bundle b){
  super.onCreate(b); setContentView(R.layout.activity_main);
  web=findViewById(R.id.web); View welcome=findViewById(R.id.welcome);
  WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true);
  web.setWebViewClient(new WebViewClient());
  web.loadUrl("https://new.coffeelovers.shop/");
  new Handler(Looper.getMainLooper()).postDelayed(()->{
   welcome.setVisibility(View.GONE); web.setVisibility(View.VISIBLE);
  },1800);
  getOnBackPressedDispatcher().addCallback(this,new OnBackPressedCallback(true){
   @Override public void handleOnBackPressed(){ if(web.canGoBack()) web.goBack(); else finish(); }
  });
 }
}