package jeuDeVie.modele;

import jeuDeVie.modele.Carte.TypeMap;

public class Grille {
	
	private Carte[][] jeu;
	
	public Grille(){
		creationGrille();
	}

	public int hauteurGrille() {
		return jeu.length;
	}

	public int largeurGrille() {
		return jeu[0].length;
	}

	public Carte getMap(int i, int j) {
		return jeu[i][j];
	}
	
	public Carte[][] getJeu(){
		return jeu;
	}
	
	public void creationGrille(){
		jeu = new Carte[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				jeu[i][j] = new Carte(i, j);
				jeu[i][j].setTypeMap(TypeMap.MORT);
			}
		}
	}
	
	public boolean estVide(){
		boolean res = true;
		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu[0].length; j++) {
				if(jeu[i][j].getTypeMap() == TypeMap.VIVANT)
					res = false;
			}
		}
		return res;
	}
	
	public void genereGrilleAleatoire(){
		int mini = 2;
		int max = 7;
		int randomI, randomJ;
		jeu = new Carte[10][10];
		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu[0].length; j++) {
				jeu[i][j] = new Carte(i,j);
			}
		}
		for (int i = 0; i < 10; i++) {
			randomI = (int) Math.round((int)( Math.random()*( max - mini + 1 ) ) + mini);
			randomJ = (int) Math.round((int)( Math.random()*( max - mini + 1 ) ) + mini);
			jeu[randomI][randomJ].setTypeMap(TypeMap.VIVANT);;
		}
	}

	public int nbVoisin(int i, int j) {
		int nbVoisin = 0;
		// Gros rectangle
		if(i >= 1 && i <= 8 && j >= 1 && j<=8){
			for(int x = i-1; x <= i+1; x++){
				for (int y = j-1; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
		}
		//Ligne du haut
		else if(i == 0 && j >=1 && j <= 8){
			for (int x = i; x <= i+1; x++) {
				for (int y = j-1 ; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
			for (int y = j-1; y <= j+1; y++) {
				nbVoisin += getMap(9, y).valeur();
			}
		}
		//Ligne du bas
		else if(i == 9 && j >=1 && j <= 8){
			for (int x = i-1; x <= i; x++) {
				for (int y = j-1 ; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
			for (int y = j-1; y <= j+1; y++) {
				nbVoisin += getMap(0, y).valeur();
			}
		}
		//Ligne de gauche
		else if(j == 0 && i >=1 && i <= 8){
			for (int x = i-1; x <= i+1; x++) {
				for (int y = j ; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
			for (int x = i-1; x <= i+1; x++) {
				nbVoisin += getMap(x, 9).valeur();
			}
		}
		//Ligne de droite
		else if(j == 9 && i >=1 && i <= 8){
			for (int x = i-1; x <= i+1; x++) {
				for (int y = j-1 ; y <= j; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
			for (int x = i-1; x <= i+1; x++) {
				nbVoisin += getMap(x, 0).valeur();
			}
		}
		//Haut Gauche
		else if(i == 0 && j == 0){
			nbVoisin = getMap(0, 1).valeur() + getMap(1, 0).valeur() + getMap(1, 1).valeur() + getMap(0, 9).valeur() + getMap(1, 9).valeur() + getMap(9, 0).valeur() + getMap(9, 1).valeur() + getMap(9, 9).valeur(); 
		}
		//Haut Droite
		else if(i == 0 && j == 9){
			nbVoisin = getMap(0, 8).valeur() + getMap(1, 8).valeur() + getMap(1, 9).valeur() +  getMap(0, 0).valeur() + getMap(1, 0).valeur() + getMap(9, 8).valeur() + getMap(9, 9).valeur() + getMap(9, 0).valeur(); 
		}
		//Bas Gauche
		else if(i == 9 && j == 0){
			nbVoisin = getMap(8, 0).valeur() + getMap(8, 1).valeur() + getMap(9, 1).valeur() + getMap(0, 0).valeur() + getMap(0, 1).valeur() + getMap(8, 9).valeur() + getMap(9, 9).valeur() + getMap(0, 9).valeur();
		}
		// Bas Droite
		else if(i == 9 && j == 9){
			nbVoisin = getMap(8, 8).valeur() + getMap(8, 9).valeur() + getMap(9, 8).valeur() + getMap(0, 8).valeur() + getMap(0, 9).valeur() + getMap(8, 0).valeur() + getMap(9, 0).valeur() + getMap(0, 0).valeur();
		}
		return nbVoisin;
	}
	
}
