package Client;

import java.util.List;

public interface CliStage {

	String getTitle();

	List<CliSession> getCliListeSessions();

	CliAgent getCliDirecteur();

	void setTitle(String title);

	void setCliListeSessions(List<CliSession> listeSessions);

	void setCliDirecteur(CliAgent directeur);

}