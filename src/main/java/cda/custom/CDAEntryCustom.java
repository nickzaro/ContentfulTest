package cda.custom;

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
		HashMap<String, Object> hashs = new HashMap<String, Object>();
		for (Map.Entry<String, Object> ent : entri.rawFields().entrySet()) {
			CDACustom cda = CDAParser.getInstance().evaluar(ent.getKey(), entri.getField(ent.getKey()));
			hashs.putAll(cda.getHashMap());
		}
		this.hash.put(key, hashs);
		return true;
	}

	@Override
	public boolean put(Object entry) {
		if (!(entry instanceof CDAEntry))
			return false;
		CDAEntry entri = (CDAEntry) entry;
		this.hash.clear();
		HashMap<String, Object> hashs = new HashMap<String, Object>();
		for (Map.Entry<String, Object> ent : entri.rawFields().entrySet()) {
			CDACustom cda = CDAParser.getInstance().evaluar(ent.getKey(), entri.getField(ent.getKey()));
			hashs.putAll(cda.getHashMap());
		}
		this.hash.putAll(hashs);
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
		return cda;
	}

}
