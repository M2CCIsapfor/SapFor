package Client;

public interface CliAgent {

	/**
	 *
	 * @return matricule
	 */
	String getMatricule();

	/**
	 *
	 * @return nom de l'agent
	 */
	String getNom();

	/**
	 *
	 * @return prenom de l'agent
	 */
	String getPrenom();

	/**
	 * setter du matricule de l agent
	 *
	 * @param matricule
	 */
	void setMatricule(String matricule);

	/**
	 * setter du nom de l'agent
	 *
	 * @param nom
	 */
	void setNom(String nom);

	/**
	 * setter du prenom de l'agent
	 *
	 * @param prenom
	 */
	void setPrenom(String prenom);

}