package cda.render;

import com.contentful.java.cda.CDAAsset;
import com.contentful.java.cda.rich.CDARichEmbeddedBlock;
import com.contentful.java.cda.rich.CDARichMark;
import com.contentful.java.cda.rich.CDARichNode;
import com.contentful.java.cda.rich.CDARichText;
import com.contentful.rich.core.Renderer;
import com.contentful.rich.html.HtmlContext;

import io.reactivex.annotations.Nullable;
import io.reactivex.annotations.NonNull;
/**
 * This renderer will generate an html tag.
 */
public class AssetRenderCustom implements Renderer<HtmlContext, String> {
	

  @Nullable @Override
  public String render(@NonNull HtmlContext context, @NonNull CDARichNode node) {
	  final StringBuilder result = new StringBuilder();
	  if (((CDARichEmbeddedBlock) node).getData() instanceof CDAAsset) {
		  CDAAsset asset = (CDAAsset) ((CDARichEmbeddedBlock) node).getData();
		  result.insert(0, "<img src=\"").append(asset.url()).append("\"/>");
	  }

    result.append("\n");
    return result.toString();
  }
}