package com.cupakitodo.rest.webservices.restfulwebservices.helloworld;

import java.util.Arrays;

public class Njemacka2 extends MiniJava {
	public static int[] playerPoints = {0, 0}; 
	// sorting method from the lecture
	public static int[] sort(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; ++i) {
			// begin of insert
			int j = 0;
			while (j < i && a[i] > b[j])
				++j;
			// end of locate
			for (int k = i - 1; k >= j; --k)
				b[k + 1] = b[k];
			// end of shift
			b[j] = a[i];
			// end of insert
		}
		return b;
	} // end of sort

	public static void main(String[] args) throws IllegalAccessException {
		//int[] stapel1 = new int[4];
		//int[] stapel2 = new int[4];
		//int[] stapel3 = new int[4];
		//int[] stapel4 = new int[4];
		int[][] playerCards = new int[2][10];
		givePlayerCards(playerCards);
		//System.out.println(playerCards[0][5]);
		int[][] stapel = new int[4][5];
		//System.out.println(stapel[0][4]);
		for(int i = 0; i < stapel.length; i++) {
			stapel[i][0] = drawCard();
		}
		//System.out.println(stapel[0][0]);
		//outputStapel(stapel);
		
		//stapel1[0] = drawCard();
		//stapel2[0] = drawCard();
		//stapel3[0] = drawCard();
		//stapel4[0] = drawCard();
		// da li staplove napisati kao jedan 2-dimenzionalan niz??
		
		int runden = 0;
		int karte1;
		int karte2;
		//boolean 
		
		
		do {
			outputStapel(stapel);
			int player = 1;
			karte1 = playerSelectCard(player, playerCards);
			player++;
			karte2 = playerSelectCard(player, playerCards);
			player = 1; // mozda ovo ni ne moram jer je odmah posle do int player = 1;
			// da li negde moram da sacuvam vrednost koje mi ove metode daju
			//ili su automatski sacuvane???
			
			
			if(karte1 <= karte2) {
				stapel = putCard(stapel, karte1, 0);
				stapel = putCard(stapel, karte2, 1);
			} else {
				stapel = putCard(stapel, karte2, 1);
				stapel = putCard(stapel, karte1, 0);
			}
			
			
			
			// 
//			if(karte1 < karte2) { // mozda da upisem karte u sortiran niz??
//				for(int i = 0; i < stapel.length; i++) {
//					for(int j = 0; j < stapel[i].length; j++) {
//						if(stapel[i][j + 1] == 0 && stapel[i][j] < karte1 && stapel[i][4] != 0) {
//							stapel[i][j+1] = karte1;
//						}
//					}
//				}	
//			}
			// treba sortirati staplove
			
			runden++;
		} while(runden < 10);
		outputResult(playerPoints);
	}

	public static void outputStapel(int[][] stapel) { //ispise karte na stolu
		System.out.print("Stapel 1: ");
		for(int i = 4; i >= 0; --i) {
			if(stapel[0][i] > 0)
				System.out.print(stapel[0][i] + " ");
				//continue;
			//System.out.print("Stapel 1: " + stapel[0][i] + " ");
		}
		System.out.println();
		
		System.out.print("Stapel 2: ");
		for(int i = 4; i >= 0; --i) {
			if(stapel[1][i] > 0)
				System.out.print(stapel[1][i] + " ");
				//continue;
			//System.out.print("Stapel 1: " + stapel[0][i] + " ");
		}
		System.out.println();
		
		System.out.print("Stapel 3: ");
		for(int i = 4; i >= 0; --i) {
			if(stapel[2][i] > 0)
				System.out.print(stapel[2][i] + " ");
				//continue;
			//System.out.print("Stapel 1: " + stapel[0][i] + " ");
		}
		System.out.println();
		
		System.out.print("Stapel 4: ");
		for(int i = 4; i >= 0; --i) {
			if(stapel[3][i] > 0)
				System.out.print(stapel[3][i] + " ");
				//continue;
			//System.out.print("Stapel 1: " + stapel[0][i] + " ");
		}
		System.out.println();
	}

	public static int playerSelectCard(int player, int[][] playerCards) { //bira kartu
		boolean gleich = false;
		int karte;
		do{
			
			karte = readInt("Spieler " +player+ ", du hast die folgenden Karten: "  + Arrays.toString(playerCards[player - 1]) +"\nWelche Karte möchtest du ausspielen?");
			for(int i = 0; i < playerCards[player - 1].length; i++) {
				if(karte == playerCards[player - 1][i] && karte > 0) {
					gleich = true;
					playerCards[player - 1][i] = 0;
					break;
				}
			}
		}while(!gleich);
			
		return karte; // ili return karte; ??
	}

	public static int calculatePoints(int[] lostCards) {
		int points = 0;
		for (int i = 0; i < lostCards.length; i++) {
			points += getValueOfCard(lostCards[i]);
		}
		return points;
	}

	public static void outputResult(int[] playerPoints) {
		if(playerPoints[0] < playerPoints[1])
			System.out.println("Spieler 1 gewinnt mit " +playerPoints[0]+ " gegen Spieler 2 mit " +playerPoints[1]+ " Punkten.");
		if(playerPoints[0] > playerPoints[1])
			System.out.println("Spieler 2 gewinnt mit " +playerPoints[1]+ " gegen Spieler 1 mit " +playerPoints[0]+ " Punkten.");
	}

	public static int getValueOfCard(int card) {
		int value = 0;

		if (card == 0) {
			value = 0;
			return value;
		}
		if (card >= 1 && card <= 105) {
			value += 1;
			if (card % 10 == 5)
				value += 1;
			if (card % 10 == 0)
				value += 2;
			if (card % 11 == 0)
				value += 5;
		}

		return value;
	}

	public static void givePlayerCards(int[][] playerCards) throws IllegalAccessException {
		for (int i = 0; i < playerCards.length; i++) {
			for (int j = 0; j < playerCards[i].length; j++) {
				playerCards[i][j] = drawCard();
			}
		}
	}
	
	public static int[][] putCard(int[][] stapel, int karte, int spieler) {
		int najveci[] = new int[4];
		boolean gdeMoze[] = {false, false, false, false};
		
		boolean svihPet[] = {false, false, false, false};
		
		boolean spakovan =  false;
		
		for(int i = 0; i<stapel.length; i++) { // uzima najvece
			for(int j=0; j<stapel[i].length; j++) {
				if(stapel[i][j] == 0) {
					najveci[i] = stapel[i][j-1];
					break;
				}
			}
			if(stapel[i][4] != 0) {  //u slucaju da ima 5 karata u nizu uzima poslednju
				najveci[i] = stapel[i][4];
				svihPet[i] = true;
			}
		}
		
		for(int i =0; i < najveci.length; i++) { //proverava da li moze karta na niz da se stavi
			if(karte > najveci[i]) {
				gdeMoze[i] = true;
			}
		}
		
		int gdePakuje = 0; 
		int razlike[] = {karte-najveci[0], karte-najveci[1], karte-najveci[2], karte-najveci[3]};
		int min = 200;
		for(int i  = 0; i < razlike.length; i++) { //najbliza gde pakuje
			if(razlike[i] < min && razlike[i] > 0) {
				min=razlike[i];
				gdePakuje = i;
			}
		}
		
		for(int i = 0; i < stapel.length; i++) {
			for(int j = 0; j < stapel[i].length; j++) {
				if(stapel[i][j] == 0 && gdeMoze[i] == true && gdePakuje == i) {
					stapel[i][j] = karte;
				}
			}
		}
		
		for(int i = 0; i < stapel.length; i++) {
			for(int j = 0; j < stapel[i].length; j++) {
				if(stapel[i][j] == 0 && gdeMoze[i] == true && gdePakuje == i && svihPet[i] == false) {
					stapel[i][j] = karte;
					spakovan = true;
					break;
				}
			}
		}
		
		if(spakovan == false) {
			for(int i = 0; i < stapel.length; i++) {
				for(int j = 0; j < stapel[i].length; j++) {
					if(gdeMoze[i] == true && gdePakuje == i && svihPet[i] == true) {
						playerPoints[spieler]=playerPoints[spieler] + calculatePoints(stapel[i]);
						stapel[i][0] = karte;
						stapel[i][1] = 0;
						stapel[i][2] = 0;
						stapel[i][3] = 0;
						stapel[i][4] = 0;
					}
				}
			}
		}
		
		
		
		
		if(gdeMoze[0] == false && gdeMoze[1] == false && gdeMoze[2] == false && gdeMoze[3] == false) {
			playerPoints[spieler]=playerPoints[spieler] + calculatePoints(stapel[0]);
			stapel[0][0] = karte;
			stapel[0][1] = 0;
			stapel[0][2] = 0;
			stapel[0][3] = 0;
			stapel[0][4] = 0;
		}
		return stapel;
	}


	
	
}
