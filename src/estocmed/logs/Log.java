/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.logs;

import estocmed.usuario.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author noobr
 */
@Entity
public class Log implements Serializable {

    @Id
    @GeneratedValue
    private int idLogs;

    @Column(length = 100, nullable = false)
    private String usuario;

    @Column(length = 100, nullable = false)
    private Date data;
    @Column(length = 100, nullable = false)
    private String operacao;

    public int getIdLogs() {
        return idLogs;
    }

    public void setIdLogs(int idLogs) {
        this.idLogs = idLogs;
    }

    public String getNomeUsuario() {
        return usuario;
    }

    public void setNomeUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

}
