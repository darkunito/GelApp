package edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.model;

public class Topping {
	private int toppingid;
	private String name;
	private String code_color;
	private long lastModified;
	private long creationTimestamp;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode_color() {
		return code_color;
	}
	public void setCode_color(String code_color) {
		this.code_color = code_color;
	}
	public int getToppingid() {
		return toppingid;
	}
	public void setToppingid(int toppingid) {
		this.toppingid = toppingid;
	}
	public long getLastModified() {
		return lastModified;
	}
	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}
	public long getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(long creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	
}
	
	
