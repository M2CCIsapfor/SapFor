package Server;

import java.util.ArrayList;
import java.util.List;

public class SerAgent extends Client.CliAgent{

	private String password;
	private String cleHashage;
	private List<SerUV> aptitude;
	
	public SerAgent() {
		super();
		this.password = new String();
		this.cleHashage = new String();
		this.aptitude = new ArrayList<SerUV>();
	}

	public SerAgent(String matricule, String password){
		super(matricule);
		this.password = password;
		this.cleHashage = new String();
		this.aptitude = new ArrayList<SerUV>();
	}
	
	public SerAgent(String matricule, String password, List<SerUV> aptitude){
		super(matricule);
		this.password=password;
		this.cleHashage = new String();
		this.aptitude=aptitude;
	}
	
	//Accesseurs et Modifieurs
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCleHashage() {
		return cleHashage;
	}

	public void setCleHashage(String cleHashage) {
		this.cleHashage = cleHashage;
	}

	public List<SerUV> getAptitude() {
		return aptitude;
	}

	public void setAptitude(List<SerUV> aptitude) {
		this.aptitude = aptitude;
	}
	
	public void addUV(SerUV newUV) {
		this.aptitude.add(newUV);
	}
}
