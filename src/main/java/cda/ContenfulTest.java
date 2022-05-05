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

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		CDAClient client = CDAClient.builder().setSpace("k9b41bs3k4e1")
				.setToken("qOdE1hZZpxgpRJRSE2uAUKlgUpvc0p0hJpd3Q-qghCk").build();

		CDAEntry entry = client.fetch(CDAEntry.class).one("7i1r6q6MxFdH2V7Rp191gH");

		CDAParser parser = CDAParser.getInstance();
		ArrayList<CDACustom> cdas = new ArrayList<CDACustom>();
		cdas.add(parser.evaluar("createdAt", entry.attrs().get("createdAt")));
		cdas.add(parser.evaluar("updatedAt", entry.attrs().get("updatedAt")));
		
		for (Map.Entry<String, Object> ent : entry.rawFields().entrySet()) {

			CDACustom cda;
			if ((cda = parser.evaluar(ent.getKey(), entry.getField(ent.getKey()))) != null) {
				System.out.println("TRUE== " + entry.getField(ent.getKey()).getClass() + "--- " + ent.getKey() + " -> "
						+ entry.getField(ent.getKey()).toString());
				System.out.println(cda);
				cdas.add(cda);
			} else {
				System.out.println("FALSE=== " + entry.getField(ent.getKey()).getClass() + "--- " + ent.getKey()
						+ " -> " + entry.getField(ent.getKey()).toString());
			}

		}
		System.out.println();
		cdas.forEach((v) -> System.out.println(v));

	}

}
