package cda.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import cda.custom.CDAArrayListCustom;
import cda.custom.CDAAssetCustom;
import cda.custom.CDACustom;
import cda.custom.CDAEntryCustom;
import cda.custom.CDAOtherCustom;
import cda.custom.CDARichDocumentCustom;

public class CDAParser {

	List<CDACustom> cDACustomList = new ArrayList<CDACustom>();
	HashMap<String, Object> cDAOuts = new HashMap<String, Object>();
	private static CDAParser cdaParser = null;

	private CDAParser() {
		cDACustomList.add(new CDAAssetCustom());
		cDACustomList.add(new CDAEntryCustom());
		cDACustomList.add(new CDARichDocumentCustom());
		cDACustomList.add(new CDAArrayListCustom());
		cDACustomList.add(new CDAOtherCustom());
	}

	public static CDAParser getInstance() {
		if (cdaParser == null)
			cdaParser = new CDAParser();
		return cdaParser;
	}

	public CDACustom evaluar(String key, Object field) {
		CDACustom cdaResp = null;
		for (CDACustom cda : cDACustomList) {
			if (cda.put(key, field)) {
				cdaResp = cda.get();
			}
		}
		return cdaResp;

	}

	public CDACustom evaluar(Object field) {
		CDACustom cdaResp = null;
		for (CDACustom cda : cDACustomList) {
			if (cda.put(field)) {
				cdaResp = cda.get();
			}
		}
		return cdaResp;

	}

	public HashMap<String, Object> getcDAOuts() {
		return cDAOuts;
	}

}
