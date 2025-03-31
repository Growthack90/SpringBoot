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
		if (mysql.count()>0)
		{
			mysql.first();
			return new Contatto(mysql.getInt("id"), mysql.getString("nome"), mysql.getString("cognome"),
				mysql.getString("email"), mysql.getString("numeroTelefono"), mysql.getString("note"));
		}
		return null;
	}
	
	/*
	 Devo aggiungere due metodi: uno per aggiungere dei contatti alla rubrica
	 e uno per modificare un contatto esistente.
	 Per fare una cosa FIGA
	 posso creare UN SOLO METODO che si chiama saveContatto(Contatto contatto)
	 Se  il contatto ha l'id a null allora lo aggiungo 
	 altrimenti avrà un cazzo di numero dentro l'id e quindi lo modifico
	 Invece che avere tanti metodi, è meglio "ridurli.
	 Un solo metodo che fa tutto!
	 
	 Per fare questo ho impostato l'id di Contatto come un Integer e non un int.
	 un int non avrebbe mai potuto essere null
	 E anche se vi avessi messo uno zero, il valore che più si avvicina a null, non avremmo potuto ditinguere perchè magari l'id voluto sarebbe potuto essere 
	 davvero 0... 
	 Quindi ho messo un Integer che può essere null e quindi posso fare il controllo se è null o no.
	 
	 */
	
	public Contatto saveContatto(Contatto contatto) {
		Contatto res = null;
		String query = "";
		MySQL mysql = new MySQL("localhost", "3306", "rubrica", "root", "");
        if (contatto.getId() == null)
        {
       // 	System.out.println("Salvo un nuovo contatto");
        	query = "INSERT INTO contatti (nome, cognome, email, numeroTelefono, note) VALUES (?, ?, ?, ?, ?)";
      //  	System.out.println(query);
            if (mysql.InsertProtectedQuery(query, new String[] {contatto.getNome(), contatto.getCognome(), contatto.getEmail(), contatto.getNumeroTelefono(), contatto.getNote()}))
            {
        //    	System.out.println("Contatto inserito correttamente");
            	Integer last_inserted_id = mysql.getLastInsertID();
            	res = this.getContatto(last_inserted_id);            	
            }
        }
        else
        {
        	System.out.println("Modifico un contatto esistente");
        	query = "UPDATE contatti SET nome = ?, cognome = ?, email = ?, numeroTelefono = ?, note = ? WHERE id = ?";
        	System.out.println(query);
        	if (mysql.UpdateProtectedQuery(query, new String[] {contatto.getNome(), contatto.getCognome(), contatto.getEmail(), contatto.getNumeroTelefono(), contatto.getNote(), contatto.getId().toString()}))
        	{
 //       		System.out.println("Contatto modificato correttamente");
        		res = this.getContatto(contatto.getId());
        	}           
        }
        return res;
    }
	
	public boolean deleteContatto(int id) {
		
		MySQL mysql = new MySQL("localhost", "3306", "rubrica", "root", "");
		String query = "DELETE FROM contatti WHERE id = ?";
		if (mysql.DeleteProtectedQuery(query, new String[] { Integer.toString(id) })) {
			return true;
		}
		return false;
	}

}