package com.syonet.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public interface GenericDAO<T> {
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("clienteitemjpa");
  EntityManager em = emf.createEntityManager();
  EntityTransaction transaction = em.getTransaction();

  void cria(T objeto);
  List<T> lista();
  T listaPorId(Integer id);
  void atualiza(T objeto);
  void deleta(T objeto);

  default void fechaTransacao() {
    emf.close();
    em.close();
  }
}
