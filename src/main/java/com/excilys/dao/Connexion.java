package com.excilys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.excilys.log4j.Log4J;


public class Connexion {
	
	private Connection conn; 
	
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

        	Log4J.afficherMessage("erreur de connection");
          
           
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
          Log4J.afficherMessage("erreur de connection");;
        } 
        
    }
    public  Connection getConn() {
        return conn;
        } 
    
    public void  closeConn(){
    
    	try {
    		if(conn != null) {
    		conn.close();}
    	} catch(SQLException e ){	
    		Log4J.afficherMessage("erreur de fermeture de connection");
    	}   
    }
}
