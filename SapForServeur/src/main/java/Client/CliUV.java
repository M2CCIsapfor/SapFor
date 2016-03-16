package Client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Yannick - Abdourahman
 */
public class CliUV {
	private Integer numero;
	private String nom;

	public CliUV() {
		this.numero = new Integer(0);
		this.nom = new String();
	}

	public CliUV(Integer numero, String nom) {
		this.numero = numero;
		this.nom = nom;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}