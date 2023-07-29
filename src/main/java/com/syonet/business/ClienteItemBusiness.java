package com.syonet.business;

import java.util.List;

import com.syonet.dao.ItemDAOImpl;
import com.syonet.domain.Cliente;
import com.syonet.domain.Item;

public class ClienteItemBusiness {
  private ItemDAOImpl idao = new ItemDAOImpl();

  //acho que eu nao entendi
  public void criaItensDoCliente(Cliente cliente) {
    List<Item> itensDoCliente = cliente.getItens();

    idao.removeItensInexistentes(cliente);
    idao.criaItens(itensDoCliente);
  }
}
