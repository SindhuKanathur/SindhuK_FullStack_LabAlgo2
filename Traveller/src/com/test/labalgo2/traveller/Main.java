package com.test.labalgo2.traveller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("enter the size of currency denominations");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		System.out.println("enter the currency denominations value");
		int[] denominations = new int[size];
		for (int i = 0 ; i < size; i++) {
			denominations[i] = sc.nextInt();
		}
		
		//Sort array in descending order
		mergeSort(denominations, 0 , size -1);
		
		System.out.println("enter the amount you want to pay");
		int target = sc.nextInt();

		//Use a hashmap to store the denomination value & the denomination count.
		Map<Integer, Integer> money = new LinkedHashMap<Integer, Integer>();
		int sum = 0;
		for (int j = 0; j < size; j++) {
			int count = 0, note = denominations[j];
			//Use the same denominations until the sum is greater than note. then switch to next note.
			while ((target - sum) >= note) {
				sum+= note;
				count++;
			}
			//If the denomination is used, put the count in hashmap.
			if (count > 0) {
				money.put(note, count);
			}
		}
		//Print the output.
		for (int key : money.keySet()) {
		    System.out.println(key+":"+money.get(key));
		}
	}

	// Main function to sort array using merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    // Merging function
    public static void merge(int[] arr, int left, int middle, int right) {
        int size1 = middle - left + 1;
        int size2 = right - middle;
        
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < size1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < size2; j++)
            rightArray[j] = arr[middle + 1 + j];
        
        // Initial indices of left and right sub-arrays
        int i = 0, j = 0;
        
        // Initial index of merged sub-array
        int k = left;
        while (i < size1 && j < size2) {
            // Descending order condition
            if (leftArray[i] >= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray
        while (i < size1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray
        while (j < size2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
