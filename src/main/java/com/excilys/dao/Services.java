package com.excilys.dao;

import java.util.List;
import java.util.Optional;

import com.excilys.modeles.*;

public class Services {

private static volatile Services instance = null;
	
	private Services() {
		
		
		
	}
	public static Services getInstance() {
   
        if (Services.instance == null) {
     
           synchronized(Services.class) {
             if (Services.instance == null) {
            	 Services.instance = new Services();
             }
           }
        }
     return Services.instance;
    }
	
	public void ServiceGetComputer(int id) throws ClassNotFoundException {
	System.out.println(ComputerDAO.getInstance().getComputer(id));
	
	}
	
	public boolean ServiceDelete(int id) throws ClassNotFoundException {
	 return ComputerDAO.getInstance().delete(id);
		
	}
	
	public void ServiceUpdate(Computer computer) throws ClassNotFoundException {
	ComputerDAO.getInstance().update(computer);
	}
	
	public boolean ServiceInsert(Computer computer) throws ClassNotFoundException {
	return ComputerDAO.getInstance().insert(computer);
	}
	
	public List<Computer> ServiceSelectAll(Optional<Integer> optional, Optional <Integer> optional2) throws ClassNotFoundException {
	return ComputerDAO.getInstance().select_All(optional, optional2);
	}
	public void ServiceCompanySelect() throws ClassNotFoundException {
	CompanyDAO.getInstance().select_All();
	 
	}
	public int ServiceCountAllComputer() throws ClassNotFoundException {
		
	return	ComputerDAO.getInstance().count();
		
	}
	
}

