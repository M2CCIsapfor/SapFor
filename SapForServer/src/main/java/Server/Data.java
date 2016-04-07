package Server;

import java.util.*;

/**
 * Classe de generation des donnees	
 * @author Equipe Serveur
 *
 */
public class Data {

	public List<SerUV> lUV;
	public List<SerAgent> lAgent;
	public List<SerSession> lSession;
	public List<SerStage> lStage;
	
	/**
	 * Constructeur sans parametres de la classe avec le jeu de donnees
	 */
	public Data() {
		this.lAgent = new ArrayList<SerAgent>();
		this.lUV = new ArrayList<SerUV>();
		this.lSession = new ArrayList<SerSession>();
		this.lStage = new ArrayList<SerStage>();
		
		// Nouveaux UVs TRANSVERSE
		SerUV trans1 = new SerUV(11, "Equipier prompt secours");
		SerUV trans2 = new SerUV(12, "Moyens radio");	
		trans2.addUV(trans1);
		SerUV trans3 = new SerUV(13, "Préservation du potentiel physique et psychologique");
		trans3.addUV(trans1); trans3.addUV(trans2);
		SerUV trans4 = new SerUV(14, "Organisation et missions du SDIS");
		trans4.addUV(trans1); trans4.addUV(trans2); trans4.addUV(trans3);
		
		// Nouveaux UVs SECOURS A PERSONNES
		SerUV sap1 = new SerUV(21, "Equipier au VSAV niv.1");
		SerUV sap2 = new SerUV(22, "Equipier au VSAV niv.2");	
		sap2.addUV(sap1);
		SerUV sap3 = new SerUV(23, "Equipier au VSAV niv.3");
		sap3.addUV(sap1); sap3.addUV(sap2);

		// Nouveaux UVs SECOURS ROUTIER
		SerUV sr1 = new SerUV(31, "Equipier secours routier niv.1");
		SerUV sr2 = new SerUV(32, "Equipier secours routier niv.2");	
		sr2.addUV(sr1);
		SerUV sr3 = new SerUV(33, "Equipier secours routier niv.3");
		sr3.addUV(sr1); sr3.addUV(sr2);		
		
		// Nouveaux UVs INCENDIE
		SerUV inc1 = new SerUV(41, "Protection individuelle et collective");
		SerUV inc2 = new SerUV(42, "Sauvetages et mises en sécurité");	
		inc2.addUV(inc1);
		SerUV inc3 = new SerUV(43, "Alimentation, établissements, extinction");
		inc3.addUV(inc1); inc3.addUV(inc2);
		SerUV inc4 = new SerUV(44, "Moyens élévateurs aériens");
		inc4.addUV(inc1); inc4.addUV(inc2); inc4.addUV(inc3);		
		
		// Nouveaux UVs INTERVENTIONS
		SerUV inter1 = new SerUV(51, "Interventions diverses");
		SerUV inter2 = new SerUV(52, "Interventions animalières");	
		inter2.addUV(inter1);		
		
		lUV.add(inter2); lUV.add(inter1); lUV.add(inc4); lUV.add(inc3); lUV.add(inc2); lUV.add(inc1);
		lUV.add(sr3); lUV.add(sr2); lUV.add(sr1); lUV.add(sap3); lUV.add(sap2); lUV.add(sap1);
		lUV.add(trans4); lUV.add(trans3); lUV.add(trans2); lUV.add(trans1); 
		
		// Nouveaux Agents
		SerAgent mamadou = new SerAgent("111", "ma");
		mamadou.addUV(inter1); mamadou.addUV(inc1); mamadou.addUV(sr1); mamadou.addUV(sap1); mamadou.addUV(trans1);
		mamadou.setCleHashage("aaa");
		
		SerAgent mouctar = new SerAgent("222", "mo");
		mouctar.addUV(inc1); mouctar.addUV(inc2); mouctar.addUV(inc3); mouctar.addUV(sap1);
		mouctar.setCleHashage("bbb");
		
		SerAgent vicky = new SerAgent("333", "vi");
		vicky.addUV(sr1); vicky.addUV(sr2); vicky.addUV(inter1); vicky.addUV(inter2); vicky.addUV(inc1);
		vicky.setCleHashage("ccc");
		
		SerAgent sebastien = new SerAgent("444", "se");
		sebastien.addUV(inc1); sebastien.addUV(inc2); sebastien.addUV(sr1); sebastien.addUV(sr2);
		sebastien.setCleHashage("ddd");
		
		SerAgent christophe = new SerAgent("555", "ch");
		christophe.addUV(trans1); christophe.addUV(trans2); christophe.addUV(trans3); christophe.addUV(inter1);
		christophe.setCleHashage("eee");
		
		SerAgent julien = new SerAgent("666", "ju");
		julien.addUV(inc2); julien.addUV(inc1); julien.addUV(sap1);
		julien.setCleHashage("fff");
		
		SerAgent ibrahima = new SerAgent("777", "ib");
		ibrahima.addUV(inc1); ibrahima.addUV(inc2); ibrahima.addUV(trans1); ibrahima.addUV(trans2);
		ibrahima.setCleHashage("ggg");
		
		SerAgent abdourahman = new SerAgent("888", "ab");
		abdourahman.addUV(inter1); abdourahman.addUV(inter2); abdourahman.addUV(inc1); abdourahman.addUV(sr1);
		abdourahman.setCleHashage("hhh");
		
		SerAgent yannick = new SerAgent("999", "ya");
		yannick.addUV(trans1); yannick.addUV(trans2); yannick.addUV(trans3); yannick.addUV(inter1);
		yannick.setCleHashage("iii");
		
		SerAgent francois = new SerAgent("321", "fr");
		francois.addUV(inter1); francois.addUV(inter2); francois.addUV(inc1); francois.addUV(inc2);
		francois.setCleHashage("jjj");
		
		SerAgent noel = new SerAgent("123", "no");
		noel.addUV(trans1); noel.addUV(trans2); noel.addUV(trans3); noel.addUV(sap1); noel.addUV(sap2);
		noel.addUV(sr1); noel.addUV(sr2); noel.addUV(inc1); noel.addUV(inc1); noel.addUV(inc2); noel.addUV(inter1);
		noel.setCleHashage("kkk");
		
		lAgent.add(noel); lAgent.add(julien); lAgent.add(christophe); lAgent.add(sebastien); lAgent.add(francois);
		lAgent.add(yannick); lAgent.add(abdourahman); lAgent.add(ibrahima); lAgent.add(vicky); lAgent.add(mouctar); lAgent.add(mamadou);
		
		//nouvelles Sessions et nouveaux Stages
		SerSession transA = new SerSession(001, trans1, "Montpellier", "11-07-2016");
		SerSession incA = new SerSession(002, inc1, "Montpellier", "17-07-2016");
		SerSession srA = new SerSession(003, sr1, "Montpellier", "13-07-2016");
		SerSession sapA = new SerSession(004, sap1, "Montpellier", "12-07-2016");
		SerSession interA = new SerSession(005, inter1, "Montpellier", "18-07-2016");
		SerStage debutants = new SerStage("debutants", ibrahima);

		List<SerAgent> lAg1 = new ArrayList<SerAgent>();
		List<SerAgent> lAg2 = new ArrayList<SerAgent>();
		List<SerAgent> lAg3 = new ArrayList<SerAgent>();
		
		lAg1.add(julien);
		lAg2.add(sebastien); lAg2.add(julien);
		lAg3.add(sebastien);
		
		transA.setCandidatsAp(lAg1); transA.setCandidatsFo(lAg3); transA.setApprenants(lAg3); transA.setFormateurs(lAg3);
		incA.setCandidatsAp(lAg3); incA.setCandidatsFo(lAg1); incA.setApprenants(lAg3); incA.setFormateurs(lAg3);
		srA.setCandidatsAp(lAg3); srA.setCandidatsFo(lAg3); srA.setApprenants(lAg1); srA.setFormateurs(lAg3);
		sapA.setCandidatsAp(lAg3); sapA.setCandidatsFo(lAg3); sapA.setApprenants(lAg3); sapA.setFormateurs(lAg1);
		interA.setCandidatsAp(lAg2); interA.setCandidatsFo(lAg3); interA.setApprenants(lAg3); interA.setFormateurs(lAg3);

		debutants.addSession(interA); debutants.addSession(sapA); debutants.addSession(srA); debutants.addSession(incA); debutants.addSession(transA);

		
		SerSession transB = new SerSession(006, trans4, "Brest", "22-06-2016");
		SerSession incB = new SerSession(007, inc4, "Brest", "24-06-2016");
		SerSession srB = new SerSession(010, sr3, "Brest", "28-06-2016");
		SerSession sapB = new SerSession(011, sap3, "Brest", "25-06-2016");
		SerSession interB = new SerSession(012, inter2, "Brest", "18-06-2016");
		SerStage experts = new SerStage("experts", noel);
		experts.addSession(interB); experts.addSession(sapB); experts.addSession(srB); experts.addSession(incB); experts.addSession(transB);
		
		SerSession incC = new SerSession(013, inc3, "Strasbourg", "02-05-2016");
		SerSession srC = new SerSession(014, sr1, "Strasbourg", "05-05-2016");
		SerSession sapC = new SerSession(015, sap2, "Strasbourg", "03-05-2016");
		SerStage intermediaires = new SerStage("intermediaires", julien);
		intermediaires.addSession(incC); intermediaires.addSession(srC); intermediaires.addSession(sapC);
		
		lSession.add(interB); lSession.add(interA); lSession.add(sapC); lSession.add(srC); lSession.add(incC);
		lSession.add(sapB); lSession.add(srB); lSession.add(incB); lSession.add(transB); lSession.add(sapA);
		lSession.add(srA); lSession.add(incA); lSession.add(transA);
		
		lStage.add(intermediaires); lStage.add(experts); lStage.add(debutants);
	}
	
	/**
	 * Fonction main de la classe Data
	 * @param args
	 */
	public static void main (String[] args) {
		Data data = new Data();
		for (SerStage stage : data.lStage) {
			for (SerSession sess : stage.getListeSerSessions()) {
				System.out.println(sess.getDate());
				System.out.println(sess.getLieu());
			}
		}
	}

}
