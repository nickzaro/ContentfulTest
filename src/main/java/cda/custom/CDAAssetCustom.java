package cda.custom;

import java.util.HashMap;

import com.contentful.java.cda.CDAAsset;

public class CDAAssetCustom extends CDACustom {

	public boolean put(String key, Object entry) {
		if (!(entry instanceof CDAAsset))
			return false;
		this.hash.clear();
		CDAAsset asset = (CDAAsset) entry;
		this.hash.put(asset.title(), asset.url());
		return true;
	}

	public HashMap<String, Object> getHashMap() {
		return this.hash;
	}

	@Override
	public CDACustom get() {
		CDACustom cda = new CDAAssetCustom();
		cda.hash.putAll(this.hash);
		return cda;
	}

	@Override
	public boolean put(Object entry) {
		if (!(entry instanceof CDAAsset))
			return false;
		throw new UnsupportedOperationException();
	}

}
