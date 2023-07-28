package com.syonet.dao;

import java.util.List;

import com.syonet.domain.Cliente;
import com.syonet.generic.GenericDAO;

public class ClienteDAOImpl implements GenericDAO<Cliente> {

  @Override
  public void cria(Cliente cliente) {
    transaction.begin();
    try {
      em.persist(cliente);
      transaction.commit();
    } catch (Exception e ) {
      System.out.println(e);
      transaction.rollback();
    }
  }

  @Override
  public List<Cliente> lista() {
    return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
      .getResultList();
  }

  @Override
  public Cliente listaPorId(Integer id) {
    return em.createQuery("SELECT c FROM Cliente c WHERE id = " + id, Cliente.class)
      .getSingleResult();
  }

  @Override
  public void atualiza(Cliente cliente) {
    transaction.begin();
    try {
      em.merge(cliente);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    }
  }

  @Override
  public void deleta(Cliente cliente) {
    transaction.begin();
    try {
      em.remove(cliente);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    }
  }
}
