package com.syonet;

import java.util.ArrayList;
import java.util.List;

import com.syonet.business.ClienteItemBusiness;
import com.syonet.domain.Cliente;
import com.syonet.domain.Item;

public class Main {
    public static void main( String[] args ) {
        List<Item> itens = new ArrayList<>();
        Cliente cliente = new Cliente("matheus",itens);
        Item i1 = new Item(cliente, "carro");
        Item i2 = new Item(cliente, "moto");
        Item i3 = new Item(cliente, "caminhao");
        
        itens.add(i1);
        itens.add(i2);
        itens.add(i3);

        ClienteItemBusiness cib = new ClienteItemBusiness();
        cib.criaClienteComItens(cliente);
        
    }
}
