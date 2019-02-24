/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.saidapermanente;

import estocmed.estoqueconsumo.EstoqueConsumo;
import estocmed.estoquepermanente.EstoquePermanente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Karlos
 */
public class EstoquePermanenteTempTableModel extends AbstractTableModel{
    
    private List<EstoquePermanente> estoques = new ArrayList<>();
    private String[] colunas = {"Produto", "Vencimento", "Data Entrada"};

    public EstoquePermanenteTempTableModel(List<EstoquePermanente> estoques) {
        this.estoques = estoques;
    }

    @Override
    public int getRowCount() {
        return estoques.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EstoquePermanente estoque = estoques.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return estoque.getProdutoPermanente().getNomeProdutoPermanente();
            case 1:
                return estoque.getVencimentoPermanente();
            case 2:
                return estoque.getDataEntradaPermanente();

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
