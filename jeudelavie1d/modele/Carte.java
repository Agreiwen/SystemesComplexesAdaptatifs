package jeudelavie1d.modele;


public class Carte {
	
	protected int positionX;
	//protected int positionY;
	public enum TypeMap {VIVANT, MORT};
	private TypeMap typeMap;
	
	public Carte(int x){
		this.positionX = x;
	//	this.positionY = y;
		typeMap = TypeMap.MORT;
	}

	public Carte(Carte carte) {
		// TODO Auto-generated constructor stub
		try{
		this.positionX = carte.positionX;
		this.typeMap = carte.typeMap;
		}catch(Exception E){
			this.positionX = 0;
			this.typeMap = TypeMap.MORT;
		}
	//	this.positionY = carte.positionY;
		
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
		return "Carte(" + positionX + ", " + typeMap + ") ";
	}

}