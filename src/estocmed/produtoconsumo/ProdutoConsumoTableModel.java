/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.produtoconsumo;

import estocmed.destino.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano Lima
 */
public class ProdutoConsumoTableModel extends AbstractTableModel {

    private List<ProdutoConsumo> produto = new ArrayList<>();
    private String[] colunas = {"Código", "Nome do Produto", "Tipo do Produto"};

    public ProdutoConsumoTableModel(List<ProdutoConsumo> produto) {
        this.produto = produto;
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
        ProdutoConsumo produtos = produto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return produtos.getIdProduto();
            case 1:
                return produtos.getNomeProdutoConsumo();
            case 2:
                return produtos.getTipoProduto().getTipoProduto();

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
