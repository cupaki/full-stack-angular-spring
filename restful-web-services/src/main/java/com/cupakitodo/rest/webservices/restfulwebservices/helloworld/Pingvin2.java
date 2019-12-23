package com.cupakitodo.rest.webservices.restfulwebservices.helloworld;

public class Pingvin2 extends MiniJava {

	static public int fish = 0;
	static public int row = -2;
	static public int column = 0;
	static public boolean fishAvailable[][];
	static public boolean yes = false;
	static public int broj=0;

	public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
		fish = 0;
		broj = 0;
		
		try {
		fishAvailable = new boolean[world.length][world[0].length];
		System.out.println("World " + world.length);
		System.out.println(world[0].length);
		System.out.println("fishA " + fishAvailable.length);
		//System.out.println(fishAvailable[0][7]);
		
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				fishAvailable[i][j] = true;
			}
		}
		fishAvailable[0][0] = false;
		}catch(Exception e) {System.out.println(e);}
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				if (j > 0)
					System.out.print("\t");
				if (world[i][j] == 0)
					System.out.print("L");
				if (world[i][j] == 1)
					System.out.print("E");
				if (world[i][j] == 2)
					System.out.print("W");
				if (world[i][j] == 3) {
					System.out.print("H");
					fishAvailable[i][j] = false;
				}
				if (world[i][j] == 4) {
					System.out.print("F");
					fishAvailable[i][j] = false;
				}
				if (i == pinguRow && j == pinguColumn)
					System.out.print("(P)");
			}
			System.out.println();
		}
	}

	public static int move(int[][] world, int pinguRow, int pinguColumn) {
		
		if (fish != 0)
			return 0;
		broj++;
		for (int i = 0; i < fishAvailable.length; i++) {
			for (int j = 0; j < fishAvailable[i].length; j++) {
				if (fishAvailable[i][j]) {
					yes = true;
					break;
				}
			}
		}
		if (!yes) {
			return 0;
		}
		yes = false;
		try {
			fishAvailable[pinguRow][pinguColumn] = false;
		} catch (Exception e) {

		}
		if (pinguRow >= world.length)
			return 0;
		if (pinguRow < 0)
			return 0;
		if (pinguColumn >= world[pinguRow].length)
			return 0;
		if (pinguColumn < 0)
			return 0;
		
		if (world[pinguRow][pinguColumn] == 0) { // land
			try {
				//if (!(pinguRow == row && pinguColumn + 1 == column)) {
					if (fishAvailable[pinguRow][pinguColumn + 1] == true || world[pinguRow][pinguColumn + 1] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow, pinguColumn + 1); // down
					}
				//}
			} catch (Exception e) { System.out.println(e);
			}
			//if (!(pinguRow - 1 == row && pinguColumn == column)) {
				try {
					if (fishAvailable[pinguRow - 1][pinguColumn] == true || world[pinguRow - 1][pinguColumn] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow - 1, pinguColumn); // left
					}
				} catch (Exception e) { System.out.println(e);
				}
			//}
			//if (!(pinguRow == row && pinguColumn == column)) {
				try {
					if (fishAvailable[pinguRow + 1][pinguColumn] == true || world[pinguRow + 1][pinguColumn] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow + 1, pinguColumn); // right
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}
			//if (!(pinguRow == row && pinguColumn - 1 == column)) {
				try {
					if (fishAvailable[pinguRow][pinguColumn - 1] == true || world[pinguRow][pinguColumn - 1] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow, pinguColumn - 1); // up
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}
		}

		if (world[pinguRow][pinguColumn] == 1) { // ice (diagonal)
			//if (!(pinguRow - 1 == row && pinguColumn - 1 == column)) {
				try {
					if (fishAvailable[pinguRow - 1][pinguColumn - 1] == true
							|| world[pinguRow - 1][pinguColumn - 1] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow - 1, pinguColumn - 1); // up left
					}
				} catch (Exception e) {System.out.println(e);
				//}
			}

			//if (!(pinguRow - 1 == row && pinguColumn + 1 == column)) {
				try {
					if (fishAvailable[pinguRow - 1][pinguColumn + 1] == true
							|| world[pinguRow - 1][pinguColumn + 1] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow - 1, pinguColumn + 1); // up right 
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}

			//if (!(pinguRow + 1 == row && pinguColumn - 1 == column)) {
				try {
					if (fishAvailable[pinguRow + 1][pinguColumn - 1] == true
							|| world[pinguRow + 1][pinguColumn - 1] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow + 1, pinguColumn - 1); // down left
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}

			//if (!(pinguRow + 1 == row && pinguColumn + 1 == column)) {
				try {
					if (fishAvailable[pinguRow + 1][pinguColumn + 1] == true
							|| world[pinguRow + 1][pinguColumn + 1] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow + 1, pinguColumn + 1); // down right
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}
		}

		if (world[pinguRow][pinguColumn] == 2) { // (water) 3 x diagonal
			//if (!(pinguRow - 3 == row && pinguColumn - 3 == column)) {
				try {
					if (fishAvailable[pinguRow - 3][pinguColumn - 3] == true
							|| world[pinguRow - 3][pinguColumn - 3] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow - 3, pinguColumn - 3); // up left
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}

			//if (pinguRow - 3 == row && pinguColumn + 3 == column) {
				try {
					if (fishAvailable[pinguRow - 3][pinguColumn + 3] == true
							|| world[pinguRow - 3][pinguColumn + 3] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow - 3, pinguColumn + 3); // up right
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}
			//if (!(pinguRow + 3 == row && pinguColumn - 3 == column)) {
				try {
					if (fishAvailable[pinguRow + 3][pinguColumn - 3] == true
							|| world[pinguRow + 3][pinguColumn - 3] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow + 3, pinguColumn - 3); // down left
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}
			//if (!(pinguRow + 3 == row && pinguColumn + 3 == column)) {
				try {
					if (fishAvailable[pinguRow + 3][pinguColumn + 3] == true
							|| world[pinguRow + 3][pinguColumn + 3] == 4) {
						//row = pinguRow;
						//column = pinguColumn;
						fish += move(world, pinguRow + 3, pinguColumn + 3); // down right
					}
				} catch (Exception e) {System.out.println(e);
				}
			//}
		}

		if (world[pinguRow][pinguColumn] == 3) { // shark
			return 0; // dead
		}

		if (world[pinguRow][pinguColumn] == 4) { // fish
			fish++;
		}
		return fish;
	}

	public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
		int fish = move(world, pinguRow, pinguColumn);
		if (fish > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt die Beispielwelt Nr. 1 zurück. Modifizieren Sie diese Methode nicht.
	 * 
	 * @return Eine Beispielwelt
	 */
	public static int[][] generateExampleWorldOne() {
		return new int[][] { { 2, 3, 3, 3, 3, 3 , 2}, { 3, 0, 3, 3, 3, 3,0 }, { 3, 3, 3, 3, 3, 1,4 }, { 3, 3, 3, 0, 1, 3,1 },
				{ 3, 3, 3, 3, 3, 3,2 } };
	}

	/**
	 * Gibt die Beispielwelt Nr. 2 zurück. Modifizieren Sie diese Methode nicht.
	 * 
	 * @return Eine Beispielwelt
	 */
	public static int[][] generateExampleWorldTwo() {
		return new int[][] { { 0, 0, 0, 2 }, { 0, 0, 0, 1 }, { 0, 1, 3, 4 }, { 3, 4, 3, 3 } };
	}

	/**
	 * Sie können die main-Methode verwenden, um Ihr Programm zu testen.
	 */
	public static void main(String[] args) {
		int pinguRow = 0;
		int pinguColumn = 0;
		int[][] world = generateExampleWorldOne();
		// int[][] world = generateExampleWorldTwo();
		printWorld(world, pinguRow, pinguColumn);
		write("" + isFishReachable(world, pinguRow, pinguColumn));
		System.out.println(broj);
		
		//pinguRow = 0;
		//pinguColumn = 1;
		world = generateExampleWorldTwo();
		printWorld(world, pinguRow, pinguColumn);
		write(""+isFishReachable(world, pinguRow, pinguColumn));
		System.out.println(broj);
	}

}