package fr.deltadesnoc.bddmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import fr.deltadesnoc.bddmanager.Manager;

public class DataBase {
	
	private Connection con;
	private Statement stat;
	
	public DataBase(){}
	
	public boolean connect(String url, String baseName, String user, String pass){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://" + url + ":3306" + "/" + baseName , user, pass);
			stat = con.createStatement();
			Manager.getLogger().log("Connexion effectué");
			return true;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			Manager.getLogger().warn(e.getMessage());
			return false;
		}
		
	}
	
	public Statement getStat() {
		return stat;
	}
	
	public Connection getCon() {
		return con;
	}

}
