package cda.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CDAOtherCustom extends CDACustom {

	// son los que tenemos por ahora, agregar otros de ser necesario y hacer su
	// custom
	protected ArrayList<String> CONTENTFUL_CDA = new ArrayList<String>(
			Arrays.asList("CDAAsset", "ArrayList", "CDAEntry", "CDARichDocument"));

	public boolean put(String key, Object entry) {
		if ((CONTENTFUL_CDA.contains(entry.getClass().getSimpleName())))
			return false;
		this.hash.clear();
		this.hash.put(key, entry.toString());
		return true;
	}

	public HashMap<String, Object> getHashMap() {
		return this.hash;
	}

	@Override
	public CDACustom get() {
		CDACustom cda = new CDAOtherCustom();
		cda.hash.putAll(this.hash);
		return cda;
	}

	@Override
	public boolean put(Object entry) {
		// TODO Auto-generated method stub
		return false;
	}

}
