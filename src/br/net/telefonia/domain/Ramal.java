package br.net.telefonia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ramal")
@NamedQueries({ 
	@NamedQuery(name = "Ramal.listar", query = "SELECT ramal FROM Ramal ramal"),
	@NamedQuery(name ="Ramal.buscarPorCodigo", query = "SELECT ramal from Ramal ramal WHERE ramal.codigo = :codigo")
	})
public class Ramal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ram_codigo")
	private Long codigo;

	@Column(name = "ram_numero", length = 25, nullable = false)
	private String numero;

	@Column(name = "ram_senha", length = 25, nullable = false)
	private String senha;

	@Column(name = "ram_contexto", length = 25, nullable = false)
	private String contexto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	@Override
	public String toString() {
		return "Ramal [codigo=" + codigo + ", numero=" + numero + ", senha=" + senha + ", contexto=" + contexto + "]";
	}
	
}
