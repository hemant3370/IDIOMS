package com.hemant.idioms;


import android.net.Uri;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class mywebviewclient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		if(Uri.parse(url).getHost().equals("http://10.0.2.2:82/chrome/webapp/trendalyzer.swf"))
		{
			return false;
		}
		
			return true;
			
		
		
	}
}
