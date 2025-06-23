/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class DAO1<T> {
    
    public abstract void create(T t);
    
    public abstract boolean update(T t);
    
    public abstract boolean delete(T t);
    
    public abstract List<T> readAll();
    
    public abstract T readOnly(String str);

}
