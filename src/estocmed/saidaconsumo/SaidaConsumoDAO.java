/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estocmed.saidaconsumo;

import estocmed.saidapermanente.SaidaPermanente;
import estocmed.usuario.Usuario;
import estocmed.util.GenericDAO;
import estocmed.util.LogGeneric;
import javax.swing.JOptionPane;

/**
 *
 * @author Karlos
 */
public class SaidaConsumoDAO extends GenericDAO<SaidaConsumo>{
    
    private LogGeneric lg = new LogGeneric();
    Usuario usuario;
    
    public SaidaConsumoDAO(Usuario usuario) {
        super(SaidaConsumo.class);
        this.usuario = usuario;
    }   
    
}
