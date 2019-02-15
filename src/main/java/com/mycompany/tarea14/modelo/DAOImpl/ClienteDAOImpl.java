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
import org.primefaces.component.log.Log;

/**
 *
 * @author Oscar Alfonso
 */
public class ClienteDAOImpl extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteDAOImpl() {
    }

    public ClienteDAOImpl(Class<Cliente> entiClass) {
        super(entiClass);
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        this.beginTransaction();
        this.create(cliente);
        this.commit();
        this.closeTransaction();
    }

    @Override
    public Cliente buscarPorId(int id) {
        List<Cliente> lista;
        try {
            lista = entityManager.createQuery("SELECT c FROM Cliente c where c.idCliente=" + id, Cliente.class).getResultList();
            return lista.get(0);
        } catch (Exception e) {
            //throw e;
            System.err.println("error:" + e.getMessage());
            return new Cliente();
        }

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
        List<Cliente> lista;
        try {
            lista = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        this.beginTransaction();
        Cliente artist1 = entityManager.find(Cliente.class, cliente.getIdCliente());
        artist1.setNombre(cliente.getNombre());
        artist1.setApellido(cliente.getApellido());
        artist1.setCi(cliente.getCi());
        artist1.setDireccion(cliente.getDireccion());
        artist1.setTelefono(cliente.getTelefono());
        this.update(artist1);
        this.commit();
        this.closeTransaction();
        return true;
    }

    @Override
    public boolean eliminarCliente(int id) {
        this.beginTransaction();
        Cliente artist1 = entityManager.find(Cliente.class, id);

        this.delete(artist1);
        this.commit();
        this.closeTransaction();
        /* try {
            Cliente obj = entityManager.getReference(Cliente.class, id);
Cliente same = entityManager.find(1); //managed same
            this.beginTransaction();
            this.delete(obj);
            this.commit();
            this.closeTransaction();
            return true;
        } catch (Exception e) {
            return false;
        }*/
 /*  if (artist != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(artist);
            entityManager.getTransaction().commit();
        }*/
        System.out.println("se elimino correctamente!");
        return true;
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
