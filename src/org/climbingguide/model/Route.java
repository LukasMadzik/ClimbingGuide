package org.climbingguide.model;

public class Route{

	private int id;
	private String name;
	private int idOfSector;
	private String dificulty;
	private int bolts;
	private int length;

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
	public int getIdOfSector() {
		return idOfSector;
	}
	public void setIdOfSector(int idOfSector) {
		this.idOfSector = idOfSector;
	}
	public String getDificulty() {
		return dificulty;
	}
	public void setDificulty(String dificulty) {
		this.dificulty = dificulty;
	}
	public int getBolts() {
		return bolts;
	}
	public void setBolts(int bolts) {
		this.bolts = bolts;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
}
