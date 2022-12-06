package Control;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public interface IViewInscription {
	
	public String getMatricule();
	public String getNom();
	public String getPrenom();
	public String getEmail();
	public String getPwd();
	public String getId_universite();
	public void setMessageBox(String message);
	public void setActionListener(ActionListener actionListener);
	public void delete_info();
	public JButton Submit();
	public JButton annuler();
}