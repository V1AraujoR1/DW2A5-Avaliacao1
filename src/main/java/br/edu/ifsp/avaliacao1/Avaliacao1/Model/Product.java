package br.edu.ifsp.avaliacao1.Avaliacao1.Model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seqProduto;
    private String nome;
    private String descricao;
    private String marca;
    private String referencia;
    private float preco;

    public Product() {

    }

    public long getSeqProduto() {
        return seqProduto;
    }
    public void setSeqProduto(long seqProduto) {
        this.seqProduto = seqProduto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
