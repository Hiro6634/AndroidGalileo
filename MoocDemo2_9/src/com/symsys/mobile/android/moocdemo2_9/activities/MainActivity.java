package com.symsys.mobile.android.moocdemo2_9.activities;


import com.symsys.mobile.android.moocdemo2_9.R;
import com.symsys.mobile.android.moocdemo2_9.fragments.AboutFragment;
import com.symsys.mobile.android.moocdemo2_9.fragments.CountriesContentFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity 	extends ActionBarActivity {
	private ListView			drawerList;
	private String[] 			drawerOptions;
	private DrawerLayout 		drawerLayout;
	private Fragment[]			fragments 		= new Fragment[] { 	new CountriesContentFragment(),
																	new AboutFragment() };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawerList 		= (ListView) findViewById(R.id.leftDrawer);
		drawerLayout	= (DrawerLayout)findViewById(R.id.drawerLayout);
		drawerOptions	= getResources().getStringArray(R.array.drawer_options);
		
		drawerList.setAdapter( new ArrayAdapter<String> (this,
														R.layout.drawer_list_item,
														drawerOptions));	

		drawerList.setItemChecked(0, true);
		drawerList.setOnItemClickListener( new DrawerItemClickListener());

		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction()
			.add(R.id.contentFrame, fragments[0])
			.add(R.id.contentFrame, fragments[1])
			.hide(fragments[1])
			.commit();

		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	
		actionBar.setTitle(drawerOptions[0]);
	}
	
	public void setContent( int index ) {
		Fragment toHide = null;
		Fragment toShow = null;
		ActionBar actionBar = getSupportActionBar();
		
		switch( index) {
			case 0:
				toHide = fragments[1];
				toShow = fragments[0];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				break;
			case 1:
				toHide = fragments[0];
				toShow = fragments[1];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
				break;
		}
		actionBar.setTitle(drawerOptions[index]);
		FragmentManager manager = getSupportFragmentManager();
		manager.beginTransaction()
			.hide(toHide)
			.show(toShow)
			.commit();	
		
		drawerList.setItemChecked(index, true);
		drawerLayout.closeDrawer(drawerList);
	}
	
	class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int position,
				long arg3) {
			
			setContent(position);
		}
	}
}
