package jeuDeVie.modele;

public class Carte {
	
	protected int positionX;
	protected int positionY;
	public enum TypeMap {VIVANT, MORT};
	private TypeMap typeMap;
	
	public Carte(int x, int y){
		this.positionX = x;
		this.positionY = y;
		typeMap = TypeMap.MORT;
	}

	public Carte(Carte carte) {
		// TODO Auto-generated constructor stub
		this.positionX = carte.positionX;
		this.positionY = carte.positionY;
		this.typeMap = carte.typeMap;
	}

	public TypeMap getTypeMap() {
		return typeMap;
	}

	public void setTypeMap(TypeMap typeMap) {
		this.typeMap = typeMap;
	}
	
	public void setPositionX(int x){
		this.positionX = x;
	}
	
	public int getPositionX(){
		return this.positionX;
	}
	
	public void setPositionY(int y){
		this.positionY = y;
	}
	
	public int getPositionY(){
		return this.positionY;
	}
	
	public int valeur(){
		int res;
		if(this.getTypeMap() == TypeMap.MORT){
			res = 0;
		}else{
			res = 1;
		}
		return res;
	}

	@Override
	public String toString() {
		return "Carte(" + positionX + ", " + positionY + ", " + typeMap + ") ";
	}

}
