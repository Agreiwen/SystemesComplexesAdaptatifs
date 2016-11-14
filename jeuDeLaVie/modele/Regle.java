package jeuDeLaVie.modele;

public class Regle {

	protected int numero;
	protected int[] valeur;
	
	public Regle(int num){
		this.numero = num;
		this.remplirTab();
	}

	private void remplirTab() {
		valeur = new int[8];
	    int decimal = numero;
	    for(int i = 0; i < 8; i++) {
	    	if(decimal - Math.pow(2,7-i) > 0) {
	    		valeur[i] = 1;
	            decimal -= Math.pow(2,7-i);
	        }
	        else if(decimal - Math.pow(2,7-i) == 0) {
	        	valeur[i] = 1;
	            break;
	        }
	        else {
	        	valeur[i] = 0;
	        }
	    }
	}
	
	public int getValeur(int i, int j, int k) {
		int res = 0;
		String s = ""+i+j+k;
		int concatenation = Integer.valueOf(s);
		switch(concatenation){
		case 0 :
			res = valeur[7];
			break;
		case 1 :
			res = valeur[6];
			break;
		case 10 :
			res = valeur[5];
			break;
		case 11 :
			res = valeur[4];
			break;
		case 100 :
			res = valeur[3];
			break;
		case 101 :
			res = valeur[2];
			break;
		case 110 :
			res = valeur[1];
			break;
		case 111 :
			res = valeur[0];
			break;
		}
		return res;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
