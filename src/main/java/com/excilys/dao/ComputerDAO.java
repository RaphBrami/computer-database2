package com.excilys.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.excilys.modeles.Computer;

public final class ComputerDAO { 

	private static volatile ComputerDAO instance = null;
	
	ComputerDAO() {

		
	}
	public static ComputerDAO getInstance() {
   
        if (ComputerDAO.instance == null) {
     
           synchronized(ComputerDAO.class) {
             if (ComputerDAO.instance == null) {
            	 ComputerDAO.instance = new ComputerDAO();
             }
           }
        }
     return ComputerDAO.instance;
    }
	public Computer getComputer(int id) throws ClassNotFoundException {
		String affichage = "SELECT computer.id , computer.name , computer.introduced , computer.discontinued , computer.company_id FROM computer WHERE id=?;";
		Connexion conn = new Connexion();
		Computer computer = new Computer();
		Mapper map = new Mapper();
		conn.connect();
		return map.getCompterMapper(conn, affichage, id);
	}

	public boolean delete(int id) throws ClassNotFoundException {
		Connexion conn = new Connexion();
		Computer computer = new Computer();
		Mapper map = new Mapper();
		conn.connect();
		String delete = "DELETE FROM computer WHERE id = ?";
		return map.deleteMapper(delete, conn, id);
		
	}

	public void update(Computer computer) throws ClassNotFoundException {
		Connexion conn = new Connexion();
		Mapper mapper = new Mapper();
		conn.connect();
		String update = "UPDATE computer SET name = ? , introduced = ?  ,discontinued = ? ,company_id = ? WHERE id = ?";
		mapper.updateMapper(conn, update, computer);
		
	}

	public boolean insert(Computer computer) throws ClassNotFoundException {
		Connexion conn = new Connexion();
		Mapper mapper = new Mapper();
		conn.connect();
		String insert = "INSERT INTO computer (name,introduced,discontinued,company_id) VALUES (?,?,?,?)";
		return mapper.insertMapper(conn, insert, computer);
		
		
		
	}

	public List<Computer> select_All(Optional<Integer> taille, Optional<Integer> page) throws ClassNotFoundException {
		Connexion conn = new Connexion();
		Mapper mapper = new Mapper();
		String select_All = "SELECT * FROM computer ";
		if(taille.isPresent() && page.isPresent()) {
			
			select_All += " LIMIT "+taille.get()+" OFFSET "+(taille.get()*page.get());
		}
		conn.connect();
		return mapper.select_allMapper(conn, select_All);
		
   }
	public int count() throws ClassNotFoundException {
		
		Connexion conn = new Connexion();
		Mapper mapper = new Mapper();
		String select_All = "SELECT COUNT(*) FROM computer ";
		conn.connect();
		return mapper.countMapper(conn,mapper,select_All);
		
	}
}

