package cda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDAClient;
import com.contentful.java.cda.CDAEntry;

import cda.custom.CDACustom;
import cda.parser.CDAParser;

public final class CDAManager {
	private final static String space = "k9b41bs3k4e1";
	private final static String token = "qOdE1hZZpxgpRJRSE2uAUKlgUpvc0p0hJpd3Q-qghCk";
	private final static CDAClient client = CDAClient.builder().setSpace(space).setToken(token).build();
	private final static CDAManager cdaManager = new CDAManager();

	private CDAManager() {
	}

	public static CDAManager getInstance() {
		return cdaManager;
	}

	public static String fetch(String entry) {
		CDAEntry cdaEntry = client.fetch(CDAEntry.class).one(entry);
		CDAParser parser = CDAParser.getInstance();
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		// transformar a fecha de formato del wcm_portal 
		cdas.add(parser.evaluar("createdAt", cdaEntry.attrs().get("createdAt")));
		cdas.add(parser.evaluar("updatedAt", cdaEntry.attrs().get("updatedAt")));

		for (Map.Entry<String, Object> ent : cdaEntry.rawFields().entrySet()) {

			CDACustom cda;
			if ((cda = parser.evaluar(ent.getKey(), cdaEntry.getField(ent.getKey()))) != null) {
				System.out.println("TRUE=== " + cdaEntry.getField(ent.getKey()).getClass() + "--- " + ent.getKey()
				+ " -> " + cdaEntry.getField(ent.getKey()).toString());
				cdas.add(cda);
			} else {
				System.out.println("FALSE=== " + cdaEntry.getField(ent.getKey()).getClass() + "--- " + ent.getKey()
						+ " -> " + cdaEntry.getField(ent.getKey()).toString());
				// TODO: una exception debe lanzarse
			}

		}
		HashMap<String, Object> hashs = new HashMap<String, Object>();
		cdas.forEach((cda) -> hashs.putAll(cda.getHashMap()));
		return hashs.toString();

	}
	
	public static String fetchWithContentType(String contentTypeId) {
		CDAArray cdaArray = client.fetch(CDAEntry.class).
				withContentType(contentTypeId).all();
		System.out.println(cdaArray);
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		CDAParser parser = CDAParser.getInstance();
		for (Entry<String, CDAEntry> ent : cdaArray.entries().entrySet()) {

			CDACustom cda;
			if ((cda = parser.evaluar(ent.getKey(), ent.getValue())) != null) {
				System.out.println("TRUE=== " + ent.getValue().getClass() + "--- " + ent.getKey()
				+ " -> " + ent.toString());
				cdas.add(cda);
			} else {
				System.out.println("FALSE=== " + ent.getValue().getClass() + "--- " + ent.getKey()
				+ " -> " + ent.toString());
				// TODO: una exception debe lanzarse
			}

		}
		return cdas.toString();
	}
}
