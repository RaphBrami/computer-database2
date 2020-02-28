package com.excilys.modeles;

public class Compagnie {

	private String name;
	private int id;
	
	/*
	 * Constructeur
	 */
	
	public Compagnie() {
		
	}
	/*
	 * Accesseurs
	 */
	public Compagnie setName(String name) {
		
		this.name= name;
		return this;	
	}
	public Compagnie setId(int id) {
		
		this.id=id;
		return this;
	}
	/*
	 * Mutateur
	 */
	
	public String getName() {
		
		return this.name;
	}
	
	public int getId() {
		
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Company [,id=" + id + ", name=" + name + "]";
	}
	
}