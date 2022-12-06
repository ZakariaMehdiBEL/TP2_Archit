package Journal;


import java.util.ArrayList;
import java.util.List;

public class JournalAllMethods implements IJournal{
	List<IJournal> journals = new ArrayList<IJournal>();
 
	
	@Override
	public void outPut_Msg(String message) {
	for(IJournal j : journals) {
		j.outPut_Msg(message);
	}
		
	}
	 public void ajouterjournal(IJournal j){
			this.journals.add(j);
		}

}