package jeuDeLaVie.modele;

import java.util.Observable;

import jeuDeLaVie.modele.Grille;
import jeuDeVie.modele.Carte.TypeMap;

public class Modele extends Observable implements Runnable{
	
	protected int dimension;
	protected int largeur;
	protected int longueur;
	protected int voisinage;
	protected boolean initialise;
	protected int methode;
	protected int regle;
	protected int maxVivant;
	protected int etapeParametrage;
	protected Grille grille, copie;
	protected boolean torique;
	
	public Modele(){
		setInitialise(false);
		setEtapeParametrage(1);
	}
	
	public boolean isTorique() {
		return torique;
	}

	public void setTorique(boolean torique) {
		this.torique = torique;
	}
	
	public int getDimension() {
		return dimension;
	}

	public int getEtapeParametrage() {
		return etapeParametrage;
	}

	public void setEtapeParametrage(int etapeParametrage) {
		this.etapeParametrage = etapeParametrage;
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
	
	public int getCelluleGrille(int i, int j) {
		return grille.getCellule(i, j);
	}
	
	public void setCelluleGrille(int i, int j, int valeur) {
		grille.setCellule(i, j, valeur);
	}
	
	//Methode : 1 pour regle jeu de la vie, 2 pour parite
	public int getMethode() {
		return methode;
	}

	public void setMethode(int methode) {
		this.methode = methode;
	}
	
	public int getRegle() {
		return regle;
	}

	public void setRegle(int regle) {
		this.regle = regle;
	}

	public int getMaxVivant() {
		return maxVivant;
	}

	public void setMaxVivant(int maxVivant) {
		this.maxVivant = maxVivant;
	}
	
	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public Grille getCopie() {
		return copie;
	}

	public void setCopie(Grille copie) {
		this.copie = copie;
	}
	
	public void miseAJour() {
		this.setChanged();
		this.notifyObservers();
	}

	public void creationGrille() {
		grille = new Grille(largeur,longueur);
		copie = new Grille(largeur, longueur);
	}
	
	public void genereAleatoire(){
		int randomI, randomJ;
		for (int i = 0; i < maxVivant; i++) {
			randomI = (int) Math.round((int)( Math.random()*( largeur - 1 )));
			randomJ = (int) Math.round((int)( Math.random()*( longueur - 1 )));
			setCelluleGrille(randomI, randomJ, 1);
		}
	}
	
	public int nbVoisin(int voisinage, int i, int j) {
		if(voisinage == 1){
			if(torique == true){
				return grille.nbVoisinMoore8(i, j);
			}else{
				return grille.nbVoisinMoore8NonTorique(i, j);
			}
		}else{
			if(torique == true){
				return grille.nbVoisinMoore9(i, j);
			}else{
				return grille.nbVoisinMoore9NonTorique(i, j);
			}
		}
	}
	
	public void iterationJeuDeLaVie(){
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				if(getCelluleGrille(i, j) == 0){
					if(nbVoisin(voisinage,i,j) == 3){
						copie.setCellule(i, j, 1);
					}else{
						copie.setCellule(i, j, 0);
					}
				}
				else{
					if(nbVoisin(voisinage,i,j) < 2 || nbVoisin(voisinage,i,j) > 3){
						copie.setCellule(i, j, 0);
					}else{
						copie.setCellule(i, j, 1);
					}
				}
			}
		}
	}
	
	public void iterationParite() {
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				if((nbVoisin(voisinage, i, j) % 2) == 0){
					copie.setCellule(i, j, 0);
				}else{
					copie.setCellule(i, j, 1);
				}
			}
		}
	}
	
	public void copieDansGrille(){
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				grille.setCellule(i, j, copie.getCellule(i, j));
			}
		}
		miseAJour();
	}

	@Override
	public void run() {
		switch(getMethode()){
		case 1:
			//Jeu de la vie
			while(true){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				iterationJeuDeLaVie();
				if(grille.equals(copie))
					break;
			    copieDansGrille();
			    //copie.grilleVide();
			}
			break;
		case 2 :
			while(true){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				iterationParite();
				if(grille.equals(copie))
					break;
			    copieDansGrille();
			}
		}
	}

}
