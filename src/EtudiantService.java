package ServiceEtude;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Journal.IJournal;
import Repos.UniversiteRepository;



public class EtudiantService {
	
	private IEtudiantRepository StudRep;
	private IUniversiteRepository UnivRep;
	private IJournal journal;
	private Etudiant stud; 
	public EtudiantService(IEtudiantRepository StudRep,IUniversiteRepository UnivRep,IJournal journal){
		this.UnivRep = UnivRep;
		this.StudRep = StudRep;
		this.journal = journal;
	}

	public void setEtudiant(Etudiant stud) {
		this.stud = stud;
	}
	
	public boolean inscription () throws SQLException	
	{
		 
	  //  Etudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
	   // Universite univ=UnivRep.GetById(stud.getId_universite());
	    journal.outPut_Msg("Log: debut de l'opiration d'ajout de l'etudiant avec matricule "+stud.getMatricule());
	   
	    
	    if(StudRep.correctMailAndMat(stud))
	    {
	    	return false;
	    }
	    
	   
		
		int nmbDeLiver = ((UniversiteRepository)UnivRep).initialiseNmbLivre(UnivRep.GetById(stud.getId_universite()));
		stud.setNbLivreMensuel_Autorise(nmbDeLiver);                      
		
		
		 StudRep.add(stud);
		 journal.outPut_Msg("Log: Fin de l'opiration d'ajout de l'utudiant avec matricule "+stud.getMatricule());
		 
		
		 
		 return true;
	    
		
	}
	
	public void addBonus() throws SQLException {
		 int nmbDebonus = ((UniversiteRepository)UnivRep).addingBounes(UnivRep.GetById(stud.getId_universite()));
		 ArrayList<Etudiant> etudiants = GetEtudiantParUniversitye();
		 
		 for(Etudiant e : etudiants) {
			 e.AddBonus(nmbDebonus);
			
		 }
		 journal.outPut_Msg("bonus added");
	}
	
	

public ArrayList<Etudiant> GetEtudiantParUniversitye() throws SQLException
{	
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}