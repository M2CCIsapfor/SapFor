package Server;

import java.util.List;

public interface SerStage {

	String getTitle();

	void setTitle(String title);
	
	List<SerSession> getListeSerSessions();

	void setListeSerSessions(List<SerSession> listeSerSessions);

	SerAgent getDirecteurSer();

	void setDirecteurSer(SerAgent directeurSer);

	void addSession(SerSession newSession);

}