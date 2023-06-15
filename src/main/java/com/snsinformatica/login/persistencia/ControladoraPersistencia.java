package com.snsinformatica.login.persistencia;

import com.snsinformatica.login.logica.Rol;
import com.snsinformatica.login.logica.Usuario;
import com.snsinformatica.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    UsuarioJpaController controlador = new UsuarioJpaController();
    RolJpaController rolJPA = new RolJpaController();

    public ControladoraPersistencia() {
    }

    public List<Usuario> traerUsuarios() {

        List<Usuario> listaUsuario = controlador.findUsuarioEntities();
        return listaUsuario;
    }

    public List<Rol> traerRoles() {
        return rolJPA.findRolEntities();
    }

    public void crearUsuario(Usuario usu) {
        controlador.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
        try {
            controlador.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
        return controlador.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu) {
        try {
            controlador.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
