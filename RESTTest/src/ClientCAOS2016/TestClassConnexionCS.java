package ClientCAOS2016;

/**
*
* @author Yannick Melin
* 			Abdouraman Ahmed
*/
import java.util.List;

import model.*;

public class TestClassConnexionCS {

	public static void afficher(List<UV> listeuv) {
		for (UV uv : listeuv) {
			System.out.println(uv.getNom());
			uv.getNom();
		}
	}
	
	public static void afficherSession(List<Session> list) {
		for (model.Session s : list) {
			System.out.println(s.getId()+" - "+s.getLieu()+" - "+s.getDate()+" - "+s.getUV().getNom());
		}
	}
	
	public static void afficherStage(List<Stage> list) {
		for (Stage s : list) {
			System.out.println(s.getTitle());
		}
	}
	
	public static void afficherAgent(List<Agent> list) {
		for (model.Agent a : list) {
			System.out.println(a.getAgentT().getNom());
		}
	}

	public static void main(String[] args) {

		ConnexionCS connex = new ConnexionCS("666", "ju");

		/**
		 * Connexion login mot de passe : récupère la clé de hashage
		 * /s/login?login=666&password=ju
		 */
		// afficher(connex.getListeUV("agent"));
		System.out.println("getIdConnexion()");
		System.out.println(connex.getIdConnexion());
		
		/*System.out.println("getListeUVAgent()");
		afficher(connex.getListeUVAgent());*/
		
		/**
		 * Récupère la liste des sessions où l'agent peut candidater en tant apprenant
		 * /s/<connexion>/sessionAcc?role=apprenant
		 * retourne 5 13 12 11 3 1
		 */
		System.out.println("getListSessionApprenant()");
		//afficherSession(connex.getListeSessions("sessionT"));
		afficherSession(connex.getListSessionApprenant());
		
		/*System.out.println("getListeAgents()");
		afficherAgent(connex.getListeAgents("agent"));*/
		
		/**
		 * Récupère la liste des sessions où l'agent peut candidater en tant formateur
		 * /s/<connexion>/sessionAcc?role=formateur
		 * retourne 4 2
		 */
		System.out.println("getListSessionFormateur()");
		afficherSession(connex.getListSessionFormateur());
		
		/**
		 * Récupère la liste des sessions où l'agent est candidat en tant apprenant
		 * /s/<connexion>/sessions?role=ApprenantCandidat
		 * retourne 5 1 
		 */
		System.out.println("getListSessionCandidatApprenant()");
		afficherSession(connex.getListSessionCandidatApprenant());
		
		/**
		 * Récupère la liste des sessions où l'agent est candidat en tant formateur
		 * /s/<connexion>/sessions?role=Formateur
		 * retourne 2
		 */
		System.out.println("getListSessionCandidatFormateur()");
		afficherSession(connex.getListSessionCandidatFormateur());
		
		/**
		 * Récupère la liste des sessions où l'agent est inscrit en tant apprenant
		 * /s/<connexion>/sessions?role=ApprenantInscrit
		 * retourne 3
		 */
		System.out.println("getListSessionInscritApprenant()");
		afficherSession(connex.getListSessionInscritApprenant());
		
		/**
		 * Récupère la liste des sessions où l'agent est inscrit en tant formateur
		 * /s/<connexion>/sessions?role=FormateurInscrit
		 * retourne 4
		 */		
		System.out.println("getListSessionInscritFormateur()");
		afficherSession(connex.getListSessionInscritFormateur());
		
		/**
		 * Récupère la liste des stages où l'agent connecté est directeur
		 * /s/<connexion>/directeur?role=directeur
		 * retourne ?
		 */	
		System.out.println("getListStage()");
		afficherStage(connex.getListStage());
				
		/*System.out.println("getListAgentCandidatApprenant()");
		afficherAgent(connex.getListAgentCandidatApprenant(23));*/
		
		
		
	/*	System.out.println("getListSessionFormateur()");
				
		System.out.println("getListSessionFormateur()");
				
		System.out.println("getListSessionFormateur()");
				
		System.out.println("getListSessionFormateur()");
				
		System.out.println("getListSessionFormateur()");
		
		System.out.println("getListSessionFormateur()");
		
		System.out.println("getListSessionFormateur()");
		
		System.out.println("getListSessionFormateur()");
		
		System.out.println("getListSessionFormateur()");
		
		System.out.println("getListSessionFormateur()");*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
}
