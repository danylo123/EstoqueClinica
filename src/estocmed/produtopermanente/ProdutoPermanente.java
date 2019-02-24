/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.produtopermanente;

import estocmed.fornecedor.Fornecedor;
import estocmed.tipodoproduto.TipoDoProduto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Karlos
 */
@Entity
public class ProdutoPermanente implements Serializable {
    
    @Id
    @GeneratedValue
    private int idProdutoPermanente;

    @Column(length = 100, nullable = false)
    private String nomeProdutoPermanente;

    @Column(length = 100,nullable = false)
    private TipoDoProduto tipoProduto;  

    @ManyToOne
    @JoinColumn(name = "Fornecedor")
    private Fornecedor codFornecedor;

    public TipoDoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoDoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    public int getIdProdutoPermanente() {
        return idProdutoPermanente;
    }

    public void setIdProdutoPermanente(int idProdutoPermanente) {
        this.idProdutoPermanente = idProdutoPermanente;
    }

    public String getNomeProdutoPermanente() {
        return nomeProdutoPermanente;
    }

    public void setNomeProdutoPermanente(String nomeProdutoPermanente) {
        this.nomeProdutoPermanente = nomeProdutoPermanente;
    }

    
    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return codFornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor codFornecedor) {
        this.codFornecedor = codFornecedor;
    }
}
