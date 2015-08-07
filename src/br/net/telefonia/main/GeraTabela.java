package br.net.telefonia.main;

import br.net.telefonia.util.HibernateUtil;


public class GeraTabela {
	
	public static void main(String[] args){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
