package br.com.htcursos.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations="/context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BootStartTest {
	
	@Autowired
	private DataSource dataSource;

	@Test
	public void loadContextTest(){
		
		assertNotNull("Falha o dataSource está nulo :(", dataSource);
	}
}
