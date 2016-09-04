package com.example.yamasaki.twittersample1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

/**
 * Created by yamasaki on 2016/08/18.
 */

public class OAuthActivity extends Activity{

	private String mCallbackURL;
	private Twitter mTwitter;
	private RequestToken mRequestToken;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oauth);

		mCallbackURL = getString(R.string.twitter_callback_url);
		mTwitter = TwitterUtils.getTwitterInstance(this);

		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startAuthorize();
			}
		});
	}

	/**
	 * OAuth認証開始
	 */
	private void startAuthorize() {
		AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				try {
					mRequestToken = mTwitter.getOAuthRequestToken(mCallbackURL);
					return mRequestToken.getAuthorizationURL();
				} catch (TwitterException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(String url) {
				if (url != null) {
					Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(intent);
				} else {
					// 失敗。。。
				}
			}
		};
		task.execute();
	}

	@Override
	public void onNewIntent(Intent intent) {
		if (intent == null || intent.getData() == null || !intent.getData().toString().startsWith(mCallbackURL)) {
			return;
		}
		String verifier = intent.getData().getQueryParameter("oauth_verifier");

		AsyncTask<String, Void, AccessToken> task = new AsyncTask<String, Void, AccessToken>() {
			@Override
			protected AccessToken doInBackground(String... params) {
				try {
					return mTwitter.getOAuthAccessToken(mRequestToken, params[0]);
				} catch (TwitterException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(AccessToken accessToken) {
				if (accessToken != null) {
					// 認証成功
					showToast("認証成功！");
					successOAuth(accessToken);
				} else {
					// 認証失敗
					showToast("認証失敗。。。");
				}
			}
		};
		task.execute(verifier);
	}

	/**
	 * 認証成功時にアクセストークン保存し、ホーム画面起動します。
	 * @param accessToken
	 */
	private void successOAuth(AccessToken accessToken) {
		TwitterUtils.storeAccessToken(this, accessToken);
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

	/**
	 * トースト表示します。
	 * @param text
	 */
	private void showToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}


//	private static final String CONSUMER_KEY = "5jMjVZE7sdnCW573g78p0zx2C";
//	private static final String CONSUMER_SECRET = "T6ZlVNnlogJJ8DPfXBtcVApvBa9kl2sOxjgG5iypH5KMrrznON";
//	private static final String CALLBAC_URL = "Callback:/twitter";
//
//
//	public static RequestToken _req = null;
//	public static OAuthAuthorization _oauth = null;
//
//	private Twitter mTwitter;
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_oauth);
//
//		Button btn = (Button)findViewById(R.id.button1);
//		btn.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				executeOauth();
//			}
//		});
//	}
//
//	private void executeOauth(){
//		//Twitetr4Jの設定を読み込む
//		Configuration conf = ConfigurationContext.getInstance();
//
//		//Oauth認証オブジェクト作成
//		_oauth = new OAuthAuthorization(conf);
//		//Oauth認証オブジェクトにconsumerKeyとconsumerSecretを設定
//		_oauth.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
//		//アプリの認証オブジェクト作成
//		try {
//			_req = _oauth.getOAuthRequestToken(CALLBAC_URL);
//		} catch (TwitterException e) {
//			e.printStackTrace();
//		}
//		String _uri;
//		_uri = _req.getAuthorizationURL();
//		startActivityForResult(new Intent(Intent.ACTION_VIEW , Uri.parse(_uri)), 0);
//	}
//}
