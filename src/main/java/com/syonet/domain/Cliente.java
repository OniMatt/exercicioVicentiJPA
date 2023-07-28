package com.syonet.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name="nome")
  private String nome;

  @OneToMany(mappedBy = "cliente")
  private List<Item> itens;

  public Cliente() {
  }

  public Cliente(String nome, List<Item> itens) {
    this.nome = nome;
    this.itens = itens;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Item> getItens() {
    return itens;
  }

  public void setItens(List<Item> itens) {
    this.itens = itens;
  }
}
