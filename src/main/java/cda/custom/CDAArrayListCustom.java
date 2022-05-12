package cda.custom;

import java.util.ArrayList;
import java.util.HashMap;

import com.contentful.java.cda.CDAEntry;

import cda.parser.CDAParser;

public class CDAArrayListCustom extends CDACustom {

	@SuppressWarnings("unchecked")
	@Override
	public boolean put(String key, Object entry) {
		if (!(entry instanceof ArrayList))
			return false;
		this.hash.clear();
		ArrayList<Object> entri = (ArrayList<Object>) entry;
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		for (Object en : entri) {
			CDACustom cda;
			if (en instanceof CDAEntry)
				cda = CDAParser.getInstance().evaluar(en);
			else
				cda = CDAParser.getInstance().evaluar(key, en);
			cdas.add(cda);
		}

		this.hash.put(key, cdas);
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

	@Override
	public boolean put(Object entry) {
		if (!(entry instanceof ArrayList))
			return false;
		throw new UnsupportedOperationException();
	}

}
