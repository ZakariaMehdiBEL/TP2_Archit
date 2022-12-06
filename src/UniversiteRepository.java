package Repos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Journal.IJournal;
import Package.DetermineThePackage;
import Package.TypePackage;
import ServiceEtude.IUniversiteRepository;
import ServiceEtude.Universite;
import Package.Package;

public class UniversiteRepository implements IUniversiteRepository {
	
	private IdbConnection db;
	private IJournal journal;
	public UniversiteRepository(IdbConnection db,IJournal journal) {
		this.db=db;
		this.journal = journal;
	}
	@Override
	public Universite GetById(int universityId) throws SQLException {
		 
		Connection connect=db.getConn(); 
		Statement stmt = connect.createStatement();
		journal.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e"); 
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
		journal.outPut_Msg("LogBD : universit� r�cup�r�e");

		
		connect.close();
		return u;	
	
		
	}

	public int initialiseNmbLivre(Universite univ){
		Package pac = new DetermineThePackage().typeOfPackage(univ.getPack());
		 
		return pac.getNmbLivre();
	}
	
	public int addingBounes(Universite univ) {
		Package pac =  new DetermineThePackage().typeOfPackage(univ.getPack());
			return pac.getBoune();
		
	}
}