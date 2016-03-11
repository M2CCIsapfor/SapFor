package Client;


import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 *
 * @author Yannick - Abdourahman
 */
public class UV {
    private Integer numero;
    private String nom;

    public UV() {
        this.numero = new Integer(0);
        this.nom = new String();
    }

    public UV(Integer numero, String nom) {
        setNumero(numero);
        setNom(nom);
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