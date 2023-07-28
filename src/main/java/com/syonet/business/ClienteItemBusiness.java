package com.syonet.business;

import java.util.List;

import com.syonet.dao.ClienteDAOImpl;
import com.syonet.dao.ItemDAOImpl;
import com.syonet.domain.Cliente;
import com.syonet.domain.Item;

public class ClienteItemBusiness {
  private ClienteDAOImpl cdao = new ClienteDAOImpl();
  private ItemDAOImpl idao = new ItemDAOImpl();

  public void criaClienteComItens(Cliente cliente) {
    List<Item> itensDoCliente = cliente.getItens();
    cdao.cria(cliente);
    idao.deletaItens(idao.lista());
    idao.criaItens(itensDoCliente);
    cdao.fechaTransacao();
  }
}
