package cda.custom;

import java.util.HashMap;

import com.contentful.java.cda.CDAAsset;

public class CDAAssetCustom extends CDACustom{

	public boolean put(String key, Object entry) {
		if (!(entry instanceof CDAAsset))
			return false;
		CDAAsset asset = (CDAAsset) entry;
		this.hash.put(asset.title(), asset.url());
		return true;
	}

	public HashMap<String, Object> get() {
		return this.hash;
	}

}
