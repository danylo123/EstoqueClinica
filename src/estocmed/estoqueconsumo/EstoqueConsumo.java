/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.estoqueconsumo;

import estocmed.curso.Curso;
import estocmed.produtoconsumo.ProdutoConsumo;
import java.io.Serializable;
import java.text.Collator;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author noobr
 */
@Entity
public class EstoqueConsumo implements Comparable<EstoqueConsumo>, Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int idEstoque;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProdutoConsumo produto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;

    @Column(length = 100, nullable = false)
    private int qtdEstoque;

    @Column(length = 100, nullable = false)
    private int qtdSaida;

    @Transient
    private int qtdSaidaAtual;
  
    @Column(length = 100, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrada;

    @Column(length = 100, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vencimentoProdConsumo;

    @Column(length = 100, nullable = false)
    private String tipoEntrada;

    @Override
    public int compareTo(EstoqueConsumo produtoConsumo) {
        Collator cot = Collator.getInstance(new Locale("pt", "BR"));
        return cot.compare(produto.getNomeProdutoConsumo(), produtoConsumo.getProduto().getNomeProdutoConsumo());
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public Date getVencimentoProdConsumo() {
        return vencimentoProdConsumo;
    }

    public int getQtdSaidaAtual() {
        return qtdSaidaAtual;
    }

    public void setQtdSaidaAtual(int qtdSaidaAtual) {
        this.qtdSaidaAtual = qtdSaidaAtual;
    }
    
    public void setVencimentoProdConsumo(Date vencimentoProdConsumo) {
        this.vencimentoProdConsumo = vencimentoProdConsumo;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public ProdutoConsumo getProduto() {
        return produto;
    }

    public void setProduto(ProdutoConsumo produto) {
        this.produto = produto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Integer getQtdSaida() {
        return qtdSaida;
    }

    public void setQtdSaida(Integer qtdSaida) {
        this.qtdSaida = qtdSaida;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

}
