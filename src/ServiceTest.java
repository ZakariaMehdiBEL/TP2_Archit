package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import DataBaseCon.DBConnection;
import Journal.IJournal;
import Journal.JournalAllMethods;
import Journal.JournalDateClassMessages;
import Journal.JournalFichierMessages;
import Repos.EtudiantRepository;
import Repos.IdbConnection;
import Repos.UniversiteRepository;
import ServiceEtude.Etudiant;
import ServiceEtude.EtudiantService;
import ServiceEtude.IEtudiantRepository;
import ServiceEtude.IUniversiteRepository;

public class ServiceTesting {

	
	@Test
	void etudiantExistTest() throws SQLException {
		
		IJournal journal = new JournalAllMethods();
		IJournal journal1 = new JournalDateClassMessages();
		IJournal journal2 = new JournalFichierMessages();
		((JournalAllMethods) journal).ajouterjournal(journal1);
		((JournalAllMethods) journal).ajouterjournal(journal2);
		IdbConnection db=DBConnection.getDBConnection();
		IUniversiteRepository UnivRep=new UniversiteRepository(db,journal);
		IEtudiantRepository StudRep=new EtudiantRepository(db,journal);
		EtudiantService es = new EtudiantService(StudRep, UnivRep, journal);
		Etudiant etud = new Etudiant(45113, "guens", "wassila", "ddtjd@gmail.com","xxxx", 123);
		 es.setEtudiant(etud);
		assertEquals(true, es.inscription());
	}
	@Test
	void etudiantDoesntExistTest() throws SQLException {
		
		IJournal journal = new JournalAllMethods();
		IJournal journal1 = new JournalDateClassMessages();
		IJournal journal2 = new JournalFichierMessages();
		((JournalAllMethods) journal).ajouterjournal(journal1);
		((JournalAllMethods) journal).ajouterjournal(journal2);
		IdbConnection db=DBConnection.getDBConnection();
		IUniversiteRepository UnivRep=new UniversiteRepository(db,journal);
		IEtudiantRepository StudRep=new EtudiantRepository(db,journal);
		EtudiantService es = new EtudiantService(StudRep, UnivRep, journal);
		Etudiant etud = new Etudiant(4,"mahdi","slimani","guen@gmail.com","xxxx", 123);
		 es.setEtudiant(etud);
		assertEquals(false, es.inscription());
	}
	
}