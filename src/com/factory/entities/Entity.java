package com.factory.entities;

public abstract class Entity {
	private int id;
	
	

	public Entity() {
		super();
	}

	public Entity(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}
	
	

}
