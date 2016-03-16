package Server;

import java.util.ArrayList;
import java.util.List;

public class SerUV extends Client.CliUV {

	private List<SerUV> prerequis;
	
	public SerUV() {
		super();
		this.prerequis = new ArrayList<SerUV>();
	}

	public SerUV(int id, String nom){
		super(id, nom);
		this.prerequis=new ArrayList<SerUV>();
	}
	
	public SerUV(int id, String nom, List<SerUV> prerequis){
		super(id, nom);
		this.prerequis=prerequis;
	}

	//Accesseurs et Modifieurs

	public List<SerUV> getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(List<SerUV> prerequis) {
		this.prerequis = prerequis;
	}

	public void addUV(SerUV newUV) {
		this.prerequis.add(newUV);
	}
	
}
