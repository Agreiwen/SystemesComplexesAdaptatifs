package jeuDeVie.modele;

public class Carte {
	
	protected int positionX;
	protected int positionY;
	public enum TypeMap {VIVANT, MORT};
	private TypeMap typeMap;
	
	public Carte(int x, int y){
		this.positionX = x;
		this.positionY = y;
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

	@Override
	public String toString() {
		return "Carte(" + positionX + ", " + positionY + ", " + typeMap + ") ";
	}

	public int nbVosin() {
		// TODO La suite au prochain episode
		return 0;
	}

}
