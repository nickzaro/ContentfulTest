package cda.custom;

import java.util.HashMap;

public interface ICDACustom {

	
	public boolean put(String key,Object entry);
	
	public HashMap<String, Object> get();
	
}
