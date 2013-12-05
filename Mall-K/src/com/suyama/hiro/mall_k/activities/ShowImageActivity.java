package com.suyama.hiro.mall_k.activities;




import com.suyama.hiro.mall_k.R;
import com.suyama.hiro.mall_k.Shops;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowImageActivity extends Activity {
	private ImageView	imageView;
	private TextView	imageComment;
	private int			imageId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_image);
		
		// Obtenemos las referencias a los elementos del Layout
		imageView 		= (ImageView)findViewById(R.id.activity_show_image_imageView);
		imageComment	= (TextView)findViewById(R.id.activity_show_image_comment_textView);
		
		imageView.setImageResource(R.drawable.imagen);
		
		// Actualizo los valores a mostar. La imagen es fija para todos los casos, no asi el comentario 
		Intent intentInfo = getIntent();
		imageId = Integer.parseInt(intentInfo.getStringExtra(Shops.IMAGE));
		imageView.setImageResource(intentInfo.getStringExtra(Shops.IMAGE).equals("")?
					android.R.drawable.ic_menu_gallery:
					imageId);
		imageComment.setText(intentInfo.getStringExtra(Shops.IMAGECOMMENT));
		
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

			Resources resources = getResources();
			Uri uri = Uri.parse("android.resource://"+
					resources.getResourcePackageName(imageId)+'/'+
					resources.getResourceTypeName(imageId)+'/'+
					resources.getResourceEntryName(imageId));
			
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.putExtra(Intent.EXTRA_STREAM, uri);
			intent.setType("image/*");
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
