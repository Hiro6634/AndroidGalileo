package com.symsys.mobile.android.moocdemo2_9.data;

import com.symsys.mobile.android.moocdemo2_9.R;
import com.symsys.mobile.android.moocdemo2_9.fragments.FlagFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FlagPagerAdapter extends FragmentPagerAdapter {

	public FlagPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		int[] arrayFlags = new int[] {
				R.drawable.brazil,
				R.drawable.mexico,
				R.drawable.colombia,
				R.drawable.argentina,
				R.drawable.peru,
				R.drawable.venezuela,
				R.drawable.chile,
				R.drawable.ecuador,
				R.drawable.guatemala,
				R.drawable.cuba
		};
		
		Fragment fragment = new FlagFragment();
		Bundle args = new Bundle();
		args.putInt(FlagFragment.RESOURCE, arrayFlags[position]);
		fragment.setArguments(args);
		
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

}
