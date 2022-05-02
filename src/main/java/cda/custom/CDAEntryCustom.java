package cda.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.contentful.java.cda.CDAEntry;

import cda.parser.CDAParser;

public class CDAEntryCustom extends CDACustom{

	@Override
	public boolean put(String key,Object entry) {
		if (!(entry instanceof CDAEntry))
			return false;
		CDAEntry entri = (CDAEntry)entry;
		for( Map.Entry<String, Object> ent : entri.rawFields().entrySet()) {
			CDAParser.getInstance().add(ent.getKey(), entri.getField(ent.getKey()));
			//TODO: deberia de ser con new para que el parser no tenga un array?
		}
		
		this.hash.put(key,  CDAParser.getInstance().getcDAOuts().toString());
		return true;
	}

	@Override
	public HashMap<String, Object> get() {
		return this.hash;
	}

}
