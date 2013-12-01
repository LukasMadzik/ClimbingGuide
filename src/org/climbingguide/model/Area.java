package org.climbingguide.model;

import java.util.ArrayList;
import java.util.List;

public class Area{

	private int id;
	private String name;
	private List <Sector> sectors = new ArrayList<Sector>();
	
	public List<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
