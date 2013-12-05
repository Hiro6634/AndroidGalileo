package com.suyama.hiro.mall_k.activities;

import java.util.HashMap;

import com.suyama.hiro.mall_k.R;
import com.suyama.hiro.mall_k.Shops;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ShopDetailActivity extends Activity {

	private TextView				nameTextView;
	private TextView				descriptionTextView;
	private TextView				webTextView;
	private TextView				emailTextView;
	private TextView				addressTextView;
	private TextView				phoneTextView;
	private TextView				scheduleTextView;
	private Button					callButton;
	private ImageButton				imageButton;
	private HashMap<String, String> shopInfo;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop_detail);
		
		// Buscamos las referencias a los objetos del Layout
		nameTextView 		= (TextView)findViewById(R.id.activity_shop_detail_name_textView);
		descriptionTextView = (TextView)findViewById(R.id.activity_shop_detail_description_textView);
		addressTextView 	= (TextView)findViewById(R.id.activity_shop_detail_address_textView);
		webTextView 		= (TextView)findViewById(R.id.activity_shop_detail_web_textView);
		emailTextView 		= (TextView)findViewById(R.id.activity_shop_detail_email_textView);
		phoneTextView 		= (TextView)findViewById(R.id.activity_shop_detail_phone_textView);
		scheduleTextView	= (TextView)findViewById(R.id.activity_shop_detail_schedule_textView);
		callButton			= (Button)findViewById(R.id.activity_shop_detail_callButton);
		imageButton			= (ImageButton)findViewById(R.id.activity_shop_detail_imageButton);

		// Recuperamos los datos adjuntos al intent. 
		Intent intent = getIntent();
		shopInfo = (HashMap<String, String>)intent.getSerializableExtra("map");
		
		// Cargamos los datos variables en el Layout
		nameTextView.setText(shopInfo.get(Shops.NAME));
		descriptionTextView.setText(shopInfo.get(Shops.DESCRIPTION));
		addressTextView.setText(shopInfo.get(Shops.ADDRESS));
		webTextView.setText(shopInfo.get(Shops.WEBSITE));
		emailTextView.setText(shopInfo.get(Shops.EMAIL));
		phoneTextView.setText(shopInfo.get(Shops.PHONE));
		scheduleTextView.setText(shopInfo.get(Shops.SCHEDULE));

		// Aplicamos para que se generen los links
		Linkify.addLinks(phoneTextView, Linkify.ALL);
		Linkify.addLinks(webTextView, Linkify.ALL);
		Linkify.addLinks(emailTextView, Linkify.ALL);
		
		// Listener del Botón de Llamar
		callButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Lanzamos el discador con el número de la tienda
				Intent callDial = new Intent(Intent.ACTION_DIAL);
				callDial.setData(Uri.parse("tel:" + shopInfo.get(Shops.PHONE)));
				startActivity(callDial);
			}
		});
		
		// listener del botón con la imagen
		imageButton.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Lanzamos la Actividad que muestra la imagen. Si bien se pasa como dato el path a una imagen para este ejercicio se muestar una imagen fija para todos igual.
				Intent showImage = new Intent( getApplicationContext(), ShowImageActivity.class);
				showImage.putExtra(Shops.IMAGE, shopInfo.get(Shops.IMAGE));
				showImage.putExtra(Shops.IMAGECOMMENT, shopInfo.get(Shops.IMAGECOMMENT));
				
				startActivity(showImage);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_share:
			String msg = nameTextView.getText().toString() + 
					"\nemail:" + 
					emailTextView.getText().toString() +
					"\nweb: " +
					webTextView.getText().toString();
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.putExtra(Intent.EXTRA_TEXT, msg);
			intent.setType("text/plain");
			startActivity(Intent.createChooser(intent,
					getString(R.string.action_share)));
			return true;
		case R.id.action_favorite:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
