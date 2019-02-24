/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.tipodoproduto;

import estocmed.destino.Destino;
import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class TipoDoProdutoDAO extends GenericDAO<TipoDoProduto>{
    
    private LogGeneric lg = new LogGeneric();
    Usuario usuario;

    public TipoDoProdutoDAO(Usuario usuario) {
        super(TipoDoProduto.class);
        this.usuario = usuario;
    }

    public void salvar(TipoDoProduto tipoProduto) {
        Object[] options = {"Sim", "Não"};
        if (tipoProduto.getIdTipoProduto() == 0) {
            if (adicionar(tipoProduto)) {
                JOptionPane.showMessageDialog(null, "Tipo de Produto cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Tipo de Produto");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(tipoProduto)) {
                JOptionPane.showMessageDialog(null, "Tipo de Produto editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Destino");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(TipoDoProduto tipoProduto) {
        Object[] options = {"Sim", "Não"};
        if (tipoProduto.getIdTipoProduto() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Tipo de Produto" + tipoProduto.getTipoProduto()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(tipoProduto)) {
                    JOptionPane.showMessageDialog(null, "Tipo de Produto excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Tipo de Produto");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Tipo de Produto" + tipoProduto.getTipoProduto(),
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
