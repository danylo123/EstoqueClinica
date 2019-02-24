/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.produtopermanente;

import estocmed.produtoconsumo.ProdutoConsumo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Karlos
 */
public class ProdutoPermanenteTableModel extends AbstractTableModel {

    private List<ProdutoPermanente> produtoPermanentes = new ArrayList<>();
    private String[] colunas = {"Código", "Nome", "Tipo do Produto", "Fornecedor"};

    public ProdutoPermanenteTableModel(List<ProdutoPermanente> produtoPermanentes) {
        this.produtoPermanentes = produtoPermanentes;
    }

    @Override
    public int getRowCount() {
        return produtoPermanentes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutoPermanente produtosPermanente = produtoPermanentes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return produtosPermanente.getIdProdutoPermanente();
            case 1:
                return produtosPermanente.getNomeProdutoPermanente();
            case 2:
                return produtosPermanente.getTipoProduto().getTipoProduto();

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
