package Server;

import java.util.List;

public interface SerUV {


	Integer getNumero();

	String getNom();

	void setNumero(Integer numero);

	void setNom(String nom);

	List<SerUV> getPrerequis();

	void setPrerequis(List<SerUV> prerequis);

	void addUV(SerUV newUV);

}