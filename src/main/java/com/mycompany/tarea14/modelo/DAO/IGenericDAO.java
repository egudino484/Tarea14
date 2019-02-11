/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea14.modelo.DAO;

/**
 *
 * @author Oscar Alfonso
 */
public interface IGenericDAO <T> {
    public T create(T t);
    public T read (Object id);
    
}