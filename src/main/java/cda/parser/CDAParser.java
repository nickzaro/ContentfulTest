package cda.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cda.custom.CDAAssetCustom;
import cda.custom.CDAEntryCustom;
import cda.custom.CDAOtherCustom;
import cda.custom.CDARichDocumentCustom;
import cda.custom.ICDACustom;

public class CDAParser {

	List<ICDACustom> cDACustomList = new ArrayList<ICDACustom>();
	//List<HashMap<String, Object>> cDAOuts = new ArrayList<HashMap<String, Object>>();
	HashMap<String, Object> cDAOuts = new HashMap<String, Object>();
	private static CDAParser cdaParser = null;

	private CDAParser() {
		cDACustomList.add(new CDAAssetCustom());
		cDACustomList.add(new CDAEntryCustom());
		cDACustomList.add(new CDARichDocumentCustom());
		// listCDACustom.add(new CDAArrayListCustom());
		cDACustomList.add(new CDAOtherCustom());
	}

	public static CDAParser getInstance() {
		if (cdaParser == null)
			cdaParser = new CDAParser();
		return cdaParser;
	}

	public boolean add(String key,Object field) {
		for (ICDACustom cda : cDACustomList) {
			if (cda.put(key,field)) {
				cDAOuts.putAll(cda.get());
				return true;
			}
		}
		return false;

	}

	public HashMap<String, Object> getcDAOuts() {
		return cDAOuts;
	}

}
