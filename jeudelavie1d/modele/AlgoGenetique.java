package jeudelavie1d.modele;

public class AlgoGenetique {
	
	protected Modele m;
	protected Grille solution;
	protected Grille copie;

	public AlgoGenetique(Modele m) {
		this.m = m;
		solution = new Grille(m.r, m.largeur);
		copie = new Grille(m.r,m.largeur);
	}
	
	public void recopieDansCopie(Carte[] grille){
		
			for (int j = 0; j < copie.largeurGrille(); j++) {
				copie.getMap(j).setTypeMap(grille[j].getTypeMap());
			
		}
	}
	
	public void recopieDansSolution(Carte[] grille){
			for (int j = 0; j < solution.largeurGrille(); j++) {
				solution.getMap(j).setTypeMap(grille[j].getTypeMap());
			}
	}
	
	public void afficherSolution(){
			for (int j = 0; j < solution.largeurGrille(); j++) {
				System.out.print(solution.getMap(j).toString());
			}
			System.out.println();
	}
	
	public void algo(int nbIteration){
		int maxCoup = 0;
	//	boolean solutionsuper = true;
		int borneSup = 500;
		for (int i = 0; i < nbIteration; i++) {
			if(i%100000 == 0){
				System.out.println("Iteration "+i+" - "+"maxCoup = "+maxCoup);
			}
			//System.out.println(i);
			//String message = "";
			m = new Modele(this.m.r.getNumero(),this.m.largeur);
			m.getGrille().genereGrilleAleatoire();
			//if(m.getNBVivant(m.getGrille())>9){
				
			
				recopieDansCopie(m.getGrille().getJeu());
					//m.affichageGrille();
				//System.out.println(m.getVivant());
				while(!m.isFin()){
					m.jeuDeLaVie();
					if(m.nbCoup >= borneSup){
					//message += "******    D?passemnt     ";
						break;
					}
				}
				if(m.nbCoup < borneSup && m.nbCoup > maxCoup && m.getGrille().estVide() ){
					maxCoup = m.nbCoup;
					//System.out.println("j'ai mieux");
					recopieDansSolution(copie.getJeu());
				}
			//message += Integer.toString(m.getCoup());
			//message += "\n";
			//System.out.println(message);
			}
	//	}
		afficherSolution();
		System.out.println("\n"+maxCoup);
	}

}
