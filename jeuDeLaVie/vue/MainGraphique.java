package jeuDeLaVie.vue;

import jeuDeLaVie.modele.Modele;

public class MainGraphique {
	
	protected VueParametrage vp;
	
	public MainGraphique(){
		
	    Modele m = new Modele();
	    vp = new VueParametrage(m);

	}
	
	public static void main(String[] args) {
		new MainGraphique();
	}
}
