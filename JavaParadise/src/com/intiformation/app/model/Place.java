package com.intiformation.app.model;
import java.io.Serializable;

public class Place implements Serializable {
	
	//Attributes
	private Long id ;
	private String name ;
	
	//Constructor
	public Place() {
	}
	
	public Place(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Place(String name) {
	this.name =name;
	}

	// Methods
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
