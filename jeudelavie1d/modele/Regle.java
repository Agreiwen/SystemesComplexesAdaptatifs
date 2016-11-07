package jeudelavie1d.modele;

public class Regle {

	
	protected int numero;
	protected int[] valeur;
	
	
	public Regle(int num){
		this.numero = num;
		this.remplirTab();
		//for (int i = 0; i < valeur.length; i++) {
		//	System.out.println(valeur[i]);
		//}
		
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
	            //Cette condition n'est pas obligatoire, le tableau de byte est rempli de 0 ? la base.
	            else {
	                 
	                valeur[i] = 0;
	                 
	            }
	             
	        }


	       /*return valeur;*/
	         
	    
		
	}
	
	


	public int getValeur(int i) {
		return valeur[i];
	}



	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
