package br.net.telefonia.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.net.telefonia.dao.RamalDAO;
import br.net.telefonia.domain.Ramal;
import br.net.telefonia.util.FacesUtil;


@ManagedBean
@ViewScoped
public class RamalBean {
	private Ramal ramalParaCadastro;
	private List<Ramal> listaRamais;
	private List<Ramal> listaRamaisFiltrados;
	
	
	
	
	
	
	public void salvar() throws RuntimeException{
		try { 
			RamalDAO ramalDao = new RamalDAO();
			ramalDao.salvar(ramalParaCadastro);
			
			
			
			FacesUtil.adicionarMsgInfo(ramalParaCadastro.toString() + "Ramal salvo com sucesso");
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu erro ao tentar incluir um ramal:" + ex.getMessage());
		}finally 
			{ramalParaCadastro = new Ramal();
		}
		
	}
	
	public void carregar(){
		
		try{
			RamalDAO ramalDao = new RamalDAO();
			listaRamais = ramalDao.listar();
			
			
		}catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Erro ao tentar listar os fabricantes:" + ex.getMessage());
		}
		
	}

	public Ramal getRamalParaCadastro() {
		if (ramalParaCadastro == null) {
			ramalParaCadastro = new Ramal();							
		
		}
		return ramalParaCadastro;
	}

	public void setRamalParaCadastro(Ramal ramalParaCadastro) {
		this.ramalParaCadastro = ramalParaCadastro;
	}

	public List <Ramal> getListaRamais() {
		return listaRamais;
	}

	public void setListaRamais(List <Ramal> listaRamais) {
		this.listaRamais = listaRamais;
	}

	public List<Ramal> getListaRamaisFiltrados() {
		return listaRamaisFiltrados;
	}

	public void setListaRamaisFiltrados(List<Ramal> listaRamaisFiltrados) {
		this.listaRamaisFiltrados = listaRamaisFiltrados;
	}

	
	

}
