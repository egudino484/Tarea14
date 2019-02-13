/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea14.controlador;

import com.mycompany.tarea14.modelo.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Oscar Alfonso
 */
public interface IClienteControlador {
    
    public void insertarCliente(Cliente cliente);
     
     public List<Cliente> listarCliente();

//    public void insertarCliente(Cliente cliente) throws Exception ;
//
//    public boolean actualizarCliente(Cliente cliente)throws Exception;
//
  public boolean eliminarCliente(int id)throws Exception;
//
//    public List<Cliente> getClientes()throws Exception;
//
//    public Cliente getCliente(int id)throws Exception;
//
//    public Cliente getClienteCI(String ci)throws Exception;
}

