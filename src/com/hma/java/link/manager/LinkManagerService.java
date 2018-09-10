package com.hma.java.link.manager;

import java.util.ArrayList;

import com.hma.java.link.model.Link;

public class LinkManagerService {
	private ArrayList<Link> links;
	private LinkManager manager;

	public LinkManagerService(LinkManager manager) {
		this.manager = manager;
		load();
	}

	public LinkManager getManager() {
		return manager;
	}

	public void setManager(LinkManager manager) {
		this.manager = manager;
	}

	public int addLink(Link link) {
		links.add(link);
		return save();
	}

	public int updateLink(Link link, int index) {
		links.remove(index);
		links.add(index, link);
		return save();
	}

	public int deleteLink(int index) {
		links.remove(index);
		return save();

	}

	public void load() {
		links = manager.laodLinks();
	}

	public int save() {
		return manager.saveLinks(links);
	}

	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}

	public Link getLinkByIndex(int index) {
		return links.get(index);
	}

}
