/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.setor;

import estocmed.destino.Destino;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Karlos
 */
public class SetorTableModel extends AbstractTableModel {

    private List<Setor> setor = new ArrayList<>();
    private String[] colunas = {"Código", "Setor", "Local"};

    public SetorTableModel(List<Setor> setor) {
        this.setor = setor;
    }

    @Override
    public int getRowCount() {
        return setor.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Setor setores = setor.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return setores.getIdSetor();
            case 1:
                return setores.getNomeSetor();
            case 2:
                return setores.getLocalSetor();
        }
        return null;
    }

    @Override
    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
            case 2:
                return colunas[2];
        }
        return null;
    }

}
