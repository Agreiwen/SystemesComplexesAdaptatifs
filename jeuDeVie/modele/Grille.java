package jeuDeVie.modele;

import jeuDeVie.modele.Carte.TypeMap;

public class Grille {
	
	private Carte[][] jeu;
	private int taillelargeur;
	private int taillehauteur;
	public Grille(int l, int h){
		creationGrille();
		this.taillehauteur = 40;
		this.taillelargeur = 40;
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
		jeu = new Carte[this.taillehauteur][this.taillelargeur];
		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu[0].length; j++) {
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
		int max = 37;
		int randomI, randomJ;
		jeu = new Carte[this.taillehauteur][this.taillelargeur];
		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu[0].length; j++) {
				jeu[i][j] = new Carte(i,j);
			}
		}
		for (int i = 0; i < this.taillehauteur; i++) {
			randomI = (int) Math.round((int)( Math.random()*( max - mini + 1 ) ) + mini);
			randomJ = (int) Math.round((int)( Math.random()*( max - mini + 1 ) ) + mini);
			jeu[randomI][randomJ].setTypeMap(TypeMap.VIVANT);;
		}
	}

	public int nbVoisin(int i, int j) {
		int nbVoisin = 0;
		// Gros rectangle
		if(i >= 1 && i <= this.taillelargeur-2 && j >= 1 && j<=this.taillelargeur-2){
			for(int x = i-1; x <= i+1; x++){
				for (int y = j-1; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
		}
		//Ligne du haut
		else if(i == 0 && j >=1 && j <= this.taillelargeur-2){
			for (int x = i; x <= i+1; x++) {
				for (int y = j-1 ; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
			for (int y = j-1; y <= j+1; y++) {
				nbVoisin += getMap(this.taillelargeur-1, y).valeur();
			}
		}
		//Ligne du bas
		else if(i == this.taillelargeur-1 && j >=1 && j <= this.taillelargeur-2){
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
		else if(j == 0 && i >=1 && i <= this.taillelargeur-2){
			for (int x = i-1; x <= i+1; x++) {
				for (int y = j ; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x, y).valeur();
					}
				}
			}
			for (int x = i-1; x <= i+1; x++) {
				nbVoisin += getMap(x, this.taillelargeur-1).valeur();
			}
		}
		//Ligne de droite
		else if(j == this.taillelargeur-1 && i >=1 && i <= this.taillelargeur-2){
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
			nbVoisin = getMap(0, 1).valeur() + getMap(1, 0).valeur() + getMap(1, 1).valeur() + getMap(0, this.taillelargeur-1).valeur() + getMap(1, this.taillelargeur-1).valeur() + getMap(this.taillelargeur-1, 0).valeur() + getMap(this.taillelargeur-1, 1).valeur() + getMap(this.taillelargeur-1, this.taillelargeur-1).valeur(); 
		}
		//Haut Droite
		else if(i == 0 && j == this.taillelargeur-1){
			nbVoisin = getMap(0, this.taillelargeur-2).valeur() + getMap(1, this.taillelargeur-2).valeur() + getMap(1, this.taillelargeur-1).valeur() +  getMap(0, 0).valeur() + getMap(1, 0).valeur() + getMap(this.taillelargeur-1, this.taillelargeur-2).valeur() + getMap(this.taillelargeur-1, this.taillelargeur-1).valeur() + getMap(this.taillelargeur-1, 0).valeur(); 
		}
		//Bas Gauche
		else if(i == this.taillelargeur-1 && j == 0){
			nbVoisin = getMap(this.taillelargeur-2, 0).valeur() + getMap(this.taillelargeur-2, 1).valeur() + getMap(this.taillelargeur-1, 1).valeur() + getMap(0, 0).valeur() + getMap(0, 1).valeur() + getMap(this.taillelargeur-2, this.taillelargeur-1).valeur() + getMap(this.taillelargeur-1, this.taillelargeur-1).valeur() + getMap(0, this.taillelargeur-1).valeur();
		}
		// Bas Droite
		else if(i == this.taillelargeur-1 && j == this.taillelargeur-1){
			nbVoisin = getMap(this.taillelargeur-2, this.taillelargeur-2).valeur() + getMap(this.taillelargeur-2, this.taillelargeur-1).valeur() + getMap(this.taillelargeur-1, this.taillelargeur-2).valeur() + getMap(0, this.taillelargeur-2).valeur() + getMap(0, this.taillelargeur-1).valeur() + getMap(this.taillelargeur-2, 0).valeur() + getMap(this.taillelargeur-1, 0).valeur() + getMap(0, 0).valeur();
		}
		return nbVoisin;
	}
	
	
	public boolean vivantMajoritaire(int i, int j){
		return (nbVoisin(i,j)>=4);
	}
	
	public boolean mortMajoritaire(int i, int j){
		return (nbVoisin(i,j)<=4);
	}
	
	public boolean pair(int i, int j){
		return  ((nbVoisin(i, j) %2)== 0);
		/*switch(nbVoisin(i, j)){
		case 0:
			return false;
		case 1:
			return false;
		case 2:
			return true;
		case 3:
			return false;
		case 4:
			return true;
		case 5:
			return false;
		case 6:
			return true;
		case 7:
			return false;
		case 8:
			return true;
		case 9:
			return false;
		case 10:
			return true;
		default:
			return false;
		}*/
	}
	
}
