package com.blogs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;

	public Tag() {

	}

	public Tag(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name + "]";
	}

	// contract for overriding equals and hashcode
	public boolean equals(Object o) {
		System.out.println("In tags equals");
		if (o instanceof Tag) {
			Tag tag = (Tag) o;
			return this.name.equals(name);
		}
		return false;
	}
	@Override
	public int hashCode()
	{
		System.out.println("In tags hashcode");
		return name.hashCode();	}

}
