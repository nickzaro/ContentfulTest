package cda.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.contentful.java.cda.CDAEntry;

import cda.parser.CDAParser;

public class CDAArrayListCustom extends CDACustom {

	@Override
	public boolean put(String key, Object entry) {
		if (!(entry instanceof ArrayList))
			return false;
		ArrayList entri = (ArrayList) entry;
		this.hash.clear();
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		HashMap<String, Object> hashs = new HashMap<String, Object>();
		for (Object en : entri) {
			CDACustom cda;
			if (en instanceof CDAEntry)
				cda=CDAParser.getInstance().evaluar(en);
			else
				cda= CDAParser.getInstance().evaluar(key, en);
			
			hashs.putAll(cda.getHashMap());
			cdas.add(cda);
			// TODO: sacar un padre que solo tenga put de un parametro y el ArrayList array
			// para el tema de los
			// CDACustomComplex: CDAArrayListCustom y CDAEntryCustom
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
