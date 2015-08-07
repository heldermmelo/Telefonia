package br.net.telefonia.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.net.telefonia.domain.Ramal;
import br.net.telefonia.util.HibernateUtil;

public class RamalDAO {
	public void salvar(Ramal ramal) throws HibernateException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(ramal);
			transacao.commit();
			
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Ramal> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Ramal> ramais = null;

		try {
			Query consulta = sessao.getNamedQuery("Ramal.listar");
			ramais = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return ramais;
	}

	public Ramal buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Ramal ramal = null;

		try {
			Query consulta = sessao.getNamedQuery("Ramal.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			ramal = (Ramal) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return ramal;
	}

	public void excluir(Ramal ramal) throws HibernateException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(ramal);
			transacao.commit();
			sessao.close();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Long codigo) throws HibernateException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			Ramal ramal = buscarPorCodigo(codigo);
			sessao.delete(ramal);
			transacao.commit();
			sessao.close();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void editar(Ramal ramal) throws HibernateException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
// se não for validar em tela,utilizar versão abaixo comentada.
//			Ramal ramalEditar = buscarPorCodigo(ramal.getCodigo());
//			ramalEditar.setContexto(ramal.getContexto());
//			ramalEditar.setNumero(ramal.getNumero());
//			ramalEditar.setSenha(ramal.getSenha());

			sessao.update(ramal);

			transacao.commit();
			sessao.close();
		} catch (HibernateException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}
}
