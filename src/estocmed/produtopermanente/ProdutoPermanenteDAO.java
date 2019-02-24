/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.produtopermanente;

import estocmed.produtoconsumo.ProdutoConsumo;
import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class ProdutoPermanenteDAO extends GenericDAO<ProdutoPermanente> {

    private LogGeneric lg = new LogGeneric();
    Usuario usuario;

    public ProdutoPermanenteDAO(Usuario usuario) {
        super(ProdutoPermanente.class);
        this.usuario = usuario;
    }

    public void salvar(ProdutoPermanente produtoPermanente) {
        Object[] options = {"Sim", "Não"};
        if (produtoPermanente.getIdProdutoPermanente() == 0) {
            if (adicionar(produtoPermanente)) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Produto Permanente");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "Bird Stork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(produtoPermanente)) {
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Produto Permanente");
            }

        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(ProdutoPermanente produtoPermanente) {
        Object[] options = {"Sim", "Não"};
        if (produtoPermanente.getIdProdutoPermanente() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Produto Pemanente" + produtoPermanente.getNomeProdutoPermanente()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(produtoPermanente)) {
                    JOptionPane.showMessageDialog(null, "Produto Permanente excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Produto Permanente");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Produto Permanente" + produtoPermanente.getNomeProdutoPermanente(),
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
