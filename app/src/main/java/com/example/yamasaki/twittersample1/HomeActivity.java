package com.example.yamasaki.twittersample1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends Activity implements ActionBar.TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ActionBar mActionBar = getActionBar();

		//ActionBarのタブ設定
		mActionBar.addTab(mActionBar.newTab().setText("ホーム").setTabListener(this));
		mActionBar.addTab(mActionBar.newTab().setText("フォロワー").setTabListener(this));
		mActionBar.addTab(mActionBar.newTab().setText("フォロー").setTabListener(this));
		mActionBar.addTab(mActionBar.newTab().setText("検索リスト").setTabListener(this));

		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// アイコンを表示しない
		mActionBar.setDisplayShowHomeEnabled(false);
		// SHOW_TITLEのフラグを消すことで、タイトル表示を消す
		mActionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		Intent intent = new Intent();
		switch (tab.getPosition()) {
			case 0:
				break;
			case 1:
				intent = new Intent();
				intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.FollowListActivity");
				startActivity(intent);
//				finish();
				break;
			case 2:
				intent = new Intent();
				intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.FollowerListActivity");
				startActivity(intent);
//				finish();
				break;
			case 3:
				intent = new Intent();
				intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.FindListActivity");
				startActivity(intent);
//				finish();
				break;
		}
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.menu, menu);
//
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//			case R.id.menu1:
//				// メニュー１選択時の処理
//				break;
//		}
//		return super.onOptionsItemSelected(item);
//	}

}
