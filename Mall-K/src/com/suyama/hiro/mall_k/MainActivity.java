package com.suyama.hiro.mall_k;

import java.util.HashMap;

import com.suyama.hiro.mall_k.R;
import com.suyama.hiro.mall_k.activities.ShopDetailActivity;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
//	private List<HashMap<String, String>> shops;
	private Shops shops;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		shops = new ArrayList<HashMap<String,String>>();
		shops = new Shops();

		// Creamos el adapter para el ActivityView
		SimpleAdapter  adapter = new SimpleAdapter(
				this,
				shops.getList(),
				android.R.layout.simple_list_item_2, 
				new String[] {Shops.NAME, Shops.DESCRIPTION}, 
				new int[] {android.R.id.text1, android.R.id.text2});
	
		setListAdapter(adapter);
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		TextView text1 = (TextView)v.findViewById(android.R.id.text1);
		
		// Buscamos la tienda en la lista para obtener sus datos y enviarlos a la otra actividad.
		for( HashMap<String, String> elemento: shops.getList()) {
			if( elemento.get(Shops.NAME).equals(text1.getText().toString()))
			{
				// Lanzamos la actividad con los detalles de la tienda.
				Intent intent = new Intent( getApplicationContext(), ShopDetailActivity.class );	
				intent.putExtra("map", elemento);
				startActivity(intent);
				break;
			}
		}
		
		super.onListItemClick(l, v, position, id);
	}
}
