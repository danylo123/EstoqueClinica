/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.logs;

import estocmed.destino.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano Lima
 */
public class LogTableModel extends AbstractTableModel {

    private List<Log> produto = new ArrayList<Log>();
    private String[] colunas = { "Código","Usuario","Data","Operação"};

    public LogTableModel(List<Log> log) {
        this.produto = log;
    }

    @Override
    public int getRowCount() {
        return produto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Log logs = produto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return logs.getIdLogs();
            case 1:
                return logs.getNomeUsuario();
            case 2:
                return logs.getData();
                case 3:
                    return logs.getOperacao();
               

        }
        return null;
    }

    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
            case 2:
                return colunas[2];
            case 3:
                return colunas[3];

        }
        return null;
    }

}
