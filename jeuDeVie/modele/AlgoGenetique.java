package jeuDeVie.modele;

public class AlgoGenetique {
	
	protected Modele m;
	protected Grille solution;
	protected Grille copie;

	public AlgoGenetique(Modele m) {
		this.m = m;
		solution = new Grille();
		copie = new Grille();
	}
	
	public void recopieDansCopie(Carte[][] grille){
		for (int i = 0; i < copie.hauteurGrille(); i++) {
			for (int j = 0; j < copie.largeurGrille(); j++) {
				copie.getMap(i, j).setTypeMap(grille[i][j].getTypeMap());
			}
		}
	}
	
	public void recopieDansSolution(Carte[][] grille){
		for (int i = 0; i < solution.hauteurGrille(); i++) {
			for (int j = 0; j < solution.largeurGrille(); j++) {
				solution.getMap(i, j).setTypeMap(grille[i][j].getTypeMap());
			}
		}
	}
	
	public void afficherSolution(){
		for (int i = 0; i < solution.hauteurGrille(); i++) {
			for (int j = 0; j < solution.largeurGrille(); j++) {
				System.out.print(solution.getMap(i, j).toString());
			}
			System.out.println();
		}
	}
	
	public void algo(int nbIteration){
		int maxCoup = 0;
		int borneSup = 500;
		for (int i = 0; i < 1000000; i++) {
			if(i%100000 == 0){
				System.out.println(i+" "+maxCoup);
			}
			//System.out.println(i);
			//String message = "";
			m = new Modele();
			m.getGrille().genereGrilleAleatoire();
			recopieDansCopie(m.getGrille().getJeu());
			//m.affichageGrille();
			//System.out.println(m.getVivant());
			while(!m.isFin()){
				m.jeuDeLaVie();
				if(m.nbCoup >= borneSup){
					//message += "******    Dépassemnt     ";
					break;
				}
			}
			if(m.nbCoup < borneSup && m.nbCoup > maxCoup && m.getGrille().estVide()){
				maxCoup = m.nbCoup;
				//System.out.println("j'ai mieux");
				recopieDansSolution(copie.getJeu());
			}
			//message += Integer.toString(m.getCoup());
			//message += "\n";
			//System.out.println(message);
		}
		afficherSolution();
		System.out.println("\n"+maxCoup);
	}

}
