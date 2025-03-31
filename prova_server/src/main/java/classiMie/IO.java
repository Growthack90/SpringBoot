package classiMie;

import java.util.Scanner;

public class IO {
	
	public static final String RESET = "\033[0m";  // Resetta il colore
    public static final String BLACK = "\033[0;30m";   // Nero
    public static final String RED = "\033[0;31m";     // Rosso
    public static final String GREEN = "\033[0;32m";   // Verde
    public static final String YELLOW = "\033[0;33m";  // Giallo
    public static final String BLUE = "\033[0;34m";    // Blu
    public static final String PURPLE = "\033[0;35m";  // Viola
    public static final String CYAN = "\033[0;36m";    // Ciano
    public static final String WHITE = "\033[0;37m";   // Bianco
    
	private static String error = null;
	
	public static void print(Object s) {
		System.out.print(s);
	}
	
	public static void println(Object s) {
		System.out.println(s);
	}
	
	public static String getString() {
		error = null;
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static String getString(String message) {
		println(message);
		return getString();
	}
	
	public static int getInt() {
		error = null;
		int n = 0;
		Scanner sc = new Scanner(System.in);
		try {
				n = sc.nextInt();
				sc.nextLine();
				return n;
		} 
		catch (Exception e) 
		{
			
			error = "Devi inserire un numero intero";
			return 0;
		}
			
	}
	
	public static int getInt(String message) {
		println(message);
		return getInt();
	}
	
	public static int getInt(String message, String errorMessage) {	
		int res = getInt(message);
		if (error != null)
        {
            println(errorMessage);
        }
		
		return res;
	}
	
	public static int getInt(String message, String errorMessage, boolean repeat) {
		int res;
		if (repeat) {
			do {
				res = getInt(message, errorMessage);
			} while (error != null);
		} else {
			res = getInt(message, errorMessage);
		}
		
		return res;
	}
	
	public static int getInt(String message, boolean repeat) {
		return getInt(message, "Devi inserire un numero intero", repeat);
	}
	
	
	public static double getDouble() {
		error = null;
		double n = 0;
		Scanner sc = new Scanner(System.in);
		try {
			n = sc.nextDouble();
			sc.nextLine();
			return n;
		} catch (Exception e) {
			error = "Devi inserire un numero decimale";
			return 0;
		}
	}
	
	public static double getDouble(String message) {
		println(message);
		return getDouble();
	}
	
	public static double getDouble(String message, String errorMessage) {
		double res = getDouble(message);
		if (error != null) {
			println(errorMessage);
		}
		return res;
	}
	
	
	public static double getDouble(String message, String errorMessage, boolean repeat) {
		double res;
		if (repeat) {
			do {
				res = getDouble(message, errorMessage);
			} while (error != null);
		} else {
			res = getDouble(message, errorMessage);
		}
		return res;
	}
	
	public static double getDouble(String message, boolean repeat) {
		return getDouble(message, "Devi inserire un numero decimale", repeat);
	}
	
	
	public static char getChar() {
		error = null;
		char c = 0;
		Scanner sc = new Scanner(System.in);
		try {
			c = sc.next().charAt(0);
			sc.nextLine();
			return c;
		} catch (Exception e) {
			error = "Devi inserire un carattere";
			return 0;
		}
	}
	
	public static char getChar(String message) {
		println(message);
		return getChar();
	}
	
	
	public static char getChar(String message, String errorMessage) {
		char res = getChar(message);
		if (error != null) {
			println(errorMessage);
		}
		return res;
	}
	
	public static char getChar(String message, String errorMessage, boolean repeat) {
		char res;
		if (repeat) {
			do {
				res = getChar(message, errorMessage);
			} while (error != null);
		} else {
			res = getChar(message, errorMessage);
		}
		return res;
	}
	
	public static char getChar(String message, boolean repeat) {
		return getChar(message, "Devi inserire un carattere", repeat);
	}

	
	public static boolean getBoolean() {
		error = null;
		boolean b = false;
		Scanner sc = new Scanner(System.in);
		try {
			b = sc.nextBoolean();
			sc.nextLine();
			return b;
		} catch (Exception e) {
			error = "Devi inserire true o false";
			return false;
		}
	
	}
	
	public static boolean getBoolean(String message) {
		println(message);
		return getBoolean();
	}
	
	public static boolean getBoolean(String message, String errorMessage) {
		boolean res = getBoolean(message);
		if (error != null) {
			println(errorMessage);
		}
		return res;
	}
	
	
	public static boolean getBoolean(String message, String errorMessage, boolean repeat) {
		boolean res;
		if (repeat) {
			do {
				res = getBoolean(message, errorMessage);
			} while (error != null);
		} else {
			res = getBoolean(message, errorMessage);
		}
		return res;
	}
	
	
	public static boolean getBoolean(String message, boolean repeat) {
		return getBoolean(message, "Devi inserire true o false", repeat);
	}
	
	
	
	public static Object getObject() {
		Scanner sc = new Scanner(System.in);
		Object o = sc.next();
		sc.nextLine();
		return o;
	}
	
	public static Object getObject(String message) {
		println(message);
		return getObject();
	}
	
	public static String getError() {
		return error;
	}
	
	
	
	
	
	
}
