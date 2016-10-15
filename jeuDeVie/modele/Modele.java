package jeuDeVie.modele;

import java.util.Observable;

import jeuDeVie.modele.Carte.TypeMap;

public class Modele extends Observable implements Runnable{
	
	protected Grille grille;
	protected int hauteur = 10;
	protected int largeur = 10;
	public enum TypeSelection {VIVANT, MORT}
	protected TypeSelection typeSelection;
	private Carte[][] copie;
	protected int nbCoup = 0;
	protected boolean fin = false;
	protected float temps;
	protected boolean run = false;
	protected boolean isInitialise = false;
	
	public Modele(){
     	grille = new Grille();
     	setCopie(new Carte[getHauteur()][getLargeur()]);
	}
	
	/* Getters et setters */
	
	public float getTemps() {
		return temps;
	}

	public void setTemps(float temps) {
		this.temps = temps;
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public boolean isInitialise() {
		return isInitialise;
	}

	public void setInitialise(boolean isInitialise) {
		this.isInitialise = isInitialise;
	}
	
	public void setTypeSelection(TypeSelection typeSelection){
		this.typeSelection = typeSelection;
	}
	
	public TypeSelection getTypeSelection(){
		return typeSelection;
	}
	
	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
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
	
	public int getCoup() {
		return nbCoup;
	}
	
	public void setCoup(int coup){
		this.nbCoup = coup;
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
	
	/* Methodes */
	
	public void affichageGrille(){
		for(int i=0; i<grille.hauteurGrille(); i++){
			for(int j=0; j<grille.largeurGrille(); j++){
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
	
	public void initGrille(){
		for (int i = 0; i < getCopie().length; i++) {
			for (int j = 0; j < getCopie()[0].length; j++) {
				getGrille().getJeu()[i][j] = new Carte(i, j);
			}
		}
	}
	
	public void ecritureCopie(){
		for (int i = 0; i < grille.hauteurGrille(); i++) {
			for (int j = 0; j < grille.largeurGrille(); j++) {
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
			
			if(equals(getGrille().getJeu(), getCopie())){
				setFin(true);
			}else{
				nbCoup++;
			}
			for (int i = 0; i < getHauteur(); i++) {
				for (int j = 0; j < getLargeur(); j++) {
					getGrille().getMap(i, j).setTypeMap(getCopie()[i][j].getTypeMap());
				}
			}

	}
	
	public int getMort() {
		int mort = 0;
		for (int i = 0; i < getHauteur(); i++) {
			for (int j = 0; j < getLargeur(); j++) {
				if(getGrille().getMap(i, j).getTypeMap() ==  TypeMap.MORT){
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
				if(getGrille().getMap(i, j).getTypeMap() ==  TypeMap.VIVANT){
					vivant++;
				}
			}
		}
		return vivant;
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

	@Override
	public void run() {
		jeuDeLaVie();
	}
	
	public void miseAJour(){
		setChanged();
		notifyObservers();
	}
	
	public void majMortVivant(){
		getMort();
		getVivant();
	}

}
