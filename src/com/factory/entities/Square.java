package com.factory.entities;

public class Square extends Entity{
	private int base;
	

	public Square() {
		
	}

	public Square(int id, int base) {
		super(id);
		this.base = base;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}
/*
	@Override
	public String toString() {
		return super.toString() + "\nSquare [base=" + base + "]";
	}
	*/
	
	
	

}
