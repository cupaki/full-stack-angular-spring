package com.cupakitodo.rest.webservices.restfulwebservices.helloworld;

import java.util.Arrays;

public class GameWithArrays {

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };
		//int[] n = otherSort(arr1, arr2);
		int[] arr3 = {2,1};
		int[] arr4 = {3,5,6,7,5,7,1};
		System.out.println(alpen2(arr4));
		//plankton(arr3);
	}
	
	public static int[] othersort2(int[] arr, int[] arr2) {
		int mesto = -1; 
		int[] sorted = new int[arr.length];
		for(int i = 0; i<arr2.length; i++) {//ubacuje prvo one koji se poklapaju
			for(int j=0; j<arr.length; j++) {
				if(arr[j] == arr2[i]) {
					mesto++; //mesto se poveca na 0 i odatle krece ubacivanje
					sorted[mesto] = arr[j];
				}
			}
		}
		
		
		for(int i = 0; i<arr.length; i++) { //ubacuje one kojih nema u drugom
			boolean isti = false;
			for(int j=0; j<arr2.length; j++) {
				if(arr2[j] == arr[i]) {
					isti = true;
					//break;
				}
			}
			if(isti == false) {
				mesto++;
				sorted[mesto] = arr[i];
			}
		}
		
		return sorted;
	}

	public static int[] otherSort(int[] arr, int[] arr2) {
		int m = 0; // ruck brojac mesta
		int n = 0; // temp brojac mesta
		int[] ruck = new int[arr.length];
		int l = 0; // za broj istih

		for (int j = 0; j < arr2.length; j++) { // izracunava koja je duzina temp[]
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == arr2[j])
					l++;
			}
		}
		int[] temp = new int[arr.length];

		boolean isti = false;
		//int i = 0;

		for (int j = 0; j < arr.length; j++) { // udje u arr2
			isti = false;
			for (int i = 0; i < arr2.length; i++) { // udje u arr
				if (arr[j] == arr2[i]) {
					ruck[m] = arr[j]; // ako je isti broj prepisuje ga u ruck[]
					m += 1;
					isti = true;
				}
			}
			
			if (!isti) {
				temp[n] = arr[j];
				n += 1;
			}
		}
		//System.out.println(Arrays.toString(temp));

		for (int j = 0; j < temp.length; j++) {
			for (int i = 0; i < ruck.length; i++) {
				if (ruck[i] == 0) {
					ruck[i] = temp[j];
					j++;
				}
			}
		}
		return ruck;
	}

	public static int[] fairFriends(int[] arr, int[] arr2) {
		int[] tausch = new int[2];
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < arr.length; i++)
			sum1 += arr[i];
		for (int j = 0; j < arr2.length; j++)
			sum2 += arr2[j];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (sum1 - arr[i] + arr2[j] == sum2 - arr2[j] + arr[i]) {
					tausch[0] = arr[i];
					tausch[1] = arr2[j];
					return tausch;
				}
			}
		}
		return tausch;
	}

	public static boolean alpen(int[] arr) {
		boolean alpen = false;

		if (arr[0] >= arr[1]) {
			alpen = false;
			return alpen;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= arr[i + 1]) {
				for (int j = arr.length; j > i; j--) {
					System.out.println("ar j: " + arr[j] + "drugi -1: " + arr[j-1]);
					if (arr[j] >= arr[j - 1]) {
						if (j == i) {
							alpen = true;
							return alpen;
						} else
							break;
					}
				}
			}
		}
		return alpen;
	}
	
	public static boolean alpen2(int[] arr) {
		boolean alpen = false;
		boolean opada = false;
		if (arr[0] >= arr[1]) {
			alpen = false;
			return alpen;
		}
		for (int i = 1; i < arr.length-1; i++) {
			if (arr[i] >= arr[i + 1]) {
				alpen = true;
				for (int j = arr.length-1; j > i; j--) {
					if (arr[j] >= arr[j - 1]) {
						alpen = false;
						break;

					}
				}
				break;
			}
		}
		return alpen;
	}

	public static int[] plankton(int[] arr) {
		int profit = 0;
		int[] mafia = new int[3];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i < j) {
					if (arr[j] - arr[i] > profit) {
						profit = arr[j] - arr[i];
						mafia[0] = i;
						mafia[1] = j;
						mafia[2] = profit;
					}
				}
			}
		}
		return mafia;
	}


	
	
	public static int EA(int n1, int n2) {
		System.out.println("EA " + n1 + "drugi " + n2);
		if (n1 == 0)
			return n2;
		return EA(n2 % n1, n1);
	}
	
	static int euclid(int a, int b)
	{
		// do until the two numbers become equal
		while (a != b)
		{
			// replace larger number by its difference with the smaller number
			if (a > b)
			   a = a - b;
			else
			   b = b - a; 
		}
		System.out.print(a + "dsadsad");
		return a;		// or b (since both are equal)
	}

	public static int pinguinFreunde(int[] arr) {
		int gleich = 0;
		int gruppe;
		int[] temp = new int[arr.length];
		// for(int i = 0; i < arr.length; i++) {
		// for(int j = 0; j < arr.length; j++) {
		// treba da izbroji koliko ima istih
		// i upise kolicinu u novi niz
		// }
		// }

		for (int i = 1; i <= 105; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == arr[j]) {
					gleich++;
					//break;
				}
			}
			if (gleich > 0) {
				for (int l = 0; l < temp.length; l++) { // Da li je ovaj if na pravom mestu
					if (temp[l] == 0)
						temp[l] = gleich;
				}
			}
			gleich = 0; // Da li je ovo na pravom mestu
		}

		gruppe = temp[0];
		System.out.println(Arrays.toString(temp));
		//System.out.println("grupe " + gruppe);
		for (int i = 1; i < temp.length; i++) {
			System.out.println("uforu " + temp[i]);
			gruppe = euclid(temp.length, gruppe);
			
			System.out.println(gruppe);
		}

		if (gruppe == 1)
			gruppe = 0;
		System.out.println(gruppe);
		return gruppe;
		/*
		 * treba da prebrojim od svakog broja koliko istih imam pa da nadjem naveci
		 * zajednicki delilac i da ga ispise ako nema onda 0 1 ne moze - min 2
		 */
	}
}
	
