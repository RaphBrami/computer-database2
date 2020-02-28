package com.excilys.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import com.excilys.modeles.Computer;

public class Mapper {
	private static Logger logger = Logger.getLogger(CompanyDAO.class);
	public Computer getCompterMapper(Connexion conn, String affichage,int id )	{	
	
	Computer computer = new Computer();
	try {	

	PreparedStatement preparedStatement = conn.getConn().prepareStatement(affichage);
	preparedStatement.setInt(1, id);
	ResultSet generateComputer = preparedStatement.executeQuery();
	
	if(generateComputer.first()) {
	computer.setId(generateComputer.getInt(1));
	computer.setName(generateComputer.getString(2));
	computer.setIntroduced(generateComputer.getTimestamp(3).toLocalDateTime().toLocalDate());
	computer.setDiscontinuited(generateComputer.getTimestamp(4).toLocalDateTime().toLocalDate());
	computer.setCompagnyId(generateComputer.getInt(5));
	}
	
	} catch (SQLException e) {
		
		logger.debug(e);

		}finally {
			
		conn.closeConn();	
		}
   
		return computer;
  }
	
	public boolean deleteMapper(String delete,Connexion conn,int id) {
		try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (SQLException e) {
			logger.debug(e);
			return false;
		} finally {	
			conn.closeConn();
		
	  }
	}
	
	public void updateMapper(Connexion conn,String update,Computer computer) {
		
		try {
			
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(update);
			preparedStatement.setInt(5, computer.getid());
			preparedStatement.setString(1, computer.getname());
			preparedStatement.setTimestamp(2, computer.getIntroduced()!=null?Timestamp.valueOf( computer.getIntroduced().atTime(LocalTime.MIDNIGHT)):null);
			preparedStatement.setTimestamp(3, computer.getDiscontinuited()!=null?Timestamp.valueOf( computer.getDiscontinuited().atTime(LocalTime.MIDNIGHT)):null);
			preparedStatement.setInt(4, computer.getCompagnyId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			logger.debug(e);
			} finally {
				
			conn.closeConn();
				
			}
	   }		
	
	
	public boolean insertMapper(Connexion conn, String insert ,Computer computer) {
		
		try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(insert);
			preparedStatement.setString(1, computer.getname());
			preparedStatement.setTimestamp(2,computer.getIntroduced()!=null?Timestamp.valueOf(computer.getIntroduced().atTime(LocalTime.MIDNIGHT)):null);			
			preparedStatement.setTimestamp(3,computer.getDiscontinuited()!=null?Timestamp.valueOf(computer.getDiscontinuited().atTime(LocalTime.MIDNIGHT)):null);		
			preparedStatement.setInt(4,computer.getCompagnyId());					
			preparedStatement.executeUpdate();	
			preparedStatement.close();

			return true;
		}catch (SQLException e) {
			
			logger.debug(e);
			return false;
			}finally {
				
			conn.closeConn();	
			}
       }
    
	
	public static List<Computer> select_allMapper(Connexion conn , String select_All ) {
		ArrayList<Computer> listcomp = new ArrayList<Computer>();
		
	try {
		
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(select_All);
			ResultSet generateComputer = preparedStatement.executeQuery();
			
			while (generateComputer.next()) {
				Computer computer = new Computer();
				int id = generateComputer.getInt(1);
				String name = generateComputer.getString(2);
				LocalDate introduced = generateComputer.getTimestamp(3)!=null?generateComputer.getTimestamp("introduced").toLocalDateTime().toLocalDate():null;
				LocalDate discontinued = generateComputer.getTimestamp(4)!=null?generateComputer.getTimestamp("discontinued").toLocalDateTime().toLocalDate():null;
				int company_id = generateComputer.getInt(5);
				
				computer.setId(id);
				computer.setName(name);
				computer.setIntroduced(introduced);
				computer.setDiscontinuited(discontinued);
				computer.setCompagnyId(company_id);
				
				listcomp.add(computer);
				System.out.println(computer);
				
			} 
				preparedStatement.close();
				conn.closeConn();

	
		  
		} catch (SQLException e) {
			
			logger.debug(e);
		
			}finally {
				
			conn.closeConn();	
			}
	return listcomp;
       }
		
	
	public int  countMapper(Connexion conn,Mapper mappeur,String select_All) {
			
			int count = 0;
		try {
			
				PreparedStatement preparedStatement = conn.getConn().prepareStatement(select_All);
				ResultSet generateComputer = preparedStatement.executeQuery();	
				generateComputer.next();
				count = generateComputer.getInt(1);
				preparedStatement.close();
				conn.closeConn();		
			  
			}catch (SQLException e) {
				
				logger.debug(e);

				}finally {

				conn.closeConn();
				
				}
		
		return count;
		
		}
	}


