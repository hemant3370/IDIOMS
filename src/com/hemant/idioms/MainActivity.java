package com.hemant.idioms;



import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;









import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
  WebView wv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 wv = (WebView) findViewById(R.id.webView1);
		wv.setWebViewClient(new mywebviewclient());
		wv.loadUrl("file:///android_asset/htm/index.html");
		wv.setClickable(true);
		WebSettings webSettings =  wv.getSettings();
		webSettings.setJavaScriptEnabled(true);
		wv.setWebViewClient(new WebViewClient());
		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);
		
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack())
		{
			wv.goBack();
			return  true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Toast.makeText(MainActivity.this, "No settings as of now!", Toast.LENGTH_SHORT).show();
			return true;
		}
		if(id == R.id.exit){
			AlertDialog.Builder exitbuilder = new AlertDialog.Builder(MainActivity.this);
			exitbuilder.setMessage("Are you sure you want to exit?");
			exitbuilder.setCancelable(false);
			exitbuilder.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

							MainActivity.this.finish();
							// getParent().finish();

						}
					});

			exitbuilder.setNegativeButton("No",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

							dialog.cancel();
						}
					});
			AlertDialog exiAlertDialog = exitbuilder.create();
			exiAlertDialog.show();
		}
		return super.onOptionsItemSelected(item);
	}
}
