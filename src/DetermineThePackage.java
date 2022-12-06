ackage Package;

public class DetermineThePackage implements IDetermineThePackage{
	
	@Override
	public Package typeOfPackage(TypePackage packag) {
		if(packag == TypePackage.Standard) {
			return new Standard();
		}else if(packag == TypePackage.Premium){
			
			return new Premium();
		}
		return null;
	}
}