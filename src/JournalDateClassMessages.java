package Journal;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JournalDateClassMessages implements IJournal{

	@Override
	public void outPut_Msg(String message) {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		String date = new SimpleDateFormat("dd/MM/yyyy ',le Heure :' HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("The message : "+message+" |la classe : "+className+" |la date : "+date); 
		
	}

}