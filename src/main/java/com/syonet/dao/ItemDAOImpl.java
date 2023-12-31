package com.syonet.dao;

import java.util.List;

import com.syonet.domain.Cliente;
import com.syonet.domain.Item;
import com.syonet.generic.GenericDAO;

public class ItemDAOImpl implements GenericDAO<Item>{

  @Override
  public void cria(Item item) {
    transaction.begin();
    try {
      em.persist(item);
      transaction.commit();
    } catch (Exception e ) {
      System.out.println(e);
      transaction.rollback();
    }
  }

  @Override
  public List<Item> lista() {
    return em.createQuery("SELECT i FROM Item i", Item.class)
      .getResultList();
  }

  @Override
  public Item listaPorId(Integer id) {
    return em.createQuery("SELECT i FROM Item i WHERE id = " + id, Item.class)
      .getSingleResult();
  }

  @Override
  public void atualiza(Item item) {
    transaction.begin();
    try {
      em.merge(item);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    };
  }

  @Override
  public void deleta(Item item) {
    transaction.begin();
    try {
      em.remove(item);
      transaction.commit();
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    }
  }

  public void criaItens(List<Item> itens) {
    if(itens.isEmpty()) {
      System.out.println("O cliente não tem itens para salvar.");
      return;
    }

    transaction.begin();
    try {
      itens.stream()
        .forEach(item -> em.persist(item));
      transaction.commit();  
    } catch (Exception e) {
      System.out.println(e);
      transaction.rollback();
    }
  }

  public void removeItensInexistentes(Cliente cliente) {
    List<Item> itensNoBanco = em.createQuery("SELECT i FROM Item i WHERE cliente_id = " + cliente.getId(), Item.class)
      .getResultList();

    itensNoBanco.stream()
      .forEach( item -> {
        if(!verificaItem(item, cliente.getItens())) {
          deleta(item);
        }
      });
  }
  
  private boolean verificaItem(Item item, List<Item> itens) {
    if(itens.contains(item)) {
      return true;
    }
    return false;
  }
}
