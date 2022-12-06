package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import ServiceEtude.Etudiant;
import ServiceEtude.EtudiantService;
public class ControleurInscription implements ActionListener {
	private IViewInscription vi;
	private EtudiantService serv;
	public ControleurInscription( IViewInscription viewInscription ,EtudiantService serv) {
	 
		this.vi = viewInscription;
		vi.setActionListener(this);
		this.serv = serv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == vi.Submit()) {
			System.out.println(vi.getMatricule().isEmpty());
			if(vi.getMatricule().isEmpty()||  vi.getNom().isEmpty()||vi.getPrenom().isEmpty()||vi.getEmail().isEmpty()||vi.getPwd().isEmpty()||vi.getId_universite().isEmpty()) {
				vi.setMessageBox("Fill up all the fields !!");
			}else{
 try {
	 Integer.parseInt(vi.getMatricule());
} catch (Exception e2) {
	vi.setMessageBox("Matricule has to be a number !!");
	return;
}

 try {
	 Integer.parseInt( vi.getId_universite());
} catch (Exception e2) {
	vi.setMessageBox("Id universite has to be a number !!");
	return;
}
				
		Etudiant stud = new Etudiant(Integer.parseInt(vi.getMatricule()),vi.getNom(),vi.getPrenom(),vi.getEmail(),vi.getPwd(), Integer.parseInt( vi.getId_universite()));
			
		
		 serv.setEtudiant(stud);
		 
		
	
		 
				try {
					serv.inscription();

				} catch (SQLException e1) {
					
					 if(e1.getErrorCode() ==1251) {//the data base is down
							vi.setMessageBox("the data base is down please try later"); 
					 }else { 
					vi.setMessageBox("there is no universty with that names !!");
					}
					return;
				}
				vi.delete_info();
				vi.setMessageBox("Done !");	 
			

			
			}
		
	}else if(e.getSource() == vi.annuler()) {
		
		vi.delete_info();
	}/*else if(e.getSource() == vi.ajoutBuns()) {
	 
		vi.setMessageBox("bonus added !");
		
	}
		*/
	
	}
	

}