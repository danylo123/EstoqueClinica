/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.curso;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Karlos
 */
public class CursoTableModel extends AbstractTableModel{
    
    private List<Curso> curso = new ArrayList<>();
    private String[] colunas = {"Código", "Curso"};

    public CursoTableModel(List<Curso> curso) {
        this.curso = curso;
    }

    @Override
    public int getRowCount() {
        return curso.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Curso cursos = curso.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cursos.getIdCurso();
            case 1:
                return cursos.getNomeCurso();

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
