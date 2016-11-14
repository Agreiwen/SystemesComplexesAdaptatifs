package jeuDeLaVie.modele;

public class Grille {
	
	private int[][] jeu;
	private int largeur, longueur;
	private Regle r;
	
	public Grille(int largeur, int longueur){
		this.largeur = largeur;
		this .longueur = longueur;
		grilleVide();
	}

	public int largeurGrille() {
		return jeu.length;
	}

	public int longueurGrille() {
		return jeu[0].length;
	}

	public int getCellule(int i, int j) {
		return jeu[i][j];
	}
	
	public void setCellule(int i, int j, int valeur){
		jeu[i][j] = valeur;
	}
	
	public void grilleVide(){
		jeu = new int[largeur][longueur];
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				jeu[i][j] = 0;
			}
		}
	}
	
	public int nbVoisinMoore9NonTorique(int i, int j){
		int nbVoisin = 0;
		for (int k = i-1; k <= i+1; k++) {
			for (int l = j-1; l <= j+1; l++) {
				try {
					nbVoisin += getCellule(k, l);
				} catch (ArrayIndexOutOfBoundsException e) {
					//Degueulasse mais balek
				}
			}
		}
		return nbVoisin;
	}
	
	public int nbVoisinMoore8NonTorique(int i, int j){
		int nbVoisin = 0;
		for (int k = i-1; k <= i+1; k++) {
			for (int l = j-1; l <= j+1; l++) {
				try {
					nbVoisin += getCellule(k, l);
				} catch (ArrayIndexOutOfBoundsException e) {
					//Degueulasse mais balek
				}
			}
		}
		nbVoisin -= getCellule(i, j);
		return nbVoisin;
	}
	
	public int nbVoisinMoore8(int i, int j) {
		int nbVoisin = 0;
		int minLargeur = ((i-1)+largeur)%largeur;
		int maxLargeur = ((i+1)+largeur)%largeur;
		int minLongeur = ((j-1)+longueur)%longueur;
		int maxLongeur = ((j+1)+longueur)%longueur;
		nbVoisin += getCellule(minLargeur, minLongeur);
		nbVoisin += getCellule(minLargeur, j);
		nbVoisin += getCellule(minLargeur, maxLongeur);
		
		nbVoisin += getCellule(i, minLongeur);
		nbVoisin += getCellule(i, maxLongeur);
		
		nbVoisin += getCellule(maxLargeur, minLongeur);
		nbVoisin += getCellule(maxLargeur, j);
		nbVoisin += getCellule(maxLargeur, maxLongeur);
		return nbVoisin;
	}

	public int nbVoisinMoore9(int i, int j) {
		int nbVoisin = 0;
		int minLargeur = ((i-1)+largeur)%largeur;
		int maxLargeur = ((i+1)+largeur)%largeur;
		int minLongeur = ((j-1)+longueur)%longueur;
		int maxLongeur = ((j+1)+longueur)%longueur;
		nbVoisin += getCellule(minLargeur, minLongeur);
		nbVoisin += getCellule(minLargeur, j);
		nbVoisin += getCellule(minLargeur, maxLongeur);
		
		nbVoisin += getCellule(i, minLongeur);
		nbVoisin += getCellule(i, j);
		nbVoisin += getCellule(i, maxLongeur);
		
		nbVoisin += getCellule(maxLargeur, minLongeur);
		nbVoisin += getCellule(maxLargeur, j);
		nbVoisin += getCellule(maxLargeur, maxLongeur);
		return nbVoisin;
	}
	
	public int voisinGauche(int i){
		return getCellule(0, ((i-1)+longueur)%longueur);
	}
	
	public int voisinDroit(int i){
		return getCellule(0, ((i+1)+longueur)%longueur);
	}
	
	public int[] getLigne(int i){
		return jeu[i];
	}
	
	public void setLigne(int[] ligne, int i){
		jeu[i] = ligne;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				s.append(getCellule(i, j)+" ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grille other = (Grille) obj;
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				if(this.getCellule(i, j) != other.getCellule(i, j)){
					res &= false;
				}
			}
		}
		//System.out.println(res);
		return res;
	}
	
}
