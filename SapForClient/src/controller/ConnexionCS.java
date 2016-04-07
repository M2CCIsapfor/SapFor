package controller;

/**
 * Classe de connexion avec le serveur 
 * via les URLs de l'API REST
 * @author 
 * 		Yannick Melin
 * 		Abdourahman Ahmed
 * 		Ibrahima Toure
 */

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import model.Agent;
import model.AgentT;
import model.Session;
import model.SessionT;
import model.Stage;
import model.UV;

public class ConnexionCS {
	private String idConnexion;
	private Agent utilisateur;
	private WebResource service;
	private static String urlServeur = "http://localhost:8080/s/";

	// constructeur
	public ConnexionCS(String login, String mdp) {
		this.utilisateur = new Agent();
		config();
		Authentification(login, mdp);
	}

	// getter de test

	public String getIdConnexion() {
		return idConnexion;
	}

	// m�thodes publiques utilis�es par les controleurs externes.

	/**
	 * liste des sessions accessibles par l'utilisateur en tant que formateur
	 * 
	 * @return La liste des Sessions en tant que Formateur
	 */

	public List<Session> getListSessionFormateur() {// OK

		if (utilisateur.getListeSessionsFormateurAccessible().isEmpty()) {
			List<Session> liste = new ArrayList<Session>();
			liste = getListeSessionsParam("sessionsAcc", "role", "formateur");
			utilisateur.setListeSessionsFormateurAccessible(liste);
			return liste;
		} else {
			return utilisateur.getListeSessionsFormateurAccessible();
		}
	}

	/**
	 * liste des sessions accessibles par l'utilisateur en tant qu'apprenant
	 * 
	 * @return La liste des Sessions en tant qu'apprenant
	 */

	public List<Session> getListSessionApprenant() {// OK

		if (utilisateur.getListeSessionsApprenantAccessible().isEmpty()) {
			List<Session> liste = new ArrayList<Session>();
			liste = getListeSessionsParam("sessionsAcc", "role", "apprenant");
			utilisateur.setListeSessionsApprenantAccessible(liste);
			return liste;
		} else {
			return utilisateur.getListeSessionsApprenantAccessible();
		}
	}


	public List<Session> getListSessionApprenant2() {// OK

		List<Session> liste = new ArrayList<Session>();
		liste = getListeSessionsParam("sessionsAcc", "role", "apprenant");

		return liste;

	}

	/*
	 * liste des sessions d'un stage commente, inutilisable
	 * 
	 * @return
	 */
	/*
	 * public List<Session> getListSessionDirecteur(int id) {
	 * 
	 * if (utilisateur.getListeSessionsStage().isEmpty()) { List<Session> liste
	 * = new ArrayList<Session>(); liste = getListeSessionsParams("sessions",
	 * "role", "directeur", "stage", id);
	 * utilisateur.setListeSessionsStage(liste); return liste; } else { return
	 * utilisateur.getListeSessionsStage(); } }
	 */

	/**
	 * liste des stages dont s'occupe l'agent directeur
	 * 
	 * @return La liste des Stage du directeur concerne
	 */

	public List<Stage> getListStage() {

		if (utilisateur.getListStages().isEmpty()) {
			List<Stage> liste = new ArrayList<Stage>();
			liste = getListeStage("directeur");
			utilisateur.setListStages(liste);
			return liste;
		} else {
			return utilisateur.getListStages();

		}
	}

	/**
	 * liste des sessions ou l'utilisateur est candidat Apprenant
	 * @return Liste des Sessions ou l'utilisateur est candidat Apprenant
	 */
	public List<Session> getListSessionCandidatApprenant() {// OK

		if (utilisateur.getListeSessionsCandidat().isEmpty()) {
			List<Session> liste = new ArrayList<Session>();
			liste = getListeSessionsParam("sessions", "role", "ApprenantCandidat");
			utilisateur.setListeSessionsCandidat(liste);
			return liste;
		} else {
			return utilisateur.getListeSessionsCandidat();

		}
	}

	/**
	 * liste des sessions ou l'utilisateur est candidat Formateur
	 * @return Liste des Sessions ou l'utilisateur est candidat Formateur
	 */
	public List<Session> getListSessionCandidatFormateur() {// OK

		if (utilisateur.getListeSessionsFormateurCandidat().isEmpty()) {
			List<Session> liste = new ArrayList<Session>();
			liste = getListeSessionsParam("sessions", "role", "FormateurCandidat");
			utilisateur.setListeSessionsFormateurtCandidat(liste);
			return liste;
		} else {
			return utilisateur.getListeSessionsFormateurCandidat();

		}
	}

	/**
	 * liste des sessions ou l'utilisateur est Formateur
	 * 
	 * @return Liste des sessions ou l'utilisateur est Formateur
	 */
	public List<Session> getListSessionInscritFormateur() {// OK

		if (utilisateur.getListeSessionsFormateurInscrit().isEmpty()) {

			List<Session> liste = new ArrayList<Session>();
			liste = getListeSessionsParam("sessions", "role", "FormateurInscrit");
			utilisateur.setListeSessionsFormateurtInscrit(liste);
			return liste;
		} else {
			return utilisateur.getListeSessionsFormateurInscrit();
		}
	}

	/**
	 * liste des sessions ou l'utilisateur est Apprenant
	 * 
	 * @return Liste des sessions ou l'utilisateur est Apprenant
	 */

	public List<Session> getListSessionInscritApprenant() {// OK

		if (utilisateur.getListeSessionsInscrit().isEmpty()) {

			List<Session> liste = new ArrayList<Session>();
			liste = getListeSessionsParam("sessions", "role", "ApprenantInscrit");
			utilisateur.setListeSessionsInscrit(liste);
			return liste;
		} else {
			return utilisateur.getListeSessionsInscrit();
		}
	}

	/**
	 * liste des candidats apprenants a une session (pour directeur)
	 * 
	 * @param idSession Numero de la Session
	 * @return liste des Candidats apprenant a une session
	 */

	public List<Agent> getListAgentCandidatApprenant(int idSession) {// OK

		List<Agent> liste = new ArrayList<Agent>();
		liste = getListeAgentParamDir(idSession, "ApprenantCandidat");
		return liste;
	}

	/**
	 * liste des candidats formateurs a une session (pour directeur)
	 * 
	 * @param idSession Numero de la Session
	 * @return liste des Candidats formateur a une session
	 */

	public List<Agent> getListAgentCandidatFormateur(int idSession) {// OK

		List<Agent> liste = new ArrayList<Agent>();
		liste = getListeAgentParamDir(idSession, "ApprenantFormateur");
		return liste;
	}

	/**
	 * liste des Apprenants inscrit a une session (pour directeur)
	 * 
	 * @param idSession Numero de la Session
	 * @return liste des Apprenants inscrit a une session
	 */

	public List<Agent> getListAgentInscitApprenant(int idSession) {// OK

		List<Agent> liste = new ArrayList<Agent>();
		liste = getListeAgentParamDir(idSession, "ApprenantInscrit");
		return liste;
	}

	/**
	 * liste des Formateurs inscrit a une session (pour directeur)
	 * 
	 * @param idSession Numero de la Session
	 * @return liste des Formateurs inscrit a une session
	 */

	public List<Agent> getListAgentInscitFormateur(int idSession) {// OK

		List<Agent> liste = new ArrayList<Agent>();
		liste = getListeAgentParamDir(idSession, "FormateurInscrit");
		return liste;
	}

	/**
	 * liste des participants a une session (pour directeur)
	 * 
	 * @param idSession Numero de la Session
	 * @return liste des participants a une session
	 */

	public List<Agent> getListeAgentSession(int idSession) {// OK
		List<Agent> liste = new ArrayList<Agent>();
		liste = getListeAgents("sessions/" + idSession + "/participants");
		return liste;
	}

	/**
	 * liste des UV validees par l'agent
	 * 
	 * @return Liste des UV validees par l'agent
	 */

	public List<UV> getListeUVAgent() {// OK
		List<UV> liste = new ArrayList<UV>();
		liste = getListeUV("agent");
		return liste;
	}

	// acces au serveur

	// soumissions aux serveurs

	/**
	 * Validation des agents pour une session donnee
	 * 
	 * @param list Liste des Agents a valider
	 * @param idSession Numero de la Session
	 */

	public void validationCandidature(List<Agent> list, int idSession) {

		for (Agent agent : list) {
			String idSessionS = String.valueOf(idSession);
			String matricule = agent.getAgentT().getMatricule();

			service.path(idConnexion + "/sessions" + idSession + "session").queryParam(idSessionS, matricule);
		}

	}

	/**
	 * suppression des candidatures de l'agent aux sessions
	 * ou il ne veut plus postuler
	 * 
	 * @param list Liste des Sessions
	 */

	public void annuleCandidatures(List<Session> list) {// OK

		for (Session session : list) {
			String valID = String.valueOf(session.getId());

			service.path(idConnexion + "/delete").queryParam("session", valID);

		}

	}

	/**
	 * soumission des candidatures de l'agent comme apprenant
	 * 
	 * @param list Liste des Sessions
	 */

	public void postulerApprenant(List<Session> list) {// OK

		for (Session session : list) {
			String valID = String.valueOf(session.getId());
			String prio = String.valueOf(session.getPrio());
			service.path(idConnexion + "/submit").queryParam("role", "Apprenant").queryParam("session", valID)
			.queryParam("prio", prio);

		}

	}

	/**
	 * soumission des candidatures de l'agent comme formateur
	 * 
	 * @param list Liste des Sessions
	 */

	public void postulerFormateur(List<Session> list) {// OK

		for (Session session : list) {
			String valID = String.valueOf(session.getId());
			String prio = String.valueOf(session.getPrio());

			service.path(idConnexion + "/submit").queryParam("role", "Formateur").queryParam("session", valID)
			.queryParam("prio", prio);
		}

	}

	// m�thodes priv�es utilis�es dans la classe.

	// requetes au serveur
	/**
	 * authentification au serveur
	 * 
	 * @param login matricule de l'Agent
	 * @param mdp Mot de passe de l'Agent
	 */
	private void Authentification(String login, String mdp) {
		String logger = null;
		String log = "login";
		logger = service.path(log).queryParam("login", login).queryParam("password", mdp).accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		this.idConnexion = logger;
	}

	/*
	 * 
	 * envoi de la requete au serveur et recuperation de la liste des Sessions
	 * Comment : inutilisable
	 * 
	 * @param refMethode
	 * @return
	 */
	/*
	 * private List<Session> getListeSessions(String refMethode) {
	 * List<SessionT> listeS = new ArrayList<SessionT>(); listeS =
	 * service.path(idConnexion + "/" +
	 * refMethode).accept(MediaType.APPLICATION_JSON) .get(new
	 * GenericType<List<SessionT>>() { });
	 * 
	 * return ConvertSessionT(listeS); }
	 */

	/**
	 * Envoi de la requete parametree au serveur 
	 * et recuperation de la liste des Sessions
	 * 
	 * @param refMethode URL d'envoie
	 * @param param Parametres a envoyer
	 * @param value valeur des parametres
	 * @return Liste des Sessions
	 */
	private List<Session> getListeSessionsParam(String refMethode, String param, String value) {
		List<SessionT> listeS = new ArrayList<SessionT>();
		listeS = service.path(idConnexion + "/" + refMethode).queryParam(param, value)
				.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>() {
				});
		return ConvertSessionT(listeS);
	}

	/**
	 * convertit la liste de SessionT en Session
	 * 
	 * @param listT Liste de Session communes Client/Serveur
	 * @return Liste de Session du Client
	 */
	private List<Session> ConvertSessionT(List<SessionT> listT) {
		List<Session> listerep = new ArrayList<Session>();
		for (SessionT st : listT) {
			Session session = new Session();
			session.setSessionT(st);
			listerep.add(session);
		}
		return listerep;
	}

	/**
	 * convertit la liste de AgentT en Agent
	 * 
	 * @param listT Liste d'Agent communes Client/Serveur
	 * @return Liste d'Agent du Client
	 */
	private List<Agent> ConvertAgentT(List<AgentT> listT) {
		List<Agent> listerep = new ArrayList<Agent>();
		for (AgentT at : listT) {
			Agent agent = new Agent();
			agent.setAgentT(at);
			listerep.add(agent);
		}
		return listerep;
	}

	/*
	 * envoi de la requete param�tr�e au serveur et r�cup�ration de la liste des
	 * Sessions comment� inutilisable
	 * 
	 * @param refMethode
	 * @param param
	 * @param value
	 * @param param2
	 * @param id
	 * @return
	 */////////////////////////////////
	/*
	 * private List<Session> getListeSessionsParams(String refMethode, String
	 * param, String value, String param2, int id) { String idS =
	 * String.valueOf(id);
	 * 
	 * List<SessionT> listeS = new ArrayList<SessionT>(); listeS =
	 * service.path(idConnexion + "/" + refMethode).queryParam(param,
	 * value).queryParam(param2, idS)
	 * .accept(MediaType.APPLICATION_JSON).get(new GenericType<List<SessionT>>()
	 * { });
	 * 
	 * return ConvertSessionT(listeS) }
	 */

	/**
	 * Envoie de la requete de recuperation de la liste des Agents Candidats
	 * a une Session
	 * @param id Numero de la Session
	 * @param value Role de l'Agent
	 * @return Liste des Agents
	 */
	private List<Agent> getListeAgentParamDir(int id, String value) {
		String idS = String.valueOf(id);

		List<AgentT> listeS = new ArrayList<AgentT>();
		listeS = service.path(idConnexion + "/sessions/" + idS + "/candidats").queryParam("role", value)
				.accept(MediaType.APPLICATION_JSON).get(new GenericType<List<AgentT>>() {
				});

		return ConvertAgentT(listeS);

	}

	/**
	 * Envoi de la requete au serveur et recuperation de la liste des UV
	 * 
	 * @param refMethode URL d'envoie de la requete
	 * @return Liste des UVs
	 */

	public List<UV> getListeUV(String refMethode) {
		// List<UV> listeUV = new ArrayList<UV>();
		List<UV> listeUV = service.path(idConnexion + "/"+ refMethode).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<UV>>() {
				});
		return listeUV;
	}

	/**
	 * Envoi de la requete au serveur et recuperation de la liste des Agents
	 * 
	 * @param refMethode URL d'envoie de la requete
	 * @return Liste des Agents
	 */

	public List<Agent> getListeAgents(String refMethode) {
		List<AgentT> listeA = new ArrayList<AgentT>();
		listeA = service.path(idConnexion + "/" + refMethode).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<AgentT>>() {
				});

		return ConvertAgentT(listeA);

	}

	/**
	 * Envoi de la requete au serveur et recuperation de la liste des Agents
	 * 
	 * @param refMethode URL d'envoie de la requete
	 * @return Liste des Stage
	 */
	private List<Stage> getListeStage(String refMethode) {
		List<Stage> listeA = new ArrayList<Stage>();
		listeA = service.path(idConnexion + "/" +refMethode).queryParam("role","directeur").accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Stage>>() {
				});
		return listeA;
	}

	// configuration de la connexion

	/**
	 * creation de l'URI de connexion
	 * 
	 * @return L'URI de connexion
	 */
	private static URI getBaseURI() {
		URI uri = UriBuilder.fromUri(urlServeur).build();
		return uri;
	}

	/**
	 * creation de la config de connexion
	 */
	private void config() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		this.service = service;
	}

}
