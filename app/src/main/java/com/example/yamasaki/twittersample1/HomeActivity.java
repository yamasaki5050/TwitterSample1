package com.example.yamasaki.twittersample1;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import layout.FollowListTabFragment;
import layout.FollowerListTabFragment;
import layout.HomeTabFragment;

public class HomeActivity extends Activity {//implements ActionBar.TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//ActionBarをGetしてTabModeをセット
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.addTab(actionBar.newTab()
				.setText("ホーム")
				.setTabListener(new TabListener<HomeTabFragment>(
						this, "tag1", HomeTabFragment.class)));
		actionBar.addTab(actionBar.newTab()
				.setText("フォロー")
				.setTabListener(new TabListener<FollowListTabFragment>(
						this, "tag2", FollowListTabFragment.class)));
		actionBar.addTab(actionBar.newTab()
				.setText("フォロワー")
				.setTabListener(new TabListener<FollowerListTabFragment>(
						this, "tag3", FollowerListTabFragment.class)));
		actionBar.addTab(actionBar.newTab()
				.setText("リスト")
				.setTabListener(new TabListener<FollowListTabFragment>(
						this, "tag4", FollowListTabFragment.class)));
//		actionBar.addTab(actionBar.newTab()
//				.setText("Third")
//				.setTabListener(new TabListener<ThirdTabFragment>(
//						this, "tag3", ThirdTabFragment.class)));

	}

}

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//
//		final ActionBar mActionBar = getActionBar();
//
//		//ActionBarのタブ設定
//		mActionBar.addTab(mActionBar.newTab().setText("ホーム").setTabListener(this));
//		mActionBar.addTab(mActionBar.newTab().setText("フォロワー").setTabListener(this));
//		mActionBar.addTab(mActionBar.newTab().setText("フォロー").setTabListener(this));
//		mActionBar.addTab(mActionBar.newTab().setText("検索リスト").setTabListener(this));
//
//		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//		// アイコンを表示しない
//		mActionBar.setDisplayShowHomeEnabled(false);
//		// SHOW_TITLEのフラグを消すことで、タイトル表示を消す
//		mActionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
//	}
//
//	@Override
//	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//		Intent intent = new Intent();
//		switch (tab.getPosition()) {
//			case 0:
//				break;
//			case 1:
//				intent = new Intent();
//				intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.FollowListActivity");
//				startActivity(intent);
////				finish();
//				break;
//			case 2:
//				intent = new Intent();
//				intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.FollowerListActivity");
//				startActivity(intent);
////				finish();
//				break;
//			case 3:
//				intent = new Intent();
//				intent.setClassName("com.example.yamasaki.twittersample1", "com.example.yamasaki.twittersample1.FindListActivity");
//				startActivity(intent);
////				finish();
//				break;
//		}
//	}
//
//	@Override
//	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//	}
//
//	@Override
//	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
//
//	}
//
//}
