package Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe UV du Serveur
 * @author Equipe Serveur
 */
public class SerUV  {

	private Integer numero;
	private String nom;
	private List<SerUV> prerequis;

	/**
	 * Constructeur vide de l'UV
	 */
	public SerUV() {
		this.numero = new Integer(0);
		this.nom = new String();
		this.prerequis = new ArrayList<SerUV>();
	}

	/**
	 * Constructeur de l'UV
	 * @param id Numéro identifiant l'UV
	 * @param nom Nom de l'UV
	 */
	public SerUV(int id, String nom){
		this.numero = id;
		this.nom = nom;
		this.prerequis=new ArrayList<SerUV>();
	}
	
	/**
	 * Constructeur de l'UV
	 * @param id Numéro identifiant l'UV
	 * @param nom Nom de l'UV
	 * @param prerequis Liste des UVs prerequis pour obtenir l'UV
	 */
	public SerUV(int id, String nom, List<SerUV> prerequis){
		this.numero = id;
		this.nom = nom;
		this.prerequis=prerequis;
	}

	//Accesseurs et Modifieurs
	/**
	 * Accesseur du Numero identifiant l'UV
	 * @return Numero identifiant l'UV
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * Accesseur du Nom de l'UV
	 * @return Nom de l'UV
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur de la liste des UVs prerequis pour obtenir l'UV
	 * @return Liste des UVs prerequis pour obtenir l'UV
	 */
	public List<SerUV> getPrerequis() {
		return prerequis;
	}

	/**
	 * Modifieur du Numero identifiant l'UV
	 * @param numero Numero identifiant l'UV
	 */	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * Modifieur du Nom de l'UV
	 * @param nom Nom de l'UV
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Modifieur de la liste des UVs prerequis pour obtenir l'UV
	 * @param prerequis Liste des UVs prerequis pour obtenir l'UV
	 */
	public void setPrerequis(List<SerUV> prerequis) {
		this.prerequis = prerequis;
	}

	/**
	 * Ajout d'un UV à la liste des UVs prerequis pour obtenir l'UV
	 * @param newUV UV a ajouter a la liste des prerequis
	 */
	public void addUV(SerUV newUV) {
		this.prerequis.add(newUV);
	}
	
}
