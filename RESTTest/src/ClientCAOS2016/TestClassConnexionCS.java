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
			System.err.println(uv.getNom());
			uv.getNom();
		}
	}
	
	public static void afficherSession(List<Session> list) {
		for (model.Session s : list) {
			System.err.println(s.getId());
		}
	}
	
	public static void afficherStage(List<Stage> list) {
		for (Stage s : list) {
			System.err.println(s.getTitle());
		}
	}
	
	public static void afficherAgent(List<Agent> list) {
		for (model.Agent a : list) {
			System.err.println(a.getAgentT().getNom());
		}
	}

	public static void main(String[] args) {

		ConnexionCS connex = new ConnexionCS("666", "ju");

		// afficher(connex.getListeUV("agent"));
		System.out.println("getIdConnexion()");
		System.out.println(connex.getIdConnexion());
		
		/*System.out.println("getListeUVAgent()");
		afficher(connex.getListeUVAgent());*/
		
		System.out.println("getListSessionApprenant()");
		//afficherSession(connex.getListeSessions("sessionT"));
		afficherSession(connex.getListSessionApprenant());
		
		/*System.out.println("getListeAgents()");
		afficherAgent(connex.getListeAgents("agent"));*/
		
		System.out.println("getListSessionFormateur()");
		afficherSession(connex.getListSessionFormateur());
		
		System.out.println("getListSessionCandidatApprenant()");
		afficherSession(connex.getListSessionCandidatApprenant());
		
		
		System.out.println("getListSessionCandidatFormateur()");
		afficherSession(connex.getListSessionCandidatFormateur());
		
		
		System.out.println("getListSessionInscritFormateur()");
		afficherSession(connex.getListSessionInscritFormateur());
		
		/*System.out.println("getListStage()");
		afficherStage(connex.getListStage());*/
		
		
		System.out.println("getListSessionInscritApprenant()");
		afficherSession(connex.getListSessionInscritApprenant());
				
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
