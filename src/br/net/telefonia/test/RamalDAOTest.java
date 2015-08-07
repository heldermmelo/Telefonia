package br.net.telefonia.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.net.telefonia.dao.RamalDAO;
import br.net.telefonia.domain.Ramal;

public class RamalDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Ramal r3 = new Ramal();
		r3.setNumero("1234567");
		r3.setCodigo(2L);
		r3.setContexto("BOOOM");
		r3.setSenha("legalDemais");
		RamalDAO dao = new RamalDAO();
		dao.salvar(r3);
	}

	@Test
	@Ignore
	public void listar() {
		RamalDAO dao = new RamalDAO();
		List<Ramal> ramais = dao.listar();

		for (Ramal ramal : ramais) {
			System.out.println(ramal);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		RamalDAO dao = new RamalDAO();

		Ramal r1 = dao.buscarPorCodigo(1L);
		Ramal r2 = dao.buscarPorCodigo(3L);

		System.out.println(r1);
		System.out.println(r2);

	}

	@Test
	@Ignore
	public void excluir() {
		 RamalDAO dao = new RamalDAO();
		 Ramal ramal = dao.buscarPorCodigo(2L);
		 // Ramal r7 = dao.buscarPorCodigo(7L);
		 if (ramal != null)
		 dao.excluir(ramal);
		 // dao.excluir(r7);
//		Ramal ramal = new Ramal();
//		ramal.setCodigo(2L);
//		ramal.setContexto("Rinaldao");
//		ramal.setNumero("oblado-obrlada");
//		ramal.setSenha("RUNFORYOURLIFE");
//		RamalDAO dao = new RamalDAO();
//		dao.excluir(ramal);

	}
	@Test
	@Ignore
	public void excluirPorCodigo() {
		RamalDAO dao = new RamalDAO();

		dao.excluir(4L);

	}
	
	@Test
	@Ignore
	public void editar(){
		Ramal ramal = new Ramal();
		ramal.setCodigo(1L);
		ramal.setContexto("UGA-BUGA");
		ramal.setNumero("3456087");
		ramal.setSenha("whoAreThePatriots");
		
		RamalDAO dao = new RamalDAO();
		dao.editar(ramal);
	}
}
