package com.cupakitodo.rest.webservices.restfulwebservices.helloworld;

public class Pingvincine extends MiniJava {
	static public int fish =0;
	static public int red = 0;
	static public int kolona = 0;
	static public boolean fishAvailable[][];
	static public boolean moze = false;
	static public int broj =0;
	
    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
    	//System.out.println(world.length + world[0].length );
    	fish =0;
    	broj=0;
    	
    	try {
    		
    	fishAvailable = new boolean[world.length][world[0].length];
    	for(int i = 0; i <  world.length; i++) {
    		for(int j =0; j < world[i].length; j++) {
    			fishAvailable[i][j] = true;
    			//System.out.println(fishAvailable[i][j]);
    		}
    	}
    	fishAvailable[0][0] = false;
    	
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	for(int i = 0; i < world.length; i++) {
    	   for(int j = 0; j < world[i].length; j++) {
    		   if(j > 0)
    			   System.out.print("\t");
    		   if(world[i][j] == 0) 
    			   System.out.print("L");
    		   if(world[i][j] == 1)
    			   System.out.print("E");
    		   if(world[i][j] == 2)
    			   System.out.print("W");
    		   if(world[i][j] == 3) {
    			   System.out.print("H");
    			   fishAvailable[i][j] = false;
    		   }
    		   if(world[i][j] == 4) {
    			   System.out.print("F");
    			   fishAvailable[i][j] = false;
    		   }
    		   if(i == pinguRow && j == pinguColumn)
    			   System.out.print("(P)");
    		   //System.out.print("\t");
    	   }
    	   System.out.println();
       }
    }
    
    public static int move(int[][] world, int pinguRow, int pinguColumn) {
    	if(fish != 0) {
    		return 0;
    	}
    	broj++;
    	//System.out.println(fishAvailable.length + fishAvailable[0].length);
    	
		
		 for(int i = 0; i < fishAvailable.length; i++) { 
			 for(int j=0; j < fishAvailable[i].length; j++) {
				 //System.out.println(fishAvailable[i][j]);
			 	 if(fishAvailable[i][j]) {
			 		 moze = true; 
			 	 	break;
			 	 }
			 }
		 }
		 if(!moze) {
			 return 0;
		 }
		 moze= false;
		 try {
			 fishAvailable[pinguRow][pinguColumn] = false;
		 } catch(Exception e) {
			 
		 }
    	
    	if(pinguRow >= world.length)
    		return 0;
    	if(pinguRow < 0)
    		return 0;
    	if(pinguColumn >= world[pinguRow].length)
    		return 0;
    	if(pinguColumn < 0)
    		return 0;
    	// ovo je pravilo kako se krece po zemlji
    	if(world[pinguRow][pinguColumn] == 0) { // land
    		try {
    			if(!(pinguRow ==red && pinguColumn +1 ==kolona)) {
    				if(fishAvailable[pinguRow][pinguColumn +1] == true || world[pinguRow][pinguColumn+1] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow, pinguColumn + 1); // down
    				}
    			}
    		} catch(Exception e) {System.out.println(e);}
    		
    		if(!(pinguRow - 1==red && pinguColumn==kolona)) {
    			try {
    				if(fishAvailable[pinguRow - 1][pinguColumn] == true || world[pinguRow-1][pinguColumn] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow - 1, pinguColumn); // left
    				}
    			}catch(Exception e) {System.out.println(e);}
    		}
    		if(!(pinguRow + 1==red && pinguColumn==kolona)) {
    			try {
    				if(fishAvailable[pinguRow + 1][pinguColumn] == true || world[pinguRow+1][pinguColumn] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow + 1, pinguColumn); // right
    				}
    			}catch(Exception e) {System.out.println(e);}
    		}
    		if(!(pinguRow ==red && pinguColumn -1 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow][pinguColumn-1] == true || world[pinguRow][pinguColumn-1] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow, pinguColumn - 1); // up
    				} 
    			} catch(Exception e) {System.out.println(e);}
    		}
    		
    		
    		
    	}
    	// pravilo po ledu
    	if(world[pinguRow][pinguColumn] == 1) { // ice diagonal
    		if(!(pinguRow -1 ==red && pinguColumn -1 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow-1][pinguColumn-1] == true || world[pinguRow-1][pinguColumn-1] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow - 1, pinguColumn - 1); // up left
    				}
    			} catch(Exception e){System.out.println(e);}
    		}
    		
    		if(!(pinguRow -1 ==red && pinguColumn +1 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow-1][pinguColumn+1] == true || world[pinguRow-1][pinguColumn+1] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow - 1, pinguColumn + 1); // up right
    				}
    			} catch(Exception e) {System.out.println(e);}
    		}
    		
    		if(!(pinguRow +1 ==red && pinguColumn -1 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow+1][pinguColumn-1] == true || world[pinguRow+1][pinguColumn-1] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow + 1, pinguColumn - 1); // down left
    				}
    			} catch(Exception e) {System.out.println(e);}
    		}			
    		
    		if(!(pinguRow +1==red && pinguColumn +1 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow+1][pinguColumn+1] == true || world[pinguRow+1][pinguColumn+1] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow + 1, pinguColumn + 1); // down right
    				}
    			} catch(Exception e) {System.out.println(e);}
    		}
    	}
    	// pravilo u vodi
    	if(world[pinguRow][pinguColumn] == 2) { // water diagonal + 3
    		if(!(pinguRow -3 ==red && pinguColumn -3 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow-3][pinguColumn-3] == true || world[pinguRow-3][pinguColumn-3] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow - 3, pinguColumn - 3); // up left
    				}
    			} catch(Exception e) {System.out.println(e);}
    		}
    		
    		if(!(pinguRow -3 ==red && pinguColumn +3 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow-3][pinguColumn+3] == true || world[pinguRow-3][pinguColumn+3] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow - 3, pinguColumn + 3); // up right
    				}
    			} catch(Exception e) {System.out.println(e);}
    		}
    		
    		if(!(pinguRow +3 ==red && pinguColumn -3 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow+3][pinguColumn-3] == true || world[pinguRow+3][pinguColumn-3] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow + 3, pinguColumn - 3); // down left
    				}
    			} catch(Exception e) {System.out.println(e);}
    		}
    		
    		if(!(pinguRow +3 ==red && pinguColumn +3 ==kolona)) {
    			try {
    				if(fishAvailable[pinguRow+3][pinguColumn+3] == true || world[pinguRow+3][pinguColumn+3] == 4) {
    					red = pinguRow;
    					kolona = pinguColumn;
    					fish += move(world, pinguRow + 3, pinguColumn + 3);
    				}
    			} catch(Exception e) {System.out.println(e);}
    		}
    	}
    	// ako naleti na ajkulu
    	if(world[pinguRow][pinguColumn] == 3) { // shark
    		return 0;							// dead
    	}
    	// treba da nadje ribu
    	if(world[pinguRow][pinguColumn] == 4) { // fish
    		//move(world, pinguRow, pinguColumn);
    		fish++;
    		//return fish;
    	}
    	return fish;
    }

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn){
        int fish = move(world, pinguRow, pinguColumn);
    	if(fish > 0)
        	return true;
        return false;
    }

    /**
     * Gibt die Beispielwelt Nr. 1 zurück.
     * Modifizieren Sie diese Methode nicht.
     * @return Eine Beispielwelt
     */
    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
    }

    /**
     * Gibt die Beispielwelt Nr. 2 zurück.
     * Modifizieren Sie diese Methode nicht.
     * @return Eine Beispielwelt
     */
    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    /** 
     *  Sie können die main-Methode verwenden, um Ihr Programm zu testen. 
     */
    public static void main(String[] args){
        int pinguRow = 0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldOne();
        //int[][] world2 = generateExampleWorldTwo();
        printWorld(world, pinguRow, pinguColumn);
        write(""+isFishReachable(world, pinguRow, pinguColumn));
        
        System.out.println(broj);
        world = generateExampleWorldTwo();
        printWorld(world, pinguRow, pinguColumn);
        write(""+isFishReachable(world, pinguRow, pinguColumn));
        System.out.println(broj);
    }

}