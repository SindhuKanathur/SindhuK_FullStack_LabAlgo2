package com.test.labalgo2.paymoney;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("enter the size of transaction array");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		System.out.println("enter the values of array");
		int[] transactions = new int[size];
		for (int i = 0 ; i < size; i++) {
			transactions[i] = sc.nextInt();
		}
		System.out.println("enter the total no of targets that needs to be achieved");
		int iterations = sc.nextInt();

		for (int i = 0 ; i < iterations; i++) {
			System.out.println("enter the value of target");
			int target = sc.nextInt();
			
			int sum = 0;
			for (int j = 0; j < size; j++) {
				sum+= transactions[j];
				if (sum >= target) {
					System.out.println("Target achieved after "+(j+1)+" transactions");       
					break;
				}
			}
			if (target > sum) {
				System.out.println("Given target is not achieved");
			}
		}
	}
}
