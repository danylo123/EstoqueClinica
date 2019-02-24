/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.estoquepermanente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Karlos
 */
public class EstoquePermanenteTableModel extends AbstractTableModel {

    private List<EstoquePermanente> estoques = new ArrayList<>();
    private String[] colunas = {"Código", "Produto", "Tombo", "Data Entrada", "Data de Vencimento", "Emprestado"};

    public EstoquePermanenteTableModel(List<EstoquePermanente> estoques) {
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
                return estoque.getIdEstoquePermanente();
            case 1:
                return estoque.getProdutoPermanente().getNomeProdutoPermanente();
            case 2:
                return estoque.getTomboProdutoPermanente();
            case 3:
                return estoque.getDataEntradaPermanente();
            case 4:
                return estoque.getVencimentoPermanente();
            case 5:
                return estoque.isStatus() ? "Sim" : "Não";

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
            case 3:
                return colunas[3];
            case 4:
                return colunas[4];
            case 5:
                return colunas[5];
        }
        return null;
    }

}
