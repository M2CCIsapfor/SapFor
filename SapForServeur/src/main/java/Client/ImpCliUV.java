package Client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Yannick - Abdourahman
 */
public class ImpCliUV implements CliUV {
	private Integer numero;
	private String nom;

	public ImpCliUV() {
		this.numero = new Integer(0);
		this.nom = new String();
	}

	public ImpCliUV(Integer numero, String nom) {
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