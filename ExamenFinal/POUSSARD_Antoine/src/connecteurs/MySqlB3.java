package connecteurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySqlB3 {
	private Connection m_Con;
	// constructeurs
	
	/**
	 * Ce constructeur est le meilleur de tous...
	 * @param ip (String) : code IP du <b>serveur mysql</b>
	 * @param base
	 * @param login
	 * @param passwd
	 */
	public MySqlB3(String ip, String base, String login, String passwd, String port) {
		String connectionString = "jdbc:mysql://"+ ip + ":" + port + "/" + base + "?useSSL=false"; // MacOS
		// String connectionString = "jdbc:mysql://"+ ip + "/" + base + "?useSSL=false" ; // String normal
		try {
			m_Con=DriverManager.getConnection(connectionString, login, passwd);
		} catch(Exception exc) {
			System.err.println(getClass().getSimpleName()+
					"Constructeur : "+exc.getMessage());
		}
	}
	public MySqlB3(String base) {
		this("localhost",base,"root","root", "8889");
	}
	// requetes
	public ResultSet requete(String sql) {
		ResultSet res=null;
		// détecter si sql contient une table OU une requête SELECT...
		if(!sql.contains(" "))
			sql="SELECT * FROM "+sql;

		Statement stmt;
		try {
			stmt = m_Con.createStatement();
			res=stmt.executeQuery(sql);
		} catch (SQLException exc) {
			System.err.println(getClass().getSimpleName()+
					"requete("+sql+") : "+exc.getMessage());
		}
		return res;
	}
	// modifications
	public int update(String sql) {
		int res=-1;
		try {
			Statement stmt = m_Con.createStatement();
			res=stmt.executeUpdate(sql);
		} catch(Exception exc) {
			System.err.println(getClass().getSimpleName()+
					"insereAI("+sql+") : "+exc.getMessage());
		}
		return res;
	}
	public int insereAI(String sql) {
		int res=-1;
		System.out.println(sql);
		try {
			Statement stmt = m_Con.createStatement();
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			res = rs.getInt(1);
		} catch(Exception exc) {
			System.err.println(getClass().getSimpleName()+
					"insereAI("+sql+") : "+exc.getMessage());
		}
		return res;
	}

	public Connection getM_Con() {
		return m_Con;
	}

	public ArrayList<String> structure(String sql) {
		return null;
	}
}
