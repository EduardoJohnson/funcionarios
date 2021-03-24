package com.hepta.funcionarios.persistence;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

public class SetorDaa {

	public void save(Funcionario Funcionario) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(Funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
	}

	public Funcionario update(Funcionario Funcionario) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Funcionario FuncionarioAtualizado = null;
		try {
			em.getTransaction().begin();
			FuncionarioAtualizado = em.merge(Funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return FuncionarioAtualizado;
	}

	public void delete(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Funcionario Funcionario = em.find(Funcionario.class, id);
			em.remove(Funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}

	}

	public Setor find(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		Setor Setor = null;
		try {
			Setor = em.find(Setor.class, id);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}		return Setor;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> getAll() throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		List<Funcionario> Funcionarios = new ArrayList<>();
		try {
			Query query = em.createQuery("FROM Funcionario");
			Funcionarios = query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return Funcionarios;
	}

}
