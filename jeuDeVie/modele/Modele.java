package jeuDeVie.modele;

import java.util.Observable;

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
	
	public Modele(){
     	labyrinthe = new Labyrinthe();
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
		
	}
	
	public void affichageLabyrinthe(){
		System.out.println("-> Affichage du labyrinthe :\n");
		for(int i=0; i<labyrinthe.hauteurLabyrinthe(); i++){
			for(int j=0; j<labyrinthe.largeurLabyrinthe(); j++){
				System.out.print(labyrinthe.getMap(i, j).toString());
			}System.out.println();
		}
	}

}
