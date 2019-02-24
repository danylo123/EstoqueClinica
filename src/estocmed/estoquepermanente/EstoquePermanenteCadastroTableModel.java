/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.estoquepermanente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Karlos
 */
public class EstoquePermanenteCadastroTableModel extends AbstractTableModel{
    
    private List<EstoquePermanente> estoques = new ArrayList<>();
    private String[] colunas = {"Produto", "Tombo", "Vencimento"};

    public EstoquePermanenteCadastroTableModel(List<EstoquePermanente> estoques) {
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
        EstoquePermanente estoque = estoques.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return estoque.getProdutoPermanente().getNomeProdutoPermanente();
            case 1:
                return estoque.getTomboProdutoPermanente();
            case 2:
                return converterDataString(estoque.getVencimentoPermanente());

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
