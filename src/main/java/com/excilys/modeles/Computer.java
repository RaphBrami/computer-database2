package com.excilys.modeles;
import java.sql.Date;
import java.time.*;
public class Computer  {
	
	private String name;
	private int id;
	private LocalDate introduced;
	private LocalDate discontinuited;
	private int companyId;
	
	/*
	 * constructeur
	 */
	public Computer() {

	}
	
	/*
	 * Accesseurs
	 */
	public Computer setName(String name) {
		
		this.name = name;
		return this;	
	}
	public Computer setId(int id) {
		
		this.id =id;
		return this;
	}
	public Computer setIntroduced(LocalDate introduced) {
		
		this.introduced = introduced;
		return this;
	}
	
	public Computer setDiscontinuited(LocalDate discontinuted) {
		
		this.discontinuited = discontinuted;
		return this;
	}
	
	public Computer  setCompagnyId(int companyId) {
		this.companyId = companyId;
		return this;
	}
	/*
	 * Mutateur
	 */
	public String getname() {
		
		return this.name;	
	}
	public int getid() {

		return this.id;
	}
	public LocalDate getIntroduced() {
		
		return this.introduced;
	}
	public LocalDate getDiscontinuited() {

		return this.discontinuited;
	}
	public int  getCompagnyId() {
		return this.companyId;
	
	}
	
	@Override
	public String toString() {
		return "Computer [name=" + name + ", id=" + id + ", introduced=" + introduced
				+ ", discontinuited=" + discontinuited + ", companyId=" + companyId + "]";
	}
}