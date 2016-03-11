package Server;

import java.util.ArrayList;
import java.util.List;


public class UV {

	private int id;
	private String nom;
	private List<UV> prerequis;

	public UV() {
		this.id = 0;
		this.nom = new String();
		this.prerequis=new ArrayList<UV>();
	}
	
	public UV(int id, String nom){
		this.id=id;
		this.nom=nom;
	}
	public UV(int id, String nom, List<UV> prerequis){
		this.id=id;
		this.nom=nom;
		this.prerequis=prerequis;
	}
	
	//Accesseurs et Modifieurs
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<UV> getListeUV() {
		return prerequis;
	}

	public void setNiveau(List<UV> prerequis) {
		this.prerequis = prerequis;
	}
	
	public void addUV(UV newUV) {
		this.prerequis.add(newUV);
	}
}
