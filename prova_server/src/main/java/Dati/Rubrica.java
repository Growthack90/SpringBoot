package Dati;

import java.util.ArrayList;
import java.util.List;

import classiMie.MySQL;

public class Rubrica {

	
	public List<Contatto> getContatti()
	{
		ArrayList<Contatto> contatti = new ArrayList<Contatto>();
		MySQL mysql = new MySQL( "localhost","3306","rubrica","root","");
		mysql.SelectQuery("SELECT * FROM contatti");
		mysql.first();
		do {
			contatti.add(new Contatto(mysql.getInt("id"), mysql.getString("nome"), mysql.getString("cognome"),
					mysql.getString("email"), mysql.getString("numeroTelefono"), mysql.getString("note")));
		}while (mysql.next());
		
		
		return contatti;
    
	}
	
	
	public Contatto getContatto(int id) {
		MySQL mysql = new MySQL("localhost", "3306", "rubrica", "root", "");
		mysql.SelectQuery("SELECT * FROM contatti WHERE id = " + id);
		mysql.first();
		return new Contatto(mysql.getInt("id"), mysql.getString("nome"), mysql.getString("cognome"),
				mysql.getString("email"), mysql.getString("numeroTelefono"), mysql.getString("note"));
	}
}
