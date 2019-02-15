/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *OSCAR ALFONSO*/
package com.mycompany.tarea14.backingBeans;

import com.mycompany.tarea14.controlador.IClienteControlador;
import com.mycompany.tarea14.controladorImpl.ClienteControladorImpl;
import com.mycompany.tarea14.modelo.entidades.Cliente;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Oscar Alfonso
 */
@ManagedBean //(name="Cli")
@ViewScoped

public class ClienteView implements Serializable {

    private int txtid;
    private String txtNombre;
    private String txtAapellido;
    private String txtDieccion;
    private String txtFono;
    private String txtCi;
    private Cliente nuevoCliente;
    private Cliente edicionCliente;
    private Cliente clienteSeleccionado;
    private IClienteControlador clienteControlador;
    private List<Cliente> listcliente;

    public ClienteView() {
    }

    @PostConstruct
    public void init() {
        clienteControlador = new ClienteControladorImpl();
        nuevoCliente = new Cliente();
        clienteSeleccionado = new Cliente();
        clienteControlador.listarCliente();

//        System.err.println("Inicio se creo el BEAN");
//        clienteControlador= new ClienteControladorImpl();
    }

    public void seleccionarCliente(int clienteSeleccion) {
        System.out.println("id cliente:" + clienteSeleccion);
        clienteSeleccionado = clienteControlador.buscarPorId(clienteSeleccion);
        System.err.println("termino de convertir: " + clienteSeleccionado);
    }

    public void insertarCliente() throws Exception {
        // para ingresar codID 
        // nuevoCliente.setCi(Integer.ParseInt.(txtCi));

        //nuevoCliente= new Cliente();
        nuevoCliente.setIdCliente(txtid);
        nuevoCliente.setNombre(txtNombre);
        nuevoCliente.setApellido(txtAapellido);
        nuevoCliente.setDireccion(txtDieccion);
        nuevoCliente.setTelefono(txtFono);
        nuevoCliente.setCi(txtCi);
        System.err.println("Ya llego al servidor: " + nuevoCliente);

        clienteControlador.insertarCliente(nuevoCliente);
    }

    public void guardarCliente() throws Exception {
        // para ingresar codID 
        // nuevoCliente.setCi(Integer.ParseInt.(txtCi));

        //nuevoCliente= new Cliente();
        /*  clienteSeleccionado.setIdCliente(txtid);
        clienteSeleccionado.setNombre(txtNombre);
        clienteSeleccionado.setApellido(txtAapellido);
        clienteSeleccionado.setDireccion(txtDieccion);
        clienteSeleccionado.setTelefono(txtFono);
        clienteSeleccionado.setCi(txtCi);*/
        System.err.println("Ya llego al servidor: " + clienteSeleccionado);

        clienteControlador.actualizarCliente(clienteSeleccionado);
    }

    public void eliminarCliente(int id) throws Exception {
        // para ingresar codID 
        // nuevoCliente.setCi(Integer.ParseInt.(txtCi));

        //nuevoCliente= new Cliente();
        nuevoCliente.setIdCliente(id);

        System.err.println("Ya llego al servidor para ser eliminado: " + nuevoCliente);

        clienteControlador.eliminarCliente(nuevoCliente.getIdCliente());
    }

//    public void eliminarCliente(){
//         System.out.println("INGRESE DATOS A ELIMINAR");
//    
//    }
    public List<Cliente> listarcliente() {
        return listcliente = clienteControlador.listarCliente();
    }

    public int getTxtid() {
        return txtid;
    }

    public void setTxtid(int txtid) {
        this.txtid = txtid;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtAapellido() {
        return txtAapellido;
    }

    public void setTxtAapellido(String txtAapellido) {
        this.txtAapellido = txtAapellido;
    }

    public String getTxtDieccion() {
        return txtDieccion;
    }

    public void setTxtDieccion(String txtDieccion) {
        this.txtDieccion = txtDieccion;
    }

    public String getTxtFono() {
        return txtFono;
    }

    public void setTxtFono(String txtFono) {
        this.txtFono = txtFono;
    }

    public String getTxtCi() {
        return txtCi;
    }

    public void setTxtCi(String txtCi) {
        this.txtCi = txtCi;
    }

    public Cliente getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(Cliente nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }

    public IClienteControlador getClienteControlador() {
        return clienteControlador;
    }

    public void setClienteControlador(IClienteControlador clienteControlador) {
        this.clienteControlador = clienteControlador;
    }

    public List<Cliente> getListcliente() {
        return listcliente;
    }

    public void setListcliente(List<Cliente> listcliente) {
        this.listcliente = listcliente;
    }

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

}
