package Server;

import java.util.List;

public interface SerAgent {

	String getMatricule();

	String getNom();

	String getPrenom();

	void setMatricule(String matricule);

	void setNom(String nom);

	void setPrenom(String prenom);
	
	String getPassword();

	void setPassword(String password);

	String getCleHashage();

	void setCleHashage(String cleHashage);

	List<SerUV> getAptitude();

	void setAptitude(List<SerUV> aptitude);

	public void addUV(SerUV newUV);
}