package estocmed.saidaconsumo;

import estocmed.saidapermanente.SaidaPermanente;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SaidaConsumoTableModel extends AbstractTableModel{
    
    private List<SaidaConsumo> saidas = new ArrayList<>();
    private String[] colunas = {"Código", "Data Saída", "Destino"};

    public SaidaConsumoTableModel(List<SaidaConsumo> saida) {
        this.saidas = saida;
    }

    @Override
    public int getRowCount() {
        return saidas.size();
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
        SaidaConsumo saida = saidas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return saida.getIdSaida();
            case 1:
                return converterDataString(saida.getDataSaida());
            case 2:
                return saida.getDestino().getNomeDestino();
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
