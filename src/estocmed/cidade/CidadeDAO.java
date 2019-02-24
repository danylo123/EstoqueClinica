/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.cidade;

import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class CidadeDAO extends GenericDAO<Cidade> {

    Usuario usuario;
    private LogGeneric lg = new LogGeneric();
    
    public CidadeDAO(Usuario usuario) {
        super(Cidade.class);
        this.usuario = usuario;
    }

    public void salvar(Cidade cidade) {
        Object[] options = {"Sim", "Não"};
        if (cidade.getIdCidade() == 0) {
            if (adicionar(cidade)) {
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Cidade");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(cidade)) {
                JOptionPane.showMessageDialog(null, "Cidade editada com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Cidade");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(Cidade cidade) {
        Object[] options = {"Sim", "Não"};
        if (cidade.getIdCidade() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir a Cidade" + cidade.getNomeCidade()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(cidade)) {
                    JOptionPane.showMessageDialog(null, "Cidade excluída com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Cidade");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir a Cidade" + cidade.getNomeCidade(),
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
