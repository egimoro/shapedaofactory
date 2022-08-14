package com.factory.entities;

public class Rectangle extends Entity {
	private int base;
	private int height;
	public Rectangle(int id, int base, int height) {
		super(id);
		this.base = base;
		this.height = height;
	}
	public Rectangle() {
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return super.toString() + "\nRectangle [base=" + base + "\n height=" + height + "]";
	}
	
	
	

}
