/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.saidapermanente;

import estocmed.destino.Destino;
import estocmed.estoquepermanente.EstoquePermanente;
import estocmed.setor.Setor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Karlos
 */
@Entity
public class SaidaPermanente implements Serializable {
    
    @Id
    @GeneratedValue
    private int idSaida;

    @Column(length = 100, nullable = false)
    private Date dataSaida;

    @OneToOne(fetch = FetchType.EAGER)
    private Setor setor;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "idSaida"), inverseJoinColumns = @JoinColumn(name = "idEstoquePermanente"))
    private List<EstoquePermanente> estoquePermanente = new ArrayList<>();

    public int getIdSaida() {
        return idSaida;
    }

    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }
    
    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<EstoquePermanente> getEstoquePermanente() {
        return estoquePermanente;
    }

    public void setEstoquePermanente(List<EstoquePermanente> estoquePermanente) {
        this.estoquePermanente = estoquePermanente;
    }

    /**
     * @return the 
     */
    public Setor getSetor() {
        return setor;
    }

    /**
     * @param setor
     */
    public void setSetor(Setor setor) {
        this.setor = setor;
    }    
    
}
