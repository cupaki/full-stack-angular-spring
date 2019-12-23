package com.cupakitodo.rest.webservices.restfulwebservices.helloworld;

public class Njemacka extends MiniJava {
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
		int[][] stapel = new int[4][5];
		System.out.println(stapel[0][4]);
		for(int i = 0; i < stapel.length; i++) {
			stapel[i][0] = drawCard();
		}
		//stapel1[0] = drawCard();
		//stapel2[0] = drawCard();
		//stapel3[0] = drawCard();
		//stapel4[0] = drawCard();
		// da li staplove napisati kao jedan 2-dimenzionalan niz??
		
		int runden = 0;
		int karte1;
		int karte2;
		//boolean 
		int najveci[] = new int[4];
		
		do {
			int player = 1;
			karte1 = playerSelectCard(player, playerCards);
			player++;
			karte2 = playerSelectCard(player, playerCards);
			player = 1; // mozda ovo ni ne moram jer je odmah posle do int player = 1;
			// da li negde moram da sacuvam vrednost koje mi ove metode daju
			//ili su automatski sacuvane???
			
			for(int i = 0; i<stapel.length; i++) { // uzima najvece
				for(int j=0; j<stapel[i].length; j++) {
					if(stapel[i][j] == 0) {
						najveci[i] = stapel[i][j-1];
					}
				}
				if(stapel[i][4] != 0) {
					najveci[i] = stapel[i][4];
				}
			}
			
			int gdePakuje = 0;
			int razlike[] = {najveci[0]-karte1, najveci[1]-karte1, najveci[2]-karte1, najveci[3]-karte1, najveci[4]-karte1};
			int min = razlike[0];
			for(int i  = 0; i < razlike.length; i++) { 
				if(razlike[i] < min) {
					gdePakuje = i;
				}
			}
			
			// 
			if(karte1 < karte2) { // mozda da upisem karte u sortiran niz??
				for(int i = 0; i < stapel.length; i++) {
					for(int j = 0; j < stapel[i].length; j++) {
						if(stapel[i][j + 1] == 0 && stapel[i][j] < karte1 && stapel[i][4] != 0) {
							stapel[i][j+1] = karte1;
						}
					}
				}	
			}
			// treba sortirati staplove
			
			runden++;
		} while(runden < 10);
	}

	public static void outputStapel(int[][] stapel) { //ispise karte na stolu
		int[] stapel1 = new int[5];
		int[] stapel2 = new int[5];
		int[] stapel3 = new int[5];
		int[] stapel4 = new int[5];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (stapel[i][j] <= 0) {
					continue;
				}
				if (i == 0)
					stapel1[j] = stapel[i][j];
				if (i == 1)
					stapel2[j] = stapel[i][j];
				if (i == 2)
					stapel3[j] = stapel[i][j];
				if (i == 3)
					stapel4[j] = stapel[i][j];
				System.out.println("Stapel 1: " + stapel1);
				System.out.println("Stapel 2: " + stapel2);
				System.out.println("Stapel 3: " + stapel3);
				System.out.println("Stapel 4: " + stapel4);
				/*
				 * Da li moze bez i brojaca i bez if-ova??
				 * pa da kazem ... = stapel[0/1/2/3][j];
				 * **mrzi me da pisem ali of kors o/1/2/3 ne zajedno
				 */
			}
		}
	}

	public static int playerSelectCard(int player, int[][] playerCards) { //bira kartu
		boolean gleich = false;
		int karte;
		do{
			karte = readInt("Spieler " +player+ ", du hast die folgenden Karten: " +playerCards[player - 1]+ "\nWelche Karte möchtest du ausspielen?");
			for(int i = 0; i < playerCards[player - 1].length; i++) {
				if(karte == playerCards[player - 1][i]) {
					gleich = true;
					playerCards[player - 1][i] = 0;
					break;
				}
			}
		}while(!gleich);
			
		return 0; // ili return karte; ??
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
}