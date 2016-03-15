package Server;

import java.util.List;

import Client.CliUV;

public interface SerSession {

	int getId();

	CliUV getCliUv();

	String getDate();

	String getLieu();

	Integer getNbMin();

	Integer getNbMax();

	Integer getNbFormateur();

	void setId(int id);

	void setCliUv(CliUV uv);

	void setDate(String date);

	void setLieu(String lieu);

	void setNbMin(Integer nbMin);

	void setNbMax(Integer nbMax);

	void setNbFormateur(Integer nbFormateur);

	SerUV getSerUv();

	void setSerUv(SerUV uv);

	int getNbApprenant();

	void setNbApprenant(int nbApprenant);

	int getMinFormateur();

	void setMinFormateur(int minFormateur);

	List<SerAgent> getCandidatsAp();

	void setCandidatsAp(List<SerAgent> candidatsAp);

	List<SerAgent> getCandidatsFo();

	void setCandidatsFo(List<SerAgent> candidatsFo);

	List<SerAgent> getApprenants();

	void setApprenants(List<SerAgent> apprenants);

	List<SerAgent> getFormateurs();

	void setFormateurs(List<SerAgent> formateurs);

	public void validerApprenants(List<SerAgent> Apprenants);
	
	public void validerFormateurs(List<SerAgent> Formateurs);
	
	public void removeAgent(SerAgent agent);
}