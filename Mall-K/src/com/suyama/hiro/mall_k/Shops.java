package com.suyama.hiro.mall_k;

import java.util.ArrayList;
import java.util.HashMap;

public class Shops {
	public final static String NAME 		= "Shop.NAME";
	public final static String DESCRIPTION 	= "Shop.DESCRIPTION";
	public final static String ADDRESS		= "Shop.ADDRESS";
	public final static String IMAGE		= "Shop.imagePath";
	public final static String PHONE		= "Shop.PHONE";
	public final static String IMAGECOMMENT	= "Shop.IMAGECOMMENT";
	public final static String SCHEDULE		= "Shop.SCHEDULE";
	public final static String EMAIL		= "Shop.EMAIL";
	public final static String WEBSITE		= "Shop.WEBSITE";
	
	private ArrayList<HashMap<String, String>>	list;
	
	public Shops(){
		list = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> element;
		
		// Cargamos los elementos de la lista hardcoded
		element = new HashMap<String, String>();
		element.put(Shops.NAME, 			"La Herradura");
		element.put(Shops.DESCRIPTION, 	"Minimercado");
		element.put(Shops.ADDRESS, 		"Diagonal Brown 11");
		element.put(Shops.PHONE, 		"1142931122");
		element.put(Shops.WEBSITE,		"www.laherradura.com.ar");
		element.put(Shops.EMAIL,			"info@laherradura.com.ar");
		element.put(Shops.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shops.IMAGE,			String.valueOf(R.drawable.laherradura));
		element.put(Shops.IMAGECOMMENT,	"Imagen de la Tienda");
		
		list.add(element);

	
		element = new HashMap<String, String>();
		element.put(Shops.NAME, 			"Summus");
		element.put(Shops.DESCRIPTION, 	"Panaderia");
		element.put(Shops.ADDRESS, 		"Esteban Adrogue 123");
		element.put(Shops.PHONE, 		"1142945678");
		element.put(Shops.WEBSITE,		"www.summus.com.ar");
		element.put(Shops.EMAIL,			"info@summus.com.ar");
		element.put(Shops.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shops.IMAGE,			String.valueOf(R.drawable.summus));
		element.put(Shops.IMAGECOMMENT,	"Imagen de la Tienda");
		
		list.add(element);
		
		element = new HashMap<String, String>();
		element.put(Shops.NAME, 			"La Fabrica");
		element.put(Shops.DESCRIPTION, 	"Sandwiches");
		element.put(Shops.ADDRESS, 		"Diagonal Brown 321");
		element.put(Shops.PHONE, 		"01142933344");
		element.put(Shops.WEBSITE,		"www.lafabrica.com.ar");
		element.put(Shops.EMAIL,			"info@lafabrica.com.ar");
		element.put(Shops.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shops.IMAGE,			String.valueOf(R.drawable.lafabrica));
		element.put(Shops.IMAGECOMMENT,	"Imagen de la Tienda");
		
		list.add(element);

		element = new HashMap<String, String>();
		element.put(Shops.NAME, 			"Libreria del Colegio");
		element.put(Shops.DESCRIPTION, 	"Libreria");
		element.put(Shops.ADDRESS, 		"Diagonal Brown 23");
		element.put(Shops.WEBSITE,		"www.libreriadelcolegio.com.ar");
		element.put(Shops.EMAIL,			"info@libreriadelcolegio.com.ar");
		element.put(Shops.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shops.PHONE, 		"01142939876");
		element.put(Shops.IMAGE,			String.valueOf(R.drawable.libreriadelcolegio));
		element.put(Shops.IMAGECOMMENT,	"Imagen de la Tienda");
		
		list.add(element);
		
		element = new HashMap<String, String>();
		element.put(Shops.NAME, 			"Los Amores");
		element.put(Shops.DESCRIPTION, 	"Heladeria");
		element.put(Shops.ADDRESS, 		"Rosales 123");
		element.put(Shops.WEBSITE,		"www.losamores.com.ar");
		element.put(Shops.EMAIL,			"info@losamores.com.ar");
		element.put(Shops.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shops.PHONE, 		"01142934455");
		element.put(Shops.IMAGE,			String.valueOf(R.drawable.losamores));
		element.put(Shops.IMAGECOMMENT,	"Imagen de la Tienda");
		
		list.add(element);

		element = new HashMap<String, String>();
		element.put(Shops.NAME, 			"Hispamar");
		element.put(Shops.DESCRIPTION, 	"Pescaedria");
		element.put(Shops.ADDRESS, 		"Bynon 1212");
		element.put(Shops.WEBSITE,		"www.hispamar.com.ar");
		element.put(Shops.EMAIL,			"info@hispamar.com.ar");
		element.put(Shops.SCHEDULE, 		"8:00 a 12:00\n13:00 a 21:00");
		element.put(Shops.PHONE, 		"01142936655");
		element.put(Shops.IMAGE,			String.valueOf(R.drawable.hispamar));
		element.put(Shops.IMAGECOMMENT,	"Imagen de la Tienda");
		
		list.add(element);
	}

	public ArrayList<HashMap<String, String>> getList() {
		return list;
	}
}
