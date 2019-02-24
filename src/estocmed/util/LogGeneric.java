/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.util;

import estocmed.logs.LogDAO;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Karlos
 */
public class LogGeneric {

    private final estocmed.logs.Log log = new estocmed.logs.Log();
    private final LogDAO logDAO = new LogDAO();
    private final Date date = new Date();
    private final Calendar c = Calendar.getInstance();
    private final DateFormat f = DateFormat.getDateInstance();

    public void salvarLog(String nome, String op) {
        c.set(date.getDay(), date.getDate(), date.getMonth(), date.getHours(), date.getMinutes());
        log.setNomeUsuario(nome);
        log.setOperacao(op);
        log.setData(date);
        logDAO.salvar(log);
    }

}
