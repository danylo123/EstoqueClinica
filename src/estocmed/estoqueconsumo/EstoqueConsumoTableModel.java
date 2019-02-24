/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.estoqueconsumo;

import estocmed.usuario.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Adriano Lima
 */
public class EstoqueConsumoTableModel extends AbstractTableModel {

    private List<EstoqueConsumo> estoques = new ArrayList<>();
    private String[] colunas = {"Código", "Produto", "Qtd Estoque", "Qtd Saída", "Data Entrada", "Data Vencimento", "Tipo de Entrada"};

    public EstoqueConsumoTableModel(List<EstoqueConsumo> estoques) {
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

    private String converterDataString(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(date);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EstoqueConsumo estoque = estoques.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return estoque.getIdEstoque();
            case 1:
                return estoque.getProduto().getNomeProdutoConsumo();
            case 2:
                return estoque.getQtdEstoque();
            case 3:
                return estoque.getQtdSaida();
            case 4:
                return estoque.getDataEntrada();
            case 5:
                return converterDataString(estoque.getVencimentoProdConsumo());
            case 6:
                return estoque.getTipoEntrada();

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
            case 6:
                return colunas[6];
        }
        return null;
    }

}
