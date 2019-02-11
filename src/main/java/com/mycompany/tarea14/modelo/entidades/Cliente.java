/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea14.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Oscar Alfonso
 */
@Entity
@Table (name="cliente")
public class Cliente implements Serializable{
    @Id
    private int idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String ci;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Cliente")
//    private List<Factura> factura = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String direccion, String telefono, String ci) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ci = ci;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", ci=" + ci + '}';
    }
    
    
    
}
