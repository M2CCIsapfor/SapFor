package Server;

import java.util.*;

public class Data {

	public List<UV> lUV;
	public List<Agent> lAgent;
	public List<Session> lSession;
	public List<Stage> lStage;
	
	
	
	public Data() {
		this.lAgent = new ArrayList<Agent>();
		this.lUV = new ArrayList<UV>();
		this.lSession = new ArrayList<Session>();
		this.lStage = new ArrayList<Stage>();
		
		// Nouveaux UVs TRANSVERSE
		UV trans1 = new UV(11, "Equipier prompt secours");
		UV trans2 = new UV(12, "Moyens radio");	
		trans2.addUV(trans1);
		UV trans3 = new UV(13, "Préservation du potentiel physique et psychologique");
		trans3.addUV(trans1); trans3.addUV(trans2);
		UV trans4 = new UV(14, "Organisation et missions du SDIS");
		trans4.addUV(trans1); trans4.addUV(trans2); trans4.addUV(trans3);
		
		// Nouveaux UVs SECOURS A PERSONNES
		UV sap1 = new UV(21, "Equipier au VSAV niv.1");
		UV sap2 = new UV(22, "Equipier au VSAV niv.2");	
		sap2.addUV(sap1);
		UV sap3 = new UV(23, "Equipier au VSAV niv.3");
		sap3.addUV(sap1); sap3.addUV(sap2);

		// Nouveaux UVs SECOURS ROUTIER
		UV sr1 = new UV(31, "Equipier secours routier niv.1");
		UV sr2 = new UV(32, "Equipier secours routier niv.2");	
		sr2.addUV(sr1);
		UV sr3 = new UV(33, "Equipier secours routier niv.3");
		sr3.addUV(sr1); sr3.addUV(sr2);		
		
		// Nouveaux UVs INCENDIE
		UV inc1 = new UV(41, "Protection individuelle et collective");
		UV inc2 = new UV(42, "Sauvetages et mises en sécurité");	
		inc2.addUV(inc1);
		UV inc3 = new UV(43, "Alimentation, établissements, extinction");
		inc3.addUV(inc1); inc3.addUV(inc2);
		UV inc4 = new UV(44, "Moyens élévateurs aériens");
		inc4.addUV(inc1); inc4.addUV(inc2); inc4.addUV(inc3);		
		
		// Nouveaux UVs INTERVENTIONS
		UV inter1 = new UV(51, "Interventions diverses");
		UV inter2 = new UV(52, "Interventions animalières");	
		inter2.addUV(inter1);		
		
		lUV.add(inter2); lUV.add(inter1); lUV.add(inc4); lUV.add(inc3); lUV.add(inc2); lUV.add(inc1);
		lUV.add(sr3); lUV.add(sr2); lUV.add(sr1); lUV.add(sap3); lUV.add(sap2); lUV.add(sap1);
		lUV.add(trans4); lUV.add(trans3); lUV.add(trans2); lUV.add(trans1); 
		
		// Nouveaux Agents
		Agent mamadou = new Agent("111", "ma");
		mamadou.addUV(inter1); mamadou.addUV(inc1); mamadou.addUV(sr1); mamadou.addUV(sap1); mamadou.addUV(trans1);
		mamadou.setCleHashage("aaa");
		
		Agent mouctar = new Agent("222", "mo");
		mouctar.addUV(inc1); mouctar.addUV(inc2); mouctar.addUV(inc3); mouctar.addUV(sap1);
		mouctar.setCleHashage("bbb");
		
		Agent vicky = new Agent("333", "vi");
		vicky.addUV(sr1); vicky.addUV(sr2); vicky.addUV(inter1); vicky.addUV(inter2); vicky.addUV(inc1);
		vicky.setCleHashage("ccc");
		
		Agent sebastien = new Agent("444", "se");
		sebastien.addUV(inc1); sebastien.addUV(inc2); sebastien.addUV(sr1); sebastien.addUV(sr2);
		sebastien.setCleHashage("ddd");
		
		Agent christophe = new Agent("555", "ch");
		christophe.addUV(trans1); christophe.addUV(trans2); christophe.addUV(trans3); christophe.addUV(inter1);
		christophe.setCleHashage("eee");
		
		Agent julien = new Agent("666", "ju");
		julien.setCleHashage("fff");
		
		Agent ibrahima = new Agent("777", "ib");
		ibrahima.addUV(inc1); ibrahima.addUV(inc2); ibrahima.addUV(trans1); ibrahima.addUV(trans2);
		ibrahima.setCleHashage("ggg");
		
		Agent abdourahman = new Agent("888", "ab");
		abdourahman.addUV(inter1); abdourahman.addUV(inter2); abdourahman.addUV(inc1); abdourahman.addUV(sr1);
		abdourahman.setCleHashage("hhh");
		
		Agent yannick = new Agent("999", "ya");
		yannick.addUV(trans1); yannick.addUV(trans2); yannick.addUV(trans3); yannick.addUV(inter1);
		yannick.setCleHashage("iii");
		
		Agent francois = new Agent("321", "fr");
		francois.addUV(inter1); francois.addUV(inter2); francois.addUV(inc1); francois.addUV(inc2);
		francois.setCleHashage("jjj");
		
		Agent noel = new Agent("123", "no");
		noel.addUV(trans1); noel.addUV(trans2); noel.addUV(trans3); noel.addUV(sap1); noel.addUV(sap2);
		noel.addUV(sr1); noel.addUV(sr2); noel.addUV(inc1); noel.addUV(inc1); noel.addUV(inc2); noel.addUV(inter1);
		noel.setCleHashage("kkk");
		
		lAgent.add(noel); lAgent.add(julien); lAgent.add(christophe); lAgent.add(sebastien); lAgent.add(francois);
		lAgent.add(yannick); lAgent.add(abdourahman); lAgent.add(ibrahima); lAgent.add(vicky); lAgent.add(mouctar); lAgent.add(mamadou);
		
		//nouvelles Sessions et nouveaux Stages
		Session transA = new Session(001, trans1, "Montpellier", "11-07-2016");
		Session incA = new Session(002, inc1, "Montpellier", "17-07-2016");
		Session srA = new Session(003, sr1, "Montpellier", "13-07-2016");
		Session sapA = new Session(004, sap1, "Montpellier", "12-07-2016");
		Session interA = new Session(005, inter1, "Montpellier", "18-07-2016");
		Stage debutants = new Stage(1, "111");

		List<Agent> lAg1 = new ArrayList<Agent>();
		List<Agent> lAg2 = new ArrayList<Agent>();
		List<Agent> lAg3 = new ArrayList<Agent>();
		
		lAg1.add(julien);
		lAg2.add(sebastien); lAg2.add(julien);
		lAg3.add(sebastien);
		
		transA.setCandidatsAp(lAg1); transA.setCandidatsFo(lAg3); transA.setApprenants(lAg3); transA.setFormateurs(lAg3);
		incA.setCandidatsAp(lAg3); incA.setCandidatsFo(lAg1); incA.setApprenants(lAg3); incA.setFormateurs(lAg3);
		srA.setCandidatsAp(lAg2); srA.setCandidatsFo(lAg3); srA.setApprenants(lAg1); srA.setFormateurs(lAg3);
		sapA.setCandidatsAp(lAg3); sapA.setCandidatsFo(lAg3); sapA.setApprenants(lAg3); sapA.setFormateurs(lAg1);
		interA.setCandidatsAp(lAg2); interA.setCandidatsFo(lAg3); interA.setApprenants(lAg3); interA.setFormateurs(lAg2);

		debutants.addSession(interA); debutants.addSession(sapA); debutants.addSession(srA); debutants.addSession(incA); debutants.addSession(transA);

		
		Session transB = new Session(006, trans4, "Brest", "22-06-2016");
		Session incB = new Session(007, inc4, "Brest", "24-06-2016");
		Session srB = new Session(010, sr3, "Brest", "28-06-2016");
		Session sapB = new Session(011, sap3, "Brest", "25-06-2016");
		Session interB = new Session(012, inter2, "Brest", "18-06-2016");
		Stage experts = new Stage(2, "555");
		experts.addSession(interB); experts.addSession(sapB); experts.addSession(srB); experts.addSession(incB); experts.addSession(transB);
		
		Session incC = new Session(013, inc3, "Strasbourg", "02-05-2016");
		Session srC = new Session(014, sr1, "Strasbourg", "05-05-2016");
		Session sapC = new Session(015, sap2, "Strasbourg", "03-05-2016");
		Stage intermediaire = new Stage(3, "123");
		intermediaire.addSession(incC); intermediaire.addSession(srC); intermediaire.addSession(sapC);
		
		lSession.add(interB); lSession.add(interA); lSession.add(sapC); lSession.add(srC); lSession.add(incC);
		lSession.add(sapB); lSession.add(srB); lSession.add(incB); lSession.add(transB); lSession.add(sapA);
		lSession.add(srA); lSession.add(incA); lSession.add(transA);
		
		lStage.add(intermediaire); lStage.add(experts); lStage.add(debutants);
	}
	

	public static void main (String[] args) {
		Data data = new Data();
		for (Stage stage : data.lStage) {
			for (Session sess : stage.getIdSessions()) {
				System.out.println(sess.getDates());
			}
		}
	}

}
