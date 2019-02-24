/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.tipodoproduto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Karlos
 */
public class TipoDoProdutoTableModel extends AbstractTableModel {

    private List<TipoDoProduto> tipoProdutos = new ArrayList<>();
    private String[] colunas = {"Código", "Tipo de Produto"};

    public TipoDoProdutoTableModel(List<TipoDoProduto> tipoProdutos) {
        this.tipoProdutos = tipoProdutos;
    }

    @Override
    public int getRowCount() {
        return tipoProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoDoProduto tipoProduto = tipoProdutos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tipoProduto.getIdTipoProduto();
            case 1:
                return tipoProduto.getTipoProduto();

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
        }
        return null;
    }

}
