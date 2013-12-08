package com.suyama.hiro.mall_k.fragments;

import java.util.ArrayList;
import java.util.Arrays;

import com.suyama.hiro.mall_k.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CommentsFragment extends Fragment {
	private ListView commentsList;
	private String[] arrayComments;
	private View view;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		ArrayList<String> comments = new ArrayList<String>(Arrays.asList(arrayComments));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,comments);
		commentsList.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_comments, container, false);
		commentsList = (ListView)view.findViewById(R.id.fragment_comments_listView);
		
		return view;
	}

	public void setComments( String[] comments){
		this.arrayComments = comments;
	}
}
