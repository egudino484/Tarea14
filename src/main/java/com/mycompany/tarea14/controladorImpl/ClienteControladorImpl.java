/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea14.controladorImpl;

import com.mycompany.tarea14.controlador.IClienteControlador;
import com.mycompany.tarea14.modelo.DAO.IClienteDAO;
import com.mycompany.tarea14.modelo.DAOImpl.ClienteDAOImpl;
import com.mycompany.tarea14.modelo.entidades.Cliente;
import java.util.List;
import javax.persistence.Tuple;

/**
 *
 * @author Oscar Alfonso
 */
public class ClienteControladorImpl implements IClienteControlador{
    
    @Override
    public void insertarCliente(Cliente cliente){
        try {
        IClienteDAO sql = new ClienteDAOImpl(Cliente.class);
        sql.insertarCliente(cliente);
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
        }

    }
    
    public List<Cliente> listarCliente() {
        try {
          IClienteDAO sql = new ClienteDAOImpl(Cliente.class);
          return sql.listarCliente();
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }
}
    
//     public List<Cliente> listarClienteCQ() {
//          try {
//            ClienteDAOImpl sql = new ClienteDAOImpl(Cliente.class);
//            return sql.listarClienteCQ();
//        } catch (Exception e) {
//            System.err.println("ERROR:" + e);
//            return null;
//        }
//     }
//     
//     public List<Tuple> listarClienteTuple() {
//          try {
//            ClienteDAOImpl sql = new ClienteDAOImpl(Cliente.class);
//            return sql.listarClienteTuple();
//        } catch (Exception e) {
//
//            System.err.println("ERROR:" + e);
//            return null;
//        }
//     }
//     
//     public List<Cliente> listarClienteTQ() {
//          try {
//            ClienteDAOImpl sql = new ClienteDAOImpl(Cliente.class);
//            return sql.listarClienteTQ();
//        } catch (Exception e) {
//            System.err.println("ERROR:" + e);
//            return null;
//        }
//     }
//
//    @Override
//    public boolean actualizarCliente(Cliente cliente) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean eliminar(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Cliente> getClientes() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Cliente getCliente(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Cliente getClienteCI(String ci) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//     
//}
