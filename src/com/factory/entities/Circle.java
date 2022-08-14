package com.factory.entities;

public class Circle extends Entity {
	private int radius;
	private double pi;
	public Circle(int id, int radius, double pi) {
		super(id);
		this.radius = radius;
		this.pi = pi;
		
	}
	public Circle() {
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	
	
	
	

}
