package cda.custom;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class CDACustom {

	HashMap<String, Object> hash = new HashMap<String, Object>();
	ArrayList<Object> array = new ArrayList<Object>();

	public abstract boolean put(String key, Object entry);

	public abstract boolean put(Object entry);

	public abstract HashMap<String, Object> getHashMap();

	public abstract CDACustom get();

	@Override
	public String toString() {
		if (hash.size() > 0)
			return hash.toString();
		else
			return array.toString();
	}

}
