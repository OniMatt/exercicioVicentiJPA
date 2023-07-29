package com.syonet;

import java.util.ArrayList;
import java.util.List;

import com.syonet.business.ClienteItemBusiness;
import com.syonet.dao.ClienteDAOImpl;
import com.syonet.dao.ItemDAOImpl;
import com.syonet.domain.Cliente;
import com.syonet.domain.Item;

public class Main {
    public static void main( String[] args ) {
        ClienteDAOImpl cdao = new ClienteDAOImpl();
        ItemDAOImpl idao = new ItemDAOImpl();
        List<Item> itens = new ArrayList<>();
        Cliente cliente = new Cliente("matheus",itens);
        Item i1 = new Item(cliente, "carro");
        Item i2 = new Item(cliente, "moto");
        Item i3 = new Item(cliente, "caminhao");
        Item i4 = new Item(cliente, "item que vai ser excluido");
        

        cdao.cria(cliente);
        idao.cria(i4);

        itens.add(i1);
        itens.add(i2);
        itens.add(i3);

        ClienteItemBusiness cib = new ClienteItemBusiness();
        cib.criaItensDoCliente(cliente);

        cdao.fechaTransacao();
        
    }
}
