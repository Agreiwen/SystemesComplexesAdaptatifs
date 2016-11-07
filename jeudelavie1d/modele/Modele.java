package jeudelavie1d.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import jeudelavie1d.modele.Carte.TypeMap;

public class Modele extends Observable implements Runnable{
	
	protected Grille grille;
	protected Regle r;
	//protected int hauteur = 10;
	protected int largeur;
	public enum TypeSelection {VIVANT, MORT}
	protected TypeSelection typeSelection;
	private Carte[] copie;
	protected int nbCoup = 0;
	protected boolean fin = false;
	protected float temps;
	protected boolean run = false;
	protected boolean isInitialise = false;
	
	public Modele(int i, int largeur){
     	this.largeur = largeur;
     	r = new Regle(i);
     	grille = new Grille(r, largeur-1);
     	//System.out.println(getLargeur());
     	setCopie(new Carte[getLargeur()]);
	}
	
	/* Getters et setters */
	
	public float getTemps() {
		return temps;
	}

	public void setTemps(float temps) {
		this.temps = temps;
		//this.miseAJour();
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
	
	public Carte[] getCopie() {
		return copie;
	}

	public void setCopie(Carte[] copie) {
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
			for(int j=0; j<grille.largeurGrille(); j++){
				System.out.print(grille.getMap(j).toString());
			}System.out.println();
	}
	
	public void initCopie(){
		for (int i = 0; i < getCopie().length; i++) {
				getCopie()[i] = new Carte(i);
			}
	}
	
	public void initGrille(){
		for (int i = 0; i < getCopie().length; i++) {
				getGrille().getJeu()[i] = new Carte(i);
		}
	}
	
	
	public void ecritureCopie(){
		int etatsuiv = 0;
		int etatg;
		int etatj;
		int etatd;
		for (int j = 0; j < grille.largeurGrille(); j++) {
			
			// Cas premiere cellule
			if(j == 0){
				if(grille.getMap(j).getTypeMap() == TypeMap.MORT){	
					etatj = 0;
				}else{
					etatj = 1;
				}
				if(grille.getMap(grille.largeurGrille()-1).getTypeMap() == TypeMap.MORT){
					etatg = 0;
				}else{
					etatg = 1;
				}
				if(grille.getMap(j+1).getTypeMap() == TypeMap.MORT){	
					etatd = 0;
				}else{
					etatd = 1;
				}
				
				
			}else if(j == grille.largeurGrille()-1){//Cas derni?re cellule
				if(grille.getMap(j).getTypeMap() == TypeMap.MORT){	
					etatj = 0;
				}else{
					etatj = 1;
				}
				if(grille.getMap(0).getTypeMap() == TypeMap.MORT){
					etatd = 0;
				}else{
					etatd = 1;
				}
				if(grille.getMap(j-1).getTypeMap() == TypeMap.MORT){	
					etatg = 0;
				}else{
					etatg = 1;
				}
				
				
				
			}else{// Le reste
				if(grille.getMap(j).getTypeMap() == TypeMap.MORT){	
					etatj = 0;
				}else{
					etatj = 1;
				}
				if(grille.getMap(j+1).getTypeMap() == TypeMap.MORT){
					etatd = 0;
				}else{
					etatd = 1;
				}
				if(grille.getMap(j-1).getTypeMap() == TypeMap.MORT){	
					etatg = 0;
				}else{
					etatg = 1;
				}
				
				
			}
			etatsuiv = grille.getEvolution(etatg, etatj, etatd);
			if(etatsuiv == 1){
				getCopie()[j].setTypeMap(TypeMap.VIVANT);
			}else{
				getCopie()[j].setTypeMap(TypeMap.MORT);
			}
			
		}
	}
	
	public void affichageCopie(){
		for (int i = 0; i < getCopie().length; i++) {
				System.out.println(getCopie()[i].toString());
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
				for (int j = 0; j < getLargeur(); j++) {
					getGrille().getMap(j).setTypeMap(getCopie()[j].getTypeMap());
				}
			getGrille().ajouterJeuCourant();
		//	miseAJour();

	}
	
	public int getMort() {
		int mort = 0;
			for (int j = 0; j < getLargeur(); j++) {
				if(getGrille().getMap(j).getTypeMap() ==  TypeMap.MORT){
					mort++;
				}
		}
		return mort;
	}

	public int getVivant() {
		int vivant = 0;
			for (int j = 0; j < getLargeur(); j++) {
				if(getGrille().getMap(j).getTypeMap() ==  TypeMap.VIVANT){
					vivant++;
				}
		}
		return vivant;
	}
	public int getNBVivant(Grille g) {
		int vivant = 0;
			for (int j = 0; j < getLargeur(); j++) {
				if(g.getMap(j).getTypeMap() ==  TypeMap.VIVANT){
					vivant++;
			}
		}
		return vivant;
	}

	public boolean equals(Carte[] courant, Carte[] copie){
		boolean res = true;
		for (int i = 0; i < copie.length; i++) {
				if(!courant[i].getTypeMap().equals(copie[i].getTypeMap())){
					res = false;
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

	public ArrayList<Carte[]> bonnesGrilles(){
		ArrayList<Carte []> bonnesGrilles = new ArrayList<>();
		for (int i = 0; i < this.getLargeur(); i++) {
			int [] initialeCondition = toBinnaiare(this.largeur);
			this.grille.initialiser(initialeCondition);

		}
		return bonnesGrilles;
	}

	public int [] toBinnaiare (int n) {
		int[] valeur = new int[8];
		int decimal = n;
		for (int i = 0; i < 8; i++) {
			if (decimal - Math.pow(2, 7 - i) > 0) {
				valeur[i] = 1;
				decimal -= Math.pow(2, 7 - i);
			} else if (decimal - Math.pow(2, 7 - i) == 0) {
				valeur[i] = 1;
				break;
			}
			//Cette condition n'est pas obligatoire, le tableau de byte est rempli de 0 ? la base.
			else {
				valeur[i] = 0;
			}
		}
		return valeur;
	}

}
