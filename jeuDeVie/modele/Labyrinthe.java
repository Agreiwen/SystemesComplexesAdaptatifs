package jeuDeVie.modele;

import jeuDeVie.modele.Carte.TypeMap;

public class Labyrinthe {
	
	private Carte[][] jeu;
	
	public Labyrinthe(){
		jeu = new Carte[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				jeu[i][j] = new Carte(i, j);
				jeu[i][j].setTypeMap(TypeMap.MORT);
			}
		}
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

}
