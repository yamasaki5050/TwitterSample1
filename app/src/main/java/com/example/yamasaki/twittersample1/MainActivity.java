package com.example.yamasaki.twittersample1;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterListener;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private final String PREF_FILE_NAME = "twitter_test";
	private final String PREF_TOKEN = "token";
	private final String PREF_SECRET = "secret";

	private final String API_KEY = "5jMjVZE7sdnCW573g78p0zx2C";
	private final String API_SECRET = "T6ZlVNnlogJJ8DPfXBtcVApvBa9kl2sOxjgG5iypH5KMrrznON";

	private AsyncTwitter mTwitter;
	private RequestToken mReqToken;

	private Handler mHandler;
	private EditText mText;
	private EditText mLogText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if(!TwitterUtils.hasAccessToken(this)) {
			// OAuth 画面を起動
			Intent intent = new Intent();
			intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.OAuthActivity");
			startActivity(intent);
			finish();
		}else{
			Intent intent = new Intent();
			intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.HomeActivity");
			startActivity(intent);
			finish();
		}

	}

//	private final TwitterListener mListener = new TwitterAdapter() {
//		@Override
//		public void gotOAuthRequestToken(RequestToken token) {
//			mReqToken = token;
//			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mReqToken.getAuthorizationURL()));
//			startActivity(intent);
//		}
//
//		@Override
//		public void gotOAuthAccessToken(AccessToken token) {
//			SharedPreferences pref = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
//			SharedPreferences.Editor editor = pref.edit();
//			editor.putString(PREF_TOKEN, token.getToken());
//			editor.putString(PREF_SECRET, token.getTokenSecret());
//			editor.commit();
//			mTwitter.setOAuthAccessToken(new AccessToken(token.getToken(), token.getTokenSecret()));
//		}
//
//		@Override
//		public void searched(QueryResult queryResult) {
//			String log = "";
//			for (Status status : queryResult.getTweets()) {
//				log += status.getText() + "\n";
//			}
//			final String logText = log;
//			mHandler.post(new Runnable() {
//
//				@Override
//				public void run() {
//					mLogText.setText(logText);
//				}
//
//			});
//		}
//
//		@Override
//		public void updatedStatus(Status status) {
//			final String logText = "ID:" + status.getId() + "\n" + status.getText();
//			mHandler.post(new Runnable() {
//
//				@Override
//				public void run() {
//					mLogText.setText(logText);
//				}
//
//			});
//		}
//
//
//	};

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//
//		mTwitter = new AsyncTwitterFactory().getInstance();
//		mTwitter.addListener(mListener);
//		mTwitter.setOAuthConsumer(API_KEY, API_SECRET);
//
//		AccessToken token = getAccessToken();
//		if (token == null) {
//			mTwitter.getOAuthRequestTokenAsync("twittercallback://callback");
//		} else {
//			mTwitter.setOAuthAccessToken(token);
//		}
//
//		mText = (EditText)findViewById(R.id.editText1);
//		mLogText = (EditText)findViewById(R.id.editText2);
//
//		Button btnTweet = (Button)findViewById(R.id.button1);
//		btnTweet.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				String text = mText.getText().toString();
//				mTwitter.updateStatus(text);
//			}
//
//		});
//		Button btnSearch = (Button)findViewById(R.id.button2);
//		btnSearch.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				String text = mText.getText().toString();
//				Query query = new Query();
//				query.setQuery(text);
//				query.setCount(80);
//				query.setResultType(Query.POPULAR);
//				mTwitter.search(query);
//			}
//
//		});
//
//		mHandler = new Handler();
//	}
//
//	public AccessToken getAccessToken() {
//		SharedPreferences pref = getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
//		String token = pref.getString(PREF_TOKEN, null);
//		String secret = pref.getString(PREF_SECRET, null);
//
//		if (token != null && secret != null) {
//			return new AccessToken(token, secret);
//		} else {
//			return null;
//		}
//
//	}
//
//	@Override
//	protected void onNewIntent(Intent intent) {
//		//ブラウザからのコールバックで呼ばれる
//		final Uri uri = intent.getData();
//		final String verifier = uri.getQueryParameter("oauth_verifier");
//		if (verifier != null) {
//			mTwitter.getOAuthAccessTokenAsync(mReqToken, verifier);
//		}
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		//getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}