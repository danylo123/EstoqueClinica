/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.estoquepermanente;

import estocmed.produtopermanente.ProdutoPermanente;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Karlos
 */
@Entity
public class EstoquePermanente implements Comparable<EstoquePermanente>, Serializable {

    @Id
    @GeneratedValue
    private int idEstoquePermanente;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProdutoPermanente produtoPermanente;

    @Column(length = 100, nullable = false)
    private Date dataEntradaPermanente;
    @Column(length = 100, nullable = false)
    private Date vencimentoPermanente;
    @Column(length = 30, nullable = false)
    private String tomboProdutoPermanente;

    @Column(nullable = false)
    private boolean status = false;

    public int getIdEstoquePermanente() {
        return idEstoquePermanente;
    }

    public void setIdEstoquePermanente(int idEstoquePermanente) {
        this.idEstoquePermanente = idEstoquePermanente;
    }

    public ProdutoPermanente getProdutoPermanente() {
        return produtoPermanente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the tomboProdutoPermanente
     */
    public String getTomboProdutoPermanente() {
        return tomboProdutoPermanente;
    }

    /**
     * @param tomboProdutoPermanente the tomboProdutoPermanente to set
     */
    public void setTomboProdutoPermanente(String tomboProdutoPermanente) {
        this.tomboProdutoPermanente = tomboProdutoPermanente;
    }

    public void setProdutoPermanente(ProdutoPermanente produtoPermanente) {
        this.produtoPermanente = produtoPermanente;
    }

    public Date getDataEntradaPermanente() {
        return dataEntradaPermanente;
    }

    public void setDataEntradaPermanente(Date dataEntradaPermanente) {
        this.dataEntradaPermanente = dataEntradaPermanente;
    }

    public Date getVencimentoPermanente() {
        return vencimentoPermanente;
    }

    public void setVencimentoPermanente(Date vencimentoPermanente) {
        this.vencimentoPermanente = vencimentoPermanente;
    }
    
    @Override
    public int compareTo(EstoquePermanente o) {
        return (o.isStatus() == this.status ? 0 : (this.status ? 1 : -1));
    }

}
