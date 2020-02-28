package com.excilys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class Connexion {
	
	private Connection conn; 
	private static Logger logger = Logger.getLogger(Connexion.class);
	
    public void connect() throws ClassNotFoundException {
        String user = "user";
        String mdp = "mdp";
        String BddName = "bddname";
        String url = "url";
        try{
            conn = DriverManager.getConnection(url, user, mdp);
            System.out.println("Connexion ok");
            Class.forName("com.mysql.jdbc.Driver");
        }catch(SQLException e){
           logger.debug(e);
        } 
        
    }
    
    public void connectH2() throws ClassNotFoundException {
        String user = "admincdb";
        String mdp = "mot_de_passe";
        String BddName = "computer-database-db";
        String url = "jdbc:mysql://localhost:3306/computer-database-db?useSSL=false";
        try{
        	
            conn = DriverManager.getConnection(url, user, mdp);
            System.out.println("Connexion ok");
            Class.forName("com.mysql.jdbc.Driver");
        }catch(SQLException e){
           logger.debug(e);
        } 
        
    }
    public  Connection getConn() {
        return conn;
        } 
    
    public void  closeConn(){
    
    	try {
    		conn.close();
    	} catch(SQLException e ){	
    		logger.debug(e);
    	}   
    }
}
