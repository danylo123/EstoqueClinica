/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.destino;

import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class DestinoDAO extends GenericDAO<Destino> {

    private LogGeneric lg = new LogGeneric();
    Usuario usuario;

    public DestinoDAO(Usuario usuario) {
        super(Destino.class);
        this.usuario = usuario;
    }

    public void salvar(Destino destino) {
        Object[] options = {"Sim", "Não"};
        if (destino.getIdDestino() == 0) {
            if (adicionar(destino)) {
                JOptionPane.showMessageDialog(null, "Destino cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Destino");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(destino)) {
                JOptionPane.showMessageDialog(null, "Destino editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Destino");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(Destino destino) {
        Object[] options = {"Sim", "Não"};
        if (destino.getIdDestino() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Destino" + destino.getNomeDestino()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(destino)) {
                    JOptionPane.showMessageDialog(null, "Destino excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Destino");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Destino" + destino.getNomeDestino(),
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
