/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.destino;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author noobr
 */
@Entity
public class Destino implements Serializable {

    @Id
    @GeneratedValue
    private int idDestino;
    
    @Column(length = 100, nullable = false)
    private String nomeDestino;
    
    @Column(length = 100, nullable = false)
    private String municipioDestino;

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        this.nomeDestino = nomeDestino;
    }

    public String getMunicipioDestino() {
        return municipioDestino;
    }

    public void setMunicipioDestino(String municipioDestino) {
        this.municipioDestino = municipioDestino;
    }

    
    
    
}
