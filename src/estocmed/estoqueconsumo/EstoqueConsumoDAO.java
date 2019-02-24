/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.estoqueconsumo;

import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class EstoqueConsumoDAO extends GenericDAO<EstoqueConsumo> {

    private LogGeneric lg = new LogGeneric();
    Usuario usuario;
    
    public EstoqueConsumoDAO(Usuario usuario) {
        super(EstoqueConsumo.class);
        this.usuario = usuario;
    }

    public void salvar(EstoqueConsumo estoque) {
        Object[] options = {"Sim", "Não"};
        if (estoque.getIdEstoque() == 0) {
            if (adicionar(estoque)) {
                JOptionPane.showMessageDialog(null, "Estoque de Consumo cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Estoque");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(estoque)) {
                JOptionPane.showMessageDialog(null, "Estoque de Consumo editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Estoque");
            }

        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(EstoqueConsumo estoque) {
        Object[] options = {"Sim", "Não"};
        if (estoque.getIdEstoque() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Estoque de Consumo"
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(estoque)) {
                    JOptionPane.showMessageDialog(null, "Estoque de Consumo excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Estoque de Consumo");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Estoque de Consumo",
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
