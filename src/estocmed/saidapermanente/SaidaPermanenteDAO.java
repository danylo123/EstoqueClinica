/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.saidapermanente;

import estocmed.saidaconsumo.SaidaConsumo;
import estocmed.setor.Setor;
import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class SaidaPermanenteDAO extends GenericDAO<SaidaPermanente>{
    
    private LogGeneric lg = new LogGeneric();
    Usuario usuario;
    
    public SaidaPermanenteDAO(Usuario usuario) {
        super(SaidaPermanente.class);
        this.usuario = usuario;
    }
    
    
    
    
}
