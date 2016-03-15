package Client;

public interface CliSession {

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

}