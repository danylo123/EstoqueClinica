/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.destino;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano Lima
 */
public class DestinoTableModel extends AbstractTableModel {

    private List<Destino> destino = new ArrayList<Destino>();
    private String[] colunas = { "Código","Nome","Municipio"};

    public DestinoTableModel(List<Destino> destino) {
        this.destino = destino;
    }

    @Override
    public int getRowCount() {
        return destino.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Destino destinos = destino.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return destinos.getIdDestino();
            case 1:
                return destinos.getNomeDestino();
            case 2:
                return destinos.getMunicipioDestino();


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
