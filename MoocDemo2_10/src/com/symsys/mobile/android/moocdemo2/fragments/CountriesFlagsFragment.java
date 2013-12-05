package com.symsys.mobile.android.moocdemo2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.symsys.mobile.android.moocdemo2.data.FlagPagerAdapter;
import com.symsys.mobile.android.moocdemo2.R;

public class CountriesFlagsFragment extends Fragment {

	ViewPager viewPager;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_countries_flags, container, false);
		viewPager = (ViewPager)view.findViewById(R.id.pager);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		FlagPagerAdapter adapter = new FlagPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
	}
}
