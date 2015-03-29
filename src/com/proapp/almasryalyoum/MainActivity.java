package com.proapp.almasryalyoum;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.DetailedState;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.ads.AdRequest;
import com.google.ads.AdView;


public class MainActivity extends Activity {

	WebView web;
	ProgressBar progressBar;
	TextView progressTv;
	Handler h;
	//Button share;
	//private StartAppAd startAppAd = new StartAppAd(MainActivity.this);











	/////////////////////////////////////////////////
	public void Load() {

		progressBar = (ProgressBar)findViewById(R.id.progressBar);
		//share =(Button)findViewById(R.id.share);
		// mInterstitial = new InterstitialAd(this);

		/**
		share.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT,   "..........." + "" +"" +" "


+" ÿ»Ìﬁ «·»—‰«„Ã ·„ «»⁄… ¬Œ— Õ·ﬁ«  »—‰«„Ã «·»—‰«„Ã »ﬂ· ”ÂÊ·…...ﬁ„ » Õ„Ì· «· ÿ»Ìﬁ „‰ ÃÊÃ· »·«Ì"
+ "................"
+"http://play.google.com/store/apps/details?id=com.prolab.albernameg");// url elapplication to share
				startActivity(Intent.createChooser(intent, "Share"));
			}
		});
		
		**/

		h = new Handler();
		progressBar.setVisibility(ProgressBar.VISIBLE);
		Thread TH = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i += 3) {
					progressBar.setProgress(i);
					try {
						//Thread.sleep(1000); // time for progress bar 
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				}
				h.post(new Runnable() {
					public void run() {
						progressBar.setVisibility(ProgressBar.GONE);
						progressTv.setVisibility(progressTv.GONE);
					}
				});

			}
		});
		TH.start();
	}// end of Load method
	///////////////////////////////////////////////////////

	public void CheckConnection(){

		final ConnectivityManager connMgr = (ConnectivityManager)
				this.getSystemService(Context.CONNECTIVITY_SERVICE);
		final android.net.NetworkInfo wifi =
				connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		final android.net.NetworkInfo mobile =
				connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if(wifi.isAvailable() && wifi.getDetailedState() == DetailedState.CONNECTED){
			// Toast.makeText(this, "You are Connected by Wifi" , 5000).show();
		}
		else if(mobile.isAvailable() && mobile.getDetailedState() == DetailedState.CONNECTED ){
			//  Toast.makeText(this, "You ara Connected by Mobile 3G" , 5000).show();
			//LoadProgress();
		}
		else
		{   

			Intent i = new Intent(MainActivity.this,No_Internet.class);
			startActivity(i);
			finish();

		}
	}


	@SuppressWarnings("deprecation")
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CheckConnection();
		Load();
		//String DeveloperId ="112108138" ; 
		//String AppID = "202460723" ; 


		//StartAppAd.init(MainActivity.this, DeveloperId, AppID );
		//StartAppSearch.init(MainActivity.this, DeveloperId,AppID );

		
        /////////3sha el e3lan bta3 admob
		/**
		AdView adView = (AdView)this.findViewById(R.id.adView);
	    adView.loadAd(new AdRequest());
	    **/
		////////

		web = (WebView) findViewById(R.id.webview01);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		progressTv = (TextView)findViewById(R.id.progressTv);

		web.setWebViewClient(new WebViewClient());
		web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setAllowFileAccess(true);
		web.getSettings().setLoadWithOverviewMode(true);
		web.getSettings().setUseWideViewPort(true);
		//startAppAd.showAd(); // show the ad
		//startAppAd.loadAd(); // load the next ad


		//
		WebSettings webSettings = web.getSettings();
		web.getSettings().setPluginState(WebSettings.PluginState.ON);

		web.getSettings().setPluginState(PluginState.ON);
		web.getSettings().setSupportZoom(true);
		web.getSettings().setBuiltInZoomControls(true);




		// try { if( Build.VERSION.SDK_INT >= 11) getWindow().setFlags( 16777216, 16777216); } catch( Exception e) {} // FLAG_HARDWARE_ACCELERATED == 16777216 (0x01000000)



		/**
      if (Build.VERSION.SDK_INT < 8) {
          web.getSettings().setPluginsEnabled(true);
      } else {
          web.getSettings().setPluginState(PluginState.ON);
      }
		 **/


		//
	//	web.loadUrl("http://www.youtube.com/user/albernameg?feature=watch");
		//web.loadUrl("https://soundcloud.com/deejay-ahmed-kenzy");

		///////
		web.loadUrl("http://m.almasryalyoum.com/");
		
		
		
		
		web.setWebChromeClient(new WebChromeClient());




	}


	/*@Override
	public void onResume(){
		super.onResume();
		startAppAd.onResume();
		startAppAd.showAd();
		startAppAd.loadAd();*/

	
/**
	@Override
	public void onBackPressed() {
	startAppAd.onBackPressed();
	super.onBackPressed();
	startAppAd.showAd();
	startAppAd.loadAd();

	}
	@Override
	public void onPause() {
	super.onPause();
	startAppAd.onPause();
	startAppAd.showAd();
	startAppAd.loadAd();
	}


**/






	public class myWebClient extends WebViewClient
	{
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub

			view.loadUrl(url);
			return true;

		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);

			progressBar.setVisibility(View.GONE);
			progressTv.setVisibility(View.GONE);
		}
	}


	// To handle "Back" key press event for WebView to go back to previous screen.
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
			web.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
