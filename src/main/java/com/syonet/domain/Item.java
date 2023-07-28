package com.syonet.domain;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nome")
  private String nome;

  @ManyToOne
  @JoinColumn(name="cliente_id")
  private Cliente cliente;

  public Item() {
  }

  public Item(Cliente cliente, String nome) {
    this.cliente = cliente;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
