package jeuDeLaVie.modele;

import java.util.Observable;

public class Modele extends Observable implements Runnable{
	
	protected int dimension;
	protected int largeur;
	protected int longueur;
	protected int voisinage;
	protected boolean initialise;
	protected int methode;
	protected int maxVivant;
	protected int etapeParametrage;
	protected Grille grille, copie, copieLigne;
	protected boolean torique;
	protected Regle regle;
	protected int tailleHistorique;
	
	public Modele(){
		setInitialise(false);
		setEtapeParametrage(1);
		setTailleHistorique(10);
	}
	
	public boolean isTorique() {
		return torique;
	}

	public void setTorique(boolean torique) {
		this.torique = torique;
	}
	
	public int getTailleHistorique() {
		return tailleHistorique;
	}

	public void setTailleHistorique(int tailleHistorique) {
		this.tailleHistorique = tailleHistorique;
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public int getEtapeParametrage() {
		return etapeParametrage;
	}

	public void setEtapeParametrage(int etapeParametrage) {
		this.etapeParametrage = etapeParametrage;
	}
	
	public Regle getRegle() {
		return regle;
	}

	public void setRegle(int regle) {
		this.regle = new Regle(regle);
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
	
	public Grille getCopieLigne() {
		return copieLigne;
	}

	public void setCopieLigne(Grille copieLigne) {
		this.copieLigne = copieLigne;
	}
	
	public void miseAJour() {
		this.setChanged();
		this.notifyObservers();
	}

	public void creationGrille() {
		grille = new Grille(largeur,longueur);
		copie = new Grille(largeur, longueur);
		copieLigne = new Grille(1, longueur);
	}
	
	public void genereAleatoire(){
		int randomI, randomJ;
		switch(dimension){
		case 1 :
			for (int i = 0; i < maxVivant; i++) {
				randomJ = (int) Math.round((int)( Math.random()*( longueur - 1 )));
				setCelluleGrille(0, randomJ, 1);
			}
			break;
		case 2 :
			for (int i = 0; i < maxVivant; i++) {
				randomI = (int) Math.round((int)( Math.random()*( largeur - 1 )));
				randomJ = (int) Math.round((int)( Math.random()*( longueur - 1 )));
				setCelluleGrille(randomI, randomJ, 1);
			}
			break;
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
	
	public void iterationRegle(){
		int voisinGauche, milieu, voisinDroit;
		for (int j = 0; j < longueur; j++) {
			voisinGauche =  grille.voisinGauche(j);
			milieu = getCelluleGrille(0, j);
			voisinDroit =  grille.voisinDroit(j);
			copieLigne.setCellule(0, j, regle.getValeur(voisinGauche, milieu, voisinDroit));
		}
	}
	
	public void copieLigneDansGrille(){
		int[] tabAux = new int[1];
		for (int i = largeur-1; i > 0; i--) {
			tabAux = grille.getLigne(i-1);
			grille.setLigne(tabAux, i);
		}
		grille.setLigne(copieLigne.getLigne(0), 0);
		copieLigne.grilleVide();
		miseAJour();
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
		if(getDimension() == 1){
			while(true){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				iterationRegle();
				copieLigneDansGrille();
			}
		}else if(getDimension() == 2){
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
				//Parite
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

}
