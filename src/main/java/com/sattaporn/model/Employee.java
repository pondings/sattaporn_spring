package com.sattaporn.model;
// Generated Aug 6, 2017 12:26:10 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", schema = "public")
public class Employee implements java.io.Serializable {

	private int id;
	private String name;
	private String lname;
	private String sirName;
	private String fullName;

	public Employee() {
	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(int id, String name, String lname, String sirName, String fullName) {
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.sirName = sirName;
		this.fullName = fullName;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "lname")
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name = "sir_name", length = 20)
	public String getSirName() {
		return this.sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	@Column(name = "full_name")
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
