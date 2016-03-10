
import java.util.*;

public class Session {
	private UV uv;
	private String lieu;
	private int nbApprenant;
	private int nbFormateur;
	private int minApprenant;
	private int minFormateur;
	private String date;
	private List<Agent> candidatsAp;
	private List<Agent> candidatsFo;
	private List<Agent> apprenants;
	private List<Agent> formateurs;
	
	public Session() {
		
		this.uv=new UV();
		this.lieu = new String();
		this.nbApprenant = 0;
		this.minFormateur = 0;
		this.minApprenant = 0;
		this.minFormateur = 0;
		this.date = new String();
		this.candidatsAp = new ArrayList<Agent>();
		this.candidatsFo = new ArrayList<Agent>();
		this.apprenants = new ArrayList<Agent>();
		this.formateurs = new ArrayList<Agent>();
	}
	
	public Session(UV uv, String lieu, String date){
		this.uv=uv;
		this.lieu=lieu;
		this.date=date;
	}

	public UV getUv() {
		return uv;
	}

	public void setId(UV uv) {
		this.uv = uv;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getNbApprenant() {
		return nbApprenant;
	}

	public void setNbApprenant(int nbApprenant) {
		this.nbApprenant = nbApprenant;
	}

	public int getNbFormateur() {
		return nbFormateur;
	}

	public void setNbFormateur(int nbFormateur) {
		this.nbFormateur = nbFormateur;
	}

	public int getMinApprenant() {
		return minApprenant;
	}

	public void setMinApprenant(int minApprenant) {
		this.minApprenant = minApprenant;
	}

	public int getMinFormateur() {
		return minFormateur;
	}

	public void setMinFormateur(int minFormateur) {
		this.minFormateur = minFormateur;
	}

	public String getDates() {
		return date;
	}

	public void setDates(String date) {
		this.date = date;
	}

	public List<Agent> getCandidatsAp() {
		return candidatsAp;
	}

	public void setCandidatsAp(List<Agent> candidatsAp) {
		this.candidatsAp = candidatsAp;
	}

	public List<Agent> getCandidatsFo() {
		return candidatsFo;
	}

	public void setCandidatsFo(List<Agent> candidatsFo) {
		this.candidatsFo = candidatsFo;
	}

	public List<Agent> getApprenants() {
		return apprenants;
	}

	public void setApprenants(List<Agent> apprenants) {
		this.apprenants = apprenants;
	}

	public List<Agent> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Agent> formateurs) {
		this.formateurs = formateurs;
	}


	
	
}
