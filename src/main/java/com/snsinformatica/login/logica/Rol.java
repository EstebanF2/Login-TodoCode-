package com.snsinformatica.login.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombreRol;
    private String descripcion;
    
    @OneToMany(mappedBy = "unRol") //mapeo de donde tiene la relacion
    private List<Usuario> listaUsuarios;

    public Rol(int id, String nombreRol, String descripcion) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Rol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
