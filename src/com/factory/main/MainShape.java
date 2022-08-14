package com.factory.main;


import java.util.Scanner;

import com.factory.dao.ShapeDaoFactory;

public class MainShape {

	public static void main(String[] args) {
		ShapeDaoFactory shape = new ShapeDaoFactory();
		String type = "";
		String ans = "";
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Insert shape (Square, Rectangle, Circle).");
			type = scan.nextLine();
			if (type.equalsIgnoreCase("square")) {
				shape.getShape(type);
			}else if (type.equalsIgnoreCase("rectangle")) {
				shape.getShape(type);
			}else if(type.equalsIgnoreCase("circle")){
				shape.getShape(type);
				}else
					System.out.println("Null.");
			System.out.println("Would you like to continue? Yes/Y");
			ans = scan.nextLine();
		}while(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y"));
	}			


}
