package com.symsys.mobile.android.moocdemo2_7.activities;


import com.symsys.mobile.android.moocdemo2_7.R;
import com.symsys.mobile.android.moocdemo2_7.fragments.CountriesFlagsFragment;
import com.symsys.mobile.android.moocdemo2_7.fragments.CountriesListFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;

public class MainActivity 	extends ActionBarActivity 
							implements TabListener{

	Fragment[] fragments = new Fragment[] { 	new CountriesListFragment(),
												new CountriesFlagsFragment()};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getSupportActionBar();

		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction()
							.add(R.id.mainContent, fragments[0])
							.add(R.id.mainContent, fragments[1])
							.commit();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		actionBar.addTab(
				actionBar.newTab()
				.setText(getString(R.string.title_fragment_list))
				.setTabListener(this));

		actionBar.addTab(
				actionBar.newTab()
				.setText(getString(R.string.title_fragment_flags))
				.setTabListener(this));
	}
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment toHide = null;
		Fragment toShow = null;
		
		switch( tab.getPosition()) {
		case 0:
			toHide = fragments[1];
			toShow = fragments[0];
			break;
		case 1:
			toHide = fragments[0];
			toShow = fragments[1];
			break;
		}
		
		ft.hide(toHide);
		ft.show(toShow);
	}
	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
