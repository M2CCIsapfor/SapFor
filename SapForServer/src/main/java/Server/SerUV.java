package Server;

import java.util.ArrayList;
import java.util.List;

public class SerUV extends Client.UV {

	private Integer numero;
	private String nom;
	private List<SerUV> prerequis;
	
	public SerUV() {
		this.numero = new Integer(0);
		this.nom = new String();
		this.prerequis = new ArrayList<SerUV>();
	}

	public SerUV(int id, String nom){
		this.numero = id;
		this.nom = nom;
		this.prerequis=new ArrayList<SerUV>();
	}
	
	public SerUV(int id, String nom, List<SerUV> prerequis){
		this.numero = id;
		this.nom = nom;
		this.prerequis=prerequis;
	}

	//Accesseurs et Modifieurs

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

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
