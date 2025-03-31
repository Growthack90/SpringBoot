package classiMie;

public class Crypt {
	
	public static String crypt(String s) {
		
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			res += (char)(s.charAt(i) + 1);
			
		}
		return res;
        
    }

}
