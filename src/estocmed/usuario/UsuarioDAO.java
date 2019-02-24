/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.usuario;

import estocmed.util.GenericDAO;
import estocmed.util.HibernateUtil;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Karlos
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    private LogGeneric lg = new LogGeneric();

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public void salvar(Usuario usuario) {
        Object[] options = {"Sim", "Não"};
        if (usuario.getIdUsuario() == 0) {
            if (adicionar(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                lg.salvarLog("Administrador", "Cadastro de Usuário");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                lg.salvarLog("Administrador", "Edição de Usuário");
            }
        } else {
            JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
        }
    }

    public Usuario autenticarUsuario(String login, String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("senhaUsuario", senha)).add(Restrictions.eq("loginUsuario", login)).uniqueResult();
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos!");
        } else {
            sessao.close();
            return usuario;
        }
        return usuario;
    }

    public boolean excluir(Usuario usuario) {
        Object[] options = {"Sim", "Não"};
        if (usuario.getIdUsuario() != 0) {
            if (JOptionPane.showOptionDialog(null, "Deseja excluir o Usuário " + usuario.getLoginUsuario()
                    + "?", "BirdStork", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {

                if (remover(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                    lg.salvarLog("Administrador", "Exclusão de Usuário");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir o Usuário " + usuario.getLoginUsuario(),
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
