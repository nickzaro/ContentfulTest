package cda.custom;

import java.util.HashMap;

public abstract class CDACustom {

	HashMap<String, Object> hash = new HashMap<String, Object>();
	
	public abstract boolean put(String key, Object entry);

	public abstract HashMap<String, Object> getHashMap();

	public abstract CDACustom get();

	@Override
	public String toString() {
		return  hash.toString();
	}
	
	
}
