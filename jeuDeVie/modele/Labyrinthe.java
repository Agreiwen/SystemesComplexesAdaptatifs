package jeuDeVie.modele;

import jeuDeVie.modele.Carte.TypeMap;

public class Labyrinthe {
	
	private Carte[][] jeu;
	
	public Labyrinthe(){
		creationLaby();
	}

	public int hauteurLabyrinthe() {
		return jeu.length;
	}

	public int largeurLabyrinthe() {
		return jeu[0].length;
	}

	public Carte getMap(int i, int j) {
		return jeu[i][j];
	}
	
	public Carte[][] getJeu(){
		return jeu;
	}
	
	public void creationLaby(){
		jeu = new Carte[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				jeu[i][j] = new Carte(i, j);
				jeu[i][j].setTypeMap(TypeMap.MORT);
			}
		}
	}
	
	public void genereLabyAleatoire(){
		jeu = new Carte[10][10];
		int random;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				jeu[i][j] = new Carte(i, j);
				random = (int)Math.round(Math.random());
				if(random == 0){
					jeu[i][j].setTypeMap(TypeMap.MORT);
				}else{
					jeu[i][j].setTypeMap(TypeMap.VIVANT);
				}
				
			}
		}
	}

}
