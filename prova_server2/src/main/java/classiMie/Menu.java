package classiMie;

public class Menu {
	
	
	private String[] voci;
	
	private int scelta;
	
	public Menu() {
		this.clear();
	}
	
	public void clear()
	{
		this.voci = new String[0];
	}
	
	public void add(String voce) {
		int n = voci.length;
		String[] temp = voci;
		voci = new String[n + 1];
		for (int i = 0; i < n; i++) {
			voci[i] = temp[i];
		}
		voci[n] = voce;
	}
	
	public void print() {
		for (int i = 0; i < voci.length; i++) {
			IO.println((i + 1) + ") " + voci[i]);
		}
	}
	
	public void eseguimenu() {
		this.print();
        IO.println("Inserisci la tua scelta");
        this.scelta = IO.getInt();    
	}
	
	public int getScelta() {
		return this.scelta;
	}
	
}
