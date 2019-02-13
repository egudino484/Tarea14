/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea14.modelo.DAO;

import com.mycompany.tarea14.modelo.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Oscar Alfonso
 */
public interface IClienteDAO {

    public void insertarCliente(Cliente cliente);

    public List<Cliente> listarCliente();
//

    public boolean actualizarCliente(Cliente cliente);

    public boolean eliminarCliente(int id);

    public Cliente buscarPorId(int id);

//
//    public List<Cliente> getClientes();
//
//    public Cliente getCliente(int id);
//
//    public Cliente getClienteCI(String ci);
//    
//    public List<Cliente> listarCliente();
}
