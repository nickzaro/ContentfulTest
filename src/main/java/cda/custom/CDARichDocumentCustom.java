package cda.custom;

import java.util.HashMap;

import com.contentful.java.cda.rich.CDARichDocument;
import com.contentful.rich.html.HtmlContext;
import com.contentful.rich.html.HtmlProcessor;

public class CDARichDocumentCustom extends CDACustom {

	public boolean put(String key,Object entry) {
		if (!(entry instanceof CDARichDocument))
			return false;
		CDARichDocument ent =(CDARichDocument) entry;
		final HtmlProcessor processor = new HtmlProcessor();
		final HtmlContext context = new HtmlContext();
		final String html = processor.process(context, (CDARichDocument) ent);
		this.hash.put(key, html);
		return true;
	}

	
	public HashMap<String, Object> get() {
		return this.hash;
	}

}