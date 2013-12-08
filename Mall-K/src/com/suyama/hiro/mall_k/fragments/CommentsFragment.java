package com.suyama.hiro.mall_k.fragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.suyama.hiro.mall_k.R;
import com.suyama.hiro.mall_k.data.Shops;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CommentsFragment extends Fragment 
								implements OnClickListener{
	private String[] 				arrayComments;
	
//	private ArrayList<String>		comments;
	private List<HashMap<String, String>>	comments;
//	private ArrayAdapter<String> 	adapter; 
	private SimpleAdapter			adapter; 
	private View 					view;

	private ListView 	commentsList;
	private ImageButton	addButton;
	private EditText	commentText;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		
//		comments = new ArrayList<String>(Arrays.asList(arrayComments));
//		adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,comments);
		adapter = new SimpleAdapter(
				getActivity(), 
				comments,
				android.R.layout.simple_list_item_1,
				new String[]{Shops.COMMENT},
				new int[]{android.R.id.text1});
		commentsList.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_comments, container, false);
		commentsList 	= (ListView)view.findViewById(R.id.fragment_comments_listView);
		addButton		= (ImageButton)view.findViewById(R.id.fragment_comments_addButton);
		commentText		= (EditText)view.findViewById(R.id.fragment_comments_editText);		
		
		addButton.setOnClickListener(this);
		return view;
	}

	public void setComments( String[] comments){
		this.arrayComments = comments;
	}

	@Override
	public void onClick(View view) {
//		comments.add(commentText.getText().toString());
		HashMap<String,String> element = new HashMap<String, String>();
		element.put(Shops.COMMENT, commentText.getText().toString());
		comments.add(element);
	    adapter.notifyDataSetChanged();
	}
}
