/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.logs;

import estocmed.produtoconsumo.ProdutoConsumo;
import estocmed.util.GenericDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author noobr
 */
public class LogDAO extends GenericDAO<Log> {

    public LogDAO() {
        super(Log.class);
    }

    public void salvar(Log log) {
        Object[] options = {"Sim", "Não"};

        adicionar(log);

    }
}
