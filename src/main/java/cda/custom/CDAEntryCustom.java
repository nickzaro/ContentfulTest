package cda.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.contentful.java.cda.CDAEntry;

import cda.parser.CDAParser;

public class CDAEntryCustom extends CDACustom {

	@Override
	public boolean put(String key, Object entry) {
		if (!(entry instanceof CDAEntry))
			return false;
		CDAEntry entri = (CDAEntry) entry;
		this.hash.clear();
		this.array.clear();
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		for (Map.Entry<String, Object> ent : entri.rawFields().entrySet()) {
			cdas.add(CDAParser.getInstance().evaluar(ent.getKey(), entri.getField(ent.getKey())));
		}

		this.hash.put(key, cdas);
		return true;
	}

	@Override
	public boolean put(Object entry) {
		if (!(entry instanceof CDAEntry))
			return false;
		CDAEntry entri = (CDAEntry) entry;
		this.hash.clear();
		this.array.clear();
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		for (Map.Entry<String, Object> ent : entri.rawFields().entrySet()) {
			cdas.add(CDAParser.getInstance().evaluar(ent.getKey(), entri.getField(ent.getKey())));
		}

		this.array.addAll(cdas);
		return true;
	}

	@Override
	public HashMap<String, Object> getHashMap() {
		return this.hash;
	}

	@Override
	public CDACustom get() {
		CDACustom cda = new CDAEntryCustom();
		cda.hash.putAll(this.hash);
		cda.array.addAll(this.array);
		return cda;
	}

}
