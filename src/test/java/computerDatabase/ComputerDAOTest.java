package computerDatabase;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Assert.*;
import org.junit.Test;

import com.excilys.dao.ComputerDAO;
import com.excilys.dao.UI;
import com.excilys.modeles.Computer;
public class ComputerDAOTest {
	
	@Test
	public void getComputertest() throws ClassNotFoundException {
		
		Computer computer1 = new Computer();
		Computer computer2 = new Computer();
		computer2 = ComputerDAO.getInstance().getComputer(575);
		computer1.setId(575).setCompagnyId(9).setName("samsung").setIntroduced(UI.scannerDate("2019-12-20")).setDiscontinuited(UI.scannerDate("2021-09-23"));
		
		assertEquals(computer1,computer2);
  }	
}
