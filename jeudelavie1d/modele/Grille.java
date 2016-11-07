package jeudelavie1d.modele;

import jeudelavie1d.modele.Carte.TypeMap;

//import jeuDeVie.modele.Carte.TypeMap;

public class Grille {
	
	private Carte[][] jeux;
	private Carte[] jeu;
	private Regle r;
	public int largeur;
	
	public Grille(Regle r, int largeur){
		this.r = r;
		this.largeur = largeur;
		creationGrille();
	}


	public int largeurGrille() {
		return jeu.length;
	}

	public Carte getMap(int i) {
		return jeu[i];
	}
	public Carte getMap2d(int i, int j) {
		return jeux[i][j];
	}
	
	public Carte[] getJeu(){
		return jeu;
	}
	public Carte[][] getJeux(){
		return jeux;
	}
	
	public void creationGrille(){
		jeu = new Carte[this.largeur];
		jeux = new Carte[20][this.largeur];
		for (int i = 0; i < this.largeur; i++) {
				jeu[i] = new Carte(i);
				jeu[i].setTypeMap(TypeMap.MORT);
		}
		for (int i = 0; i < jeux.length; i++) {
			for (int j = 0; j < jeux[0].length; j++) {
				jeux[i][j] = new Carte(j);
				jeux[i][j].setTypeMap(TypeMap.MORT);
			}
		}
	}
	
	public boolean estVide(){
		boolean res = true;
		for (int i = 0; i < jeu.length; i++) {
			
				if(jeu[i].getTypeMap() == TypeMap.VIVANT)
					res = false;
			
		}
		return res;
	}

	public void initialiser(int [] initialeCondition){
		for (int i = 0; i < this.largeur; i++) {
			if(initialeCondition[i] == 0)
				jeux[0][i].setTypeMap(TypeMap.MORT);
			else
				jeux[0][i].setTypeMap(TypeMap.VIVANT);
		}

	}
	
	public void genereGrilleAleatoire(){
		int randomI, randomJ;
		jeu = new Carte[this.largeur];
		for (int i = 0; i < jeu.length; i++) {
			
				jeu[i] = new Carte(i);
			
		}
		for (int i = 0; i < this.largeur; i++) {
			//randomI = (int) (Math.round(Math.random()*(7-2+1)) + 2);
			randomI = (int) (Math.round(Math.random()*((this.largeur-1)-0+1)));
			jeu[randomI].setTypeMap(TypeMap.VIVANT);;
		}
	}

	
	// A REVOIR POUR 1D
	
	public int getEvolution(int g, int i, int d){
		int etatcellule = 0;
		if(g == 1 && i == 1 && d == 1){
			etatcellule = r.getValeur(0);
		}
		if(g == 1 && i == 1 && d == 0){
			etatcellule = r.getValeur(1);
		}
		if(g == 1 && i == 0 && d == 1){
			etatcellule = r.getValeur(2);
		}
		if(g == 1 && i == 0 && d == 0){
			etatcellule = r.getValeur(3);
		}
		if(g == 0 && i == 1 && d == 1){
			etatcellule = r.getValeur(4);
		}
		if(g == 0 && i == 1 && d == 0){
			etatcellule = r.getValeur(5);
		}
		if(g == 0 && i == 0 && d == 1){
			etatcellule = r.getValeur(6);
		}
		if(g == 0 && i == 0 && d == 0){
			etatcellule = r.getValeur(7);
		}
		return etatcellule;
	}
	/*public int nbVoisin(int i, int j) {
		int nbVoisin = 0;
		// Gros rectangle
		if(i >= 1 && i <= 8 && j >= 1 && j<=8){
			for(int x = i-1; x <= i+1; x++){
				for (int y = j-1; y <= j+1; y++) {
					if(x!=i || y!=j){
						nbVoisin += getMap(x).valeur();
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
	}*/


	public void ajouterJeuCourant() {
		//affichertab2d(jeux);
	//	affichertab1d(jeu);
		Carte[][] temp = new Carte[20][this.largeur];
	//	System.out.println(temp[0].length);
		for (int i = 1; i < 20; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				Carte c = new Carte(jeux[i-1][j]);
				temp[i][j] = c;
			}
			
		}
	//	affichertab2d(temp);
		
		
		
		
		
		
		
	//	System.arraycopy(jeux, 0, temp, 1, 19);
		//System.arraycopy(jeu, 0, temp[0], 0, jeu.length);
		for (int i = 0; i < temp[0].length; i++) {
			Carte c2 = new Carte(jeu[i]);
			temp[0][i] = c2;
		}
		
		/*System.out.println("TEMP :");
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print("[");
				System.out.print(affichertypemap(temp[i][j].getTypeMap()));
				System.out.print("]");
				System.out.print(" ");
			}
			System.out.println(" ");
		}*/
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				Carte c3 = new Carte(temp[i][j]);
				jeux[i][j] = c3;
			}
		}
		//System.arraycopy(temp, 0, jeux, 0, temp.length);
		//this.jeux = temp;
		//affichertab2d(jeux);
		//affichertab1d(jeu);
	}


	private void affichertab1d(Carte[] jeu2) {
		System.out.println("Jeu :");
		for (int i = 0; i < jeu2.length; i++) {
			System.out.print("[");
			System.out.print(affichertypemap(jeu2[i].getTypeMap()));
			System.out.print("]");
			System.out.print(" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		
	}

	public String affichertypemap(TypeMap typeMap){
		
		if(typeMap.equals(TypeMap.MORT)){
			return "M";
		}else{
			return "V";
		}
		
	}
	private void affichertab2d(Carte[][] jeux2) {
		System.out.println("Jeux 2d :");
		for (int i = 0; i < jeux2.length; i++) {
			for (int j = 0; j < jeux2[0].length; j++) {
				System.out.print("[");
				System.out.print(affichertypemap(jeux2[i][j].getTypeMap()));
				System.out.print("]");
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
		
	}
	
}
