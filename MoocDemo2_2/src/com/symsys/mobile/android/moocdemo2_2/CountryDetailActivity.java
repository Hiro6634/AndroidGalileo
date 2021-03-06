package com.symsys.mobile.android.moocdemo2_2;

import com.symsys.mobile.android.moocdemo2_2.R;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class CountryDetailActivity extends FragmentActivity {

	public static final String COUNTRY = "country";
	
	private String country = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_country_detail);
	
		Intent intent = getIntent();
		country = intent.getStringExtra(COUNTRY);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.country_detail, menu);
		return true;
	}

	public String getCountry() {
		return country;
	}
}
