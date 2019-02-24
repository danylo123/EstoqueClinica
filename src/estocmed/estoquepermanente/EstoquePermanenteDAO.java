/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.estoquepermanente;

import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class EstoquePermanenteDAO extends GenericDAO<EstoquePermanente> {

    private LogGeneric lg = new LogGeneric();
    Usuario usuario;

    public EstoquePermanenteDAO(Usuario usuario) {
        super(EstoquePermanente.class);
        this.usuario = usuario;
    }

    public boolean salvar(EstoquePermanente estoque) {
        Object[] options = {"Sim", "Não"};
        if (estoque.getIdEstoquePermanente() == 0) {
            if (adicionar(estoque)) {
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Estoque Permanente");
            }
            return true;
        } else if (atualizar(estoque)) {
            lg.salvarLog(usuario.getNomeUsuario(), "Edição de Estoque");
            return true;
        }
        return false;
    }

    public boolean excluir(EstoquePermanente estoque) {
        Object[] options = {"Sim", "Não"};
        if (estoque.getIdEstoquePermanente() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Estoque Permanente"
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(estoque)) {
                    JOptionPane.showMessageDialog(null, "Estoque Permanente excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Estoque Permanente");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Estoque Permanente",
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
