package classiMie;

/*   
 * RIEPILOGO DEI METODI E DI COME FUNZIONA LA CLASSE
 * 
 *  per creare un oggetto MySQL bisogna passare i parametri del database
 *  
 *  faremo 
 *  MySQL db = new MySQL("localhost", "3306", "esercizio", "root", "");
 *  
 *  Se usiamo il costruttore senza parametri, dobbiamo settare i parametri con i metodi set
 *  dovremo poi chiamare il metodo Connect per connetterci al database
 *  così
 *  db.Connect();
 *  
 *  per controllare se siamo connessi, usiamo il metodo isConnected
 *  db.isConnected();
 *  
 *  per chiudere la connessione, usiamo il metodo Close
 *  db.Close();
 *  
 *  per fare una query di selezione, usiamo il metodo SelectQuery
 *  
 *  db.SelectQuery("SELECT * FROM football_players");
 *  oppure
 *  db.SelectQuery("SELECT * FROM football_players WHERE id = 1");
 *  
 *  per fare una query di selezione con parametri PROTETTI, usiamo il metodo SelectProtectedQuery
 *  
 *  db.SelectProtectedQuery("SELECT * FROM football_players WHERE id = ?", new String[] {"1"});
 *  
 *  per scorrere i risultati, usiamo i metodi first, last, next, previous, absolute
 *  db.first()  // ci posiziona sul primo record
 *  db.last()  // ci posiziona sull'ultimo record
 *  db.next()  // ci sposta al record successivo
 *  db.previous()  // ci sposta al record precedente
 *  db.absolute(3)  // ci sposta al record 3
 *  db.seek(3)  // uguale ad absolute
 *  
 *  quando siamo posizionati su un record, possiamo estrarre i dati con i metodi getString, getInt, getDouble, getFloat, getBoolean
 *  esempio
 *  db.getString("first_name");
 *  db.getInt("id");
 *  db.getDouble("salary");
 *  db.getFloat("height");
 *  ecc
 *  
 *  per contare i record, usiamo il metodo count
 *  db.count();
 *  
 *  per fare una query di aggiornamento, usiamo il metodo UpdateQuery
 *  db.UpdateQuery("UPDATE football_players SET salary = 2000 WHERE id = 1");
 *  
 *  per fare una query di aggiornamento con parametri protetti, usiamo il metodo UpdateProtectedQuery
 *  db.UpdateProtectedQuery("UPDATE football_players SET salary = ? WHERE id = ?", new String[] {"2000", "1"});
 *  
 *  per fare una query di inserimento, usiamo il metodo InsertQuery
 *  db.InsertQuery("INSERT INTO football_players(first_name, last_name) VALUES('Mario', 'Rossi')");
 *  
 *  per fare una query di inserimento con parametri protetti, usiamo il metodo InsertProtectedQuery
 *  db.InsertProtectedQuery("INSERT INTO football_players(first_name, last_name) VALUES(?, ?)", new String[] {"Mario", "Rossi"});
 *  
 *  per recuperare l'ultimo ID inserito, usiamo il metodo getLastInsertID
 *  db.getLastInsertID();
 *  
 *  per fare una query di cancellazione, usiamo il metodo DeleteQuery
 *  db.DeleteQuery("DELETE FROM football_players WHERE id = 1");
 *  
 *  per fare una query di cancellazione con parametri protetti, usiamo il metodo DeleteProtectedQuery
 *  db.DeleteProtectedQuery("DELETE FROM football_players WHERE id = ?", new String[] {"1"});
 *  
 *  per recuperare l'errore, usiamo il metodo getErrorString
 *  db.getErrorString();
 *  
 *  ATTENZIONE:
 *  perchè tutto funzioni è necessario che siano presenti o raggiungibili le librerie del driver mysql
 *  e che siano incluse nel progetto nel suo classpath
 *  
 * 
 * */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	
	private String dbhost;
	private String dbport;
	private String dbname;
	private String dbusername;
	private String dbpassword;
	private Connection dbConn;
	private String errorString;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Integer lastInsertID;
	
 	public MySQL(String dbhost, String dbport, String dbname, String dbusername, String dbpassword) {
		this.dbhost = dbhost;
		this.dbport = dbport;
		this.dbname = dbname;
		this.dbusername = dbusername;
		this.dbpassword = dbpassword;
		this.Connect();
	}
	
	public MySQL()
	{
		this.dbhost = null;
		this.dbport = null;
		this.dbname = null;
		this.dbusername = null;
		this.dbpassword = null;
	}
	
	public String getErrorString() {
		return errorString;
	}
	
	public void CleanErrorString() {
		this.errorString = null;
	}
	
	private void SetError(String error) {
		this.errorString = error;
	}
	
	public boolean Connect()
	{
		this.CleanErrorString();
		try {
			  String connectionstring =  "jdbc:mysql://" + this.dbhost + ":" + this.dbport + "/" + this.dbname;
			  this.dbConn = java.sql.DriverManager.getConnection(connectionstring, this.dbusername, this.dbpassword);
			  return true;
		}
		catch (SQLException e) {
			this.SetError(e.getMessage());
			return false;
		}
		
	}
	
	public boolean isConnected() {
		this.CleanErrorString();
		try {
			if (this.dbConn == null) return false;
			return this.dbConn.isValid(0);
		} catch (SQLException e) {
			this.SetError(e.getMessage());
			return false;
		}
	}

	public String getDbhost() {
		return dbhost;
	}

	public void setDbhost(String dbhost) {
		this.dbhost = dbhost;
	}

	public String getDbport() {
		return dbport;
	}

	public void setDbport(String dbport) {
		this.dbport = dbport;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getDbusername() {
		return dbusername;
	}

	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}

	public String getDbpassword() {
		return dbpassword;
	}

	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}
	
	public void Close() {
		this.CleanErrorString();
		try {
			this.dbConn.close();
		} catch (SQLException e) {
			this.SetError(e.getMessage());
		}
	}
	
	public Connection getDbConn() {
		return dbConn;
	}
	
	// Ora andiamo con le varie query
	
	public boolean SelectQuery(String query) {
		this.CleanErrorString();
		try {
			this.stmt = this.dbConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			this.stmt.executeQuery(query);
			this.rs = this.stmt.getResultSet();
			this.first();
			return true;
		} catch (SQLException e) {
			this.SetError(e.getMessage());
			return false;
		}
	}
	
	public boolean SelectProtectedQuery(String query, String[] values) {
		this.CleanErrorString();
		try {
			this.pstmt = this.dbConn.prepareStatement(query);
			for (int i = 0; i < values.length; i++) {
				this.pstmt.setString(i + 1, values[i]);
			}
			this.rs = this.pstmt.executeQuery();
			this.first();
			return true;
		} catch (SQLException e) {
			this.SetError(e.getMessage());
			return false;
		}
	}
	
	public boolean first()
	{
		this.CleanErrorString();
		if (this.rs == null) 
		{
			this.SetError("ResultSet non inizializzato");
			return false;
		} 
		else {
				try {
					this.rs.first();
					return true;
				} 
				catch (SQLException e) 
				{
					this.SetError(e.getMessage());
					return false;
				}
				
			 }
	}
	
	public boolean last() {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return false;
		} else {
			try {
				this.rs.last();
				return true;
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return false;
			}

		}
	}
	
	public boolean next() {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return false;
		} else {
			try {
				return this.rs.next();
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return false;
			}
		}
	}
	
	public boolean previous() {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return false;
		} else {
			try {
				return this.rs.previous();
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return false;
			}
		}
	}
	
	public boolean absolute(int row) {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return false;
		} else {
			try {
				return this.rs.absolute(row);
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return false;
			}
		}
	}
	
	public boolean seek(int row)
	{
		return this.absolute(row);
	}
	
	public String getString(String field) {
		this.CleanErrorString();
		if (this.rs == null) 
		{
			this.SetError("ResultSet non inizializzato");
			return null;
		} 
		else 
		{
			try {
				return this.rs.getString(field);
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return null;
			}
		}
	}
	
	public Integer getInt(String field) {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return -1;
		} else {
			try {
				return this.rs.getInt(field);
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return null;
			}
		}
	}
	
	public Double getDouble(String field) {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return null;
		} else {
			try {
				return this.rs.getDouble(field);
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return null;
			}
		}
	}
	
	public Float getFloat(String field) {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return  null;
		} else {
			try {
				return this.rs.getFloat(field);
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return null;
			}
		}
	}
	
	public Boolean getBoolean(String field) {
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return null;
		} else {
			try {
				return this.rs.getBoolean(field);
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return null;
			}
		}
	}

	
	
	public Integer count()
	{
		this.CleanErrorString();
		if (this.rs == null) {
			this.SetError("ResultSet non inizializzato");
			return null;
		} 
		else 
		{
			
			try {
					int actualpos = this.rs.getRow();
					this.rs.last();
					int count = this.rs.getRow();
					this.rs.absolute(actualpos);
					return count;
			} 
			catch (SQLException e) 
			{
				this.SetError(e.getMessage());
				return null;
			}
		}
	}
		
	
	
	
	public boolean UpdateProtectedQuery(String query, String[] values) {
		this.CleanErrorString();
		try {
			  this.pstmt = this.dbConn.prepareStatement(query);
			  for (int i = 0; i < values.length; i++) {
				  this.pstmt.setString(i+1, values[i]);
              }
			  this.pstmt.executeUpdate();
			  return true;
			} catch (SQLException e) {
				this.SetError(e.getMessage());
				return false;
		}
	}
	
	public boolean UpdateQuery(String query) {
		this.CleanErrorString();
		try {
				this.stmt = this.dbConn.createStatement();
				this.stmt.executeUpdate(query);
				return true;
			} 
		catch (SQLException e) 
		{
				this.SetError(e.getMessage());
				return false;
		}
	}
	
	public boolean InsertProtectedQuery(String query, String[] values) {
		this.CleanErrorString();
		try {
				this.pstmt = this.dbConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < values.length; i++) {
					this.pstmt.setString(i + 1, values[i]);
				}
				this.pstmt.executeUpdate();
				// recuperiamo l'ID
				this.rs = this.pstmt.getGeneratedKeys();
				if (this.rs.next()) {
					this.lastInsertID = this.rs.getInt(1);
				}
				
				
			return true;
		} catch (SQLException e) {
			this.SetError(e.getMessage());
			return false;
		}
	}
	
	public boolean InsertQuery(String query) {
		return this.InsertProtectedQuery(query, new String[] {});
	}
	
	public Integer getLastInsertID() {
		return this.lastInsertID;
	}
	
	public boolean DeleteQuery(String query) {
        this.CleanErrorString();
        try {
            this.stmt = this.dbConn.createStatement();
            this.stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            this.SetError(e.getMessage());
            return false;
        }
    }
	
	public boolean DeleteProtectedQuery(String query, String[] values) {
		this.CleanErrorString();
		try {
			this.pstmt = this.dbConn.prepareStatement(query);
			for (int i = 0; i < values.length; i++) {
				this.pstmt.setString(i + 1, values[i]);
			}
			this.pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			this.SetError(e.getMessage());
			return false;
		}
	}
	
	
	
}
