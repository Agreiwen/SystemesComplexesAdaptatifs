package jeuDeVie.modele;

import jeuDeVie.modele.Carte.TypeMap;

public class Modele{
	
	protected Grille grille;
	protected int hauteur = 10;
	protected int largeur = 10;
	public enum TypeSelection {VIVANT, MORT}
	protected TypeSelection typeSelection;
	private Carte[][] copie;
	protected int nbCoup = 0;
	protected boolean fin = false;
	
	public Modele(){
     	grille = new Grille();
     	setCopie(new Carte[getHauteur()][getLargeur()]);
	}
	
	public void setTypeSelection(TypeSelection typeSelection){
		this.typeSelection = typeSelection;
	}
	
	public TypeSelection getTypeSelection(){
		return typeSelection;
	}
	
	public Grille getLabyrinthe() {
		return grille;
	}

	public void setLabyrinthe(Grille labyrinthe) {
		this.grille = labyrinthe;
	}
	
	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public void affichageLabyrinthe(){
		System.out.println("-> Affichage du labyrinthe :\n");
		for(int i=0; i<grille.hauteurLabyrinthe(); i++){
			for(int j=0; j<grille.largeurLabyrinthe(); j++){
				System.out.print(grille.getMap(i, j).toString());
			}System.out.println();
		}
	}
	
	public void initCopie(){
		for (int i = 0; i < getCopie().length; i++) {
			for (int j = 0; j < getCopie()[0].length; j++) {
				getCopie()[i][j] = new Carte(i, j);
			}
		}
	}
	
	public void initLaby(){
		for (int i = 0; i < getCopie().length; i++) {
			for (int j = 0; j < getCopie()[0].length; j++) {
				getLabyrinthe().getJeu()[i][j] = new Carte(i, j);
			}
		}
	}
	
	public void ecritureCopie(){
		for (int i = 0; i < grille.hauteurLabyrinthe(); i++) {
			for (int j = 0; j < grille.largeurLabyrinthe(); j++) {
				if(grille.getMap(i, j).getTypeMap() == TypeMap.MORT){
					if(grille.nbVoisin(i,j) == 3){
						getCopie()[i][j].setTypeMap(TypeMap.VIVANT);
					}else{
						getCopie()[i][j].setTypeMap(TypeMap.MORT);
					}
				}
				else{
					if(grille.nbVoisin(i,j) < 2 || grille.nbVoisin(i,j) > 3){
						getCopie()[i][j].setTypeMap(TypeMap.MORT);
					}else{
						getCopie()[i][j].setTypeMap(TypeMap.VIVANT);
					}
				}
			}
		}
	}
	
	public void affichageCopie(){
		for (int i = 0; i < getCopie().length; i++) {
			for (int j = 0; j < getCopie()[0].length; j++) {
				System.out.println(getCopie()[i][j].toString());
			}
		}
	}
	
	public void jeuDeLaVie(){
		initCopie();
		ecritureCopie();
		
		if(equals(getLabyrinthe().getJeu(), getCopie())){
			setFin(true);
		}else{
			nbCoup++;
		}
		for (int i = 0; i < getHauteur(); i++) {
			for (int j = 0; j < getLargeur(); j++) {
				getLabyrinthe().getMap(i, j).setTypeMap(getCopie()[i][j].getTypeMap());
			}
		}
	}
	
	public void pasDeTemps(){
		jeuDeLaVie();
	}

	public int getCoup() {
		return nbCoup;
	}

	public int getMort() {
		int mort = 0;
		for (int i = 0; i < getHauteur(); i++) {
			for (int j = 0; j < getLargeur(); j++) {
				if(getLabyrinthe().getMap(i, j).getTypeMap() ==  TypeMap.MORT){
					mort++;
				}
			}
		}
		return mort;
	}

	public int getVivant() {
		int vivant = 0;
		for (int i = 0; i < getHauteur(); i++) {
			for (int j = 0; j < getLargeur(); j++) {
				if(getLabyrinthe().getMap(i, j).getTypeMap() ==  TypeMap.VIVANT){
					vivant++;
				}
			}
		}
		return vivant;
	}
	
	public void majMortVivant(){
		getMort();
		getVivant();
	}

	public boolean equals(Carte[][] courant, Carte[][] copie){
		boolean res = true;
		for (int i = 0; i < copie.length; i++) {
			for (int j = 0; j < copie[0].length; j++) {
				if(!courant[i][j].getTypeMap().equals(copie[i][j].getTypeMap())){
					res = false;
				}
			}
		}
		return res;
	}

	public Carte[][] getCopie() {
		return copie;
	}

	public void setCopie(Carte[][] copie) {
		this.copie = copie;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
}
