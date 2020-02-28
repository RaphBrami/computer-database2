package com.excilys.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.excilys.modeles.*;
import com.excilys.modeles.Computer;

	public final class CompanyDAO { 
		
		private static Logger logger = Logger.getLogger(CompanyDAO.class);
		private static volatile CompanyDAO instance = null;
		
		CompanyDAO() {

			
		}
		public static CompanyDAO getInstance() {
	   
	        if (CompanyDAO.instance == null) {
	     
	           synchronized(CompanyDAO.class) {
	             if (CompanyDAO.instance == null) {
	            	 CompanyDAO.instance = new CompanyDAO();
	             }
	           }
	        }
	     return CompanyDAO.instance;
	    }
	
	public boolean select_All() throws ClassNotFoundException	{
		Connexion conn = new Connexion();
		List <Compagnie> listcomp = new ArrayList<Compagnie>();
		String select_All = "SELECT company.id , company.name FROM company";
		conn.connect();
		Compagnie company = new Compagnie();
	try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(select_All);
			ResultSet generateComputer = preparedStatement.executeQuery();
			while(generateComputer.next()) {
						
			int id = generateComputer.getInt(1);
				  String name = generateComputer.getString(2);
				  company.setId(id);
				  company.setName(name);	
				  listcomp.add(company);
				  System.out.println(company);
			}
			  preparedStatement.close();
		
		return true;
		}catch(SQLException e) {
			logger.debug(e);
		return false;}
	finally {
		  conn.closeConn();
		
		}
	}
  }

