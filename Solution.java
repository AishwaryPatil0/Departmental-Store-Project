package com;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Smart Bazar");
		System.out.println("***********************");

		Scanner scan= new Scanner (System.in);
		DepartmentalStore store= new DepartmentalStore();

		store.addProduct();

		int choice=1;
		while(choice == 1)
		{
			store.displayProduct();
			store.buyProduct();
			System.out.println("--------------------");
			System.out.println("Press 1 to Continue or any other number to checkout");
			choice=scan.nextInt();//10
		}

		store.checkOut();
	}

}
