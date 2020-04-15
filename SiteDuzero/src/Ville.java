
public class Ville {
	
	
    public boolean exists (int ints[], int k) {

		boolean isExist = false;
		
		for(int i = 0 ; i <= (ints.length-1) ; i++){
            if(ints[i]==k){
            	System.out.println(k+" existe");
            	isExist = true ;
            }
        }
		
        return isExist ;
	}
    
}
