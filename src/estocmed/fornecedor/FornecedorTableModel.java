/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.fornecedor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano Lima
 */
public class FornecedorTableModel extends AbstractTableModel {

    private List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
    private String[] colunas = {"Código", "Nome"};

    public FornecedorTableModel(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int getRowCount() {
        return fornecedor.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedor fornecedores = fornecedor.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fornecedores.getIdFornecedor();
            case 1:
                return fornecedores.getNome();

        }
        return null;
    }

    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
        }
        return null;
    }

}
