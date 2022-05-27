package cda.custom;

import java.util.HashMap;

import com.contentful.java.cda.CDAAsset;
import com.contentful.java.cda.rich.CDARichDocument;
import com.contentful.java.cda.rich.CDARichEmbeddedBlock;
import com.contentful.java.cda.rich.CDARichNode;
import com.contentful.rich.html.HtmlContext;
import com.contentful.rich.html.HtmlProcessor;

import cda.render.AssetCheckerCustom;
import cda.render.AssetRenderCustom;

public class CDARichDocumentCustom extends CDACustom {

	public boolean put(String key, Object entry) {
		if (!(entry instanceof CDARichDocument))
			return false;
		CDARichDocument ent = (CDARichDocument) entry;

		final HtmlProcessor processor = new HtmlProcessor();

		processor.addRenderer(new AssetCheckerCustom(), new AssetRenderCustom());
		final HtmlContext context = new HtmlContext();
		final String html = processor.process(context, (CDARichDocument) ent);
		this.hash.put(key, html);
		return true;
	}

	public HashMap<String, Object> getHashMap() {
		return this.hash;
	}

	@Override
	public CDACustom get() {
		CDACustom cda = new CDARichDocumentCustom();
		cda.hash.putAll(this.hash);
		return cda;
	}

	@Override
	public boolean put(Object entry) {
		if (!(entry instanceof CDARichDocument))
			return false;
		throw new UnsupportedOperationException();
	}

}
