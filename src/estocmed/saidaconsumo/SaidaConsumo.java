/*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
 */
package estocmed.saidaconsumo;

import estocmed.destino.Destino;
import estocmed.estoqueconsumo.EstoqueConsumo;
import estocmed.produtoconsumo.ProdutoConsumo;
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
import javax.persistence.OneToOne;

/**
 *
 * @author noobr
 */
@Entity
public class SaidaConsumo implements Serializable {

    @Id
    @GeneratedValue
    private int idSaida;

    @Column(length = 100, nullable = false)
    private Date dataSaida;

    @OneToOne(fetch = FetchType.EAGER)
    private Destino destino;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "idSaida"), inverseJoinColumns = @JoinColumn(name = "idEstoque"))
    private List<EstoqueConsumo> estoqueConsumo = new ArrayList<>();
    
    private String quantidadeSaidaDestino = "";

    public int getQuantidadeSaidaDestino(Integer index) {
        String[] valores = quantidadeSaidaDestino.split(";");
        return Integer.parseInt(valores[index]);
    }

    public void setQuantidadeSaidaDestino(List<Integer> valores) {
        for (Integer valor : valores) {
            quantidadeSaidaDestino += String.valueOf(valor) + ";";
        }
    }
    
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

    public List<EstoqueConsumo> getEstoqueConsumo() {
        return estoqueConsumo;
    }

    public void setEstoqueConsumo(List<EstoqueConsumo> estoqueConsumo) {
        this.estoqueConsumo = estoqueConsumo;
    }
    
    /**
     * @return the destino
     */
    public Destino getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Destino destino) {
        this.destino = destino;
    }    

}
