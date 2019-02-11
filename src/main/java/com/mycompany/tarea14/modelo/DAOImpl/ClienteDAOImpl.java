/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea14.modelo.DAOImpl;

import com.mycompany.tarea14.modelo.DAO.IClienteDAO;
import com.mycompany.tarea14.modelo.entidades.Cliente;
import java.util.List;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Oscar Alfonso
 */
public class ClienteDAOImpl extends GenericDAO<Cliente> implements IClienteDAO{
    
     public ClienteDAOImpl() {
    }
    
    public ClienteDAOImpl (Class<Cliente> entiClass){
        super (entiClass);
    }
    
    @Override
    public void insertarCliente (Cliente cliente){
        this.beginTransaction();
        this.create(cliente);
        this.commit();
        this.closeTransaction();       
    }
   
    
//    public List<Cliente> listarCliente(){
//        this.beginTransaction();
//        List<Cliente> lista = this.findAll();
//        this.closeTransaction();
//        return lista;        
//    }
//    
    @Override
    public List<Cliente> listarCliente() {
        TypedQuery<Cliente> lista;
        try {
            lista = entityManager.createQuery("SELECT c FROM Cliente c",Cliente.class);
            return lista.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

}

    
//    public List<Cliente> listarClienteCQ() {
//        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
//        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class) ;
//        Root<Cliente> cliente= cq.from(Cliente.class);
//        cq.select(cliente);
//        return this.entityManager.createQuery(cq).getResultList();
//    }
//
//    public List<Tuple> listarClienteTuple() {
//        CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
//        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
//        Root<Cliente> cliente= cq.from(Cliente.class);          
//        cq.select(cb.tuple(cliente.get("idCliente"), cliente.get("apellido")));
//        return this.entityManager.createQuery(cq).getResultList();
//    }
//    
//    public List<Cliente> listarClienteTQ() {
//        TypedQuery<Cliente> tq= entityManager.createQuery("select c from Cliente c",Cliente.class );
//        return  tq.getResultList();
//    }
//
//    
//
//    @Override
//    public boolean actualizarCliente(Cliente cliente) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean eliminarCliente(int id) {
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
//        
//}
