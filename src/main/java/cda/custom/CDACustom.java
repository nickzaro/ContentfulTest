package cda.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class CDACustom implements ICDACustom {

	static ArrayList<String> CONTENTFUL_CDA = new ArrayList<String>(
			Arrays.asList("CDAAsset", "ArrayList", "CDAEntry", "CDARichDocument"));
	static HashMap<String, Object> hashContenido = new HashMap<String, Object>();
	HashMap<String, Object> hash = new HashMap<String, Object>();
	
	protected HashMap<String, Object> getHash() {
		return hash;
	}
	
	public static ArrayList<String> getCONTENTFUL_CDA() {
		return CONTENTFUL_CDA;
	}

	public static HashMap<String, Object> getHashContenido() {
		return hashContenido;
	}
	
	
}
