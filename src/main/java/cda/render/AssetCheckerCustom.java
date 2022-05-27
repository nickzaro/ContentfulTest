package cda.render;

import com.contentful.java.cda.CDAAsset;
import com.contentful.java.cda.rich.CDARichEmbeddedBlock;
import com.contentful.java.cda.rich.CDARichNode;
import com.contentful.rich.core.RenderabilityChecker;
import com.contentful.rich.html.HtmlContext;

public class AssetCheckerCustom implements RenderabilityChecker<HtmlContext> {

	@Override
	public boolean canRender(HtmlContext context, CDARichNode node) {
		return ((CDARichEmbeddedBlock) node).getData() instanceof CDAAsset;
	}

}
