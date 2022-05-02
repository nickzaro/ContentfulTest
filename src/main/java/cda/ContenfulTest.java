package cda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDAClient;
import com.contentful.java.cda.CDAEntry;

import cda.custom.CDACustom;
import cda.parser.CDAParser;


public class ContenfulTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		CDAClient client = CDAClient.builder().setSpace("k9b41bs3k4e1")
				.setToken("qOdE1hZZpxgpRJRSE2uAUKlgUpvc0p0hJpd3Q-qghCk").build();

		CDAEntry entry = client.fetch(CDAEntry.class).one("7i1r6q6MxFdH2V7Rp191gH");

		CDAArray result = client.fetch(CDAEntry.class).withContentType("products").all();

		CDAParser parser = CDAParser.getInstance();
	//	List<CDACustom> mapEntry = new ArrayList<CDACustom>();
	//	mapEntry.add(parser.add("createdAt", entry.attrs().get("createdAt")));
	//	mapEntry.add(parser.add("updatedAt", entry.attrs().get("updatedAt")));
		// mapEntry.putAll(entry.rawFields());
		for (Map.Entry<String, Object> ent : entry.rawFields().entrySet()) {
			
			if(parser.add(ent.getKey(), entry.getField(ent.getKey()))) {
				System.out.println("TRUE== "+entry.getField(ent.getKey()).getClass() + "--- " + ent.getKey() + " -> "
						+ entry.getField(ent.getKey()).toString());
			}
			else {
				System.out.println("FALSE=== "+entry.getField(ent.getKey()).getClass() + "--- " + ent.getKey() + " -> "
						+ entry.getField(ent.getKey()).toString());
			}
			//System.out.println(Class.forName("java.util.ArrayList").newInstance());
		}
		//mapEntry.stream().forEach(e -> System.out.println(e.get()));
		parser.getcDAOuts().forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		
	}
	
	
}
