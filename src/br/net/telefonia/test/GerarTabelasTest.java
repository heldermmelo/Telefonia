package br.net.telefonia.test;

import org.junit.Test;

import br.net.telefonia.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	
	}

}
