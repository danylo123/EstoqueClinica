/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.setor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Karlos
 */
@Entity
public class Setor implements Serializable {
    
    @Id
    @GeneratedValue
    private int idSetor;
    
    @Column(length = 100, nullable = false)
    private String nomeSetor;
    
    @Column(length = 100, nullable = false)
    private String localSetor;

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getLocalSetor() {
        return localSetor;
    }

    public void setLocalSetor(String localSetor) {
        this.localSetor = localSetor;
    }
    
}
