package estocmed.produtoconsumo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import birdpoint.professor.Professor;
import estocmed.util.GenericDAO;
import estocmed.usuario.Usuario;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class ProdutoConsumoDAO extends GenericDAO<ProdutoConsumo> {

    private LogGeneric lg = new LogGeneric();
    Usuario usuario;
    
    public ProdutoConsumoDAO(Usuario usuario) {
        super(ProdutoConsumo.class);
        this.usuario = usuario;
    }

    public void salvar(ProdutoConsumo produto) {
        Object[] options = {"Sim", "Não"};
        if (produto.getIdProduto() == 0) {
            if (adicionar(produto)) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Produto de Consumo");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "Bird Stork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(produto)) {
                JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Produto de Consumo");
            }

        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(ProdutoConsumo produto) {
        Object[] options = {"Sim", "Não"};
        if (produto.getIdProduto() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Produto de Consumo" + produto.getNomeProdutoConsumo()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(produto)) {
                    JOptionPane.showMessageDialog(null, "Produto de Consumo excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Produto de Consumo");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Produto de Consumo" + produto.getNomeProdutoConsumo(),
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
