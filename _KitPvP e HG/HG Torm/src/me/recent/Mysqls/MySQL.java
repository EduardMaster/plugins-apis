package me.recent.Mysqls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	
	private final String bancodedados;
	private final String host;
	private final String porta;
	private final String senha;
	private final String usuario;
	
	public MySQL(String db, String host, String port, String pw, String user) {
		this.bancodedados = db;
		this.host = host;
		this.porta = port;
		this.senha = pw;
		this.usuario = user;
	}
	
	public synchronized Connection conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bancodedados, usuario, senha);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public synchronized void execute(String query) {
		Connection con = conectar();
		try {
			con.prepareStatement(query).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public synchronized ResultSet getQueryResult(String query) {
		Connection con = conectar();
		try {
			return con.prepareStatement(query).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}