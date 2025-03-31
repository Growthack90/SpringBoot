package Dati;

public class Contatto {
	
	 	private int id;
	    private String nome;
	    private String cognome;
	    private String email;
	    private String numeroTelefono;
	    private String note;
	    
	    
		public Contatto() {

		}
		
		public Contatto(int id, String nome, String cognome, String email, String numeroTelefono, String note) {
			this.id = id;
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.numeroTelefono = numeroTelefono;
			this.note = note;
		}

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNumeroTelefono() {
			return numeroTelefono;
		}

		public void setNumeroTelefono(String numeroTelefono) {
			this.numeroTelefono = numeroTelefono;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}
		
		

}
