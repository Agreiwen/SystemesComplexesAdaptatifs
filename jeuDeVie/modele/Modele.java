package jeuDeVie.modele;

import java.util.Observable;

import jeuDeVie.modele.Carte.TypeMap;

public class Modele extends Observable implements Runnable{
	
	protected Labyrinthe labyrinthe;
	protected int hauteur = 10;
	protected int largeur = 10;
	public enum TypeSelection {VIVANT, MORT}
	protected TypeSelection typeSelection;
	protected long TempsDepart;
	protected long TempsArrivee;
	protected boolean run = false;
	protected float temps;
	protected boolean isInitialise = false;
	private Carte[][] copie;
	protected int nbCoup = 0;
	private boolean fin = false;
	
	public Modele(){
     	labyrinthe = new Labyrinthe();
     	setCopie(new Carte[getHauteur()][getLargeur()]);
	}
	
	public float getTemps() {
		return temps;
	}

	public void setTemps(float temps) {
		this.temps = temps;
		this.miseAJour();
	}

	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public long getTempsDepart() {
		return TempsDepart;
	}

	public void setTempsDepart(long tempsDepart) {
		TempsDepart = tempsDepart;
	}

	public long getTempsArrivee() {
		return TempsArrivee;
	}

	public void setTempsArrivee(long tempsArrivee) {
		TempsArrivee = tempsArrivee;
	}

	public void setTypeSelection(TypeSelection typeSelection){
		this.typeSelection = typeSelection;
	}
	
	public TypeSelection getTypeSelection(){
		return typeSelection;
	}
	
	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	public void setLabyrinthe(Labyrinthe labyrinthe) {
		this.labyrinthe = labyrinthe;
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

	public void miseAJour(){
		setChanged();
		notifyObservers();
	}
	
	@Override
	public void run() {
		jeuDeLaVie();
	}
	
	public void affichageLabyrinthe(){
		System.out.println("-> Affichage du labyrinthe :\n");
		for(int i=0; i<labyrinthe.hauteurLabyrinthe(); i++){
			for(int j=0; j<labyrinthe.largeurLabyrinthe(); j++){
				System.out.print(labyrinthe.getMap(i, j).toString());
			}System.out.println();
		}
	}

	public boolean isInitialise() {
		return isInitialise;
	}

	public void setInitialise(boolean b) {
		this.isInitialise = b;
	}
	
	public void initCopie(){
		for (int i = 0; i < getCopie().length; i++) {
			for (int j = 0; j < getCopie()[0].length; j++) {
				getCopie()[i][j] = new Carte(i, j);
				//System.out.println(test[i][j].toString());
			}
		}
	}
	
	public void ecritureCopie(){
		for (int i = 0; i < labyrinthe.hauteurLabyrinthe(); i++) {
			for (int j = 0; j < labyrinthe.largeurLabyrinthe(); j++) {
				//System.out.print("("+i+","+j+") :");
				if(labyrinthe.getMap(i, j).getTypeMap() == TypeMap.MORT){
					//System.out.print(" MORT ");
					if(labyrinthe.nbVoisin(i,j) == 3){
						//System.out.println(getLabyrinthe().getMap(i, j).getTypeMap()+" -> VIVANT");
						getCopie()[i][j].setTypeMap(TypeMap.VIVANT);
					}else{
						//System.out.println(getLabyrinthe().getMap(i, j).getTypeMap()+" -> MORT");
						getCopie()[i][j].setTypeMap(TypeMap.MORT);
					}
				}
					
				else{
					//System.out.print(" VIVANT ");
					if(labyrinthe.nbVoisin(i,j) < 2 || labyrinthe.nbVoisin(i,j) > 3){
						//System.out.println(getLabyrinthe().getMap(i, j).getTypeMap()+" -> MORT");
						getCopie()[i][j].setTypeMap(TypeMap.MORT);
					}else{
						//System.out.println(getLabyrinthe().getMap(i, j).getTypeMap()+" -> VIVANT");
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
		// Tant que copie est differente de laby.getJeu() Faire...
		
		if(equals(getLabyrinthe().getJeu(), getCopie())){
			setFin(true);
			nbCoup-=2;
		}
		for (int i = 0; i < getHauteur(); i++) {
			for (int j = 0; j < getLargeur(); j++) {
				getLabyrinthe().getMap(i, j).setTypeMap(getCopie()[i][j].getTypeMap());
			}
		}
		nbCoup++;
		miseAJour();
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
