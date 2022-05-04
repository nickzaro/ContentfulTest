package cda.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.contentful.java.cda.CDAEntry;

import cda.parser.CDAParser;

public class CDAArrayListCustom extends CDACustom{

	@Override
	public boolean put(String key,Object entry) {
		if (!(entry instanceof ArrayList))
			return false;
		ArrayList entri = (ArrayList)entry;
		this.hash.clear();
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		for( Object en: entri) {
			
			cdas.add(CDAParser.getInstance().evaluar(key,en));
			// TODO: se tiene que evaluar si es CDAEntry  o CDAAsset
			// y escribir el objeto segun eso, por ahi se necesita un
			// un metodo en CDAParser que reciba un object sin key y devuelva
			// un cda, asi se agarra con un su key y valor interior, 
			// tambien se modificarian los demas tipos, para cuando solo viene el object
		}
		
		this.hash.put(key,  cdas);
		return true;
	}

	@Override
	public HashMap<String, Object> getHashMap() {
		return this.hash;
	}

	@Override
	public CDACustom get() {
		CDACustom cda = new CDAArrayListCustom();
		cda.hash.putAll(this.hash);
		return cda;
	}

}
