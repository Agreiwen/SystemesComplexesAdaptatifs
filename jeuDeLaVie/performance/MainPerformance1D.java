package jeuDeLaVie.performance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainPerformance1D {
	
	public static int LARGEUR;
	public static String NOM_FICHIER;
	public static int BORNE_SUP = 100;
	public int[] tabCourant;
	public int[] tabCopie;
	public int[] tabSolution;
	public int[] tabDepart;
	public int nbCoup;
	
	public MainPerformance1D(int largeur, String nomFichier){
		LARGEUR = largeur;
		NOM_FICHIER = nomFichier;
		initTab();
	}
	
	public void aleatoire(){
		int random;
		for (int i = 0; i < LARGEUR; i++) {
			random = (int) (Math.round(Math.random()));
			tabCourant[i] = random;
		}
	}
	
	public void initTab(){
		tabCourant = new int[LARGEUR];
		for (int i = 0; i < LARGEUR-1; i++) {
			tabCourant[i] = 0;
		}
		tabCopie = new int[LARGEUR];
		for (int i = 0; i < LARGEUR-1; i++) {
			tabCopie[i] = 0;
		}
		tabSolution = new int[LARGEUR];
		for (int i = 0; i < LARGEUR-1; i++) {
			tabSolution[i] = 0;
		}
		tabDepart = new int[LARGEUR];
		for (int i = 0; i < LARGEUR-1; i++) {
			tabDepart[i] = 0;
		}
	}
	
	public void affTab(int[] tab){
		for (int i = 0; i < LARGEUR; i++) {
			//ecrire(NOM_FICHIER, tab[i]+" ");
			System.out.print(tab[i]+" ");
		}
		//ecrire(NOM_FICHIER, "\n");
		System.out.println();
	}
	
	public void ecritureCopie() {
		int voisinGauche, voisinDroite, milieu, result;
		for (int i = 0; i < LARGEUR; i++) {
			voisinGauche = tabCourant[((i-1)+LARGEUR)%LARGEUR];
			voisinDroite = tabCourant[((i+1)+LARGEUR)%LARGEUR];
			milieu = tabCourant[i];
			String res = ""+voisinGauche+milieu+voisinDroite;
			result = Integer.valueOf(res);
			tabCopie[i] = regle32(result);
		}
	}

	public int regle32(int concat) {
		int res = 0;
		switch(concat){
			case 0 :
				res = 0;
				break;
			case 1 : 
				res = 1;
				break;
			case 10 :
				res = 1;
				break;
			case 11 :
				res = 1;
				break;
			case 100 :
				res = 1;
				break;
			case 101 :
				res = 0;
				break;
			case 110 :
				res = 0;
				break;
			case 111 :
				res = 0;
				break;
		}
		return res;
	}
	
	public void courantDevientCopie(){
		for (int i = 0; i < LARGEUR; i++) {
			tabCourant[i] = tabCopie[i];
		}
	}
	
	public boolean tabToutMort(){
		boolean res = true;
		for (int i = 0; i < LARGEUR; i++) {
			if(tabCopie[i] == 1)
				res = false;
		}
		return res;
	}
	
	private void departDevientCourant() {
		for (int i = 0; i < LARGEUR; i++) {
			tabDepart[i] = tabCourant[i];
		}
	}
	
	public void jeuDeLaVie() {
		int i = 0;
		aleatoire();
		//affTab(tabCourant);
		departDevientCourant();
		while(i < 40){
			ecritureCopie();
			i++;
			if(tabToutMort()){
				//ecrire(NOM_FICHIER, "\nTout mort a "+i+" iteration(s)\n");
				nbCoup = i;
				//System.out.println("\nTout mort a "+nbCoup+" iteration(s)");
				break;
			}
			courantDevientCopie();
		}
	}
	
	public void ecrire(String nomFic, String texte)
	{
		String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic;
		try
		{
			FileWriter fw = new FileWriter(adressedufichier, true);
			BufferedWriter output = new BufferedWriter(fw);
			output.write(texte);
			output.flush();
			output.close();
		}
		catch(IOException ioe){
			System.out.print("Erreur : ");
			ioe.printStackTrace();
			}

	}
	
	public void recopieDansSolution(){
		for (int i = 0; i < LARGEUR; i++) {
			tabSolution[i] = tabDepart[i];
		}
	}

	private void algoGenetique(int nbIteration) {
		int maxCoup = 0;
		for (int i = 0; i < nbIteration; i++) {
			jeuDeLaVie();
			if(nbCoup < BORNE_SUP && nbCoup > maxCoup){
				recopieDansSolution();
				maxCoup = nbCoup;
				System.out.print("Iteration "+i+" - "+"maxCoup = "+maxCoup+" - ");
				affTab(tabSolution);
				System.out.println();
			}
			if((i % 100000) == 0)
				System.out.println("Iteration "+i+" - "+"maxCoup = "+maxCoup);
		}
		System.out.println();
		affTab(tabSolution);
	}
	
	public static void main(String[] args) {
		//int largeur = (int)((Math.random()*32)+1)*3;
		int largeur = 27;
		String nomFichier = "resultat.txt";
		MainPerformance1D m = new MainPerformance1D(largeur,nomFichier);
		int iteration = 3000000;
		m.algoGenetique(iteration);
		//m.ecrire(NOM_FICHIER, LARGEUR+"\n");
	}

}
