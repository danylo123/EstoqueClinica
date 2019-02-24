/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.fornecedor;


import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class FornecedorDAO extends GenericDAO<Fornecedor> {

    private LogGeneric lg = new LogGeneric();
    Usuario usuario;

    public FornecedorDAO(Usuario usuario) {
        super(Fornecedor.class);
        this.usuario = usuario;
               
    }

    public void salvar(Fornecedor fornecedor) {
        Object[] options = {"Sim", "Não"};
        if (fornecedor.getIdFornecedor() == 0) {
            if (adicionar(fornecedor)) {
                JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Cadastro de Fornecedor");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(fornecedor)) {
                JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso!");
                lg.salvarLog(usuario.getNomeUsuario(), "Edição de Fornecedor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public boolean excluir(Fornecedor fornecedor) {
        Object[] options = {"Sim", "Não"};
        if (fornecedor.getIdFornecedor() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Fornecedor" + fornecedor.getNome()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (remover(fornecedor)) {
                    JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
                    lg.salvarLog(usuario.getNomeUsuario(), "Exclusão de Fornecedor");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Fornecedor" + fornecedor.getNome(),
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
