package Repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Journal.IJournal;
import ServiceEtude.Etudiant;
import ServiceEtude.IEtudiantRepository;

public class EtudiantRepository implements IEtudiantRepository {
	IdbConnection db;
	private IJournal journal;
	public EtudiantRepository(IdbConnection db,IJournal journal){
		this.db = db;
		this.journal = journal;
	}

	
	public void add(Etudiant E) throws SQLException
	{
 
		Connection connect=db.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
			journal.outPut_Msg("log : ajout dans la BD r�ussi de l'�tudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
			journal.outPut_Msg("log : Echec de l'ajout dans la BD de l'�tudiant  du Matricule" + E.getMatricule());
				 
			}
		connect.close();
	 }


	public boolean Exists(String email) throws SQLException	
	{ 
		Connection connect=db.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		//boolean rs = stmt.execute(sql);
		boolean rs = stmt.executeQuery(sql).next();
		
		if (rs){
			journal.outPut_Msg("logBD--- :email existe dans la BD  " + email);
			connect.close();
			return true;
			}
		journal.outPut_Msg("logBD--- : email n'existe pas " + email);
		connect.close();
		return false;
	}
	
	public boolean Exists(int mat) throws SQLException	
	{  
		Connection connect=db.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		//boolean rs = stmt.execute(sql);
		boolean rs = stmt.executeQuery(sql).next();
	 
		if (rs){
			journal.outPut_Msg("logBD--- :etudiant avec ce matricule existe d�ja dans la BD  " + mat);
			connect.close();
			return true;
			}
		journal.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		connect.close();
		return false;
	}

	public boolean correctMailAndMat(Etudiant etud) throws SQLException{
		String  mail = etud.getEmail();
		int mat = etud.getMatricule();
		return Exists(mat)||Exists(mail)|| mail == null || mail.length() == 0;

	}

}