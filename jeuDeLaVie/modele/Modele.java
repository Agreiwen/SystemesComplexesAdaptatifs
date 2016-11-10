package jeuDeLaVie.modele;

import java.util.Observable;

import jeuDeLaVie.modele.Grille;

public class Modele extends Observable{
	
	protected int dimension;
	protected int largeur;
	protected int longueur;
	protected int voisinage;
	protected boolean initialise;
	protected Grille grille;
	
	public Modele(){
		setInitialise(false);
	}
	
	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	// Voisinage : 1 pour moore8 et 2 pour moore9
	public int getVoisinage() {
		return voisinage;
	}

	public void setVoisinage(int voisinage) {
		this.voisinage = voisinage;
	}
	
	public boolean isInitialise() {
		return initialise;
	}

	public void setInitialise(boolean initialise) {
		this.initialise = initialise;
	}
	
	public int getCellule(int i, int j){
		return grille.getCellule(i, j);
	}
	
	public void setCellule(int i, int j, int valeur){
		grille.setCellule(i, j, valeur);
	}
	
	public void miseAJour(){
		this.setChanged();
		this.notifyObservers();
	}

	public void creationGrille() {
		grille = new Grille(largeur,longueur);
	}

}
