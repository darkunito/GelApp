package edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.model;

import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.GelAppRootAPIResource;
import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.MediaType;

public class GelAppRootAPI {
	@InjectLinks({
        @InjectLink(resource = GelAppRootAPIResource.class, style = Style.ABSOLUTE, rel = "self bookmark home", title = "GelApp Root API")})
	private List<Link> links;

public List<Link> getLinks() {
	return links;
}

public void setLinks(List<Link> links) {
	this.links = links;
}
}