package com;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStore {

	//key->Integer->product Id  &value->product->product instance
	LinkedHashMap<Integer, Product> db= new LinkedHashMap<Integer, Product> ();

	Scanner scan=new Scanner(System.in);
	int totalBill= 0;

	public void addProduct()
	{
		db.put(1, new Product("Chacolates",10, 10)); //Product p1= new Product("Chacolates",10, 10);
		db.put(2, new Product("Biscuits",20, 20));   //Product p2= new Product "Biscuits",20, 20);
		db.put(3, new Product("Icecream",30, 50));  //Product p3= new Product("Icecream",30, 50);
	}
	public void displayProduct()
	{
		Set<Integer> keys=db.keySet();//1 2 3
		for(int key: keys)
		{
			Product p= db.get(key); //getting product
			System.out.println("Enter "+ key+" to order"+p.getName());
			System.out.println("Available Quantity:"+ p.getQuantity());
			System.out.println("Cost: Rs. "+ p.getCost());
			System.out.println("------------------------");
		}
	}
	public void buyProduct()
	{
		System.out.println("Enter the choice:");
		int choice = scan.nextInt(); //choice-> key

		Product p= db.get(choice); // getting the product

		if(p!=null)
		{
			System.out.println("Enter Quantity");
			int quantity =scan.nextInt();

			if(quantity<= p.getQuantity())
			{
				// current product cost calculating
				int productCost= quantity * p.getCost();

				//Adding current product cost to total bill
				totalBill = totalBill + productCost; // totalBill +=productCost

				//Update new Quantity
				p.setQuantity(p.getQuantity() - quantity);

				System.out.println("Ordered "+quantity+" "+p.getName());
				System.out.println("Current Product Cost: Rs."+productCost);
				System.out.println("Total Bill as of now: "+totalBill);

			}
			else
			{
				System.out.println("Invalid Quantity"); //InvalidQuantityException
			}
		}
		else
		{
			System.out.println("Invalid Choice"); //InvalidChoiceException
		}
	}


	public void checkOut()
	{
		System.out.println("Total Bills: Rs."+totalBill);
		System.out.println("Thank you for shopping!");
	}
}
