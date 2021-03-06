package com.symsys.mobile.android.moocdemo2.fragments;


import com.symsys.mobile.android.moocdemo2.activities.CountryDetailActivity;
import com.symsys.mobile.android.moocdemo2.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class CountryInfoFragment extends Fragment {

	private WebView webView;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		
		Activity activity = getActivity();
		
		if( activity instanceof CountryDetailActivity){
			String country = ((CountryDetailActivity)getActivity()).getCountry();
			loadWebViewContent(country);
		}
	}

	public void loadWebViewContent( String country ) {
		
		webView.loadUrl("http://es.m.wikipedia.org/wiki/" + country );
		webView.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
			
		});
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_country_info, container);
		webView = (WebView)view.findViewById(R.id.webView);
		return view;
	}

}
