package com.hma.java.link.model;

public class Link {
	private String label;
	private String value;

	public Link() {
	}

	public Link(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return label + "|" + value + "\n";
	}

}
