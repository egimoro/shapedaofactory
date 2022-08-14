package com.factory.dao;

import java.util.*;

import com.factory.entities.Entity;

public interface DAO {
	public void add(Entity e);
	public List<Map<String,String>>read();
	
	public void update(Entity e);
	public void delete(int id);
	public void getArea();

}
