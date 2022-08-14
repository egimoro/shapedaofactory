package com.factory.dao;

import java.util.Scanner;

import com.factory.entities.Circle;
import com.factory.entities.Rectangle;
import com.factory.entities.Square;

public class ShapeDaoFactory extends AbstractDaoFactory {
	@Override
	public DAO getShape(String name) {

		switch(name.toLowerCase()) {
		
		case "square":
			Scanner scan = new Scanner(System.in);

			SquareDao squaredao = new SquareDao();
			Square square = new Square();
		
			int choice = 0;
			do {
				System.out.println("1) create \n2) read \n3) update"
						+ "\n4) delete \n5) area \n6) exit");

				choice = Integer.parseInt(scan.nextLine());

			switch(choice) {
			case 1:
				square.setBase(6);
				squaredao.add(square);
				System.out.println("Base added!");
				break;
			case 2:
				squaredao.read();
				break;
			case 3:
				square.setBase(4);
				square.setId(5);
				squaredao.update(square);
				break;
			case 4:
				squaredao.delete(7);
				break;
			case 5:
				squaredao.getArea();
				break;
			case 6:
				System.out.println("Bye.");
				break;
			default:
				System.out.println("Wrong choice.");	
			}
			}while(choice != 6);
		
			return new SquareDao();
		case "rectangle":
			RectangleDao rectangledao = new RectangleDao();
			Rectangle rectangle = new Rectangle();
			scan = new Scanner(System.in);
			choice = 0;
			do {
				System.out.println("1) create \n2) read \n3) update"
						+ "\n4) delete \n5) area \n6) exit");

				choice = Integer.parseInt(scan.nextLine());
				
				switch(choice) {
				case 1:
					rectangle.setBase(14);
					rectangle.setHeight(5);
					rectangledao.add(rectangle);
					break;
				case 2:
					rectangledao.read();
					break;
				case 3:
					rectangle.setBase(0);
					rectangle.setHeight(0);
					rectangle.setId(0);
					break;
				case 4:
					rectangledao.delete(1);
					break;
				case 5:
					rectangledao.getArea();
					break;
				case 6:
					System.out.println("Bye.");
					break;
				default:
					System.out.println("Wrong choice.");
				
				}
				
			}while(choice != 6);
			
			return new RectangleDao();
		case "circle":
			 final double PI = 3.14;

			do {
			CircleDao circledao = new CircleDao();
			Circle circle = new Circle();
			scan = new Scanner(System.in);
			System.out.println("1) Add \n2) Read \n3) Update \n4) Delete \n5) Area \n6) Exit");
			 choice = Integer.parseInt(scan.nextLine());
			 switch(choice) {
			 case 1:
				 circle.setRadius(9);
				 circle.setPi(PI);
				 circledao.add(circle);
				 break;
			 case 2:
				 circledao.read();
				 break;
			 case 3:
				 circle.setRadius(15);
				 circle.setId(3);
				 circledao.update(circle);
				 break;
			 case 4:
				 circledao.delete(2);
				 break;
			 case 5:
				 circledao.getArea();
				 break;
			 case 6:
				 System.out.println("Bye.");
				 break;
			default:
				System.out.println("Wrong choice.");
			 
			 }
			}while(choice != 6);
			return new CircleDao();
		default:
			return null;	
		}

	}
}
