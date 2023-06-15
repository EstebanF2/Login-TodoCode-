package com.snsinformatica.login.logica;

import com.snsinformatica.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia control = new ControladoraPersistencia();

    public Usuario validarUsuario(String usuario, String contrasena) {

        Usuario usr = null;

        //Aqui traigo los usuarios que tengo en la BD
        List<Usuario> listaUsuarios = control.traerUsuarios();

        //Con este for comparo lo ingresado en el login con la lista de usuarios de la BD
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombre().equals(usuario)) {
                if (usu.getContrasena().equals(contrasena)) {
                    usr = usu;
                    return usr;
                } else {
                    usr = null;
                    return usr;
                }
            } else {
                usr = null;
            }
        }
        return usr;
    }

    public List<Usuario> traerUsuarios() {
        return control.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return control.traerRoles();
    }

    public void crearUsuario(String usuario, String pass, String rolRecibido) {

        Usuario usu = new Usuario();

        usu.setNombre(usuario);
        usu.setContrasena(pass);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }

        int id = this.buscarUltimaIdUsuario();
        usu.setId(id + 1);

        control.crearUsuario(usu);

    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = control.traerRoles();

        for (Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuario() {
        List<Usuario> listaUsuario = this.traerUsuarios();

        Usuario usu = listaUsuario.get(listaUsuario.size() - 1);
        return usu.getId();
    }

    public void borrarUsuario(int id_usuario) {
        control.borrarUsuario(id_usuario);
    }

    public Usuario traerUsuario(int id_usuario) {
        return control.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu, String usuario, String pass, String rolRecibido) {

        usu.setNombre(usuario);
        usu.setContrasena(pass);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        
        control.editarUsuario(usu);

    }

}
