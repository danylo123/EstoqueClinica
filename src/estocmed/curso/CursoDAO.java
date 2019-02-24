/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.curso;

import estocmed.fornecedor.Fornecedor;
import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class CursoDAO extends GenericDAO<Curso>{
    
    private LogGeneric lg = new LogGeneric();
    Usuario usuario;

    public CursoDAO(Usuario usuario) {
        super(Curso.class);
        this.usuario = usuario;   
    }

    public void salvar(Curso curso) {
        Object[] options = {"Sim", "Não"};
        if (curso.getIdCurso() == 0) {
            if (adicionar(curso)) {
                JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Curso");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(curso)) {
                JOptionPane.showMessageDialog(null, "Curso editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Curso");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(Curso curso) {
        Object[] options = {"Sim", "Não"};
        if (curso.getIdCurso() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Curso" + curso.getNomeCurso()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(curso)) {
                    JOptionPane.showMessageDialog(null, "Curso excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Curso");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Curso" + curso.getNomeCurso(),
                            "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "A exclusão foi cancelada!");
            }
        }
        return true;
    }
    
}
