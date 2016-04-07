package Client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 * Classe UV commune Client et Serveur
 * @author Equipe Serveur
 */
public class UV {
	private Integer numero;
	private String nom;

	/**
	 * Constructeur vide de l'UV
	 */
	public UV() {
		this.numero = new Integer(0);
		this.nom = new String();
	}

	/**
	 * Constructeur de l'UV
	 * @param numero Numéro identifiant l'UV
	 * @param nom Nom de l'UV
	 */
	public UV(Integer numero, String nom) {
		this.numero = numero;
		this.nom = nom;
	}

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
}