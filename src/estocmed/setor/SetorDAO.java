/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.setor;

import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class SetorDAO extends GenericDAO<Setor> {

    private LogGeneric lg = new LogGeneric();
    Usuario usuario;

    public SetorDAO(Usuario usuario) {
        super(Setor.class);
        this.usuario = usuario;
    }

    public void salvar(Setor setor) {
        Object[] options = {"Sim", "Não"};
        if (setor.getIdSetor() == 0) {
            if (adicionar(setor)) {
                JOptionPane.showMessageDialog(null, "Setor cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Setor");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(setor)) {
                JOptionPane.showMessageDialog(null, "Destino editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Setor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(Setor setor) {
        Object[] options = {"Sim", "Não"};
        if (setor.getIdSetor() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Setor " + setor.getNomeSetor()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {

                if (remover(setor)) {
                    JOptionPane.showMessageDialog(null, "Setor excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Setor");

                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Setor " + setor.getNomeSetor(),
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
